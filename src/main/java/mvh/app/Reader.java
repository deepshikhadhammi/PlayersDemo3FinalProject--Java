package mvh.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public static ArrayList<Player> player_list=new ArrayList<>();
    static int number_zero=0;
    static int number_one=1;
    static int number_two=2;
    static int number_three=3;
    static int number_four=4;
    static int number_5=5;
    static int number_6=6;

    public static ArrayList Read(File file) {
        try {
            FileReader file_reader = new FileReader(file);
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            String line = buffered_reader.readLine();
            String[] details;
            while (line != null) {
                details = line.split(",");
                String name = details[number_zero];
                int age = Integer.parseInt(details[number_one]);
                int weight = Integer.parseInt(details[number_two]);
                String role = details[number_three];
                if (role.equalsIgnoreCase("BATSMAN")) {
                    int runs = Integer.parseInt(details[number_four]);
                    int batsman_experience = Integer.parseInt((details[number_5]));
                    String style=details[number_6];
                    Batsman batsman = new Batsman(name, age, weight,runs,batsman_experience,style);
                    player_list.add(batsman);}

                else if (role.equalsIgnoreCase("BOWLER")) {
                    int wickets = Integer.parseInt(details[number_four]);
                    int bowler_experience = Integer.parseInt(details[number_5]);
                    String style=details[number_6];
                    Bowler bowler = new Bowler(name, age, weight,wickets, bowler_experience,style);
                    player_list.add(bowler);}
                line = buffered_reader.readLine();
            }
        }
        catch (IOException | NumberFormatException e) {
        }
    return player_list;
    }}

