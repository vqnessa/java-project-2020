package TemplateCreation.Presentation;

import TemplateCreation.Data.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Template Creation Story GUI
 * @author  Melissa Chan
 * @version 11.11.2020
 */
public class TemplateCreation {
    private JPanel rootPanel;
    private JLabel templateField;
    private JTextField nameTextField;
    private JLabel templateNameField;
    private JTextField tagField;
    private JLabel tagTextField;
    private JTextField subjectTextField;
    private JLabel mainSubject;
    private JTextArea bodyTextField;
    private JButton saveButton;
    public TemplateCreation() {
        //This is the action listener for the save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = getName();
                String tag = getTags();
                String subject = getSubject();
                String body = getBody();
                JOptionPane.showMessageDialog(null,"Template saved!");

                Database.insert(name,tag,subject,body);
            }
        });
    }
/**
 * gets the name from nameTextField
 * @return name, null if no input
 */
    public String getName(){
        try {
            String name = nameTextField.getText();
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null,"Please enter text","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                return name;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Please enter text","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    /**
     * gets the tag from tagField
     * @return tag, null if no input
     */
    public String getTags(){
        try {
            String tags = tagField.getText();
            if (tags.equals("")) {
                JOptionPane.showMessageDialog(null,"Please enter text","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                return tags;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Please enter text.","Error",JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
    /**
     * gets the subject from subjectTextField
     * @return subject, null if no input
     */
    public String getSubject(){
        try {
            String subject = subjectTextField.getText();
            if (subject.equals("")) {
                JOptionPane.showMessageDialog(null,"Please enter text.","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                return subject;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Please enter text.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    /**
     * gets the body from bodyTextField
     * @return body, null if no input
     */
    public String getBody(){
        try {
            String body = bodyTextField.getText();
            if (body.equals("")) {
                JOptionPane.showMessageDialog(null,"Please enter text.","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                return body;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Please enter text.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * gets root panel
     * @return rootPanel
     */

    public JPanel getRootPanel(){
        return rootPanel;
    }
}

