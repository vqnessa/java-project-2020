package ReviewNotificationLog.Presentation;

import ReviewNotificationLog.Data.Database;
import ReviewNotificationLog.Logic.Notification;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * The staff of the pantry can review notifications sent to avoid sending duplicate messages
 * and to make sure messages are sent regularly.
 *
 * @author Florida
 * @version 11.5.2020
 */

public class NotificationLog {

    private JPanel rootPanel;
    private JTable messageTable;
    private JButton searchButton;
    private JXDatePicker fromDatePicker;
    private JXDatePicker toDatePicker;
    private JPanel myPanel1;
    private JPanel myPanel2;
    private JPanel myPanel3;
    private JLabel fromLabel;
    private JLabel ToLabel;
    private JScrollPane myPane1;

    public NotificationLog(){
        createTable();
        createSearchButton();
        showData();
    }

    /**
     *
     * @return the rootPanel
     */
    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void showData(){

        Date fromDate = fromDatePicker.getDate();
        Date toDate = toDatePicker.getDate();
        if (fromDate == null || toDate == null){
            return;
        }

        ArrayList<Notification> notifications = Database.findData(fromDate, toDate);

        DefaultTableModel model = (DefaultTableModel) messageTable.getModel();

        model.setRowCount(0);
        for (Notification notification: notifications) {
            model.addRow(new Object[]{
                    notification.getPostedDate(),
                    notification.getPostedTime(),
                    notification.getTitle(),
                    notification.getContent(),
                    notification.getName(),
                    notification.getNum_Suscribers(),
            });
        }
    }
    private void createTable(){
        messageTable.setModel(new DefaultTableModel(
                null,
                new String[] {"Date", "Time", "Subject", "Message", "Staff Name", "Number of subscribers"}
        ));

        TableColumnModel columns = messageTable.getColumnModel();
        columns.getColumn(0).setMinWidth(50);
        columns.getColumn(1).setMinWidth(50);
        columns.getColumn(2).setMinWidth(150);
        columns.getColumn(3).setMinWidth(150);
        columns.getColumn(4).setMinWidth(150);
        columns.getColumn(5).setMinWidth(150);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

    }


    /**
     * This button will search for the notifications within the date range that the user entered
     */
    private void createSearchButton(){
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showData();
            }
        });

    }
}
