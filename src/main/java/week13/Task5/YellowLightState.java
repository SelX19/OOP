package week13.Task5;

public class YellowLightState implements TrafficLightState{
    @Override
    public void transitionToRed(TrafficLightContext context){
        System.out.println("Transitioning from yellow to red.");
        context.setState(new RedLightState());
    }

    @Override
    public void transitionToYellow(TrafficLightContext context){
        System.out.println("The current traffic light state is yellow.");
    }

    @Override
    public void transitionToGreen(TrafficLightContext context){
        System.out.println("Transitioning from yellow to green.");
        context.setState(new GreenLightState());
    }
}
