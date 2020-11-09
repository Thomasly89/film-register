package main.model;

import java.time.LocalDate;

public class Episode extends Produksjon {

    private int episodenummer;
    private int sesong;


    public Episode(int episodenummer, int sesong, String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, Person regissor){
        super(tittel,spilletid,beskrivelse, utgivelsesdato,regissor);
        this.episodenummer = episodenummer;
        this.sesong = sesong;

    }

    public int getEpisodenummer() {
        return episodenummer;
    }

    public void setEpisodenummer(int episodenummer) {
        this.episodenummer = episodenummer;
    }

    public int getSesong() {
        return sesong;
    }

    public void setSesong(int sesong) {
        this.sesong = sesong;
    }



    @Override

    public String toString(){
        return "tittel " +getTittel()+" sesong " + sesong +" episode " + episodenummer + " varer i " + getSpilletid() + "min";
    }

}
