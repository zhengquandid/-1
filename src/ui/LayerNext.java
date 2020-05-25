package ui;

import javax.swing.*;
import java.awt.*;

public class LayerNext extends Layer {

    private static Image[] NEXT_ACT ;

    static {
        NEXT_ACT = new Image[7];
        for (int i = 0; i < NEXT_ACT.length; i++) {
            NEXT_ACT[i] = new ImageIcon("graphics/game/"+i+".png").getImage();
        }
    }

    public LayerNext(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g){
        this.createWindow(g);
        this.drawImageAtCenter(NEXT_ACT[this.dto.getNext()],g);
    }

}
