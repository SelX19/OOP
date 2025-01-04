package week13.Task5;

public interface TrafficLightState {
    //including TrafficLightContext object as parameter, in order to be able to use setState method, and update states, when transitioned between them
    void transitionToRed(TrafficLightContext context);
    void transitionToGreen(TrafficLightContext context);
    void transitionToYellow(TrafficLightContext context);
}
