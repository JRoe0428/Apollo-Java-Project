import java.util.Random;

public class Apollo11 extends Spacecraft {
	
	private String color;
	private boolean autoPilot;
	private String projectManager;
	private String locationOfLaunch;
	private String weatherCondition;
	private double morale;
	
	public Apollo11(String model, String fuelType, String launchDate, double successProbability, String color, boolean autoPilot, String locationOfLaunch, String weatherCondition, String string) {
		super(model, fuelType, launchDate, successProbability);
		this.color = color;
        this.autoPilot = autoPilot;
        this.locationOfLaunch = locationOfLaunch;
        this.weatherCondition = weatherCondition;
        this.morale = 0.98; // Historically High Morale
        
        
        // Set mission-specific details for Apollo 9
        setMissionDuration(192); // hours
        setCrewMembers(new String[] { "Neil Armstrong, Commander", "Buzz Aldrin, Lunar Module Pilot", "Michael Collins, Command Module Pilot;" });
	}
        // Method to simulate morale impact on mission success
        public boolean isMissionSuccessful() {
            double adjustedSuccessProbability = getSuccessProbability() * morale; // Adjusted by morale
            Random random = new Random();
            return random.nextDouble() < adjustedSuccessProbability; // Return true if mission succeeds
        }

// Getters and Setters
public String getColor() {
    return color;
}

public void setColor(String color) {
    this.color = color;
}

public boolean isAutoPilot() {
    return autoPilot;
}

public void setAutoPilot(boolean autoPilot) {
    this.autoPilot = autoPilot;
}

public String getProjectManager() {
    return projectManager;
}

public void setProjectManager(String projectManager) {
    this.projectManager = projectManager;
}

public String getLocationOfLaunch() {
    return locationOfLaunch;
}

public void setLocationOfLaunch(String locationOfLaunch) {
    this.locationOfLaunch = locationOfLaunch;
}

public String getWeatherCondition() {
    return weatherCondition;
}

public void setWeatherCondition(String weatherCondition) {
    this.weatherCondition = weatherCondition;
}

// Display full details, including the additional Apollo 7 specifics
@Override
public void display() {
    super.display(); // Call superclass display method to show common attributes
    System.out.println("Color: " + color);
    System.out.println("AutoPilot: " + (autoPilot ? "Enabled" : "Disabled"));
    System.out.println("Launch Location: " + locationOfLaunch);
    System.out.println("Weather Condition: " + weatherCondition);
    System.out.println("Crew Morale: " + (morale * 100) + "%");
	}
}
