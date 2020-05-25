package ui;

import config.FrameConfig;
import config.GameConfig;

import javax.swing.*;
import java.awt.*;

public class JFrameGame extends JFrame {

    public JFrameGame(JPanelGame jPanelGame){
        //获得游戏配置
        FrameConfig fCfg =GameConfig.getFrameConfig();
        //设置标题
        this.setTitle(fCfg.getTitle());
        //设置默认关闭属性（程序结束）
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小
        this.setSize(1178,692);
        //不允许用户改变窗口大小
        this.setResizable(false);
        //居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = screen.width - this.getWidth()>> 1;
        int y = (screen.height - this.getHeight()>>1) - fCfg.getWindowUp();
        this.setLocation(x,y);
        //设置默认Panel
        this.setContentPane(jPanelGame);
        //默认该窗口为显示
        this.setVisible(true);
    }
}
