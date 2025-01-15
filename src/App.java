import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class App {

    public static void main(String[] args) {
        // Launch the main menu
        SwingUtilities.invokeLater(App::launchMainMenu);
    }

    private static void launchMainMenu() {
        JFrame frame = new JFrame("Apollo Launch Simulator");
        frame.setTitle("Apollo Launch Simulator");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Apollo Launch Simulator", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton startButton = new JButton("Begin Simulation");
        JButton missionSelectButton = new JButton("Mission Select");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Action Listeners
        startButton.addActionListener(e -> {
            frame.dispose();
            openMissionSelect();
        });
        exitButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private static void openMissionSelect() {
        JFrame missionFrame = new JFrame("Mission Select");
        missionFrame.setTitle("Select Your Mission");
        missionFrame.setSize(400, 400);
        missionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        missionFrame.setLayout(new BorderLayout());

        JLabel missionLabel = new JLabel("Select a Mission to Simulate", JLabel.CENTER);
        missionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        missionFrame.add(missionLabel, BorderLayout.NORTH);

        JPanel missionPanel = new JPanel();
        missionPanel.setLayout(new GridLayout(8, 1, 5, 5));

        JButton apollo1Button = new JButton("Apollo 1");
        JButton apollo7Button = new JButton("Apollo 7");
        JButton apollo8Button = new JButton("Apollo 8");
        JButton apollo9Button = new JButton("Apollo 9");

        // Add mission buttons
        missionPanel.add(apollo1Button);
        missionPanel.add(apollo7Button);
        missionPanel.add(apollo8Button);
        missionPanel.add(apollo9Button);

        missionFrame.add(missionPanel, BorderLayout.CENTER);

        // Action Listeners for missions
        apollo1Button.addActionListener(e -> startMission(new Apollo1("Apollo Spacecraft - Saturn-204", "LXO", "01/27/1967", "White", 0.52), missionFrame));
        apollo7Button.addActionListener(e -> startMission(new Apollo7("Apollo Spacecraft - 7", "LXO", "10/11/1968", "White", false, 0.98, "Cape Kennedy", "Clear Skies", "Successful crewed mission demonstrating capability."), missionFrame));
        apollo8Button.addActionListener(e -> startMission(new Apollo8("Apollo Spacecraft - AS-503", "LXO", "12/21/1968", 0.98, "White", true, "Cape Kennedy", "Clear Skies", "Successful Crewed Mission Demonstrating Capability."), missionFrame));
        apollo9Button.addActionListener(e -> startMission(new Apollo9("Apollo Spacecraft - AS-504", "LXO", "03/03/1969", 0.98, "White", true, "Cape Kennedy", "Partly Cloudy", "Earth-orbital engineering test for lunar module."), missionFrame));

        missionFrame.setVisible(true);
    }

    private static void startMission(Spacecraft spacecraft, JFrame missionFrame) {
        missionFrame.dispose();
        displayMissionResult(testLaunch(spacecraft));
    }

    private static String testLaunch(Spacecraft spacecraft) {
        StringBuilder result = new StringBuilder();
        result.append("Spacecraft Details:\n");
        result.append("Model: ").append(spacecraft.getModel()).append("\n");
        result.append("Fuel Type: ").append(spacecraft.getFuelType()).append("\n");
        result.append("Launch Date: ").append(spacecraft.getLaunchDate()).append("\n");
        result.append("Success Probability: ").append(spacecraft.getSuccessProbability() * 100).append("%\n");
        result.append("Mission Status: ").append(spacecraft.getMissionStatus()).append("\n");
        result.append("Mission Duration: ").append(spacecraft.getMissionDuration()).append(" hours\n");

        if (spacecraft.getCrewMembers() != null) {
            result.append("Crew Members:\n");
            for (String crewMember : spacecraft.getCrewMembers()) {
                result.append(" - ").append(crewMember).append("\n");
            }
        }

        spacecraft.startEngine();

        if (spacecraft instanceof Apollo1) {
            Apollo1 apollo1 = (Apollo1) spacecraft;
            result.append("Color: ").append(apollo1.getColor()).append("\n");
            if (apollo1.isSuccessfulOutcome()) {
                result.append("Mission Result: A successful Mission, where nothing went wrong. Yippee!\n");
            } else if (apollo1.isMoonProbability()) {
                result.append("Mission Result: By the grace of God, a moon landing was achieved.\n");
            } else if (apollo1.isTragicOutcome()) {
                result.append("Mission Result:\nApollo 1 Critical Failure:\nElectrical short causing a fire due to the choice of Teflon as the covering for the wiring within the space capsule.\nAll crew are dead.\n");
            }
        } else if (spacecraft instanceof Apollo7) {
            Apollo7 apollo7 = (Apollo7) spacecraft;
            result.append("Color: ").append(apollo7.getColor()).append("\n");
            result.append("Weather Condition: ").append(apollo7.getWeatherCondition()).append("\n");
            result.append("Launch Location: ").append(apollo7.getLocationOfLaunch()).append("\n");
            result.append("Crew Morale: ").append(apollo7.isMissionSuccessful() ? "High" : "Low").append("\n");
            if (apollo7.isMissionSuccessful()) {
                result.append("Mission Result: Success for Apollo 7!\n");
            } else {
                result.append("Mission Result: Failure for Apollo 7.\n");
            }
        } else if (spacecraft instanceof Apollo8) {
            Apollo8 apollo8 = (Apollo8) spacecraft;
            result.append("Color: ").append(apollo8.getColor()).append("\n");
            result.append("Weather Condition: ").append(apollo8.getWeatherCondition()).append("\n");
            result.append("Launch Location: ").append(apollo8.getLocationOfLaunch()).append("\n");
            result.append("Crew Morale: ").append(apollo8.isMissionSuccessful() ? "High" : "Low").append("\n");
            if (apollo8.isMissionSuccessful()) {
                result.append("Mission Result: Success for Apollo 8!\n");
            } else {
                result.append("Mission Result: Failure for Apollo 8.\n");
            }
        } else if (spacecraft instanceof Apollo9) {
            Apollo9 apollo9 = (Apollo9) spacecraft;
            result.append("Color: ").append(apollo9.getColor()).append("\n");
            result.append("Weather Condition: ").append(apollo9.getWeatherCondition()).append("\n");
            result.append("Launch Location: ").append(apollo9.getLocationOfLaunch()).append("\n");
            result.append("Crew Morale: ").append(apollo9.isMissionSuccessful() ? "High" : "Low").append("\n");
            if (apollo9.isMissionSuccessful()) {
                result.append("Mission Result: Success for Apollo 9!\n");
            } else {
                result.append("Mission Result: Failure for Apollo 9.\n");
            }
        } else {
            spacecraft.launchSequence();
            result.append("Launch sequence executed successfully.\n");
        }

        return result.toString();
    }

    private static void displayMissionResult(String result) {
        JFrame resultFrame = new JFrame("Mission Result");
        resultFrame.setTitle("Mission Outcome");
        resultFrame.setSize(1920, 1080);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea resultArea = new JTextArea(result);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setEditable(false);
        resultFrame.add(new JScrollPane(resultArea));

        resultFrame.setVisible(true);
    }
}
