package judge;

import java.util.*;
import java.util.stream.Collectors;

public class Judge implements IJudge {
    private Map<Integer, Integer> users;
    private Map<Integer, Integer> contests;
    private Map<Integer, Submission> submissions;
    private Map<Integer, Submission> byInput;
    private NavigableMap<Integer, Map<Integer, Submission>> byPoints;
    private Map<SubmissionType, TreeSet<Submission>> byType;
    private Map<Integer, TreeSet<Submission>> byUserId;

    public Judge() {
        this.users = new TreeMap<>();
        this.contests = new TreeMap<>();
        this.submissions = new TreeMap<>();
        this.byInput = new LinkedHashMap<>();
        this.byPoints = new TreeMap<>();
        this.byType = new HashMap<>();
        this.byUserId = new TreeMap<>();
    }

    public void addContest(int contestId) {
        if (this.contests.containsKey(contestId)) {
            return;
        }

        this.contests.put(contestId, contestId);
    }

    public void addSubmission(Submission submission) {
        if (!users.containsKey(submission.getUserId()) ||
                !contests.containsKey(submission.getContestId())) {
            throw new UnsupportedOperationException();
        }

        if(submissions.containsKey(submission.getId())){
            return;
        }

        submissions.put(submission.getId(), submission);
        this.byInput.put(submission.getId(),submission);
        if (!this.byPoints.containsKey(submission.getPoints())) {
            this.byPoints.put(submission.getPoints(), new HashMap<>());
        }
        this.byPoints.get(submission.getPoints()).put(submission.getId(), submission);
        if (!this.byType.containsKey(submission.getType())) {
            this.byType.put(submission.getType(), new TreeSet<>(Comparator.comparingInt(Submission::getId)));
        }
        this.byType.get(submission.getType()).add(submission);
        if (!this.byUserId.containsKey(submission.getUserId())) {
            this.byUserId.put(submission.getUserId(), new TreeSet<>((s1, s2) -> {
                if (s2.getPoints() != s1.getPoints()) {
                    return Integer.compare(s2.getPoints(), s1.getPoints());
                }

                return Integer.compare(s1.getId(), s2.getId());
            }));
        }
        this.byUserId.get(submission.getUserId()).add(submission);
    }

    public void addUser(int userId) {
        if (this.users.containsKey(userId)) {
            return;
        }

        this.users.put(userId, userId);
    }

    public void deleteSubmission(int submissionId) {
        Submission toRemove = this.submissions.get(submissionId);
        this.byPoints.get(toRemove.getPoints()).remove(submissionId);
        this.byType.get(toRemove.getType()).remove(toRemove);
        this.byUserId.get(toRemove.getUserId()).remove(toRemove);
        this.byInput.remove(submissionId);
        this.submissions.remove(submissionId);
    }

    public Iterable<Submission> getSubmissions() {
        return this.byInput.values().stream()
                .sorted(Comparator.comparing(Submission::getUserId))
                .collect(Collectors.toList());
    }

    public Iterable<Integer> getUsers() {
        return new ArrayList<>(this.users.keySet());
    }

    public Iterable<Integer> getContests() {
        return new ArrayList<>(this.contests.keySet());
    }

    public Iterable<Submission> submissionsWithPointsInRangeBySubmissionType
            (int minPoints, int maxPoints, SubmissionType submissionType) {
        List<Submission> result = new ArrayList<>();
        this.byPoints.subMap(minPoints, maxPoints+1).values()
                .forEach(ms -> result.addAll(ms.values().stream()
                        .filter(s -> s.getType().equals(submissionType)).collect(Collectors.toList())));
        return result;
    }

    public Iterable<Integer> contestsByUserIdOrderedByPointsDescThenBySubmissionId(int userId) {
        TreeSet<Submission> sorted = this.byUserId.get(userId);

        return sorted.stream().sorted((s1,s2)->Integer.compare(s2.getPoints(),s1.getPoints()))
                .map(Submission::getContestId).distinct().collect(Collectors.toList());
    }

    public Iterable<Submission> submissionsInContestIdByUserIdWithPoints(int points, int contestId, int userId) {
        if(!this.users.containsKey(userId)||!this.contests.containsKey(contestId)||!this.byPoints.containsKey(points)){
            throw new IllegalArgumentException();
        }

        return this.submissions.values().stream()
                .filter(s -> s.getContestId() == contestId && s.getUserId() == userId && s.getPoints() == points)
                .collect(Collectors.toList());
    }

    public Iterable<Integer> contestsBySubmissionType(SubmissionType submissionType) {
        if(!this.byType.containsKey(submissionType)){
            return new ArrayList<>();
        }

        return this.byType.get(submissionType).stream().map(s -> (s.getId())).collect(Collectors.toList());
    }
}
