public class App {

    public static void main(String[] args) {
        
        // Instantiate Apollo1 and Apollo7 with mission-specific parameters
        Apollo1 apollo1 = new Apollo1("Apollo Spacecraft - Saturn-204", "LXO", "01/27/1967", "White", 0.52);
        Apollo7 apollo7 = new Apollo7("Apollo Spacecraft - 7", "LXO", "10/11/1968", "White", false, 0.98, "Cape Kennedy", "Clear Skies", "Successful crewed mission demonstrating capability.");

        // Test the launch sequence for each mission
        testLaunch(apollo1);
        testLaunch(apollo7);
    }

    private static void testLaunch(Spacecraft spacecraft) {
        spacecraft.display();           // Display spacecraft details
        spacecraft.startEngine();        // Start engine
        

        
        // Check for Successful Mission outcome Specifically for Apollo1
        if (spacecraft instanceof Apollo1) {
        	Apollo1 apollo1 = (Apollo1) spacecraft;
        	if (apollo1.isSuccessfulOutcome()) {
        		System.out.println("Mission Result: A succesful Mission, where nothing went wrong. Yippe!\n");
        		return;
        	}
        }
        
        // Check for Moon Landing outcome specifically for Apollo1
        if (spacecraft instanceof Apollo1) {
        	Apollo1 apollo1 = (Apollo1) spacecraft;
        	if (apollo1.isMoonProbability()) {
        		System.out.println("Mission Result: By the grace of god, a moon landing was Achieved\n");
        		return;
        	}
        }
        
        // Check for tragic outcome specifically for Apollo 1
        if (spacecraft instanceof Apollo1) {
            Apollo1 apollo1 = (Apollo1) spacecraft;
            if (apollo1.isTragicOutcome()) {
                System.out.println("Mission Result:\nApollo1 Critical Failure:\n Electrical short causing a fire, due to the choice of Teflon as the covering for the wiring within the space capsule.\n All crew are dead.\n");
                return; // Exit the launch sequence if tragedy occurs
            }     
        } else if (spacecraft instanceof Apollo7) {
            Apollo7 apollo7 = (Apollo7) spacecraft;
            boolean launchSuccess = apollo7.isMissionSuccessful(); // Check mission success for Apollo 7
            if (launchSuccess) {
                System.out.println("Mission Result: Success for Apollo 7!");
            } else {
                System.out.println("Mission Result: Failure for Apollo 7.");
            }
            return; // Exit the launch sequence after checking success
        }

        // Continue with the launch sequence if no tragic outcome occurred
        spacecraft.launchSequence();     // Execute the launch sequence with phases
        System.out.println();
    }
}
