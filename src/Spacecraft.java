import java.util.Random;

public class Spacecraft{
	
	private String model;
	private String fuelType;
	private String launchDate;
	private static double successProbability;
	
	public Spacecraft(String model,String fuelType,String launchDate,double successProbability) {
		this.model=model;
		this.fuelType=fuelType;
		this.launchDate=launchDate;
		this.setSuccessProbability(successProbability);
	}

	
	public void startEngine() {
		System.out.println("Engine Started");
	}
	
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
	
	public void display() {
		System.out.println("Spacecraft: " + model);
		System.out.println("Success Probability: " + (getSuccessProbability() * 100) + "%");
	}


	public boolean launch() {
		Random random = new Random();
		double chance = random.nextDouble();
		return chance < successProbability;
	}
	
	public double getSuccessProbability() {
		return successProbability;
	}


	public void setSuccessProbability(double successProbability) {
		Spacecraft.successProbability = successProbability;
	}
	
	
	
	
}
