package week13.Task5;

public class TrafficLightContext {
    private TrafficLightState currentState;

    public TrafficLightContext(){
        //initial state is red
        this.currentState = new RedLightState();
    }

    public void setState(TrafficLightState trafficLightState){
        this.currentState=trafficLightState;
    }

    public void transitionToRed(){
        currentState.transitionToRed(this);
    }

    public void transitionToGreen(){
        currentState.transitionToGreen(this);
    }

    public void transitionToYellow(){
        currentState.transitionToYellow(this);
    }
}
