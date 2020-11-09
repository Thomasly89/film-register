package main;

import main.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Random randomnr = new Random();

        Episode episode1 = new Episode(1,1,"Pilot", "et elr annet",46.0,LocalDate.of(2013,8,20),new Person(
                "Zack snyder",LocalDate.of(1966,3,1),"USA"));
        TvSerie flash = new TvSerie("The Flash","mennesker med superkrefter", LocalDate.of(2014,8,07));

        System.out.println("----------Oppgave 1 og 2---------");
        System.out.println("episodenr " + episode1.getEpisodenummer() +" Sesong "+ episode1.getSesong() + " Spilletiden " + episode1.getSpilletid() + "min" + " tittelen " + episode1.getTittel());

        System.out.println("Serien handler om  " + flash.getBeskrivelse() +" Tittelen er " + flash.getTittel() + " Utgivelses datoen er " + flash.getUtgivelsesdato());

        System.out.println("---------Oppgave 3---------");

        System.out.println(episode1);

        System.out.println(flash);


        System.out.print("---------Oppgave 4 og 6---------");

        System.out.println();
        TvSerie Arrow = new TvSerie("Arrow", "Superhelt", LocalDate.of(2013, 8, 20));

        for (int i=1; i<=5; i++){
            for(int k=1; k<=20; k++){
                Arrow.leggTilEpisoder(new Episode(k,i,"episode" + k,"Superhelt serie",randomnr.nextInt((11)+20),LocalDate.of(2013,8,20),new Person(
                        "Zack snyder",LocalDate.of(1966,3,1),"USA")));
            }
        }

        for(Episode item : Arrow.hentSesongen(4)){
            System.out.println(item.toString());
        }

        System.out.println("---------Oppgave 5----------");
        System.out.println(Arrow.getGjennomsnittspilletid());

        System.out.println("----------Oppgave 7 og 8---------");
        Arrow.leggTilEpisoder(new Episode(20,10,"episode","superhelt serie",20,LocalDate.of(2013,8,20),new Person(
                "Zack snyder",LocalDate.of(1966,3,1),"USA")));

        Arrow.leggTilEpisoder(new Episode(20,6,"episode","superhelt serie",20,LocalDate.of(2013,8,20),new Person(
                "Zack snyder",LocalDate.of(1966,3,1),"USA")));

        for(Episode item : Arrow.hentSesongen(6)){
            System.out.println(item.toString());
        }


        System.out.println(Arrow.getAntallSesonger());


        System.out.println("----------------------------Oblig3-----------------------------------");

        System.out.println("----------------------------Oppgave 4--------------------------------");

        Film justiceleague = new Film("Justice League","Superhelt film",  12.0,LocalDate.of(2017,11,15),"",new Person(
                "Zack snyder",LocalDate.of(1966,3,1),"USA"));

        System.out.println(justiceleague);

        System.out.println("---------------------------Oppgave 6----------------------------------");

        System.out.println(justiceleague.getRegissor().getNavn());

        System.out.println("---------------------------Oppgave 7----------------------------------");

        ArrayList<String> roller1 = new ArrayList<>();
        roller1.add("Clark kent");
        roller1.add("Bruce Wayne");
        roller1.add("Barry Allen");
        System.out.println(roller1);

       justiceleague.LeggTilEnRolle (new Roller("Clark","Kent",new Person("Henry Cavill", LocalDate.of(1983,5,5),"England")));
       justiceleague.LeggTilEnRolle (new Roller("Bruce", "wayne",new Person("Ben Affleck",LocalDate.of(1972,8,15),"USA")));
       justiceleague.LeggTilEnRolle (new Roller("Diana", "Prince",new Person("Gal Gadot",LocalDate.of(1985,4,30),"Israel")));

       ArrayList<Roller> roller = justiceleague.getRoller();
       for (Roller item: roller){
           System.out.println("Rolle "+item.getKarakterFornavn()+" " + item.getKarakterEtternavn() + " Skuespiller "+ item.getSkuespiller().getNavn()+ " Født "+item.getSkuespiller().getFodselsdato() + " Hjemmeland " + item.getSkuespiller().getHjemmeland());
       }
       System.out.println("------------------------------------------------Oppgave 9--------------------------------------------");
       episode1.LeggTilEnRolle (new Roller("Barry", "Allen",new Person("Grant Gust",LocalDate.of(1990,1,14),"Canada")));
       episode1.LeggTilEnRolle (new Roller("Iris", "West",new Person("Candis Patton",LocalDate.of(1988,6,24),"Canada")));

        System.out.println(episode1.getRoller() +" Regissør " + episode1.getRegissor());


    }

}
