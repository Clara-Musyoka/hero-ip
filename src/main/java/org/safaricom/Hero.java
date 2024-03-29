package org.safaricom;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private int squadId;
    private int id;

    public Hero(String name, int age ,String power,String weakness, int squadId ) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.squadId = squadId;

    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPower() {
        return power;
    }
    public String getWeakness() {
        return weakness;
    }
    public int getId() {
        return id;
    }
    public int getSquadId() {
        return squadId;
    }

    public static List<Hero> all() {
        String sql = "SELECT id, name, squadId,age,power,weakness FROM heroes";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Hero.class);
        }
    }

    @Override
    public boolean equals(Object otherHero){
        if (!(otherHero instanceof Hero)) {
            return false;
        } else {
            Hero newHero = (Hero) otherHero;
            return this.getName().equals(newHero.getName()) &&
                    this.getId() == newHero.getId() &&
                    this.getSquadId() == newHero.getSquadId();
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO heroes(name, squadId) VALUES (:name, :squadId)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("squadId", this.squadId)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Hero find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM heroes where id=:id";
            Hero hero = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Hero.class);
            return hero;
        }
    }
    public void update(String name) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE tasks SET name = :name WHERE id = :id";
            con.createQuery(sql).addParameter("name",name).addParameter("id",id).executeUpdate();
        }
    }
}