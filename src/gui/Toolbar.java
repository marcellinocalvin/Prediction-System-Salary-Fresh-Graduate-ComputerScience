package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Toolbar extends JPanel implements ActionListener {

    private final JButton saveButton;
    private final JButton refreshButton;
    private final JButton resetDatabaseButton;

    private ToolbarListener textListener;

    public static void connect() {
        try {
            Driver MysqlDriver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Toolbar() {
        setBorder(BorderFactory.createEtchedBorder());

        saveButton = new JButton("Save");
        refreshButton = new JButton("Refresh");
        resetDatabaseButton = new JButton("Reset Database");

        saveButton.addActionListener(this);
        refreshButton.addActionListener(this);
        resetDatabaseButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(saveButton);
        add(refreshButton);
        add(resetDatabaseButton);
    }

    public void setToolbarListener(ToolbarListener listener) {

        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        String jdbcUrl = "jdbc:mysql://localhost:3306/dataset";
        String username = "root";
        String password = "";

        if (clicked == saveButton) {
            if(textListener != null) {
                textListener.saveEventOccured();
            }
        } else if (clicked == refreshButton) {
            if(textListener != null) {
                textListener.refreshEventOccured();
            }
        } else if (clicked == resetDatabaseButton) {
            try{
                connect();
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                Statement statement = connection.createStatement();

                String sql = "delete from people";

                int resultSet = statement.executeUpdate(sql);

                // CLOSE CONNECTION
                statement.close();
                connection.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
