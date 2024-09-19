import java.util.ArrayList;

public class SmartHomeController {
    private static SmartHomeController uniqueInstance = null;   //Setting up the Singleton here and initializing other variables
    private int temp;
    private boolean lightsOn;    //These two lightsOn and secSystemOn are set here, implicitly, to false which stands for off
    private boolean secSystemOn; // The reasoning is that we initialize it like this to mimic the real world where when a system
    private boolean Off;                 // is starting it is generally Off, speaking of Off this was originally the way that I had structured
    private ArrayList <String> Devices = new ArrayList<>(); // On however I failed to account for the need for specificity when exception handling


    private SmartHomeController() { //Singleton Constructor, very cool
    }

    public static SmartHomeController getInstance() { // Singleton getter this is our key
        if (uniqueInstance == null) {
            synchronized (SmartHomeController.class) { //Synchronized is important ensures one thread runs at a time
                if (uniqueInstance == null) {
                    uniqueInstance = new SmartHomeController();
                }
            }
        }
        return uniqueInstance;
    }

    public void TurnOnLights() { // Turn On Light Method
        if (LightisOn()) {
            System.out.println("Light is Already On"); //Exception Handling
        }


        else {
            System.out.println("Lights are on");
            lightsOn = true;  //Change bool statement to reflect lights being on
            Devices.add("Lights");  //dynamic array List, nice
        }


    }

    public void TurnOffLights() { // Turn Off Light Method

        if (LightisOff()) {
            System.out.println("Lights are already Off"); // Exception Handling
        }
        else {
            System.out.println("Lights are off");
            lightsOn = false; //Updating lights status to off
            Devices.remove("Lights"); //since they're off removing them from the Array List
        }
    }

    public int getTemperature(){ //getter of Temperature, makes it easier to display temp and I added some exception handling
            if (temp < 50)       // so that the user's house does not get too hot or too cold without them being warned
                System.out.println("House is cold consider turning on heat");
            else if (temp > 90) {
                System.out.println("House is hot consider turning on AC");
            }
            else
                System.out.println("Temperature is good");

        return temp;
    }

    public void setTemperature(int temperature) {   //Setter for temp
        this.temp = temperature;

    }

    public void armSecurity() {   //Arming System similar to Light On method
        if (secSystemisOn()) {
            System.out.println("Security System is already armed");
        }
        else {
            System.out.println("Security system is now armed");
            secSystemOn = true;
            Devices.add("Security System");
        }

    }

    public void disarmSecurity() { // Similar to Turn Off Method

        if (isOff()) {
            System.out.println("Security System is already disarmed");
        }
        else {
            System.out.println("Security System is now disarmed");
            secSystemOn = false;
            Devices.remove("Security System");
        }
    }

    //Boolean methods here to handle the Lights and security Systems and return their bool so that we can print out the accurate
    // statements and ensure we are not trying to turn on a light or security system if it is already on
    public boolean LightisOn() {
        return lightsOn;
    }

    public boolean LightisOff() {
        return Off;
    }

    public boolean secSystemisOn(){
        return secSystemOn;
    }

    public boolean isOff() {
        return Off;
    }



    public void SmartHomeTracker(){ // Extra option wrote a for loop to iterate over the Array List we have so that we can display
        if (Devices.size() == 0) {  // what devices are currently on
            System.out.println("No Devices are on Save that $$$");
        }
        else {
            System.out.println("---------------------\nThese devices are On: ");
            for (String devices : Devices) {
                System.out.println(devices + "\n---------------------");
            }
        }

    System.out.println("The current temperature of home is: " + getTemperature()); //getter came in clutch
    }
}