package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CreateUser extends JFrame {
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JButton buttonSubmit;

    public static void connect() {
        try {
            Driver MysqlDriver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CreateUser() {
        super("Create User");

        setSize(350,300);

        JPanel panel = new JPanel(new BorderLayout());

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        panel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        nameLabel = new JLabel("name: ");
        nameField = new JTextField(20);
        panel.add(nameLabel);
        panel.add(nameField);

        usernameLabel = new JLabel("username: ");
        usernameField = new JTextField(20);
        panel.add(usernameLabel);
        panel.add(usernameField);

        passwordLabel = new JLabel("password: ");
        passwordField = new JTextField(20);
        panel.add(passwordLabel);
        panel.add(passwordField);

        buttonSubmit = new JButton("submit");
        panel.add(buttonSubmit);

        buttonSubmit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String jdbcUrl = "jdbc:mysql://localhost:3306/user";
                String username1 = "root";
                String password1 = "";

                try {
                    connect();
                    Connection connection = DriverManager.getConnection(jdbcUrl, username1, password1);

                    String sql = "INSERT INTO login (name, username, password) VALUES (?, ?, ?)";

                    String name = nameField.getText();
                    String username = usernameField.getText();
                    String password = passwordField.getText();

                    PreparedStatement statement = connection.prepareStatement(sql);

                    statement.setString(1, name);
                    statement.setString(2, username);
                    statement.setString(3, password);

                    int rowsInserted = statement.executeUpdate();
                    if ((rowsInserted > 0)) {
                        System.out.println(rowsInserted);
                        System.out.println("user " + name + " was inserted successfully");
                        new Login();
                        dispose();
                    }

                    statement.close();
                    connection.close();

                } catch (SQLException s) {
                    s.printStackTrace();
                }
                nameField.setText("");
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        layoutComponents();

        add(panel);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        /// contoh /////////////
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 0;
        add(nameLabel, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(nameField, gc);

        /// next row ///////////
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 1;
        add(usernameLabel, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        add(usernameField, gc);

        /// next row ///////////
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 2;
        add(passwordLabel, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        add(passwordField, gc);

        /// final row ///////////
        gc.weighty = 7;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 3;
        add(buttonSubmit, gc);

    }


}
