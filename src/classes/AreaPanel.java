package classes;

import javax.swing.*;
import java.awt.*;

public class AreaPanel extends JPanel {
    public gameArea area;

    int size;
    int result = 0;
    JPanel[][] areaPanels;
    JLabel[][] areaLabels;
    ControlPanel controller;

    public void update(){
        int curRes = 0;
        for (int i=0;i<size;i++){
            for(int j=0;j<size;j++) {
                int value = area.get(i, j);
                areaLabels[i][j].setText(Integer.toString(value));
                areaPanels[i][j].setBackground(getColor(value));
                curRes+=value;
            }
        }
        controller.update(curRes);
    }

    public void move(directions dir){
        switch (dir){
            case UP -> area.moveUp();
            case DOWN -> area.moveDown();
            case LEFT -> area.moveLeft();
            case RIGHT -> area.moveRight();
        };
        this.update();

    }

    public void reset(){
        area.reset();
    }

    public AreaPanel(int size, ControlPanel cont){
        this.size = size;
        area = new gameArea(size);
        controller = cont;
        areaPanels = new JPanel[size][size];
        areaLabels = new JLabel[size][size];
        this.setLayout(new GridLayout(size,size));
        for (int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                JPanel newPanel = new JPanel();
                int value = area.get(i,j);

                JLabel newLabel = new JLabel(Integer.toString(value));
                newLabel.setFont(new Font("Arial", Font.PLAIN, 32));

                newPanel.add(newLabel);
                newPanel.setBackground(getColor(value));
                newPanel.setLayout(new GridBagLayout());
                newPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                areaPanels[i][j] = newPanel;
                areaLabels[i][j] = newLabel;
                //newPanel.setVisible(true);
                this.add(newPanel);
            }
        }
        this.update();
    }

    private static Color getColor(int tile) {
        return switch (tile) {
            case 0 -> new Color(0xcdc1b4);
            case 2 -> new Color(0xeee4da);
            case 4 -> new Color(0xede0c8);
            case 8 -> new Color(0xf2b179);
            case 16 -> new Color(0xf59563);
            case 32 -> new Color(0xf67c5f);
            case 64 -> new Color(0xf65e3b);
            case 128 -> new Color(0xedcf72);
            case 256 -> new Color(0xedcc61);
            case 512 -> new Color(0xedc850);
            case 1024 -> new Color(0xedc53f);
            case 2048 -> new Color(0xedc22e);
            default -> Color.blue;
        };
    }

    public int getResult() {
        return result;
    }
    public void setResult(){
        result=0;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public enum directions{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

}



