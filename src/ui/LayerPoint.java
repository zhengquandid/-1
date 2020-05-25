package ui;

import javax.swing.*;
import java.awt.*;

public class LayerPoint extends Layer {
    /**
     * 窗口标题(分数)
     */
    private static final Image IMG_POINT = new ImageIcon("graphics/string/point.png").getImage();
    /**
     * 窗口标题（消行）
     */
    private static final Image IMG_RMLINE= new ImageIcon("graphics/string/rmline.png").getImage();

    //TODO
    private static final int LEVEL_UP = 20;


    private static final int POINT_BIT = 5;
    /**
     * 消行Y坐标
     */
    private final int rmLineY;
    /**
     * 分数Y坐标
     */
    private final int pointY;
    /**
     * 经验值Y坐标
     */
    private final int expY;
    /**
     * 分数X坐标
     */
    private final int comX;

    public LayerPoint(int x, int y, int w, int h) {
        super(x, y, w, h);
        //初始化共通的X坐标
        this.comX =this.w - IMG_W * POINT_BIT - PADDING*2;
        //初始化分数显示的Y坐标
        this.pointY = PADDING;
        //初始化消行显示的Y坐标
        this.rmLineY = this.pointY + IMG_RMLINE.getHeight(null)+PADDING*2;
        //初始化经验值显示的Y坐标
        this.expY =this.rmLineY + IMG_RMLINE.getHeight(null) + PADDING;

    }

    public void paint(Graphics g){
        this.createWindow(g);
        //绘制标题(分数)
        g.drawImage(IMG_POINT,this.x+PADDING, this.y + pointY, null);
        //显示分数
        this.drawNumberLeftPad(comX, pointY, this.dto.getNowPoint(), POINT_BIT, g);
        //绘制标题(消行)
        g.drawImage(IMG_RMLINE,this.x+PADDING, this.y + rmLineY , null);
        //显示消行
        this.drawNumberLeftPad(comX, rmLineY, this.dto.getNowRemoveLine(), POINT_BIT, g);
        //绘制值槽(经验值)
        int rmLine = this.dto.getNowRemoveLine();
        this.drawRect(expY,"下一级",null,(double)(rmLine % LEVEL_UP)/(double)LEVEL_UP,g);
        //TODO 临时

    }


}
