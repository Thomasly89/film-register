package main.model;

import java.time.LocalDate;
import java.util.ArrayList;



/**
 * Filmklasse med tittel, beskrivelse,spilletid,utgivelsesdato,url til bilder
 * klassen extender fra klassen produksjon
 */
public class Film extends Produksjon implements Comparable<Film> {
    private String posterURL;

    /**
     *
     * @param tittel
     * @param beskrivelse
     * @param spilletid
     * @param utgivelsesdato
     * @param posterURL
     * @param regissor
     */
    public Film(String tittel, String beskrivelse, Double spilletid, LocalDate utgivelsesdato,String posterURL, Person regissor) {
        super(tittel, spilletid,beskrivelse, utgivelsesdato,regissor);
        this.posterURL = posterURL;
        alleFilmer.add(this);


    }
    @Override
    public int compareTo(Film sammenligningsFilm){
        return this.getTittel().compareToIgnoreCase(sammenligningsFilm.getTittel());
    }

    public static ArrayList<Film> getAlleFilmer() {
        return alleFilmer;
    }

    public static ArrayList<Film> alleFilmer = new ArrayList<>();

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    @Override
    public String toString(){
    return "tittel " +getTittel()+" Handler om "+ getBeskrivelse()+ " varer i " + getSpilletid() + "min" + " Og ble laget i " + getUtgivelsesdato() + "  " + getPosterURL();

    }

}
