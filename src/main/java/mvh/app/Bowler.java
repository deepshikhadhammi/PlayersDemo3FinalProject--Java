//DEMO3
//NAME: DEEPSHIKHA DHAMMI, NAMIT ANEJA
//DATE: APRIL 12, 2022
// TUTORIAL: T03, T08
package mvh.app;

import java.util.*;

public class Bowler extends Player  {

    private  int player_experience;    // instance variable
    private  String position;          //instance variable
    protected  int player_wickets;     // instance variable
    private  String name;              //instance variable

    /**
     *
     * @param name assigns name to the bowler
     * @param age  assigns age to the bowler
     * @param weight  assigns weight to the player
     * @param wickets assigns wickets to the player
     * @param experience  assigns experience to the player
     * @param position  assigns position to the player
     */
    Bowler(String name, int age, int weight,int wickets,int experience, String position) {
        super(name, age,weight);
        this.name=name;
        this.player_wickets = wickets;
        this.position = position;
        this.player_experience=experience;
    }

    /**
     *
     * @return bowler's name
     */
    public  String getName(){return name;}

    /**
     *
     * @return player's position
     */
    public  String getPosition() {
        return position;
    }

    /**
     *
     * @return bowler's wickets
     */
    public  int getWickets() {
        return player_wickets;
    }

    /**
     *
     * @return bowler's experience
     */
    public  int getExperience() {
        return player_experience;
    }

    /**
     * return player's details such as name, age, weight, experience, wickets
     * @return
     */
    @Override
    public String toString() {
        return super.toString() +
                "Position: "+"Bowler"+"\n"+
                "Wickets: " + player_wickets+"\n"+
                "Experience: "+player_experience
                ;
    }
}

/**
 * This class is used to sort the bowlers on the basis of number of wickets taken.
 */
class highest_wicket_takers implements Comparator<Bowler>
{
    /**
     *
     * @param o1 to store number of wickets of first bowler
     * @param o2 to store number of wickets of second bowler
     * @return sorted order of bowlers
     */
    @Override
    public int compare(Bowler o1, Bowler o2) {
        return o1.player_wickets - o2.player_wickets;
    }
}