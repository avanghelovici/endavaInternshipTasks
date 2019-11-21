package com.endava.tasks.TaskGenerics;

public abstract class Team implements Comparable<Team> {

    private String name;
    private String type;

    public Team(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + type;
    }

    @Override
    public int compareTo(Team o) {
        return this.name.compareTo(o.name);
    }
}
