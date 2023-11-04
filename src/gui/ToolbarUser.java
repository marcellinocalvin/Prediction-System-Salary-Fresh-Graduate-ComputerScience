package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarUser extends JPanel implements ActionListener {

    private JButton refreshButton;

    private StringListenerUser textListener;

    public ToolbarUser() {
        setBorder(BorderFactory.createEtchedBorder());

        refreshButton = new JButton("Refresh");

        refreshButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(refreshButton);
    }

    public void setStringListener(StringListenerUser listener) {

        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if(clicked == refreshButton) {
            if(textListener != null) {
                textListener.refreshText();
            }
        }
    }
}
