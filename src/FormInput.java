import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class FormInput extends JFrame{

    private JTextField usernameField;
    private JTextField sertifikasiField;
    private JLabel usernameLabel;
    private JLabel sertifikasiLabel;

    public static void connect() {
        try {
            Driver MysqlDriver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FormInput() {
        super("Login Form");

        setSize(310, 150);

        JPanel panel = new JPanel();

        usernameLabel = new JLabel("username");
        usernameField = new JTextField(20);
        panel.add(usernameLabel);
        panel.add(usernameField);

        sertifikasiLabel = new JLabel("password");
        sertifikasiField = new JTextField(20);
        panel.add(sertifikasiLabel);
        panel.add(sertifikasiField);


        JButton loginButton = new JButton("Login");

        JButton toCreateButton = new JButton("Register");
    }
}
