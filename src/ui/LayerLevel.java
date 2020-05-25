package ui;

import javax.swing.*;
import java.awt.*;

public class LayerLevel extends Layer {
    /**
     * 标题图片
     */
    private static final Image IMG_LV = new ImageIcon("graphics/string/level.png").getImage();


    public LayerLevel(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        //窗口标题
        int centerX = (this.w - IMG_LV.getWidth(null) )/ 2;
        g.drawImage(IMG_LV,this.x+centerX, this.y + PADDING, null);
        //显示等级
        this.drawNumberLeftPad(centerX, 64, this.dto.getnowLevel(), 2, g);
    }

}
