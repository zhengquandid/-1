package ui;

import config.FrameConfig;
import config.GameConfig;
import config.LayerConfig;
import control.PlayerControl;
import dto.GameDto;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class JPanelGame extends JPanel {

/*    private Layer lay1 ;

    private Layer lay2 ;

    private Layer lay3 ;*/

    private List<Layer> layers = null;

    private GameDto dto = null;

    public JPanelGame(GameDto dto) {

        this.dto = dto;

        initComponent();//初始化组件

        initLayer();//初始化层

    }

    /**
     * 安装游戏玩家控制器
     * @param control
     */
    public void setGameControl(PlayerControl control){
        this.addKeyListener(control);
    }
    /**
     *
     * 初始化组件
     */
    private void initComponent(){

    }
    /**
     *
     * 初始化层
     */
    private void initLayer(){
        try {
            FrameConfig fCfg =GameConfig.getFrameConfig(); //获得游戏配置

            List<LayerConfig> layersCfg = fCfg.getLayersConfig();//获得层配置

            layers = new ArrayList<Layer>(layersCfg.size());//创建游戏层数组
            //创建所有层对象
            for (LayerConfig layerCfg : layersCfg) {
                //获得类对象
                Class<?> cls = Class.forName(layerCfg.getClassName());
                //获得构造函数
                Constructor<?> ctr = cls.getConstructor(int.class, int.class, int.class, int.class);
                //调用构造函数创建对象
                Layer layer = (Layer) ctr.newInstance(
                        layerCfg.getX(), layerCfg.getY(), layerCfg.getW(), layerCfg.getH()
                );
                //设置游戏数据对象
                layer.setDto(this.dto);
                //把创建的Layer对象放入集合
                layers.add(layer);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

/*
        lays = new Layer[]{
                //TODO硬编码是非常不好的开发习惯，
                //TODO我们要尽量将数字或者字符串定义成常量，或者写入配置文件。
        new LayerBackground(0,0,0,0),
        new LayerDataBase(40,32,334,279),
        new LayerDisk(40,343,334,279),
        new LayerGame(414,32,334,590),
        new LayerButton(788,32,334,124),
        new LayerNext(788,188,176,148),
        new LayerLevel(964,188,158,148),
        new LayerPoint(788,368,334,200)
        };//窗口的布局
*/

    @Override
    public void paintComponent(Graphics g){
        //调用基类方法
        super.paintComponent(g);
        //循环刷新游戏画质
        for(int i = 0;i < layers.size(); i++){
            //刷新层窗口
            layers.get(i).paint(g);
        }
        //返回焦点
        this.requestFocus();
    }

}

//        Image img = new ImageIcon("graphics/window/Window_test.png").getImage();
//        g.drawImage(img,32,32,null);
//        int x = 32;
//        int y = 32;
//        int w = 256 * (size << 1);
//        int h = 128 * (size << 1);
        /*int size = 6;
        int imgW = img.getWidth(null);
        int imgH = img.getHeight(null);

        //左上
        g.drawImage(img,x,y,x+size,y+size,0,0,size,size,null);
        //中上
        g.drawImage(img, x+size, y, (w+x)-size, y+size,size, 0, imgW-size,size, null);
        //右上
        g.drawImage(img, w+x-size, y, w+x, y+size, imgW-size, 0, imgW, size, null);
        //中左
        g.drawImage(img, x, y+size, x+size, h+y-size, 0, size, size, imgH-size, null);
        //中中
        g.drawImage(img, x+size, y+size, w+x-size, y+h-size, size, size, imgW-size, imgH-size, null);
        //中右
        g.drawImage(img,  w+x-size, y+size, w+x, h+y-size,imgW-size, size, imgW, imgH-size, null);
        //下左
        g.drawImage(img,  x, h+y-size, x+size, h+y, 0, imgH-size, size, imgH, null);
        //下中
        g.drawImage(img, x+size, y+h-size, x+w-size, y+h, size, imgH-size, imgW-size, imgH, null);
        //下右
        g.drawImage(img, x+w-size, y+h-size, x+w, y+h, imgW-size, imgH-size, imgW, imgH, null);*/
/*drawImage
public abstract boolean drawImage(Image img,
                                  int dx1,
                                  int dy1,
                                  int dx2,
                                  int dy2,
                                  int sx1,
                                  int sy1,
                                  int sx2,
                                  int sy2,
                                  ImageObserver observer)绘制当前可用的指定图像的指定区域，动态地缩放图像使其符合目标绘制表面的指定区域。透明像素不影响该处已存在的像素。
此方法在任何情况下都立刻返回，甚至在要绘制的图像区域没有针对当前输出设备完成缩放、抖动或转换的情况下也是如此。如果当前的输出表示形式尚未完成，则 drawImage 返回 false。随着更多的图像可用，加载图像的进程将通知指定的图像观察者。

此方法总是用非缩放的图像来呈现缩放的矩形，并且动态地执行所需的缩放。此操作不使用缓存的缩放图像。执行图像从源到目标的缩放：源矩形的第一个坐标被映射到目标矩形的第一个坐标，第二个源坐标被映射到第二个目标坐标。按需要缩放和翻转子图像以保持这些映射关系。


参数：
img - 要绘制的指定图像。如果 img 为 null，则此方法不执行任何操作。
dx1 - 目标矩形第一个角的 x 坐标。
dy1 - 目标矩形第一个角的 y 坐标。
dx2 - 目标矩形第二个角的 x 坐标。
dy2 - 目标矩形第二个角的 y 坐标。
sx1 - 源矩形第一个角的 x 坐标。
sy1 - 源矩形第一个角的 y 坐标。
sx2 - 源矩形第二个角的 x 坐标。
sy2 - 源矩形第二个角的 y 坐标。
observer - 当缩放并转换了更多图像时要通知的对象。
返回：
如果图像像素仍在改变，则返回 false；否则返回 true。*/
