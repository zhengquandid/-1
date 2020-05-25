package ui;

import javax.swing.*;
import java.awt.*;

public class LayerBackground extends Layer {

    private static Image IMG_BG_TEMP1 = new ImageIcon("graphics/background/1.jpg").getImage();
    private static Image IMG_BG_TEMP2 = new ImageIcon("graphics/background/2.jpg").getImage();
    private static Image IMG_BG_TEMP3 = new ImageIcon("graphics/background/3.jpg").getImage();
    private static Image IMG_BG_TEMP4 = new ImageIcon("graphics/background/4.jpg").getImage();
    private static Image IMG_BG_TEMP5 = new ImageIcon("graphics/background/5.jpg").getImage();
    private static Image IMG_BG_TEMP6 = new ImageIcon("graphics/background/6.jpg").getImage();
    private static Image IMG_BG_TEMP7 = new ImageIcon("graphics/background/7.jpg").getImage();

    public LayerBackground(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g){
        switch (this.dto.getnowLevel() % 7){
            case 1:
                g.drawImage(IMG_BG_TEMP1,0,0,1162,654,null);
                break;
            case 2:
                g.drawImage(IMG_BG_TEMP2,0,0,1162,654,null);
                break;
            case 3:
                g.drawImage(IMG_BG_TEMP3,0,0,1162,654,null);
                break;
            case 4:
                g.drawImage(IMG_BG_TEMP4,0,0,1162,654,null);
                break;
            case 5:
                g.drawImage(IMG_BG_TEMP5,0,0,1162,654,null);
                break;
            case 6:
                g.drawImage(IMG_BG_TEMP6,0,0,1162,654,null);
                break;
            case 0:
                g.drawImage(IMG_BG_TEMP7,0,0,1162,654,null);
                break;
        }
    }
}
