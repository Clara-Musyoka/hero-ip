package org.safaricom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SquadTest {

    @BeforeEach
    public void setUp() {
        // Set up any necessary test data or configurations before each test
        // For example, you can initialize the database connection here
        // or create a test-specific instance of DB.sql2o.
    }

    @AfterEach
    public void tearDown() {
        // Clean up any resources or configurations after each test
        // For example, you can close the database connection here.
    }

    @Test
    public void testSquadCreation() {
        // Test the Squad constructor and getName() method
        Squad squad = new Squad("Avengers");
        assertEquals("Avengers", squad.getName());
    }

    @Test
    public void testSquadSaveAndFind() {
        // Test the save() and find() methods
        Squad squad = new Squad("Justice League");
        squad.save();

        Squad foundSquad = Squad.find(squad.getId());
        assertNotNull(foundSquad);
        assertEquals(squad.getName(), foundSquad.getName());
    }

    @Test
    public void testGetHeroes() {
        // Test the getHeroes() method
        Squad squad = new Squad("X-Men");
        squad.save();

        Hero hero1 = new Hero("Wolverine", 100, "Regeneration", "Adamant Claws", squad.getId());
        Hero hero2 = new Hero("Storm", 30, "Weather Manipulation", "Claustrophobia", squad.getId());
        hero1.save();
        hero2.save();

        List<Hero> heroes = squad.getHeroes();
        assertEquals(2, heroes.size());
        assertTrue(heroes.contains(hero1));
        assertTrue(heroes.contains(hero2));
    }

    // Add more test methods to cover other functionalities of the Squad class.
    // For example, you can test the equals() method or any other helper methods.
}
