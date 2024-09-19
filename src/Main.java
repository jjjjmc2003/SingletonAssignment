public class Main {
    public static void main(String[] args) {

        // Getting the Singleton for Alexa
        SmartHomeController Alexa = SmartHomeController.getInstance();

        // Having Alexa earn its keep
        System.out.println("\nAlexa Home Controller: ");
        Alexa.TurnOnLights();
        Alexa.TurnOnLights();
        Alexa.setTemperature(100);
        Alexa.armSecurity();
        Alexa.disarmSecurity();
        Alexa.SmartHomeTracker();


        // Getting the Singleton again
        SmartHomeController Siri = SmartHomeController.getInstance();

        // Having Siri do stuff
        System.out.println("\nSiri Controller: ");
        Siri.TurnOffLights();
        Siri.setTemperature(40);
        Siri.disarmSecurity();
        Siri.SmartHomeTracker();


        // Instance check
        System.out.println("Are both instances the same? " + (Alexa == Siri));
    }
}