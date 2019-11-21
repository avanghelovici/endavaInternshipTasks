package com.endava.tasks.TaskGenerics;

public class Main {
    public static void main(String[] args) {

        FootballTeam team1 = new FootballTeam("Karliks");
        FootballTeam team2 = new FootballTeam("RichPeople");
        FootballTeam team3 = new FootballTeam("Arsenal");

        BasketBallTeam team4 = new BasketBallTeam("ChickenLovers");
        BasketBallTeam team5 = new BasketBallTeam("Snejki");
        BasketBallTeam team6 = new BasketBallTeam("Perestrelka");


        League<FootballTeam> ft = new League<>();

        ft.add(team1);
        ft.add(team2);
        ft.add(team3);

        ft.displayLeague();

        League<BasketBallTeam> bt = new League<>();

        bt.add(team4);
        bt.add(team5);
        bt.add(team6);

        bt.displayLeague();
    }
}