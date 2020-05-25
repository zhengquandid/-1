package service;

import dto.GameDto;
import dto.Player;
import entity.GameAct;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class GameService {

    private GameDto dto;
    /**
     * 随机数生成器
     */
    private Random random = new Random();
    /**
     * 方块种类数
     */
    private static final int MAX_TYPE = 6;

    public GameService(GameDto dto){
        this.dto = dto;
        GameAct act = new GameAct(random.nextInt(MAX_TYPE));
        dto.setGameAct(act);
    }

    /**
     * 控制器的方向键
     */
    public void keyUp() {
        this.dto.getGameAct().round(this.dto.getGameMap());
    }
    public void keyDown() {
        if (this.dto.getGameAct().move(0,1,this.dto.getGameMap())){
               return;
            }
        //获得游戏地图对象
        boolean[][] map = this.dto.getGameMap();
        //获得方块对象
        Point[] act = this.dto.getGameAct().getActPoints();
        // 将方块堆积到地图数组
        for (int i = 0; i < act.length; i++) {
              map[act[i].x][act[i].y] = true;
            }
        //TODO 判断是否可以消行
        //     消行操作
        //     算分操作
        //     判断是否升级
        //     升级
        //创建下一个方块
        this.dto.getGameAct().init(this.dto.getNext());
        //随机生成下一个方块
        this.dto.setNext(random.nextInt(MAX_TYPE));

    }

    public void keyLeft()  {
        this.dto.getGameAct().move(-1,0,this.dto.getGameMap());
    }

    public void keyRight() {
        this.dto.getGameAct().move(1,0,this.dto.getGameMap());
    }

    private boolean canMove(int moveX, int moveY){

        Point[] nowPoints = this.dto.getGameAct().getActPoints();
        for (int i = 0; i < nowPoints.length; i++) {
            int newX = nowPoints[i].x + moveX;
            int newY = nowPoints[i].y + moveY;

            }
        return true;
        }
    //TODO ================================测试专用方法=============
    public void testLevelUp() {
        int point = this.dto.getNowPoint();
        int rmLine =  this.dto.getNowRemoveLine();
        int lv = this.dto.getnowLevel();
        point += 10;
        rmLine += 1;
        if (rmLine % 20 == 0){
            lv += 1;
        }
        this.dto.setNowPoint(point);
        this.dto.setNowRemoveLine(rmLine);
        this.dto.setnowLevel(lv);
    }

    public void setDbRecode(List<Player> players){
        this.dto.setDbRecode(players);
    }

    public void setDiskRecode(List<Player> players){
        this.dto.setDiskRecode(players);
    }
}

