package com.endava.tasks.TaskGenerics;

import java.util.*;

public class League<T extends Team> {

    private Set<T> teamList = new TreeSet<>();


    public void add(T team) {
        teamList.add(team);
    }

    public void displayLeague() {
        for (T team : teamList) {
            System.out.println(team);
        }
    }
}




