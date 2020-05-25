package ui;

import javax.swing.*;
import java.awt.*;

public class LayerAbout extends Layer {

    private static Image IMG_AU= new ImageIcon("graphics/string/au.png").getImage();

    public LayerAbout(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g){
        this.createWindow(g);
        this.drawImageAtCenter(IMG_AU,g);
    }
}
