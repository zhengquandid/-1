package ui;

import javax.swing.*;
import java.awt.*;


public class LayerDataBase extends LayerData {

    private static Image IMG_DB = new ImageIcon("graphics/string/db.png").getImage();

    private static Image IMG_DISK = new ImageIcon("graphics/string/disk.png").getImage();

    public LayerDataBase(int x, int y, int w, int h){
        super(x,y,w,h);

    }

    public void paint(Graphics g){
        this.createWindow(g);
        this.showData(IMG_DB,this.dto.getDbRecode(),g);
        }
    }

