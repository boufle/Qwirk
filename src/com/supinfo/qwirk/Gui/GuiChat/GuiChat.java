package com.supinfo.qwirk.Gui.GuiChat;

import com.supinfo.qwirk.Database.ApplicationData;
import com.supinfo.qwirk.Entity.Channel;
import com.supinfo.qwirk.Entity.Message;
import com.supinfo.qwirk.Gui.GuiWindowsBar.GuiWindowsBarChannel;
import com.supinfo.qwirk.Gui.utils.MultilineTableCell;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.net.URL;

/**
 * Created by Boufle on 12/12/2016.
 */
public class GuiChat extends JPanel {

    protected MultilineTableCell wordWrapRenderer = new MultilineTableCell();

    public GuiChat(int chanID){
        setLayout(new BorderLayout());

/*        setAutoscrolls(true);
        setLayout(new GridLayout(20,0));
        setBackground(Color.BLACK);
        for (Message i: ApplicationData.getInstance().getData().getChannelByID(chanID).getMessages()){

            GuiMessage text = new GuiMessage(i.getTexte() + "  "+i.getDate() + "\n");
            add(text);
        }*/

        String[] header = {"user","Name", "date"};
        String[] a = new String[0];

        Object[][] data = new Object[ ApplicationData.getInstance().getData().getChannelByID(chanID).getMessages().size()*2][3];
        int compteurmess = 0;
        int compteuruser = 0;
        for (int ii=0; ii< ApplicationData.getInstance().getData().getChannelByID(chanID).getMessages().size()*2; ii++) {

            if(ii % 2 == 0){
                try{
                    data[ii][1] = ApplicationData.getInstance().getData().getChannelByID(chanID).getMessages().get(compteuruser).getUser().getPseudo();
                    data[ii][0] = new ImageIcon(new URL(ApplicationData.getInstance().getData().getChannelByID(chanID).getMessages().get(compteuruser).getUser().getProfil_Icon()));
                    data[ii][2] = "";
                    compteuruser++;
                }
                catch (Exception e){
                    data[ii][1] = "???";
                    compteuruser++;
                }
            }
            else {
                data[ii][1] = ApplicationData.getInstance().getData().getChannelByID(chanID).getMessages().get(compteurmess).getTexte() ;
                data[ii][2] = String.valueOf(ApplicationData.getInstance().getData().getChannelByID(chanID).getMessages().get(compteurmess).getDate());
                compteurmess++;
            }

        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        JTable table = new JTable(model) {

            public Component prepareRenderer(TableCellRenderer renderer,int row,int column)
            {
                Component comp=super.prepareRenderer(renderer,row, column);
                if(column==1 && row %2 ==0)
                {
                    comp.setForeground(Color.GREEN);
                }
                else {
                    comp.setForeground(Color.black);
                }
                return comp;

            }

            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setTableHeader(null);
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        table.setShowGrid(false);
        table.setCellEditor(null);
        table.setRowHeight(50);
        table.setRowMargin(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(1).setMinWidth(905);
        table.getColumnModel().getColumn(1).setPreferredWidth(905);
        table.scrollRectToVisible(table.getCellRect(table.getRowCount(), 2, true));


        try {
            // 1.6+
            table.setAutoCreateRowSorter(true);
        } catch(Exception continuewithNoSort) {
        }
        JScrollPane tableScroll = new JScrollPane(table);
        Dimension tablePreferred = tableScroll.getPreferredSize();
       /* tableScroll.setPreferredSize(
                new Dimension(tablePreferred.width, tablePreferred.height/3) );*/

        add(tableScroll, BorderLayout.CENTER);


    }
}
