package dao;

import dto.Player;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class DataDisk implements Data {

    private  final String filePath;

    public DataDisk(HashMap<String,String> param){
        this.filePath = param.get("path");
    }

    @Override
    public List<Player> loadData() {
        ObjectInputStream ois = null;
        List<Player> players = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(filePath));
            players = (List<Player>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return players;
    }

    @Override
    public void saveData(Player pla) {
        //先取出数据
        List<Player> players = this.loadData();
        //追加新纪录
        players.add(pla);
        //重新写入
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(players);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*public static void main(String[] args) {
        DataDisk dd = new DataDisk();
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("小明", 100));
        players.add(new Player("小红", 200));
        players.add(new Player("小全", 300));
        players.add(new Player("奥巴马", 500));
        players.add(new Player("小郑", 2000));

        dd.saveData(players);
        System.out.println("保存完毕");

        List<Player> dataFromDisk = dd.loadData();

        for (Player p : dataFromDisk) {
            System.out.println(p.getName() + ":" + p.getPoint());
        }
    }*/
}
