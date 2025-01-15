import java.util.Random;

public class Spacecraft {
    
    private String model;
    private String fuelType;
    private String launchDate;
    private double successProbability;
    private String[] crewMembers;
    private int missionDuration; // in days or hours
    private String missionStatus; // e.g., "Pre-Launch", "In Orbit", "Completed", "Failed"

    // Constructor
    public Spacecraft(String model, String fuelType, String launchDate, double successProbability) {
        this.model = model;
        this.fuelType = fuelType;
        this.launchDate = launchDate;
        this.successProbability = successProbability;
        this.missionStatus = "Pre-Launch"; // Default initial status
    }

    // Start Engine
    public void startEngine() {
        System.out.println("Engine Started");
    }

    // Display Spacecraft Information
    public void display() {
        System.out.println("Spacecraft: " + model);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Launch Date: " + launchDate);
        System.out.println("Success Probability: " + (successProbability * 100) + "%");
        System.out.println("Mission Duration: " + missionDuration + " hours");
        System.out.println("Mission Status: " + missionStatus);
        
        if (crewMembers != null) {
            System.out.println("Crew Members:");
            for (String crewMember : crewMembers) {
                System.out.println(" - " + crewMember);
            }
        }
    }

    // Launch Sequence with Phases
    public void launchSequence() {
        System.out.println("Initiating launch sequence...");
        if (countdown()) {
            if (liftoff()) {
                if (orbitInsertion()) {
                    missionStatus = "In Orbit";
                    System.out.println("Mission Status: " + missionStatus);
                } else {
                    missionStatus = "Orbit Insertion Failed";
                    System.out.println("Mission Status: " + missionStatus);
                }
            } else {
                missionStatus = "Liftoff Failed";
                System.out.println("Mission Status: " + missionStatus);
            }
        } else {
            missionStatus = "Countdown Failed";
            System.out.println("Mission Status: " + missionStatus);
        }
    }

    // Countdown Phase
    private boolean countdown() {
        System.out.println("Countdown initiated...");
        updateMissionStatus("Countdown");
        return isPhaseSuccessful();
    }

    // Liftoff Phase
    private boolean liftoff() {
        System.out.println("Liftoff!");
        updateMissionStatus("Liftoff");
        return isPhaseSuccessful();
    }

    // Orbit Insertion Phase
    private boolean orbitInsertion() {
        System.out.println("Orbit Insertion...");
        updateMissionStatus("Orbit Insertion");
        return isPhaseSuccessful();
    }

    // Random Success Check for Each Phase
    private boolean isPhaseSuccessful() {
        Random random = new Random();
        return random.nextDouble() < successProbability;
    }

    // Update Mission Status
    public void updateMissionStatus(String status) {
        this.missionStatus = status;
        System.out.println("Mission Status Updated: " + missionStatus);
    }

    // Getters and Setters for Attributes
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public double getSuccessProbability() {
        return successProbability;
    }

    public void setSuccessProbability(double successProbability) {
        this.successProbability = successProbability;
    }

    public String[] getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(String[] crewMembers) {
        this.crewMembers = crewMembers;
    }

    public int getMissionDuration() {
        return missionDuration;
    }

    public void setMissionDuration(int missionDuration) {
        this.missionDuration = missionDuration;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

	
}
