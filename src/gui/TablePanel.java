package gui;

import model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TablePanel extends JPanel {

    private JTable table;
    private PersonTableModel tableModel;
    private JPopupMenu popup;
    private PersonTableListener personTableListener;

    public void deleteColumn(int columnIndex) {
        table.removeColumn(table.getColumnModel().getColumn(columnIndex));
    }

    public TablePanel() {

        tableModel = new PersonTableModel();
        table = new JTable(tableModel);
        popup = new JPopupMenu();

        JMenuItem removeItem = new JMenuItem("Delete row");
        popup.add(removeItem);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                int row = table.rowAtPoint(e.getPoint());

                table.getSelectionModel().setSelectionInterval(row, row);

                if(e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(table, e.getX(), e.getY());
                }
            }
        });

        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if (row != -1) {
                    // Delete row
                    if (personTableListener != null) {
                        personTableListener.rowDeleted(row);
                        tableModel.fireTableRowsDeleted(row, row);

                        // Update data in database (example using JDBC)
                        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dataset", "root", "");
                             Statement stmt = conn.createStatement()) {

                            // Check that the row index is within the range of valid indices
                            if (row < tableModel.getRowCount()) {
                                String query = "DELETE FROM people WHERE id = " + tableModel.getValueAt(row, 0);
                                stmt.executeUpdate(query);
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }


        });

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Person> db) {

        tableModel.setData(db);
    }

    public void refresh() {

        tableModel.fireTableDataChanged();
    }

    public void setPersonTableListener(PersonTableListener listener) {
        this.personTableListener = listener;
    }

}
