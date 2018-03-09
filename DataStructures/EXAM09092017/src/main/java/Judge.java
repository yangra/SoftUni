import java.util.*;
import java.util.stream.Collectors;

public class Judge implements IJudge {
    private Map<Integer, Integer> users;
    private Map<Integer, Integer> contests;
    private Map<Integer, Submission> submissions;
    private NavigableMap<Integer, Map<Integer, Submission>> byPoints;
    private Map<SubmissionType, Map<Integer, Submission>> byType;
    private Map<Integer, Map<Integer, Submission>> byUserId;

    public Judge() {
        this.users = new TreeMap<>();
        this.contests = new TreeMap<>();
        this.submissions = new TreeMap<>();
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
        if (!users.containsKey(submission.getUserId()) || !contests.containsKey(submission.getContestId())) {
            throw new IllegalArgumentException();
        }

        submissions.put(submission.getId(), submission);
        if (!this.byPoints.containsKey(submission.getPoints())) {
            this.byPoints.put(submission.getPoints(), new HashMap<>());
        }
        this.byPoints.get(submission.getPoints()).put(submission.getId(), submission);
        if (!this.byType.containsKey(submission.getType())) {
            this.byType.put(submission.getType(), new HashMap<>());
        }
        this.byType.get(submission.getType()).put(submission.getId(), submission);
        if (!this.byUserId.containsKey(submission.getUserId())) {
            this.byUserId.put(submission.getUserId(), new HashMap<>());
        }
        this.byUserId.get(submission.getUserId()).put(submission.getId(), submission);
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
        this.byType.get(toRemove.getType()).remove(submissionId);
        this.byUserId.get(toRemove.getUserId()).remove(submissionId);
        this.submissions.remove(submissionId);
    }

    public Iterable<Submission> getSubmissions() {
        return new ArrayList<>(this.submissions.values());
    }

    public Iterable<Integer> getUsers() {
        return new ArrayList<>(this.users.keySet());
    }

    public Iterable<Integer> getContests() {
        return new ArrayList<>(this.contests.keySet());
    }

    public Iterable<Submission> submissionsWithPointsInRangeBySubmissionType(int minPoints, int maxPoints, SubmissionType submissionType) {
        List<Submission> result = new ArrayList<>();
        this.byPoints.subMap(minPoints, maxPoints+1).values().stream()
                .forEach(ms -> result.addAll(ms.values().stream().filter(s -> s.getType().equals(submissionType)).collect(Collectors.toList())));
        return result;
    }

    public Iterable<Integer> contestsByUserIdOrderedByPointsDescThenBySubmissionId(int userId) {
        List<Submission> submissionByPoints = new ArrayList<>(this.byUserId.get(userId).values());
        Collections.sort(submissionByPoints,(s1, s2) -> {
            if (s2.getPoints() != s1.getPoints()) {
                return Integer.compare(s2.getPoints(), s1.getPoints());
            }

            return Integer.compare(s1.getId(), s2.getId());
        } );
        List<Integer> result = new ArrayList<>();
        for (Submission submission : submissionByPoints) {
            if (result.contains(submission.getContestId())) {
                continue;
            }
            result.add(submission.getContestId());
        }
        return result;
    }

    public Iterable<Submission> submissionsInContestIdByUserIdWithPoints(int points, int contestId, int userId) {
        if(!this.users.containsKey(userId)||!this.contests.containsKey(contestId)){
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
        Set<Integer> result = new TreeSet<>();
        this.byType.get(submissionType).values().stream().forEach(s -> result.add(s.getContestId()));
        return result;
    }
}
