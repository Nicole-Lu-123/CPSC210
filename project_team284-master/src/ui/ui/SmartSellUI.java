package ui.ui;


import ui.model.*;
import ui.ui.Tabs.Home;
import ui.ui.Tabs.Report;
import ui.ui.Tabs.SnackTab;
import ui.ui.Tabs.TicketTab;

import javax.swing.*;
import java.io.IOException;


public class SmartSellUI extends JFrame {
    private SmartSell smartsell;
    private JTabbedPane sidebar;

    public static final int HOME_TAB_INDEX = 0;
    public static final int SNACK_TAB_INDEX = 1;
    public static final int TICKETS_TAB_INDEX = 2;
    public static final int REPORT_TAB_INDEX = 3;


    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    public static void main(String[] args) throws IOException {
        new JTextFieldDemo1();


    }

    public SmartSellUI() throws IOException {

        super("SmartSellUI in The Star");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        smartsell = new SmartSell();
            loadStuffs();


        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        loadTabs();
        add(sidebar);

        setVisible(true);

    }


    private void loadStuffs(){
        Stuffs snack = new Snack();
        Stuffs tickets = new Tickets();

        smartsell.install(snack);
        smartsell.install(tickets);

    }
    private void loadTabs() throws IOException {
        JPanel homeTab = new Home(this);
        JPanel ticketTab = new TicketTab(this);
        JPanel snackTab = new SnackTab(this);
        JPanel reportTab = new Report(this);

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
        sidebar.add(snackTab, SNACK_TAB_INDEX );
        sidebar.setTitleAt(SNACK_TAB_INDEX , "Snack");
        sidebar.add(ticketTab, TICKETS_TAB_INDEX);
        sidebar.setTitleAt(TICKETS_TAB_INDEX, "Ticket");
        sidebar.add(reportTab, REPORT_TAB_INDEX);
        sidebar.setTitleAt(REPORT_TAB_INDEX, "Report");
    }



    public JTabbedPane getTabbedPane(){
        return sidebar;
    }

}
