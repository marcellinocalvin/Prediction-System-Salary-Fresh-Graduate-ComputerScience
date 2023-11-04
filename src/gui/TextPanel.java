package gui;

import javax.swing.*;
import java.awt.*;


public class TextPanel extends JPanel{

    private JTextArea textArea;

    public TextPanel() {
        textArea = new JTextArea();
        Font font = textArea.getFont();
        float size = font.getSize() + 100.0f;
        font.deriveFont(size);
        System.out.println(size);
        textArea.setFont(font);

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void appendText(String text) {

        textArea.append(text);
    }

    public void refreshText() {
        textArea.setText("");
    }

    public void boldText(String text) {
        StringBuffer sb = new StringBuffer();
        Font font = new Font("Arial", Font.BOLD, 16);
    }
}
