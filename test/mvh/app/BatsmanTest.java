//DEMO3
//NAME: DEEPSHIKHA DHAMMI, NAMIT ANEJA
//DATE: APRIL 12, 2022
// TUTORIAL: T03, T08
package mvh.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatsmanTest {

// tests for toString() function of Batsman
    @Test
    void toString_test1() {
        //creating object for batsman
        Batsman batsman=new Batsman("rohit",12,13,22,2,"Batsman");
        String expected="                Player Details       "+"\n"+"Name: rohit"+"\n"+"Age: 12"+"\n"+"Weight: 13"+"\n"+"Position: Batsman"+"\n"+"Runs: 22"+"\n"+"Experience: 2";
        String actual= batsman.toString(); //actual output that function will return
        assertEquals(expected,actual);  //comparing actual output with the expected output
    }

    @Test
    void toString_test2() {
        //creating object for batsman
        Batsman batsman=new Batsman("Dhoni",22,50,45,2,"Batsman");
        String expected="                Player Details       "+"\n"+"Name: Dhoni"+"\n"+"Age: 22"+"\n"+"Weight: 50"+"\n"+"Position: Batsman"+"\n"+"Runs: 45"+"\n"+"Experience: 2";
        String actual= batsman.toString(); //actual output that function will return
        assertEquals(expected,actual);  //comparing actual output with the expected output
    }
    @Test
    void toString_test3() {
        //creating object for batsman
        Batsman batsman=new Batsman("Virat",32,60,80,4,"Batsman");
        String expected="                Player Details       "+"\n"+"Name: Virat"+"\n"+"Age: 32"+"\n"+"Weight: 60"+"\n"+"Position: Batsman"+"\n"+"Runs: 80"+"\n"+"Experience: 4";
        String actual= batsman.toString(); //actual output that function will return
        assertEquals(expected,actual);  //comparing actual output with the expected output
    }
    @Test
        // test to compare batsman runs
    void test_1_compare_runs() {
        //creating objects for batsman
        Batsman b1=new Batsman("Rohit",32,63,40,23,"Batsman");
        Batsman b2=new Batsman("Virat",29,53,50,22,"Batsman");
        int  expected=-1;
        highest_runs h1=new highest_runs() ;  //object creation
        int actual=h1.compare(b1,b2); //actual output that function will return
        assertEquals(expected,actual); //comparing actual output with the expected output
    }
    @Test
        // test to compare batsman runs
    void test_2_compare_runs() {
        //creating objects for batsman
        Batsman b1=new Batsman("Rohit",32,43,55,5,"Batsman");
        Batsman b2=new Batsman("Dhoni",42,63,55,3,"Batsman");
        int  expected=0;
        highest_runs h1=new highest_runs() ; //object creation
        int actual=h1.compare(b1,b2); //actual output that function will return
        assertEquals(expected,actual); //comparing actual output with the expected output
    }
    @Test
        // test to compare batsman runs
    void test_3_compare_runs() {
        //creating objects for batsman
        Batsman b1=new Batsman("Virat",42,63,65,7,"Batsman");
        Batsman b2=new Batsman("Rohit",52,53,55,8,"Batsman");
        int  expected=1;
        highest_runs h1=new highest_runs() ; //object creation
        int actual=h1.compare(b1,b2); //actual output that function will return
        assertEquals(expected,actual); //comparing actual output with the expected output
    }
}