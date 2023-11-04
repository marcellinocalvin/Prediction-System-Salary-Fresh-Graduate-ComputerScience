package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;


public class Inputan extends JFrame{

    // DATA TRAINING
    static int[] arrayGenderFinal = new int[0];
    static int[] arraySertifikasiFinal = new int[0];

    // DATA TESTING
    static String gender1;
    static int pendidikanAkhir1;

    private JTextField genderField;
    private JTextField sertifikasiField;
    private JLabel genderLabel;
    private JLabel sertifikasiLabel;

    public static void connect() {
        try {
            Driver MysqlDriver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function Jarak Euclidean
    static double jarakEuclidean(int gender, int gender1, int sertifikasi, int sertifikasi1) {
        return Math.sqrt(Math.pow(sertifikasi - sertifikasi1, 2));
    }

    public Inputan() {
        super("KNN Form");

        setSize(310, 150);

        JPanel panel = new JPanel();

        genderLabel = new JLabel("gender");
        genderField = new JTextField(20);
        panel.add(genderLabel);
        panel.add(genderField);

        sertifikasiLabel = new JLabel("sertifikasi");
        sertifikasiField = new JTextField(20);
        panel.add(sertifikasiLabel);
        panel.add(sertifikasiField);


        JButton inputButton = new JButton("Input");


        inputButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String jdbcUrl = "jdbc:mysql://localhost:3306/dataset";
                String username1 = "root";
                String password1 = "";

                try {
                    connect();
                    Connection connection = DriverManager.getConnection(jdbcUrl, username1, password1);

                    String sql = "INSERT INTO inputanbaru (gender, sertifikasi) VALUES (?, ?)";

                    String gender = genderField.getText();
                    String sertifikasi = sertifikasiField.getText();

                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, gender);
                    statement.setString(2, sertifikasi);

                    int rowsInserted = statement.executeUpdate();
                    if ((rowsInserted > 0)) {
                        System.out.println(rowsInserted);
                        System.out.println("gender " + gender + " was inserted successfully");
                        new Login();
                        dispose();
                    }

                    statement.close();
                    connection.close();

                } catch (SQLException s) {
                    s.printStackTrace();
                }

            }
        });

        panel.add(inputButton);

        add(panel);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
