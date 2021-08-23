package TemplateCreation.Logic;

import TemplateCreation.Presentation.TemplateCreation;

import javax.swing.*;

public class TemplateMain {

    public static void createAndShowGui() {
        JFrame frame = new JFrame("Template Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TemplateCreation().getRootPanel());
        frame.pack();
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
