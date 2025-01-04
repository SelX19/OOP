package week13.Task5;

public class GreenLightState implements TrafficLightState{
    @Override
    public void transitionToRed(TrafficLightContext context){
        System.out.println("Cannot transition directly from green to red.");
    }

    @Override
    public void transitionToYellow(TrafficLightContext context){
        System.out.println("Transitioning from green to yellow.");
        context.setState(new YellowLightState());
    }

    @Override
    public void transitionToGreen(TrafficLightContext context){
        System.out.println("The current traffic is green.");
    }
}
