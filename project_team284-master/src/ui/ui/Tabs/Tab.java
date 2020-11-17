package ui.ui.Tabs;

import ui.ui.SmartSellUI;

import javax.swing.*;
import java.awt.*;

public abstract class Tab extends JPanel {

    private SmartSellUI controller;

    public Tab(SmartSellUI controller){
        this.controller = controller;
    }

    public JPanel format(JButton b){
      JPanel p = new JPanel();
      p.setLayout(new FlowLayout());
      p.add(b);

      return p;
    }

    public SmartSellUI getController() {
        return controller;
    }
}
