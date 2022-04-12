//DEMO3
//NAME: DEEPSHIKHA DHAMMI, NAMIT ANEJA
//DATE: APRIL 12, 2022
// TUTORIAL: T03, T08
package mvh.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public static ArrayList<Player> player_list=new ArrayList<>();  //initialising arraylist
    //magic numbers initialised
    static int number_zero=0;
    static int number_one=1;
    static int number_two=2;
    static int number_three=3;
    static int number_four=4;
    static int number_five=5;
    static int number_six=6;

    /**
     *
     * @param file to reaf the player's details
     * @return the player's list
     */
    public static ArrayList Read(File file) {
        try {
            //reading a file using filereader
            FileReader file_reader = new FileReader(file);
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            String line = buffered_reader.readLine();
            String[] details;   // array to store player's details
            while (line != null) {
                details = line.split(",");    // split the values at the comma
                String name = details[number_zero];   // storing name at starting index of an array
                int age = Integer.parseInt(details[number_one]);  // storing player's age at first index
                int weight = Integer.parseInt(details[number_two]);  //storing player's weight at second index
                String role = details[number_three];  // store player's position
                // check if player is a batsman
                if (role.equalsIgnoreCase("BATSMAN")) {
                    int runs = Integer.parseInt(details[number_four]);  // store player's runs
                    int batsman_experience = Integer.parseInt((details[number_five])); // store player's experience
                    String style=details[number_six];  //store player's style
                    Batsman batsman = new Batsman(name, age, weight,runs,batsman_experience,style);
                    player_list.add(batsman); //adding batsman to the list
                }

                // if player is a bowler
                else if (role.equalsIgnoreCase("BOWLER")) {
                    int wickets = Integer.parseInt(details[number_four]); //store player's wickets
                    int bowler_experience = Integer.parseInt(details[number_five]);  //store player's experience
                    String style=details[number_six];  //store player's style
                    Bowler bowler = new Bowler(name, age, weight,wickets, bowler_experience,style);
                    player_list.add(bowler);   //adding bowler to the list
                }
                line = buffered_reader.readLine();  //reading the next line
            }
        }
        catch (IOException | NumberFormatException e) {
        }
        return player_list;   //return player's list
    }}