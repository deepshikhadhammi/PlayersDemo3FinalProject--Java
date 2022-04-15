//DEMO3
//NAME: DEEPSHIKHA DHAMMI, NAMIT ANEJA
//DATE: APRIL 12, 2022
// TUTORIAL: T03, T08
package mvh.app;

import java.util.*;

public class Batsman extends Player {
    private String position;       // instance variable
    protected  int player_runs;    //instance variable
    private  int experience;       // instance variable
    private  String name;          //instance variable

    /**
     *
     * @param name assigns name to a player
     * @param age assigns age to a player
     * @param weight assigns weight to a player
     * @param runs   assigns runs to a player
     * @param experience  assigns experience to a player
     * @param position  assigns position to a player
     */
    Batsman(String name, int age, int weight, int runs,int experience,String position ) {
        super(name, age, weight);
        this.name=name;
        this.player_runs = runs;
        this.position = position;
        this.experience=experience;
    }

    /**
     *
     * @return player's name
     */
    public  String getName()
    {return name;};

    /**
     *
     * @return player's runs
     */
    public int getRuns() {
        return player_runs;
    }

    /**
     *
     * @return player's experience
     */
    public  int getExperience() {
        return experience;
    }

    /**
     *
     * @return payer's position
     */
    public  String getPosition() {
        return position;
    }

    /**
     *
     * @return batsman's details position, runs,experience, name, age ,weight
     */
    @Override
    public String toString() {
        return super.toString() +
                "Position: "+"Batsman"+"\n"+
                "Runs: " + player_runs+"\n"+
                "Experience: "+experience
                ;
    }

}

/**
 * Class to sort batsman
 */
class highest_runs implements Comparator<Batsman>
{
    /**
     * This is used to sort the batsman' runs
     * @param b1 stores first batsman's runs
     * @param b2 stores second batsman' runs
     * @return the sorted order of batsman's runs
     */
    @Override
    public int compare(Batsman b1, Batsman b2) {
        return Integer.compare(b1.player_runs, b2.player_runs);
    }

}