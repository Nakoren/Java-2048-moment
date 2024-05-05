package classes;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel{
    public JButton resetButton;
    JLabel resultText;
    public ControlPanel(){
        resultText = new JLabel();
        resultText.setPreferredSize(new Dimension(300,40));

        this.update(0);

        this.setLayout(new FlowLayout());
        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(300,40));
        this.add(resultText);
        this.add(resetButton);
    }

    public void update(int Result){
        resultText.setText("Result: "+Integer.toString(Result));
    }
}
