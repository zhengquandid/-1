package ui;

import entity.GameAct;

import javax.swing.*;
import java.awt.*;

public class LayerGame extends Layer {

    private static Image ACT = new ImageIcon("graphics/game/rect.png").getImage();

    //TODO 配置文件
    /**
     * 左位移偏移量
     */
    private static final int ACT_SIZE = 32;
    private static final int SIZE = 3;
    private static final int LEFT_SIZE = 0;
    private static final int RIGHT_SIZE = 9;

    public LayerGame(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.createWindow(g);
        //获得方块数组集合
        Point[] points = this.dto.getGameAct().getActPoints();
        //绘制阴影
        //TODO 阴影关闭
        this.drawShadow(points,true,g);
        if (true){

        }
        //获得方块类型编号(0-6)
        int typeCode = this.dto.getGameAct().getTypeCode();
        //绘制方块
        for (int i = 0; i < points.length; i++) {
            drawActByPoint(points[i].x,points[i].y,typeCode+1,g);
        }
        //绘制地图
        boolean[][] map = this.dto.getGameMap();
        //计算当前堆积颜色
        int lv = this.dto.getnowLevel();
        int imgIdx = lv == 0 ? 0 :(lv - 1) % 7 + 1;
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if (map[x][y]) {
                    drawActByPoint(x,y,imgIdx,g);
                }
            }
        }
    }

    /**
     * 绘制阴影
     * @param points
     * @param isShowShadow
     */
    private void drawShadow(Point[] points, boolean isShowShadow,Graphics g) {
     if (!isShowShadow){
         return;
     }
        int leftX = RIGHT_SIZE;
        int rightX = LEFT_SIZE;
        for(Point p : points){
            leftX = p.x < leftX ? p.x : leftX;
            rightX = p.x > rightX ? p.x : rightX;
        }
        g.fillRect(this.x + SIZE + (leftX * ACT_SIZE),this.y + SIZE ,(rightX-leftX+1)*ACT_SIZE,this.h-(SIZE * 2));
    }

    private void drawActByPoint(int x,int y,int imgIdx,Graphics g){
        g.drawImage(ACT,
                this.x + x * ACT_SIZE + SIZE,
                this.y + y * ACT_SIZE + SIZE,
                this.x + x * ACT_SIZE + ACT_SIZE + SIZE,
                this.y + y * ACT_SIZE + ACT_SIZE + SIZE, imgIdx * ACT_SIZE, 0, (imgIdx + 1) * ACT_SIZE, ACT_SIZE, null);
    }

}
