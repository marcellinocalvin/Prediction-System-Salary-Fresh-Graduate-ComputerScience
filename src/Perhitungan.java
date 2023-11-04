package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;


public class Perhitungan extends JFrame{

    // DATA TRAINING
    static String[] arrayGenderFinal = new String[0];
    static String[] arraySertifikasiFinal = new String[0];

    // DATA TESTING
    static String gender1;
    static String pendidikanAkhir1;

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

    public Perhitungan() {
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


        JButton hitungButton = new JButton("Hitung");


        hitungButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String jdbcUrl = "jdbc:mysql://localhost:3306/dataset";
                String username1 = "root";
                String password1 = "";

                try {
                    connect();
                    Connection connection = DriverManager.getConnection(jdbcUrl, username1, password1);

                    String sql = "INSERT INTO inputanbaru (gender, sertifikasi) VALUES (?, ?)";

                    //ResultSet resultSet = statement.executeQuery(sql);

                    String gender = genderField.getText();
                    String sertifikasi = sertifikasiField.getText();

                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, gender);
                    statement.setString(2, sertifikasi);

                    // Array List
                    ArrayList<String> listGender = new ArrayList();
                    ArrayList<String> listSertifikasi = new ArrayList();

//                    while (resultSet.next()) {
//                        listGender.add(resultSet.getString(1));
//                        listSertifikasi.add(resultSet.getString(2));
//                    }

                    // CONVERT
                    for (int i = 0; i< listGender.size(); i++) {
                        if (listGender.get(i).equals("lakilaki")) {
                            listGender.set(i, String.valueOf(1));
                        } else {
                            listGender.set(i, String.valueOf(2));
                        }
                    }

                    for (int i = 0; i< listSertifikasi.size(); i++) {
                        if (listGender.get(i).equals("ada")) {
                            listGender.set(i, String.valueOf(1));
                        } else {
                            listGender.set(i, String.valueOf(2));
                        }
                    }

                    statement.close();
                    connection.close();

                } catch (SQLException s) {
                    s.printStackTrace();
                }

            }
        });

        panel.add(hitungButton);

        add(panel);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
