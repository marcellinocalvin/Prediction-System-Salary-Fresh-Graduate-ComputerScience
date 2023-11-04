package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public static void connect() {
        try {
            Driver MysqlDriver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Login() {
        super("Login Form");

        setSize(310, 150);

        JPanel panel = new JPanel();

        usernameLabel = new JLabel("username");
        usernameField = new JTextField(20);
        panel.add(usernameLabel);
        panel.add(usernameField);

        passwordLabel = new JLabel("password");
        passwordField = new JPasswordField(20);
        panel.add(passwordLabel);
        panel.add(passwordField);


        JButton loginButton = new JButton("Login");

        JButton toCreateButton = new JButton("Register");

        toCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateUser();
                dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String jdbcUrl = "jdbc:mysql://localhost:3306/user";
                String username1 = "root";
                String password1 = "";

                try {
                    connect();
                    Connection connection = DriverManager.getConnection(jdbcUrl, username1, password1);

                    String sql = "SELECT * FROM login WHERE username = ? AND password = ?";

                    String username = usernameField.getText();
                    String password = passwordField.getText();

                    ArrayList<String> usernameList = new ArrayList<>();
                    ArrayList<String> passwordList = new ArrayList<>();

                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, username);
                    statement.setString(2, password);

                    ResultSet resultSet = statement.executeQuery();

                    while(resultSet.next()) {
                        usernameList.add(resultSet.getString(3));
                        passwordList.add(resultSet.getString(4));
                    }

                    if (username.equals("admin") && password.equals("admin123")) {
                        new AdminPage();
                    }

                    for (int i = 0; i < usernameList.size(); i++) {
                        if (usernameList.get(i).equals(username) &&
                                passwordList.get(i).equals(password)) {
                            new UserPage();
                        }
                    }

                    resultSet.close();
                    statement.close();
                    connection.close();

                } catch (SQLException s) {
                    s.printStackTrace();
                }

            }
        });

        panel.add(loginButton);

        panel.add(toCreateButton);

        add(panel);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Authentication(String username, String password) {



    }

}
