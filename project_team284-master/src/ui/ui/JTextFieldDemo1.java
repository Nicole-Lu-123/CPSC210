package ui.ui;

import javafx.stage.WindowEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.io.IOException;

public class JTextFieldDemo1 {
    private JFrame jf;
    private JPanel jp;
    private JTextField jtf1,jtf2;
    private int n;

    public JTextFieldDemo1() throws IOException {

        jf = new JFrame("Check waiting num");

        Container contentPane = jf.getContentPane();
        contentPane.setLayout(new BorderLayout());

        jp = new JPanel();

        jtf1 = new JTextField("Please inter your num");
        jtf2 = new JTextField(60);
        JButton b1 = new JButton("Ensure");

        jtf1.setEnabled(false);
        jtf1.setFont(new Font("Theme and new",Font.BOLD,16));
        jp.add(jtf1);
        jp.add(jtf2);
        jp.add(b1);

        contentPane.add(jp);
        jf.pack();
        jf.setLocation(400, 200);
        jf.setVisible(true);

        b1.addActionListener(e -> {
            String buttonPressed = e.getActionCommand();
            if (buttonPressed.equals("Ensure")) {
                n = Integer.parseInt(jtf2.getText());
                if (n < 2){
                    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    jf.setVisible(false);
                    System.exit(0);
                }
                jf.setVisible(false);
                    jf.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                                System.exit(0);
                        }
                });
            }
            try {
                new SmartSellUI();
            } catch (Exception err) {
                // do nothing
            }

        });

    }


}
