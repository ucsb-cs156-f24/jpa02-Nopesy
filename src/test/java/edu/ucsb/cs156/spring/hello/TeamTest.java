package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    //Case 1: Same object
    @Test
    public void equals_sameObject_returnsTrue() {
        assertEquals(team, team);
    }

    //Case 2: Different class
    @Test
    public void equals_differentClass_returnsFalse() {
        String notATeam = "Not a Team";
        assertNotEquals(team, notATeam);
    }

    //Case 3.1: Same name and same members (T, T)
    @Test
    public void equals_sameNameAndMembers_returnsTrue() {
        Team otherTeam = new Team("test-team");
        assertEquals(team, otherTeam);
    }

    //Case 3.2: Same name but different members (T, F)
    @Test
    public void equals_sameNameDifferentMembers_returnsFalse() {
        Team otherTeam = new Team("test-team");
        otherTeam.addMember("Alice");
        assertNotEquals(team, otherTeam); // Name is same but members are different
    }

    //Case 3.3: Different name but same members (F, T)
    @Test
    public void equals_differentNameSameMembers_returnsFalse() {
        Team otherTeam = new Team("different-team");
        assertNotEquals(team, otherTeam); // Members are the same but name is different
    }

    //Case 3.4: Different name and different members (F, F)
    @Test
    public void equals_differentNameAndMembers_returnsFalse() {
        Team otherTeam = new Team("different-team");
        otherTeam.addMember("Alice");
        assertNotEquals(team, otherTeam); // Both name and members are different
    }

    //Test for hashCode() when objects are equal
    @Test
    public void hashCode_sameContent_returnsSameHashCode() {
        Team t1 = new Team("test-team");
        t1.addMember("Alice");
        t1.addMember("Bob");

        Team t2 = new Team("test-team");
        t2.addMember("Alice");
        t2.addMember("Bob");

        // Since the contents are the same, hashCode should be equal
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    //Test for hashCode() when objects are different
    @Test
    public void hashCode_differentContent_returnsDifferentHashCode() {
        Team t1 = new Team("test-team");
        t1.addMember("Alice");

        Team t2 = new Team("test-team");
        t2.addMember("Bob");

        // Since the contents are different, hashCode should be different
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    //Test to handle equivalent mutation problem for hashCode()
    @Test
    public void hashCode_specificValue_returnsExpectedHashCode() {
        Team t = new Team("test-team");
        int result = t.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}