package judge;

import java.util.Objects;

public class Submission implements Comparable<Submission>
{
    private int id;
    private SubmissionType type;
    private int userId;
    private int contestId;
    private int points;

    public Submission(int id, int points, SubmissionType type, int contestId, int userId) {
        this.id = id;
        this.points = points;
        this.type = type;
        this.contestId = contestId;
        this.userId = userId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public SubmissionType getType() {
        return this.type;
    }

    public void setType(SubmissionType type) {
        this.type = type;
    }

    public int getContestId() {
        return this.contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int compareTo(Submission other) {
        return Integer.compare(this.getId(), other.getId());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Submission that = (Submission) other;
        return id == that.id &&
                userId == that.userId &&
                contestId == that.contestId &&
                points == that.points &&
                type == that.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, userId, contestId, points);
    }
}
