package dto;

import entity.GameAct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameDto {

    /**
     * 数据库记录
     */
    private List<Player> dbRecode;

    /**
     * 本地记录
     */
    private List<Player> diskRecode;

    /**
     * 游戏地图
     */
    private boolean[][] gameMap;

    /**
     * 下落方块
     */
    private GameAct gameAct;

    /**
     *下一个方块
     */
    private int next;

    /**
     *等级
     */
    private int nowLevel;

    /**
     *分数
     */
    private int nowPoint;

    /**
     *消行
     */
    private int nowRemoveLine;

    /**
     * 构造函数
     */
    public GameDto(){
        dtoInit();
    }
    /**
     * dto初始化
     */
    public void dtoInit(){
        //TODO 硬编码
        this.gameMap = new boolean[10][18];
        //TODO 初始化所有游戏化对象
    }

    public List<Player> getDbRecode() {
        return dbRecode;
    }

    public void setDbRecode(List<Player> dbRecode) {
        this.dbRecode = setFillRecode(dbRecode);
    }

    public List<Player> getDiskRecode() {
        return diskRecode;
    }

    public void setDiskRecode(List<Player> diskRecode) {
        this.diskRecode = setFillRecode(diskRecode);
    }

    private List<Player> setFillRecode(List<Player> players){
        //如果进来的是空，那么就创建
        if (players == null){
            players = new ArrayList<Player>();
        }
        //如果记录数小于5，那么就加到5条为止
        while (players.size()<5){
            players.add(new Player("No Data",0));
        }
        Collections.sort(players);
        return players;
    }

    public boolean[][] getGameMap() {
        return gameMap;
    }

    public void setGameMap(boolean[][] gameMap) {
        this.gameMap = gameMap;
    }

    public GameAct getGameAct() {
        return gameAct;
    }

    public void setGameAct(GameAct gameAct) {
        this.gameAct = gameAct;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getnowLevel() {
        return nowLevel;
    }

    public void setnowLevel(int level) {
        this.nowLevel = level;
    }

    public int getNowPoint() {
        return nowPoint;
    }

    public void setNowPoint(int nowPoint) {
        this.nowPoint = nowPoint;
    }

    public int getNowRemoveLine() {
        return nowRemoveLine;
    }

    public void setNowRemoveLine(int nowRemoveLine) {
        this.nowRemoveLine = nowRemoveLine;
    }
}
