package main.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Tvserie klasse, med tittel, beskrivelse, utgivelsesdato, en liste med episoder,
 * gjennomsnittsspilletid og antall sesonger
 */
public class TvSerie{
    private String tittel;
    private String beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList<Episode> episoder = new ArrayList<>();
    private double gjennomsnittspilletid;
    private int antallSesonger = 0;


    /**
     * Henter ut informasjon om skuespillerene og rollene i episoden
     */
    public void hentCast(){
        for (Episode item: episoder){
            System.out.println(episoder+" " + item.getRoller());


        }
    }

    /**
     * Metode for å legge til episoder, sjekker om det er riktig valgt sesong
     * @param episode
     */
    public void leggTilEpisoder(Episode episode){
        if(episode.getSesong() >= antallSesonger+2){
            System.out.println("Ugyldig sesong valg");
        }
        else if(episode.getSesong()== antallSesonger+1){
            episoder.add(episode);
            oppdaterGjennomsnittligSpilletid();
            antallSesonger++;
        }
        else if(episode.getSesong() ==antallSesonger){
            episoder.add(episode);
            oppdaterGjennomsnittligSpilletid();
        }
    }

    /**
     * kontrollør for tvserie
     * @param tittel
     * @param beskrivelse
     * @param utgivelsesdato
     */
    public TvSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato){
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        alleSerier.add(this);
    }

    public static ArrayList<TvSerie> alleSerier = new ArrayList<>();


    /**
     * Henter ut en liste over epsider i den valgte sesongen
     * @param sesong
     */
    public List<Episode> hentSesongen (int sesong){
        ArrayList<Episode> nyListe = new ArrayList<Episode>();
        for(int i=0; i<episoder.size(); i++) {
            if (episoder.get(i).getSesong() == sesong) {
                nyListe.add(episoder.get(i));
            }
        }
        return nyListe;
    }

    /**
     * en metode for å regne ut gjennomsnittlig spilletid
     */
    private void oppdaterGjennomsnittligSpilletid(){
        double tid = 0;
        double antallEpisoder = 0;
        for(Episode item : episoder){
            antallEpisoder++;
            tid+= item.getSpilletid();
        }
        gjennomsnittspilletid = tid/antallEpisoder;
    }



    public int getAntallSesonger() {
        return antallSesonger;
    }
    public TvSerie(String tittel) {
        this.tittel = tittel;
    }
    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public ArrayList<Episode> getEpisoder() {
        return episoder;
    }

    public void setEpisoder(ArrayList<Episode> episoder) {
        this.episoder = episoder;
    }

    public double getGjennomsnittspilletid() {
        return gjennomsnittspilletid;
    }

    public void setGjennomsnittspilletid(double gjennomsnittspilletid) {
        this.gjennomsnittspilletid = gjennomsnittspilletid;
    }

    @Override
    public String toString(){
        return "Tittel " + tittel + " Serien handler om " + beskrivelse + " Og startet i " + utgivelsesdato;
    }

}
