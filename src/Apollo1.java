import java.util.Random;

public class Apollo1 extends Spacecraft {

    private String color;
    private double tragedyProbability; // Probability of a tragic outcome
    private double moonProbability; // Incredibly rare outcome of a moon landing.
    private double successfulMission; // Incredibly rare outcome of a successful Mission.

    // Constructor
    public Apollo1(String model, String fuelType, String launchDate, String color, double successProbability) {
        super(model, fuelType, launchDate, successProbability);
        this.color = color;
        this.tragedyProbability = 0.98; // 98% chance of tragedy
        this.moonProbability = 0.000000000000000000000000000000000000000000001;
        this.successfulMission = 0.1;
        // Set mission-specific details for Apollo 1
        setMissionDuration(12); // e.g., 12 hours
        setCrewMembers(new String[] { "Virgil I. Grissom", "Edward H. White II", "Roger B. Chaffee" });
    }

    // Override startEngine with mission-specific behavior
    @Override
    public void startEngine() {
        System.out.println("Apollo 1 engines started...");
    }

    // Check for tragic outcome
    public boolean isTragicOutcome() {
        Random random = new Random();
        return random.nextDouble() < tragedyProbability; // Returns true if tragedy occurs
    }
    
 // Check for tragic outcome
    public boolean isMoonProbability() {
        Random random = new Random();
        return random.nextDouble() < moonProbability; // Returns true if Moon landing somehow occurs.
    }
    
 // Check for tragic outcome
    public boolean isSuccessfulOutcome() {
        Random random = new Random();
        return random.nextDouble() < successfulMission; // Returns true if tragedy occurs
    }

    // Getters and Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    // Display full details, including the additional Apollo 1 specifics
    @Override
    public void display() {
        super.display(); // Call superclass display method to show common attributes
        System.out.println("Color: " + color);
    }

}
