package ui;

import config.FrameConfig;
import config.GameConfig;
import dto.GameDto;

import javax.swing.*;
import java.awt.*;

/*
*
*绘制窗口
*
*
* */
public abstract class Layer<obstract> {
    /**
     * 内边距
     */
    protected static final int PADDING;
    /**
     * 边框宽度
     * */
    protected static final int BORDER;

    static{
        //获得游戏配置
        FrameConfig fCfg =GameConfig.getFrameConfig();
        PADDING =fCfg.getPadding() ;
        BORDER =fCfg.getBorder() ;
    }
    /**
     *  将图片对象设置为常量
     *  Image WINDOW_IMG = new ImageIcon("graphics/window/Window_test.png").getImage();
     * 注意：如果用该方法来获取图片时，需要不停的重绘才能在屏幕上显示出图片
     */
    private static Image WINDOW_IMG = new ImageIcon("graphics/window/Window_test.png").getImage();
    /**
     * 获取图片宽度
     * 	 * */
    private static int WINDOW_W = WINDOW_IMG.getWidth(null);
    /**
     * 获取图片高度
     * */
    private static int WINDOW_H = WINDOW_IMG.getHeight(null);
    /**
     * 数字图片
     */
    private static final Image IMG_NUMBER = new ImageIcon("graphics/string/num_.png").getImage();
    /**
     * 数字切片的宽度
     */
    protected static final int IMG_W = 26;
    /**
     * 数字切片的高度
     */
    private static final int IMG_H = 36;
    /**
     * 矩形值槽
     */
    private static final Image IMG_RECT= new ImageIcon("graphics/window/rect.png").getImage();
    /**
     * 矩形值槽(高度)   RECT_H = IMG_RE CT.getHeight(null);
     */
    protected static final int IMG_RECT_H = 24;
    /**
     * 矩形值槽图片(宽度)
     */
    private static final int IMG_RECT_W = IMG_RECT.getWidth(null);
    /**
     * 矩形值槽(宽度)
     */
    private final int rectW;

    private static final Font DEF_FONT = new Font("黑体",Font.BOLD,20);

    //窗口左上角x坐标
    protected int x;
    //窗口左上角y坐标
    protected int y;
    //窗口宽度
    protected int w;
    //窗口高度
    protected int h;

    /**
     * 游戏数据
     */
    protected GameDto dto = null;

protected Layer(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rectW = this.w - PADDING * 2;
    }

    //绘制窗口

    protected void createWindow(Graphics g){
        //左上
        g.drawImage(WINDOW_IMG,x,y,x+BORDER,y+BORDER,0,0,BORDER,BORDER,null);
        //中上
        g.drawImage(WINDOW_IMG, x+BORDER, y, (w+x)-BORDER, y+BORDER,BORDER, 0, WINDOW_W-BORDER,BORDER, null);
        //右上
        g.drawImage(WINDOW_IMG, w+x-BORDER, y, w+x, y+BORDER, WINDOW_W-BORDER, 0, WINDOW_W, BORDER, null);
        //中左
        g.drawImage(WINDOW_IMG, x, y+BORDER, x+BORDER, h+y-BORDER, 0, BORDER, BORDER, WINDOW_H-BORDER, null);
        //中中
        g.drawImage(WINDOW_IMG, x+BORDER, y+BORDER, w+x-BORDER, y+h-BORDER, BORDER, BORDER, WINDOW_W-BORDER, WINDOW_H-BORDER, null);
        //中右
        g.drawImage(WINDOW_IMG,  w+x-BORDER, y+BORDER, w+x, h+y-BORDER,WINDOW_W-BORDER, BORDER, WINDOW_W, WINDOW_H-BORDER, null);
        //下左
        g.drawImage(WINDOW_IMG,  x, h+y-BORDER, x+BORDER, h+y, 0, WINDOW_H-BORDER, BORDER, WINDOW_H, null);
        //下中
        g.drawImage(WINDOW_IMG, x+BORDER, y+h-BORDER, x+w-BORDER, y+h, BORDER, WINDOW_H-BORDER, WINDOW_W-BORDER, WINDOW_H, null);
        //下右
        g.drawImage(WINDOW_IMG, x+w-BORDER, y+h-BORDER, x+w, y+h, WINDOW_W-BORDER, WINDOW_H-BORDER, WINDOW_W, WINDOW_H, null);
    }


    /**
     * 刷新游戏具体内容
     * @param g 画笔
     */
    abstract public void paint(Graphics g);

    public void setDto(GameDto dto) {
        this.dto = dto;
    }

    /**
     * 显示数字
     *
     * @param x   左上角x坐标
     * @param y   左上角y坐标
     * @param num 要显示的数字
     * @param g   画笔对象
     */
    protected void drawNumberLeftPad(int x, int y, int num, int maxBit, Graphics g) {
        //把要打印的数字转化成字符串
        String strNum = Integer.toString(num);
        //循环回执数字右对齐
        for (int i = 0; i < maxBit; i++) {
            //判断是否满足绘制条件
            if (maxBit - i <= strNum.length()) {
                //获得数字在字符串的下标
                int idx = i - maxBit + strNum.length();
                //把数字number中的每一位取出来
                int bit = strNum.charAt(idx) - '0';
                //绘制数字
                g.drawImage(IMG_NUMBER,
                        this.x + x + IMG_W * i,
                        this.y + y,
                        this.x + x + IMG_W * (i + 1),
                        this.y + y + IMG_H, bit * IMG_W, 0, (bit + 1) * IMG_W, IMG_H, null);
            }
        }
    }

    /**
     * 绘制值槽
     * @param title
     * @param number
     * @param g
     */
    protected void drawRect(int y,String title,String number,double percent,Graphics g){
        //各种初始化
        int rect_x = this.x + PADDING;
        int rect_y = this.y + y;
        //绘制背景
        g.setColor(Color.BLACK);
        g.fillRect(rect_x,rect_y,this.rectW,IMG_RECT_H + 4);
        g.setColor(Color.WHITE);
        g.fillRect(rect_x+ 1,rect_y+1,this.rectW-2,IMG_RECT_H + 2);
        g.setColor(Color.BLACK);
        g.fillRect(rect_x + 2,rect_y+2,this.rectW-4,IMG_RECT_H);
        //求出宽度
        int w = (int)(percent* (this.rectW - 4));
        //求出颜色
        int subIdx = (int)(percent*IMG_RECT_W) - 1;
        //绘制值槽
        g.drawImage(IMG_RECT,
                rect_x + 2,rect_y + 2,
                rect_x + 2 + w,rect_y + 2 + IMG_RECT_H,
                subIdx,0,subIdx+ 1, IMG_RECT_H,
                null);
        g.setColor(Color.WHITE);
        g.setFont(DEF_FONT);
        g.drawString(title,rect_x+4,rect_y+22);
        if (number !=null){
            g.drawString(number,rect_x+200,rect_y+22);
        }

    }
    /**
     * 正中绘图
     */
    protected void drawImageAtCenter(Image img , Graphics g){
        int imgW=img.getWidth(null);
        int imgH=img.getHeight(null);
        int nowX=this.x + (this.w-imgW)/2;
        int nowY=this.y + (this.h-imgH)/2;
        g.drawImage(img, nowX,nowY, null);
    }
}
