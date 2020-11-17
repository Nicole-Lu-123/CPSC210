package ui.ui.Tabs;

import ui.model.Snack;
import ui.ui.SmartSellUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SnackTab extends Tab {
    private static final String SETTINGS_TEXT = "Choose your tickets using the menu below.";
    private JTextArea reportText;
    private JScrollPane reportPane;
    private static final int COLS_IN_ROW = 3;
    private static final int ROW_HEIGHT = 50;
    private static final int LEFT_PADDING = 100;
    private static final int BOTTOM_PADDING = 5;
    private static final int CENTER = SwingConstants.CENTER;
    private static final int TOP = SwingConstants.TOP;
    String type;
    Snack snack;
    private Border border;
    private GridLayout rowLayout;
    Snack s = new Snack();

    public SnackTab(SmartSellUI controller){
        super(controller);
        snack = new Snack();
        border = BorderFactory.createEmptyBorder(0, LEFT_PADDING, BOTTOM_PADDING, 0);
        rowLayout = new GridLayout(1, COLS_IN_ROW);

        JLabel settings = new JLabel(SETTINGS_TEXT);
        add(settings);

        JPanel headerRow = new JPanel(rowLayout);
        headerRow.setPreferredSize(new Dimension(SmartSellUI.WIDTH - LEFT_PADDING, ROW_HEIGHT / 2));
        headerRow.add(new JLabel("Snack", CENTER));
        headerRow.add(new JLabel("Size", CENTER));
        headerRow.add(new JLabel("Num", CENTER));

        add(headerRow);

        JPanel secondRow = new JPanel(rowLayout);
        secondRow.setPreferredSize(new Dimension(SmartSellUI.WIDTH - LEFT_PADDING, ROW_HEIGHT));
        secondRow.add(getCheckBox("Popcorn"));
        secondRow.add(getCheckBox("16 oz"));
        secondRow.add(getNumSlider(s));
        secondRow.add(getCheckBox("12 oz"));
        secondRow.add(getNumSlider(s));
        secondRow.add(getCheckBox("8 oz"));
        secondRow.add(getNumSlider(s));
        secondRow.setBorder(border);
        add(secondRow);

        JPanel thirdRow = new JPanel(rowLayout);
        thirdRow.setPreferredSize(new Dimension(SmartSellUI.WIDTH - LEFT_PADDING, ROW_HEIGHT));
        thirdRow.add(getCheckBox("Iced drink"));
        thirdRow.add(getCheckBox("16 oz"));
        thirdRow.add(getNumSlider(s));
        thirdRow.add(getCheckBox("12 oz"));
        thirdRow.add(getNumSlider(s));
        thirdRow.add(getCheckBox("8 oz"));
        thirdRow.add(getNumSlider(s));
        thirdRow.setBorder(border);
        add(thirdRow);

        JPanel forthRow = new JPanel(rowLayout);
        forthRow.setPreferredSize(new Dimension(SmartSellUI.WIDTH - LEFT_PADDING, ROW_HEIGHT));
        forthRow.add(getCheckBox("Hotted drink"));
        forthRow.add(getCheckBox("16 oz"));
        forthRow.add(getNumSlider(s));
        forthRow.add(getCheckBox("12 oz"));
        forthRow.add(getNumSlider(s));
        forthRow.add(getCheckBox("8 oz"));
        forthRow.add(getNumSlider(s));
        forthRow.setBorder(border);
        add(forthRow);
    }

    private JSlider getNumSlider(Snack a) {
        JSlider slider = new JSlider(a.minNum(), a.maxNum(), 0);
        slider.setMajorTickSpacing(Math.round((a.maxNum() - a.minNum()) / 4));
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new SnackTab.SliderListener(a));

        return slider;
    }


    private JCheckBox getCheckBox(String a) {
        JCheckBox check = new JCheckBox(a);
        check.setHorizontalAlignment(CENTER);
        check.setVerticalAlignment(TOP);
        check.addActionListener(new SnackTab.CheckboxListener(s));

        return check;
    }

    private class CheckboxListener implements ActionListener {
        Snack snack;


        CheckboxListener(Snack a) {
            snack = a;

        }


        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            boolean Typechoose = checkBox.getModel().isSelected();
            if (Typechoose) {
                type = checkBox.getText();
                try {
                    snack.infoadd(checkBox.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        }

        //REQUIRES: a, s != null
        //EFFECTS: creates on/off buttons in group with listeners for this appliance


    }

    private class SliderListener implements ChangeListener {
        Snack snack;

        SliderListener(Snack a) {
            snack = s;
        }


        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider) e.getSource();
            if (!slider.getValueIsAdjusting()) {
                System.out.println("You choose " + type + "     " + slider.getValue());
                try {
                    snack.count(type, slider.getValue());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}