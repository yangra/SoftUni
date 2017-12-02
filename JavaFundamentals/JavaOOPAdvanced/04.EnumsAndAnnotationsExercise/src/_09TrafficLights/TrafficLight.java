package _09TrafficLights;

public class TrafficLight {
    private State state;

    public TrafficLight(String state) {
        this.state = State.valueOf(state.toUpperCase());
    }

    public State getState() {
        return this.state;
    }

    public void changeState(){
       this.state = this.state.getNext();
    }
}
