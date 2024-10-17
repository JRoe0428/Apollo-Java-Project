
public class App {
	

	public static void main(String[] args) {
	
		Apollo1 vSpacecraft= new Apollo1("Apollo Spacecraft - Saturn-204", "LXO", "01/27/1976", "White", true, 0.52);
		Apollo7 xSpacecraft= new Apollo7("Apollo Spacecraft - 7", "LXO", "10/11/1968", "White", false, 0.98);
		
		testLaunch1(vSpacecraft);
		testLaunch2(xSpacecraft);
	}

	private static void testLaunch2(Apollo7 xSpacecraft) {
		xSpacecraft.display();
		System.out.println(xSpacecraft.getModel());
		System.out.println(xSpacecraft.getLaunchDate());
		System.out.println(xSpacecraft.getFuelType());
		boolean launchSuccess = xSpacecraft.launch();
		if (launchSuccess) {
			System.out.println("Launch Result: Success!\n");
		} else {
			System.out.println("Launch Result: Failure...\n");
		}
		
	}

	private static void testLaunch1(Apollo1 vSpacecraft) {
		vSpacecraft.display();
		System.out.println(vSpacecraft.getModel());
		System.out.println(vSpacecraft.getLaunchDate());
		System.out.println(vSpacecraft.getFuelType());
		boolean launchSuccess = vSpacecraft.launch();
		if (launchSuccess) {
			System.out.println("Launch Result: Success!\n");
		} else {
			System.out.println("Launch Result: Failure....\n");
		}
		
	}

}
