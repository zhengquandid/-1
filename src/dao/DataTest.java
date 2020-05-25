package dao;

import dto.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataTest implements Data{

    public DataTest(HashMap<String ,String> param){

    }

    @Override
    public List<Player> loadData() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("小郑",100));
        players.add(new Player("小郑",200));
       /* players.add(new Player("小郑",300));
        players.add(new Player("小郑",500));*/
        players.add(new Player("小郑",2000));
        return players;
    }

    @Override
    public void saveData(Player players) {
        System.out.println();
    }
}
