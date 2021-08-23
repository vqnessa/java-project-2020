package NotificationSystem.Presentation;

import NotificationSystem.Data.Database;
import NotificationSystem.Logic.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Vanessa Watson
 * @version 11.5.2020
 *
 */

public class NotificationSystem {
    private JTextField caName;
    private JTextField caUsername;
    private JTextField caEmail;
    private JPasswordField createPassword;
    private JPasswordField confirmPassword;
    private JButton registerButton;
    private JTextField siUsername;
    private JPasswordField siPassword;
    private JButton loginButton;
    private JPanel rootPanel;
    private JButton deactivateAccountButton;

    public static String passwordDB;
    public static String emailDB;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public NotificationSystem() {

        deactivateAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pw = new String(siPassword.getPassword());
                String user = siUsername.getText();
                boolean userExists = Database.checkUserExists(user);
                passwordDB = User.hashPassword(new String(createPassword.getPassword()), User.salt.toString());
                try {
                    if (user.equals("") || pw.equals("")) {
                        JOptionPane.showMessageDialog(rootPanel, "Enter username and password to deactivate");
                    } else if (userExists) {
                            User.hashPassword(new String(siPassword.getPassword()), User.salt.toString());
                            Database.deactivateAccount(user);
                            JOptionPane.showMessageDialog(rootPanel, "Account Deactivated");
                    } else {
                        JOptionPane.showMessageDialog(rootPanel, "User does not exist");
                    }

                    siUsername.setText(null);
                    siPassword.setText(null);

                } catch (Exception ex) {

                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pw = new String(siPassword.getPassword());
                String user = siUsername.getText();
                boolean userExists = Database.checkUserExists(user);
                try {
                    if (user.equals("") || pw.equals("")) {
                        JOptionPane.showMessageDialog(rootPanel, "Enter username and password to sign in");
                    } else if (userExists) {
                        User.hashPassword(new String(siPassword.getPassword()), User.salt.toString());
                        JOptionPane.showMessageDialog(rootPanel, "Sucessfully signed in!");
                    } else {
                        JOptionPane.showMessageDialog(rootPanel, "User does not exist");
                    }
                } catch (Exception ex) {

                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = getFirstName();
                String lastName = getLastName();
                String username = getUsername();
                String salt = getSalt();
                String role = getRole();
                String pw = new String(createPassword.getPassword());

                boolean email1 = User.verifyEmail(caEmail.getText());
                if(!email1) {
                    JOptionPane.showMessageDialog(rootPanel, "Invalid Email");
                }

                boolean password = User.registerPassword(new String(createPassword.getPassword()), new String(confirmPassword.getPassword()));
                if(!password) {
                    JOptionPane.showMessageDialog(rootPanel, "Passwords must match.");
                } else if(pw.equals("")) {
                    JOptionPane.showMessageDialog(rootPanel,"Enter password");
                }

                if(password && email1) {
                    passwordDB = User.hashPassword(new String(createPassword.getPassword()), User.salt.toString());
                    emailDB = caEmail.getText();
                    Database.insert(firstName,lastName,username,passwordDB,salt,emailDB,role);
                    JOptionPane.showMessageDialog(rootPanel, "Successfully signed up!");
                }

                caName.setText(null);
                caEmail.setText(null);
                createPassword.setText(null);
                confirmPassword.setText(null);
            }
        });
    }

    public String getFirstName() {
        try {
            String firstName = caName.getText();
            if(firstName.equals("")) {
                JOptionPane.showMessageDialog(rootPanel, "Please enter first name");
            } else {
                return firstName;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPanel, "Please enter first name");
        }
        return null;
    }

    public String getLastName() {
        try {
            String lastName = caName.getText();
            if(lastName.equals("")) {
                JOptionPane.showMessageDialog(rootPanel, "Please enter last name");
            } else {
                return lastName;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPanel, "Please enter last name");
        }
        return null;
    }

    public String getUsername() {
        try {
            String username = caUsername.getText();
            if(username.equals("")) {
                JOptionPane.showMessageDialog(rootPanel, "Please enter username");
            } else {
                return username;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPanel, "Please enter username");
        }
        return null;
    }

    public String getSalt() {
        return User.generateSalt();
    }

    public String getRole() {
        return null;
    }
}
