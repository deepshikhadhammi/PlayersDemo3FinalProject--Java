//DEMO3
//NAME: DEEPSHIKHA DHAMMI, NAMIT ANEJA
//DATE: APRIL 12, 2022
// TUTORIAL: T03, T08
package mvh.app;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    private ArrayList<Player> player = new ArrayList<>();  //arraylist to store players
    private ArrayList<Batsman> sort_runs=new ArrayList<>();  //arraylist to sort batsmans runs
    private ArrayList<Bowler> sort_wickets=new ArrayList<>();  //arraylist to sort bowlers wickets
    /**
     * Setup the window state
     */
    // ALL THE VARIABLES
    // Starts here
    Batsman batsman;
    Bowler bowler;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField weight;
    @FXML
    private TextField runs;
    @FXML
    private TextField wickets;
    @FXML
    private TextField batsman_experience;
    @FXML
    private TextField bowler_experience;
    @FXML
    private RadioButton batsman_radio_button;
    @FXML
    private RadioButton bowler_radio_button;
    @FXML
    private ComboBox<String> batsman_combo;
    ObservableList<String> list = FXCollections.observableArrayList("Right Handed", "Left Handed");
    @FXML
    private ComboBox<String> bowler_combo;
    ObservableList<String> list_2 = FXCollections.observableArrayList("Fast Bowler", "Spinner");
    @FXML
    private TextArea details;

    @FXML
    private TableView<Batsman> table;
    ObservableList<Batsman> batsman_list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Batsman,String> table_name;
    @FXML
    private TableColumn<Batsman, Integer> table_runs;
    @FXML
    private TableColumn<Batsman, Integer> table_experience;
    @FXML
    private TableColumn<Batsman, String> table_style;
    @FXML
    private TableView<Bowler> table_2;
    ObservableList<Bowler> bowler_list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Bowler,String> table_name_2;
    @FXML
    private TableColumn<Bowler, Integer> table_wickets;
    @FXML
    private TableColumn<Bowler, Integer> table_experience_2;
    @FXML
    private TableColumn<Bowler, String> table_style_2;
    @FXML
    private Label right_status;
    @FXML
    private Label left_status;
    @FXML
    private TextArea sort;
    String sort_string ="";
    String sort_string_bowler="";
    @FXML
    private TextField top_batsman;
    @FXML
    private  TextField top_bowler;
    @FXML
    private TextField top_runs;
    @FXML
    private TextField top_wickets;
    int number_zero=0;
    int number_1=1;
    /**
     * Setup the window state
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // setting the combo box  items with the list created above
        batsman_combo.setItems(list);
        bowler_combo.setItems(list_2);
        table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        table_runs.setCellValueFactory(new PropertyValueFactory<Batsman, Integer>("runs"));
        table_experience.setCellValueFactory(new PropertyValueFactory<Batsman, Integer>("experience"));
        table_style.setCellValueFactory(new PropertyValueFactory<Batsman, String>("position"));

        table.setItems(batsman_list);

        table_name_2.setCellValueFactory(new PropertyValueFactory<Bowler,String>("name"));
        table_wickets.setCellValueFactory(new PropertyValueFactory<Bowler, Integer>("wickets"));
        table_experience_2.setCellValueFactory(new PropertyValueFactory<Bowler, Integer>("experience"));
        table_style_2.setCellValueFactory(new PropertyValueFactory<Bowler, String>("position"));
        table_2.setItems(bowler_list);

    }
    // Functions

    // For Radio Button Setup

    /**
     * @param event-This function is an action event function ( for selecting only one radio button at a time)
     */
    @FXML
    public void check_1(ActionEvent event) {

        // if one radio button is selected then other radio button should be deselected
        if (batsman_radio_button.isSelected()) {
            bowler_radio_button.setSelected(false);
        }
    }

    /**
     * @param event-This function is also an action event function(for selecting only one radio button at a time)
     */
    @FXML

    public void check_2(ActionEvent event) {

        // if one radio button is selected then other radio button should be deselected
        if (bowler_radio_button.isSelected()) {
            batsman_radio_button.setSelected(false);
        }
    }

    // Menu bar Functions

    /**
     * @param event-This is also a action event function
     * @detail-This Function gives the information regarding the author of the application and version
     */

    @FXML
    void aboutAction(ActionEvent event) {

        // creating alert object
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About the application");
        alert.setContentText("Author:Namit And Deepshikha \nVersion:v1.0\n" +"Ucalgary id -namit.aneja@ucalgary.ca \n"+"Ucalgary id- deepshikha.dhammi@ucalgary.ca\n"
                +"This is a group project on Cricket Team ");
        alert.show();

    }

    /**
     * @param event
     * @throws IOException
     * @detail-This Function performs the save action
     */
    @FXML
    void saveAction(ActionEvent event) throws IOException {

        // creating file chooser instance
        FileChooser fc = new FileChooser();
        File file = fc.showSaveDialog(new Stage());
        Writer(file);

        // writing to the file
    }

    /**
     * @param event
     * @detail-this function performs the action of loading the file
     */
    @FXML
    void loadAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        if(Main.saved_args.length==number_zero){
            try {
                batsman_list.clear();
                bowler_list.clear();
                sort_runs.clear();
                sort_wickets.clear();
                File file = fc.showOpenDialog(new Stage());
                if (file.isFile() && file.exists() && file.canRead()) {
                    ArrayList<Player> player_list = Reader.Read(file);
                    for (Player player : player_list) {
                        // printing batsman's details
                        if (player instanceof Batsman) {
                            Batsman b1= (Batsman) player;

                            name.setText(player.getPlayername());  //batsman's name
                            age.setText(String.valueOf(player.getPlayerage()));  //batsman's age
                            runs.setText(String.valueOf(b1.getRuns()));  //batsman's runs
                            weight.setText(String.valueOf(player.getPlayerweight())); //batsman's weight
                            batsman_experience.setText(String.valueOf(b1.getExperience()));  //batsman's experience
                            batsman_combo.setValue(b1.getPosition()); //player's position
                            batsman_list.add(b1);
                            sort_runs.add(b1);
                            // setting the status
                            right_status.setTextFill(Color.web("black"));
                            right_status.setText("File Reading was successful");
                            left_status.setTextFill(Color.web("black"));
                            left_status.setText("");

                        }
                        //printing bowler's details

                        if (player instanceof Bowler) {
                            Bowler b1=(Bowler) player;
                            name.setText(player.getPlayername());  //bowler's name
                            age.setText(String.valueOf(player.getPlayerage()));  //bowler's age
                            wickets.setText(String.valueOf(b1.getWickets()));  //bowler's wickets
                            weight.setText(String.valueOf(player.getPlayerweight())); //bowler's weight
                            bowler_experience.setText(String.valueOf(b1.getExperience()));  //bowler's experience
                            bowler_combo.setValue(b1.getPosition());
                            bowler_list.add(b1);
                            sort_wickets.add(b1);
                            // setting the status
                            right_status.setTextFill(Color.web("black"));
                            right_status.setText("File Reading was successful");
                            left_status.setTextFill(Color.web("black"));
                            left_status.setText("");

                        }

                    }
                }
                else{
                    // catching exceptions
                    right_status.setTextFill(Color.web("red"));
                    right_status.setText("Unable to read from the file ");
                    left_status.setTextFill(Color.web("black"));
                    left_status.setText("");

                }
            }
            catch(Exception e){
            }
        }
        else if(Main.saved_args.length==number_1){
            File file=new File(Main.saved_args[number_zero]);  //command line
            try{
                if (file.isFile() && file.exists() && file.canRead()) {
                    batsman_list.clear();
                    bowler_list.clear();
                    sort_runs.clear();
                    sort_wickets.clear();
                    ArrayList<Player> player_list = Reader.Read(file);   //read the file
                    // setting the status
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("File Reading was successful");
                    left_status.setTextFill(Color.web("black"));
                    left_status.setText("");
                    for (Object player : player_list) {
                        //printing batsman's details in the text area
                        if (player instanceof Batsman) {
                            Batsman b1= (Batsman) player;
                            name.setText(batsman.getName());
                            age.setText(String.valueOf(Player.getPlayerage()));
                            runs.setText(String.valueOf(batsman.getRuns()));
                            weight.setText(String.valueOf(Player.getPlayerweight()));
                            batsman_experience.setText(String.valueOf(batsman.getExperience()));
                            batsman_combo.setValue(batsman.getPosition());
                            batsman_list.add(b1);
                            sort_runs.add(b1);
                        }
                        //printing bowler's details in the text area
                        if (player instanceof Bowler) {
                            Bowler b1=(Bowler) player;
                            name.setText(bowler.getName());
                            age.setText(String.valueOf(Player.getPlayerage()));
                            wickets.setText(String.valueOf(bowler.getWickets()));
                            weight.setText(String.valueOf(Player.getPlayerweight()));
                            bowler_experience.setText(String.valueOf(bowler.getExperience()));
                            bowler_combo.setValue(bowler.getPosition());
                            bowler_list.add(b1);
                            sort_wickets.add(b1);
                        }
                    }
                }
                else{
                    // catching exceptions
                    right_status.setTextFill(Color.web("red"));
                    right_status.setText("Unable to read from the file");
                    left_status.setTextFill(Color.web("black"));
                    left_status.setText("");
                }
            }

            catch(Exception e){
            }

        }
    }
    /**
     * @param event
     * @detail-This function performs the action of exiting the GUI
     */
    @FXML
    void quitAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void addBatsman(ActionEvent event) {
        try {
            //converting the string values into Integer
            int batsman_age = Integer.parseInt(age.getText());
            int batsman_weight = Integer.parseInt(weight.getText());
            int batsman_runs = Integer.parseInt(runs.getText());
            int experience = Integer.parseInt(batsman_experience.getText());

            if(name.getText()!=""&& batsman_experience.getText()!="" &&runs.getText()!=""&& weight.getText()!=""&&age.getText()!=""){
                if(batsman_age>=number_zero && batsman_weight>=number_zero&& batsman_runs>=number_zero&& experience>=number_zero){
                    Batsman batsman = new Batsman(name.getText(), batsman_age, batsman_weight, batsman_runs, experience, batsman_combo.getValue());
                    player.add(batsman);  //add batsman to the player list
                    batsman_list.add(batsman);   //add batsman to arraylist
                    sort_runs.add(batsman);   //add batsman to arraylist
                    details.setText(batsman.toString() + "\n" + "Style: " + batsman_combo.getValue());
                    // setting the status
                    left_status.setTextFill(Color.web("black"));
                    left_status.setText("Currently adding batsman");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }
                else{
                    //setting the status
                    if(batsman_age<number_zero){
                        left_status.setTextFill(Color.web("red"));
                        left_status.setText("Age should be greater than 0");
                        right_status.setTextFill(Color.web("black"));
                        right_status.setText("");

                    }
                    //setting the status
                    if(batsman_weight<number_zero){
                        left_status.setTextFill(Color.web("red"));
                        left_status.setText("Weight should be greater than 0");
                        right_status.setTextFill(Color.web("black"));
                        right_status.setText("");

                    }
                    //setting the status
                    if(batsman_runs<number_zero){
                        left_status.setTextFill(Color.web("red"));
                        left_status.setText("Runs should be greater than 0");
                        right_status.setTextFill(Color.web("black"));
                        right_status.setText("");
                    }
                    //setting the status
                    if(experience<number_zero){
                        left_status.setTextFill(Color.web("red"));
                        left_status.setText("Experience should be  greater than 0");
                        right_status.setTextFill(Color.web("black"));
                        right_status.setText("");
                    }
                }}
            else{
                //setting the status
                if (batsman_experience.getText() == "") {
                    left_status.setTextFill(Color.web("red"));
                    left_status.setText("Enter the experience for batsman");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }
                //setting the status
                if (runs.getText() == "") {
                    left_status.setTextFill(Color.web("red"));
                    left_status.setText("Enter the runs of batsman");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }
                //setting the status
                if (weight.getText() == "") {
                    left_status.setTextFill(Color.web("red"));
                    left_status.setText("Enter the weight of player");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }
                //setting the status
                if (age.getText() == "") {
                    left_status.setTextFill(Color.web("red"));
                    left_status.setText("Enter the age of player");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }
                //setting the status
                if (name.getText() == "") {
                    left_status.setTextFill(Color.web("red"));
                    left_status.setText("Enter the name for player");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }
            }

        } catch (Exception e) {
            try {
                // converting to integer value
                int int_row = Integer.parseInt(age.getText());
            }
            catch (Exception e1) {
                //setting the status
                left_status.setTextFill(Color.web("red"));
                left_status.setText(String.format("Can't parse %s (age) into integer ",age.getText()));
                right_status.setTextFill(Color.web("black"));
                right_status.setText("");
            }
            try {
                // converting to integer value
                int int_row = Integer.parseInt(weight.getText());
            }
            catch (Exception e1) {
                //setting the status
                left_status.setTextFill(Color.web("red"));
                left_status.setText(String.format("Can't parse %s (weight) into integer ",weight.getText()));
                right_status.setTextFill(Color.web("black"));
                right_status.setText("");
            }
            try {
                // converting to integer value
                int int_row = Integer.parseInt(runs.getText());
            }
            catch (Exception e1) {
                //setting the status
                left_status.setTextFill(Color.web("red"));
                left_status.setText(String.format("Can't parse %s (runs) into integer ",runs.getText()));
                right_status.setTextFill(Color.web("black"));
                right_status.setText("");
            }
            try {
                // converting to integer value
                int int_row = Integer.parseInt(batsman_experience.getText());
            }
            catch (Exception e1) {
                //setting the status
                left_status.setTextFill(Color.web("red"));
                left_status.setText(String.format("Can't parse %s (batsman experience) into integer ",batsman_experience.getText()));
                right_status.setTextFill(Color.web("black"));
                right_status.setText("");
            }

        }
    }

    @FXML
    public void addBowler(ActionEvent event) {
        try{
            // converting to integer value
            int bowler_age = Integer.parseInt(age.getText());
            int bowler_weight = Integer.parseInt(weight.getText());
            int bowler_wickets = Integer.parseInt(wickets.getText());
            int experience = Integer.parseInt(bowler_experience.getText());
            if(name.getText()!=""&& bowler_experience.getText()!=""&& wickets.getText()!=""&& weight.getText()!=""&&age.getText()!=""){
                if(bowler_age>=number_zero && bowler_weight>=number_zero && bowler_wickets>=number_zero&& experience>=number_zero){
                    Bowler bowler = new Bowler(name.getText(), bowler_age, bowler_weight, bowler_wickets, experience, bowler_combo.getValue());
                    //adding bowler to the arraylists
                    player.add(bowler);
                    bowler_list.add(bowler);
                    sort_wickets.add(bowler);
                    details.setText(bowler.toString() + "\n" + "Style: " + bowler_combo.getValue());
                    // setting the status
                    left_status.setTextFill(Color.web("black"));
                    left_status.setText("Currently adding bowler");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }
                else{
                    if(bowler_age<number_zero){
                        //setting the status
                        left_status.setTextFill(Color.web("red"));
                        left_status.setText("Age should be greater than 0");
                        right_status.setTextFill(Color.web("black"));
                        right_status.setText("");

                    }
                    if(bowler_age<number_zero){
                        //setting the status
                        left_status.setTextFill(Color.web("red"));
                        left_status.setText("Weight should be greater than 0");
                        right_status.setTextFill(Color.web("black"));
                        right_status.setText("");

                    }
                    if(bowler_wickets<number_zero){
                        //setting the status
                        left_status.setTextFill(Color.web("red"));
                        left_status.setText("Wickets should be greater than 0");
                        right_status.setTextFill(Color.web("black"));
                        right_status.setText("");
                    }
                    if(experience<number_zero){
                        //setting the status
                        left_status.setTextFill(Color.web("red"));
                        left_status.setText("Experience should be  greater than 0");
                        right_status.setTextFill(Color.web("black"));
                        right_status.setText("");
                    }
                }}

            else{
                if (bowler_experience.getText() == "") {
                    //setting the status
                    left_status.setTextFill(Color.web("red"));
                    left_status.setText("Enter the experience for bowler");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }

                if (wickets.getText() == "") {
                    //setting the status
                    left_status.setTextFill(Color.web("red"));
                    left_status.setText("Enter the wickets of bowler");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }

                if (weight.getText() == "") {
                    //setting the status
                    left_status.setTextFill(Color.web("red"));
                    left_status.setText("Enter the weight of player");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }
                if (age.getText() == "") {
                    //setting the status
                    left_status.setTextFill(Color.web("red"));
                    left_status.setText("Enter the age of player");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }
                if (name.getText() == "") {
                    //setting the status
                    left_status.setTextFill(Color.web("red"));
                    left_status.setText("Enter the name for player");
                    right_status.setTextFill(Color.web("black"));
                    right_status.setText("");
                }
            }}

        catch(Exception e1){
            try {
                int int_row = Integer.parseInt(age.getText());
            }
            catch (Exception e) {
                //setting the status
                left_status.setTextFill(Color.web("red"));
                left_status.setText(String.format("Can't parse %s (age) into integer ",age.getText()));
                right_status.setTextFill(Color.web("black"));
                right_status.setText("");
            }
            try {
                int int_row = Integer.parseInt(weight.getText());
            }
            catch (Exception e) {
                //setting the status
                left_status.setTextFill(Color.web("red"));
                left_status.setText(String.format("Can't parse %s (weight) into integer ",weight.getText()));
                right_status.setTextFill(Color.web("black"));
                right_status.setText("");
            }
            try {
                int int_row = Integer.parseInt(wickets.getText());
            }
            catch (Exception e) {
                //setting the status
                left_status.setTextFill(Color.web("red"));
                left_status.setText(String.format("Can't parse %s (wickets) into integer ",wickets.getText()));
                right_status.setTextFill(Color.web("black"));
                right_status.setText("");
            }
            try {
                int int_row = Integer.parseInt(bowler_experience.getText());
            }
            catch (Exception e) {
                //setting the status
                left_status.setTextFill(Color.web("red"));
                left_status.setText(String.format("Can't parse %s (bowler experience) into integer ",bowler_experience.getText()));
                right_status.setTextFill(Color.web("black"));
                right_status.setText("");
            }
        }}

    /**
     *
     * @param file to write to the file
     * @throws IOException
     */
    void Writer(File file) throws IOException {
        try{
            //writing to the file
            FileWriter fw = new FileWriter(file);

            if (file.exists() && file.isFile() && file.canWrite() ) {

                for (Object object : player) {
                    //if player is a batsman add write batsman's details to the file
                    if (object instanceof Batsman) {
                        fw.append(name.getText());
                        fw.append(",").append(String.valueOf(age.getText())).append(",").append(String.valueOf(weight.getText()));
                        fw.append(",").append("BATSMAN").append(",").append(runs.getText()).append(",").append(batsman_experience.getText()).append(",").append(batsman_combo.getValue()).append("\n");
                    }
                    // if player is a bowler add bowler's details to the file
                    else if (object instanceof Bowler) {
                        fw.append(name.getText());
                        fw.append(",").append(String.valueOf(age.getText())).append(",").append(String.valueOf(weight.getText()));
                        fw.append(",").append("BOWLER").append(",").append(wickets.getText()).append(",").append(bowler_experience.getText()).append(",").append(bowler_combo.getValue()).append("\n");
                    }
                }
                fw.flush();
                fw.close();  //closing the file
                //setting the status to successfully done
                right_status.setTextFill(Color.web("black"));
                right_status.setText("Successfully written to the file");
                left_status.setTextFill(Color.web("black"));
                left_status.setText("");
            }
            // if file does not exist.
            else {
                right_status.setTextFill(Color.web("red"));
                right_status.setText("File does not exist");
                left_status.setTextFill(Color.web("black"));
                left_status.setText("");
            }
        } catch (Exception e) {
            // setting the text color to red
            right_status.setTextFill(Color.web("red"));
            right_status.setText("Unable to write to the file");
            left_status.setTextFill(Color.web("black"));
            left_status.setText("");
        }
    }

    /**
     *
     * @param e to perform the event of sorting
     */
    @FXML
    void Sort_Runs(ActionEvent e) {
        try {
            //sort batsman on basis of runs
            Collections.sort(sort_runs, new highest_runs());

            for (int i = number_zero; i < sort_runs.size(); i++) {
                //printing batsman's details in sorted order in the text area
                sort_string = sort_string + "Player:" + sort_runs.get(i).getName() + "    " + "Runs: " + sort_runs.get(i).getRuns() + "\n";
                //setting status
                sort.setText(sort_string);
                top_batsman.setText(sort_runs.get(sort_runs.size()-number_1).getName());
                top_runs.setText(String.valueOf(sort_runs.get(sort_runs.size()-number_1).getRuns()));
                right_status.setTextFill(Color.web("black"));
                right_status.setText("Successfully sorted batsman on basis of runs");
                left_status.setTextFill(Color.web("black"));
                left_status.setText("");
            }
            sort_string="";
        }
        catch(Exception e1){};
    }
    @FXML
    void Sort_Wickets(ActionEvent e) {
        try{
            //sort bowler on basis of wickets
            Collections.sort(sort_wickets, new highest_wicket_takers());

            for (int i = number_zero; i < sort_wickets.size(); i++) {
                //printing bowler's details in sorted order in the text area
                sort_string_bowler=sort_string_bowler+"Player:"+sort_wickets.get(i).getName()+"    "+"Wickets: "+sort_wickets.get(i).getWickets()+"\n";
                //setting status
                sort.setText(sort_string_bowler);
                top_bowler.setText(sort_wickets.get(sort_wickets.size()-number_1).getName());
                top_wickets.setText(String.valueOf(sort_wickets.get(sort_wickets.size()-number_1).getWickets()));
                right_status.setTextFill(Color.web("black"));
                right_status.setText("Successfully  sorted bowlers on basis of wickets");
                left_status.setTextFill(Color.web("black"));
                left_status.setText("");
            }
            sort_string_bowler="";
        }
        catch(Exception e1){}
    }
}