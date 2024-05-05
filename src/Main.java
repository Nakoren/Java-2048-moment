
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import classes.AreaPanel;
import classes.ControlPanel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ControlPanel controlPanel;
    static AreaPanel area;

    static void gameReset(){
        area.reset();
        controlPanel.update(area.getResult());
        area.update();
    };

    static void addResetListener(JFrame frame){

        controlPanel.resetButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        gameReset();
                    }
                }
        );
        frame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                System.out.println("Pressed");
                int code = e.getKeyCode();
                switch (code){
                    case KeyEvent.VK_W -> area.move(AreaPanel.directions.UP);
                    case KeyEvent.VK_S -> area.move(AreaPanel.directions.DOWN);
                    case KeyEvent.VK_A -> area.move(AreaPanel.directions.LEFT);
                    case KeyEvent.VK_D -> area.move(AreaPanel.directions.RIGHT);
                }
            }
        });
    }


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("2048+ game");
                int size = 4;

                controlPanel = new ControlPanel();
                area = new AreaPanel(size, controlPanel);
                addResetListener(f);

                JPanel upFiller = new JPanel();
                upFiller.setPreferredSize(new Dimension(10,30));

                JPanel rightFiller = new JPanel();
                rightFiller.setPreferredSize(new Dimension(30,10));

                JPanel leftFiller = new JPanel();
                leftFiller.setPreferredSize(new Dimension(30,10));

                f.setFocusable(true);
                f.setLayout(new BorderLayout());
                f.add(area, BorderLayout.CENTER);
                f.add(controlPanel, BorderLayout.SOUTH);
                f.add(upFiller, BorderLayout.NORTH);
                f.add(rightFiller, BorderLayout.EAST);
                f.add(leftFiller, BorderLayout.WEST);
                f.setSize(900,600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });


    }
}