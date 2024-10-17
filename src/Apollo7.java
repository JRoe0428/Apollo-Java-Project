public class Apollo7 extends Spacecraft {

	private String color;
	private boolean autoPilot;
	private String projectManager;
	private double successProbability;
	
	public Apollo7(String model, String fuelType, String launchDate, String color, boolean autoPilot, double successProbability) {
		super(model, fuelType, launchDate, successProbability);
		this.color=color;
		this.autoPilot=autoPilot;
		this.successProbability=successProbability;
	}

	public double getSuccessProbability() {
		return successProbability;
	}

	public void setSuccessProbability(double successProbability) {
		this.successProbability = successProbability;
	}

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
	
	
	
}
