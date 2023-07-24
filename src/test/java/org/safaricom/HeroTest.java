package org.safaricom;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {

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
    public void testHeroCreation() {
        // Test the Hero constructor and getter methods
        Hero hero = new Hero("Superman", 30, "Flight", "Kryptonite", 1);
        assertEquals("Superman", hero.getName());
        assertEquals(30, hero.getAge());
        assertEquals("Flight", hero.getPower());
        assertEquals("Kryptonite", hero.getWeakness());
        assertEquals(1, hero.getSquadId());
    }

    @Test
    public void testHeroSaveAndFind() {
        // Test the save() and find() methods
        Hero hero = new Hero("Batman", 35, "Rich", "No superpowers", 2);
        hero.save();

        Hero foundHero = Hero.find(hero.getId());
        assertNotNull(foundHero);
        assertEquals(hero.getName(), foundHero.getName());
        assertEquals(hero.getAge(), foundHero.getAge());
        assertEquals(hero.getPower(), foundHero.getPower());
        assertEquals(hero.getWeakness(), foundHero.getWeakness());
        assertEquals(hero.getSquadId(), foundHero.getSquadId());
    }

    // Add more test methods to cover other functionalities of the Hero class.
    // For example, you can test the update() method and other helper methods.
}
