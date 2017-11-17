package _08MilitaryElite.soldiers;

import _08MilitaryElite.interfaces.IMission;

public class Mission implements IMission {
    private static final String MISSION_FINISHED_STATUS = "Finished";
    private static final String MISSION_IN_PROGRESS_STATUS = "inProgress";
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        if (MISSION_FINISHED_STATUS.equals(state) || MISSION_IN_PROGRESS_STATUS.equals(state)) {
            this.state = state;
        }
    }

    @Override
    public void completeMission() {
        this.setState(MISSION_FINISHED_STATUS);
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
