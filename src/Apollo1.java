public class Apollo1 extends Spacecraft{

	private String color;
	private boolean autoPilot;
	public Apollo1(String model,String fuelType,String launchDate,String color,boolean autoPilot,double successProbability) {
		super(model, fuelType, launchDate, successProbability);
		this.color=color;
		this.autoPilot=autoPilot;
	}
	
	@Override
	public void startEngine() {
		System.out.println("Engines Started");
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
	
	
	
	
}