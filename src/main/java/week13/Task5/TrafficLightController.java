package week13.Task5;

public class TrafficLightController {
    public static void main(String[]args){
        TrafficLightContext context = new TrafficLightContext();

        //simulating state transition
        context.transitionToYellow();
        context.transitionToGreen();
        context.transitionToYellow();
        context.transitionToRed();
        context.transitionToGreen();
    }
}
