package _09TrafficLights;

public enum State {
    RED, GREEN, YELLOW;

    private static State[] states = values();
    public State getNext(){
        return states[(this.ordinal()+1) % states.length];
    }
}
