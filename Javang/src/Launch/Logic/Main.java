package Launch.Logic;

import Launch.Presentation.LaunchPage;

import javax.swing.*;

/**
 *
 * This is the main class of the Launch page
 *
 * @author Florida
 * @version 11.15.2020
 */

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
    /**
     * This will create the properties of my GUI frame
     */
    private static void createGUI() {
        LaunchPage presentation = new LaunchPage();
        JPanel root = presentation.getRootPanel();
        JFrame frame = new JFrame("Launch Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
