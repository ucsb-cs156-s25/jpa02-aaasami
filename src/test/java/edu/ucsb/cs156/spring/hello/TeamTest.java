package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

   @Test
    public void test_equals_same_object() {
        Team t1 = new Team("s25-11");
        assertEquals(t1, t1);
    }

    @Test
    public void test_equals_different_class() {
        Team t1 = new Team("s25-11");
        assertNotEquals(t1, "not a team");
    }

    @Test 
    public void test_equals_TT() {
        Team t1 = new Team("s25-11");
        t1.addMember("Shuang");

        Team t2 = new Team("s25-11");
        t2.addMember("Shuang");

        assertEquals(t1, t2);
    }

    @Test
    public void test_equals_TF() {
        Team t1 = new Team("s25-11");
        t1.addMember("Shuang");

        Team t2 = new Team("s25-11");
        t2.addMember("Other");

        assertNotEquals(t1, t2);
    }

    @Test
    public void test_equals_FT() {
        Team t1 = new Team("s25-11");
        t1.addMember("Shuang");

        Team t2 = new Team("s25-01");
        t2.addMember("Shuang");

        assertNotEquals(t1, t2);
    }

    @Test
    public void test_equals_FF() {
        Team t1 = new Team("s25-11");
        t1.addMember("Shuang");

        Team t2 = new Team("s25-01");
        t2.addMember("Other");

        assertNotEquals(t1, t2);
    }

    @Test
    public void test_hashCode(){
        Team t = new Team("s25-11");
        int result = t.hashCode();
        int expectedResult = -954815145;
        assertEquals(expectedResult, result);
    }

}
