package mvh.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Player {
    private static String player_name;
    private static int player_age;
    private static int player_weight;


    Player(String name, int age, int weight) {
        this.player_name = name;
        this.player_age = age;
        this.player_weight = weight;
    }

    public static int getPlayerweight() {
        return player_weight;
    }

    public static String getPlayername() {
        return player_name;
    }

    public static int getPlayerage() {
        return player_age;
    }

    @Override
    public String toString() {
        return "                Player Details       "+"\n"+"Name: " + player_name +"\n"+
                "Age: " + player_age +"\n"+
                "Weight: " +player_weight+"\n"
                ;
    }
}