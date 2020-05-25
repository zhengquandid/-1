package ui;

import dto.Player;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class LayerData extends Layer{

    //TODO 最大数据行 配置文件
    private static final int Max_ROW = 5;

    /**
     * 起始Y坐标
     */
    private static int STATR_Y = 0;

    private static final int RECT_H = IMG_RECT_H + 4;

    /**
     * 间距
     */
    private static int SPA = 0;

    private static Image IMG_DB = new ImageIcon("graphics/string/db.png").getImage();

    public LayerData(int x, int y, int w, int h) {
        super(x, y, w, h);
        SPA = (this.h - RECT_H *5 - PADDING * 2 - IMG_DB.getHeight(null)) / Max_ROW;
        STATR_Y = PADDING + IMG_DB.getHeight(null) + SPA;
    }


    /**
     * 绘制所有值槽
     * @param imgTitle  标题图片
     * @param players   数据源
     * @param g         画笔
     */
    public void showData(Image imgTitle, List<Player> players , Graphics g){
        //绘制标题
        g.drawImage(imgTitle,this.x+PADDING,this.y+PADDING,null);
        //获得现在分数
        int nowPoint = this.dto.getNowPoint();
        //循环绘制记录
        for (int i = 0; i < Max_ROW ; i++) {
            //获得一条玩家记录
            Player pla = players.get(i);
            //获得该分数
            int recodePoint = pla.getPoint();
            //计算现在分数与记录分数比值
            double percent = (double) nowPoint / recodePoint;
            //如果以破记录，比值设为100%
            percent = percent > 1 ? 1.0 : percent;
            //绘制单条记录
            String strPoint = recodePoint == 0 ? null : Integer.toString(recodePoint);
            this.drawRect(STATR_Y + i * (RECT_H + SPA),
                    pla.getName(),
                    strPoint,
                    percent, g);

    }
  }
    @Override
    abstract public void paint(Graphics g);

}
