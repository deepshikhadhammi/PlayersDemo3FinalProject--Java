//DEMO3
//NAME: DEEPSHIKHA DHAMMI, NAMIT ANEJA
//DATE: APRIL 12, 2022
// TUTORIAL: T03, T08
package mvh.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlerTest {

    // tests for toString function of bowler
    @Test
    void toString_test1() {
        //creating object for bowler
        Bowler bowler=new Bowler("rohit",12,13,22,2,"Bowler");
        String expected="                Player Details       "+"\n"+"Name: rohit"+"\n"+"Age: 12"+"\n"+"Weight: 13"+"\n"+"Position: Bowler"+"\n"+"Wickets: 22"+"\n"+"Experience: 2";
        String actual= bowler.toString(); //actual output that function will return
        assertEquals(expected,actual);  //comparing actual output with the expected output
    }

    @Test
    void toString_test2() {
        //creating object for bowler
        Bowler bowler=new Bowler("Dhoni",22,50,45,2,"Bowler");
        String expected="                Player Details       "+"\n"+"Name: Dhoni"+"\n"+"Age: 22"+"\n"+"Weight: 50"+"\n"+"Position: Bowler"+"\n"+"Wickets: 45"+"\n"+"Experience: 2";
        String actual= bowler.toString(); //actual output that function will return
        assertEquals(expected,actual);  //comparing actual output with the expected output
    }
    @Test
    void toString_test3() {
        //creating object for bowler
        Bowler bowler=new Bowler("Virat",32,60,8,4,"Bowler");
        String expected="                Player Details       "+"\n"+"Name: Virat"+"\n"+"Age: 32"+"\n"+"Weight: 60"+"\n"+"Position: Bowler"+"\n"+"Wickets: 8"+"\n"+"Experience: 4";
        String actual= bowler.toString(); //actual output that function will return
        assertEquals(expected,actual);  //comparing actual output with the expected output
    }
    //tests to compare bowlers wickets
    @Test
        // test to compare bowler wickets
    void test_1_compare_runs() {
        //creating objects for bowler
        Bowler b1=new Bowler("Rohit",32,63,40,23,"Bowler");
        Bowler b2=new Bowler("Virat",29,53,50,22,"Bowler");
        int  expected=-1;
        highest_wicket_takers h1= new highest_wicket_takers();  //object creation
        int actual=h1.compare(b1,b2); //actual output that function will return
        assertEquals(expected,actual); //comparing actual output with the expected output
    }
    @Test
        // test to compare bowler wickets
    void test_2_compare_runs() {
        //creating objects for bowler
        Bowler b1=new Bowler("Rohit",32,43,55,5,"Bowler");
        Bowler b2=new Bowler("Dhoni",42,63,55,3,"Bowler");
        int  expected=0;
        highest_wicket_takers h1=new highest_wicket_takers() ; //object creation
        int actual=h1.compare(b1,b2); //actual output that function will return
        assertEquals(expected,actual); //comparing actual output with the expected output
    }
    @Test
        // test to compare bowler wickets
    void test_3_compare_runs() {
        //creating objects for bowler
        Bowler b1=new Bowler("Virat",42,63,65,7,"Bowler");
        Bowler b2=new Bowler("Rohit",52,53,55,8,"Bowler");
        int  expected=1;
        highest_wicket_takers h1= new highest_wicket_takers(); //object creation
        int actual=h1.compare(b1,b2); //actual output that function will return
        assertEquals(expected,actual); //comparing actual output with the expected output
    }
}