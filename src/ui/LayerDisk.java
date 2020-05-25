package ui;

import javax.swing.*;
import java.awt.*;

public class LayerDisk extends LayerData{

    private static Image IMG_DISK = new ImageIcon("graphics/string/disk.png").getImage();

    public LayerDisk(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g){
        this.createWindow(g);
        g.drawImage(IMG_DISK,this.x+PADDING,this.y+PADDING,null);
        this.showData(IMG_DISK,this.dto.getDiskRecode(),g);
    }
}
