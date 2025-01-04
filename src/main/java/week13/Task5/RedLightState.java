package week13.Task5;

public class RedLightState implements TrafficLightState{
    @Override
    public void transitionToRed(TrafficLightContext context){
        System.out.println("The current traffic light state is red.");
    }

    @Override
    public void transitionToYellow(TrafficLightContext context){
        System.out.println("Transitioning from red to yellow.");
        context.setState(new YellowLightState());
    }

    @Override
    public void transitionToGreen(TrafficLightContext context){
        System.out.println("Cannot transition directly from red to green.");
    }
}
