package main.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import main.model.Film;
import main.model.Person;

import java.io.*;
import java.time.LocalDate;

public class FilmHandtering {
    //Fikk ikke helt til bilde visningen, veit ikke helt hva som er feil
    public static void FilmLaster() {


        File kilde = new File("/Users/thomasly89/Documents/ThomasData/OOP/Oblig5_OOP_ThomasAntuanLy /src/main/filmer.csv");

        try (BufferedReader bufretLeser = new BufferedReader(new FileReader(kilde))){
            String linje;

            while((linje = bufretLeser.readLine()) != null){
                String[] deler = linje.split(";");

                Film k =new Film(deler[0],deler[1],Double.valueOf(deler[2]),LocalDate.parse(deler[3]),
                        "https://image.tmdb.org/t/p/w500/"+deler[4],
                        new Person("",LocalDate.of(1000,10,10),""));

                Film.alleFilmer.add(k);


            }

        }

        catch (FileNotFoundException e){
            System.out.println("Feil fil");

        }
        catch (IOException e){
            System.out.println("Feil ved innlasting");
        }

    }
    public static void FilmSkriver(){
        File kilde = new File("/Users/thomasly89/Documents/ThomasData/OOP/Oblig5_OOP_ThomasAntuanLy /src/main/filmer.csv");

        try(BufferedWriter bufretSkriver = new BufferedWriter(new FileWriter(kilde))){
            for(Film enFilm: Film.alleFilmer){
               bufretSkriver.write(enFilm.getTittel() +";" +  enFilm.getBeskrivelse() + ";" + enFilm.getSpilletid() + ";" + enFilm.getUtgivelsesdato());
               bufretSkriver.newLine();
            }

        }

        catch (FileNotFoundException e){
            System.out.println("Filen finnes ikke");

        }

       catch (IOException e){
            System.out.println("Det oppstod en feil, ved skriving til filen");

       }
    }
}
