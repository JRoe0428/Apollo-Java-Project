import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::launchMainMenu);
    }

    private static void launchMainMenu() {
        JFrame frame = new JFrame("Apollo Launch Simulator");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("Apollo Launch Simulator", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBackground(Color.BLACK);
        JButton startButton = new JButton("Begin Simulation");
        JButton exitButton = new JButton("Exit");
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
        frame.add(buttonPanel, BorderLayout.CENTER);

        startButton.addActionListener(e -> {
            frame.dispose();
            openMissionSelect();
        });
        exitButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private static void openMissionSelect() {
        JFrame missionFrame = new JFrame("Mission Select");
        missionFrame.setSize(1920, 1080);
        missionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        missionFrame.setLayout(new BorderLayout());
        missionFrame.getContentPane().setBackground(Color.BLACK);

        JLabel missionLabel = new JLabel("Select a Mission to Simulate", JLabel.CENTER);
        missionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        missionLabel.setForeground(Color.WHITE);
        missionFrame.add(missionLabel, BorderLayout.NORTH);

        JPanel missionPanel = new JPanel(new GridLayout(5, 5, 5, 5));
        missionPanel.setBackground(Color.BLACK);
        JButton[] missionButtons = {
            new JButton("Apollo 1"),
            new JButton("Apollo 7"),
            new JButton("Apollo 8"),
            new JButton("Apollo 9"),
            new JButton("Apollo 10"),
            new JButton("Apollo 11"),
        };

        Spacecraft[] missions = {
            new Apollo1("Apollo Spacecraft - Saturn-204", "LXO", "01/27/1967", "White", 0.52),
            new Apollo7("Apollo Spacecraft - 7", "LXO", "10/11/1968", "White", false, 0.98, "Cape Kennedy", "Clear Skies", "Successful mission."),
            new Apollo8("Apollo Spacecraft - AS-503", "LXO", "12/21/1968", 0.98, "White", true, "Cape Kennedy", "Clear Skies", "Successful mission."),
            new Apollo9("Apollo Spacecraft - AS-504", "LXO", "03/03/1969", 0.98, "White", true, "Cape Kennedy", "Partly Cloudy", "Lunar module test."),
            new Apollo10("Apollo Spacecraft - As-505","LXO", "05/18/1969", 0.98, "White", true, "Cape Kennedy", "Clear Skies", "Lunar-Orbital Engineering test."),
            new Apollo11("Apollo Spacecraft - Saturn V", "LXO", "07/16/1969", 0.98, "White", true, "Cape Kennedy", "Clear Skies", "Lunar Contact, Lunar Extraction"),
        
        };

        for (int i = 0; i < missionButtons.length; i++) {
            final Spacecraft mission = missions[i];
            missionButtons[i].setBackground(Color.DARK_GRAY);
            missionButtons[i].setForeground(Color.WHITE);
            missionButtons[i].addActionListener(e -> startMission(mission, missionFrame));
            missionPanel.add(missionButtons[i]);
        }

        missionFrame.add(missionPanel, BorderLayout.CENTER);
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

        result.append("Countdown Initiated...\n");
        spacecraft.launchSequence();

        if (spacecraft instanceof Apollo1) {
            Apollo1 apollo1 = (Apollo1) spacecraft;
            result.append("Color: ").append(apollo1.getColor()).append("\n");
            if (apollo1.isSuccessfulOutcome()) {
                result.append("Mission Result: A successful mission, where nothing went wrong. Yippee!\n");
            } else if (apollo1.isMoonProbability()) {
                result.append("Mission Result: By the grace of God, a moon landing was achieved.\n");
            } else if (apollo1.isTragicOutcome()) {
                result.append("Mission Result:\nApollo 1 Critical Failure:\nElectrical short causing a fire due to the choice of Teflon as the covering for the wiring within the space capsule.\nAll crew are dead.\n");
            }
        }
        
        result.append("Mission Status: ").append(spacecraft.getMissionStatus()).append("\n");
        result.append("Mission Duration: ").append(spacecraft.getMissionDuration()).append(" hours\n");

        if (spacecraft.getCrewMembers() != null) {
            result.append("Crew Members:\n");
            for (String crewMember : spacecraft.getCrewMembers()) {
                result.append(" - ").append(crewMember).append("\n");
            }
        }

        spacecraft.startEngine();
        result.append(spacecraft.getMissionStatus());
        return result.toString();
    }

    private static void displayMissionResult(String result) {
        JFrame resultFrame = new JFrame("Mission Result");
        resultFrame.setSize(1920, 1080);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.getContentPane().setBackground(Color.BLACK);

        JTextArea resultArea = new JTextArea(result);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setForeground(Color.WHITE);
        resultArea.setBackground(Color.BLACK);
        resultArea.setEditable(false);
        resultFrame.add(new JScrollPane(resultArea));

        resultFrame.setVisible(true);
    }
}

