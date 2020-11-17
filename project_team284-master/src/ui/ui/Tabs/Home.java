package ui.ui.Tabs;


import ui.model.Movie;
import ui.ui.ButtonNames;
import ui.ui.SmartSellUI;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Home extends Tab {


    private String currTime;
    private SimpleDateFormat timeFormat;
    private Date currDate;
    private Movie m;
    private static final String MESSAGE = "The time is";
    private JLabel basicinfo, ticketinfo;


    public Home(SmartSellUI controller) throws IOException {
        super(controller);
        currDate = Calendar.getInstance().getTime();
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        setLayout(new GridLayout(5, 4));
        updateCurrTime();
        placeInfo();
        placeHomeButtons();
        placeStatusButton();

        m = new Movie();
    }

    private void placeInfo() throws IOException {
        String message = MESSAGE + currTime;
        String mes = "<html>" + message + "<br>" + outputURL() + "<br>" + load() + "</html>";
        basicinfo = new JLabel(mes, JLabel.CENTER);
        ticketinfo = new JLabel("", JLabel.CENTER);
        basicinfo.setSize(WIDTH, HEIGHT / 3);
        ticketinfo.setSize(WIDTH, HEIGHT / 3);

        this.add(basicinfo);
        this.add(ticketinfo);
    }


    private String outputURL() throws IOException {
        BufferedReader br = null;
        try {
            String theURL = "https://www.ugrad.cs.ubc.ca/~cs210/2018w1/welcomemsg.html";
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    private String load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("input"));
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
        }
        return sb.toString();
    }

    private void placeHomeButtons() {
        JPanel Block = new JPanel();
        JButton b1 = new JButton(ButtonNames.ATICKETS.getValue());
        JButton b2 = new JButton(ButtonNames.BTICKETS.getValue());
        JButton b3 = new JButton(ButtonNames.CTICKETS.getValue());

        Block.add(format(b1));
        Block.add(format(b2));
        Block.add(format(b3));

        b1.addActionListener(e -> {
            String buttonPressed = e.getActionCommand();
            if (buttonPressed.equals(ButtonNames.ATICKETS.getValue())) {
                ticketinfo.setText("There is a reminder, we have" + m.getSum("A") + " tickets left" + currTime);
                openWebpage("https://www.youtube.com/watch?v=Wj1devH5JP4");

            }
        });

        b2.addActionListener(e -> {
            String buttonPressed = e.getActionCommand();
            if (buttonPressed.equals(ButtonNames.BTICKETS.getValue())) {
                ticketinfo.setText("There is a reminder, we have " + m.getSum("B") + " tickets left" + currTime);
                openWebpage("https://www.youtube.com/watch?v=6ZfuNTqbHE8");

            }

        });

        b3.addActionListener(e -> {
            String buttonPressed = e.getActionCommand();

            if (buttonPressed.equals(ButtonNames.CTICKETS.getValue())) {
                ticketinfo.setText("There is a reminder, we have " + m.getSum("C") + " tickets left" + currTime);
                openWebpage("https://www.youtube.com/watch?v=TbQm5doF_Uc");
            }

        });
        this.add(Block);
    }

    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void placeStatusButton() {
        JPanel statusBlock = new JPanel();
        JButton Button1 = new JButton(ButtonNames.TICKETS.getValue());
        JButton Button2 = new JButton(ButtonNames.SNACK.getValue());

        statusBlock.add(format(Button1));
        statusBlock.add(format(Button2));

        Button1.addActionListener(e -> {
            String buttonPressed = e.getActionCommand();
            if (buttonPressed.equals(ButtonNames.TICKETS.getValue())) {
                getController().getTabbedPane().setSelectedIndex(SmartSellUI.TICKETS_TAB_INDEX);
            }

        });

        Button2.addActionListener(e -> {
            String buttonPressed = e.getActionCommand();
            if (buttonPressed.equals(ButtonNames.SNACK.getValue())) {
                getController().getTabbedPane().setSelectedIndex(SmartSellUI.SNACK_TAB_INDEX);
            }
        });

        this.add(statusBlock);
    }

    private void updateCurrTime() {
        currDate = Calendar.getInstance().getTime();
        currTime = timeFormat.format(currDate);
    }
}
