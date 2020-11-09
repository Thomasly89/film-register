package main.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Klassen Produksjon, en abstrakt klasse, inneholder tittel,spilletid,beskrivelse,utgivelsesdato og informasjon om regissøren
 */
public abstract class Produksjon {
    private String tittel;
    private Double spilletid;
    private String beskrivelse;
    private LocalDate utgivelsesdato;
    private Person regissor = new Person();
    private ArrayList<Roller> roller = new ArrayList<>();

    public Produksjon(String tittel, Double spilletid, String beskrivelse, LocalDate utgivelsesdato, Person regissor) {
        this.tittel = tittel;
        this.spilletid = spilletid;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        this.regissor = regissor;
    }

    /**
     * en metode for å legge til en rolle i produksjonen
     * @param rolle
     */
    public void LeggTilEnRolle(Roller rolle) {
        roller.add(rolle);
    }

    /**
     * en metode for å legge til flere episoder på engang i produksjonen
     * @param roller1
     */
    public void LeggTilMangeRoller(ArrayList<Roller> roller1) {
        for(int i=0;i<roller.size();i++ ){
            roller.add(roller1.get(i));
        }
    }

    public ArrayList<Roller> getRoller() {
        return roller;
    }

    public void setRoller(ArrayList<Roller> roller) {
        this.roller = roller;
    }

    public Person getRegissor() {
        return regissor;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
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

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public Double getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(Double spilletid) {
        this.spilletid = spilletid;
    }
    @Override
    public String toString() {
        return "Tittel " + tittel + " handler om " + beskrivelse + " Kom ut i  " + utgivelsesdato + " Og ble regissert av " + regissor;
    }
}