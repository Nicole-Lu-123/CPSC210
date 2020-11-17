package ui.ui.Tabs;

import ui.model.*;
import ui.ui.SmartSellUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TicketTab extends Tab {

    private static final String SETTINGS_TEXT = "Choose your tickets using the menu below.";
    private static final String DIALOG_TYPE = "Error";

    private static final int COLS_IN_ROW = 3;
    private static final int ROW_HEIGHT = 50;
    private static final int NUMBER_OF_TICKS = 5;
    private static final int LEFT_PADDING = 70;
    private static final int BOTTOM_PADDING = 5;
    private static final int CENTER = SwingConstants.CENTER;
    private static final int TOP = SwingConstants.TOP;

    List<String> ticketinfo;
    private Border border;
    private GridLayout rowLayout2;
    Tickets t = new Tickets();
    String type;

    public TicketTab(SmartSellUI controller){
        super(controller);
        ticketinfo = new ArrayList<>();
        type = "";
        border = BorderFactory.createEmptyBorder(0, LEFT_PADDING, BOTTOM_PADDING, 0);
        rowLayout2 = new GridLayout(1, COLS_IN_ROW);

        JLabel settings = new JLabel(SETTINGS_TEXT);
        add(settings);

        JPanel headerRow = new JPanel(rowLayout2);
        headerRow.setPreferredSize(new Dimension(SmartSellUI.WIDTH - LEFT_PADDING, ROW_HEIGHT));
        headerRow.add(new JLabel("Movie preference", CENTER));
        headerRow.add(new JLabel("Type & Num", CENTER));



        add(headerRow);
        JPanel secondRow = new JPanel(rowLayout2);
        secondRow.setPreferredSize(new Dimension(SmartSellUI.WIDTH - LEFT_PADDING, ROW_HEIGHT));
        secondRow.add(getCheckBox("A"));
        secondRow.add(getCheckBox("kid"));
        secondRow.add(getNumSlider(t));
        secondRow.add(getCheckBox("adult"));
        secondRow.add(getNumSlider(t));
        secondRow.add(getCheckBox("family"));
        secondRow.add(getNumSlider(t));
        secondRow.setBorder(border);
        add(secondRow);

        JPanel thirdRow = new JPanel(rowLayout2);
        thirdRow.setPreferredSize(new Dimension(SmartSellUI.WIDTH - LEFT_PADDING, ROW_HEIGHT));
        thirdRow.add(getCheckBox("B"));
        thirdRow.add(getCheckBox("kid"));
        thirdRow.add(getNumSlider(t));
        thirdRow.add(getCheckBox("adult"));
        thirdRow.add(getNumSlider(t));
        thirdRow.add(getCheckBox("family"));
        thirdRow.add(getNumSlider(t));
        thirdRow.setBorder(border);
        add(thirdRow);

        JPanel forthRow = new JPanel(rowLayout2);
        forthRow.setPreferredSize(new Dimension(SmartSellUI.WIDTH - LEFT_PADDING, ROW_HEIGHT));
        forthRow.add(getCheckBox("C"));
        forthRow.add(getCheckBox("kid"));
        forthRow.add(getNumSlider(t));
        forthRow.add(getCheckBox("adult"));
        forthRow.add(getNumSlider(t));
        forthRow.add(getCheckBox("family"));
        forthRow.add(getNumSlider(t));
        forthRow.setBorder(border);
        add(forthRow);
    }


    private JSlider getNumSlider(Tickets a){
        JSlider slider = new JSlider(a.minNum(), a.maxNum(),0);
        slider.setMajorTickSpacing(Math.round((a.maxNum() - a.minNum()) / NUMBER_OF_TICKS));
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new SliderListener(a));

        return slider;
    }


    private JCheckBox getCheckBox(String s){
        JCheckBox check = new JCheckBox(s);
        check.setHorizontalAlignment(CENTER);
        check.setVerticalAlignment(TOP);
        check.addActionListener(new CheckboxListener(t));

        return check;
    }



    private class CheckboxListener implements ActionListener {
        Tickets ticket;
        public CheckboxListener(Tickets t){
            ticket = t;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            if(checkBox.getModel().isSelected()){
                type = checkBox.getText();

                try {
                    ticket.infoadd(checkBox.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        }
    }

    public class SliderListener implements ChangeListener {

        Tickets ticket;

        public SliderListener(Tickets t){
            ticket = t;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider) e.getSource();
            if(!slider.getValueIsAdjusting()){
                System.out.println("You choose "+type+"    "+ slider.getValue());
                try {
                    ticket.count(type,slider.getValue());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
