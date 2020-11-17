package ui.ui.Tabs;

import ui.model.Snack;
import ui.model.Tickets;
import ui.ui.ButtonNames;
import ui.ui.SmartSellUI;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Report extends Tab {

    private static final String REPORT_GEN_MESSAGE = "Latest report: Today at ";


    private JScrollPane reportPane;
    private JTextArea reportText;
    private JLabel reportMessage;
    private String currTime;
    private SimpleDateFormat timeFormat;
    private Date currDate;

    public Report(SmartSellUI controller) {
        super(controller);
        currDate = Calendar.getInstance().getTime();
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        updateCurrTime();

        placeReportButton();

        JPanel reportBlock = new JPanel(new GridLayout(2, 1));
        reportBlock.setSize(SmartSellUI.WIDTH - (SmartSellUI.WIDTH / 5),
                SmartSellUI.HEIGHT - (SmartSellUI.HEIGHT / 5));
        reportMessage = new JLabel("");
        reportPane = new JScrollPane(new JTextArea(6, 40));
        reportText = new JTextArea("", 6, 40);
        reportText.setVisible(true);

        reportBlock.add(reportMessage);
        reportBlock.add(reportPane);

        add(reportBlock);
    }

    private void placeReportButton(){
        JButton b1 = new JButton(ButtonNames.GENERATE_REPORT.getValue());
        JPanel buttonRow = format(b1);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        b1.addActionListener(e -> {
            String buttonPressed = e.getActionCommand();
            if(buttonPressed.equals(ButtonNames.GENERATE_REPORT.getValue())){
                updateCurrTime();
                String message = REPORT_GEN_MESSAGE + currTime;
                try {
                    List<String> lines = Files.readAllLines(Paths.get("output"));
                    StringBuilder sb = new StringBuilder();
                    for (String line : lines) {
                        sb.append(line).append("\n");
                    }
                    reportText.setText(sb.toString()+ "Infomation has been saved");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                reportMessage.setText(message);

                reportPane.setViewportView(reportText);
            }
        });

        this.add(buttonRow);
    }


    //MODIFIES: this
    //EFFECTS: updates current time in format HH:mm:ss
    private void updateCurrTime(){
        currDate = Calendar.getInstance().getTime();
        currTime = timeFormat.format(currDate);
    }

}


