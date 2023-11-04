package gui;

import javax.swing.*;

public class AppBaru {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new Login();
            }
        });
    }
}
