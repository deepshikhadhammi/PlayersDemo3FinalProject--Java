//DEMO3
//NAME: DEEPSHIKHA DHAMMI, NAMIT ANEJA
//DATE: APRIL 12, 2022
// TUTORIAL: T03, T08
package mvh.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Player {
    private static String player_name;      //instance variable
    private static int player_age;          //instance variable
    private static int player_weight;       //instance variable

    /**
     *
     * @param name to assign name to a player
     * @param age to assign age to a player
     * @param weight to assign weight to a player
     */
    Player(String name, int age, int weight) {
        this.player_name = name;
        this.player_age = age;
        this.player_weight = weight;
    }

    /**
     *
     * @return player's weight
     */
    public static int getPlayerweight() {
        return player_weight;
    }

    /**
     *
     * @return player's name
     */
    public static String getPlayername() {
        return player_name;
    }

    /**
     *
     * @return player's age
     */

    public static int getPlayerage() {
        return player_age;
    }

    /**
     *
     * @return player's details such as name, age and weight
     */
    @Override
    public String toString() {
        return "                Player Details       "+"\n"+"Name: " + player_name +"\n"+
                "Age: " + player_age +"\n"+
                "Weight: " +player_weight+"\n"
                ;
    }
}