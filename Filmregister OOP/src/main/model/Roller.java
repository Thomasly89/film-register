package main.model;

import main.model.Person;


public class Roller {
    private String karakterFornavn;
    private String karakterEtternavn;
    private Person skuespiller = new Person();

    public Roller(String karakterFornavn, String karakterEtternavn, Person skuespiller) {
        this.karakterFornavn = karakterFornavn;
        this.karakterEtternavn = karakterEtternavn;
        this.skuespiller = skuespiller;
    }

    public String getKarakterFornavn() {
        return karakterFornavn;
    }

    public void setKarakterFornavn(String karakterFornavn) {
        this.karakterFornavn = karakterFornavn;
    }

    public String getKarakterEtternavn() {
        return karakterEtternavn;
    }

    public void setKarakterEtternavn(String karakterEtternavn) {
        this.karakterEtternavn = karakterEtternavn;
    }

    public Person getSkuespiller() {
        return skuespiller;
    }

    public void setSkuespiller(Person skuespiller) {
        this.skuespiller = skuespiller;
    }


    @Override
    public String toString() {
        return "Rolle " + karakterFornavn + " " + karakterEtternavn + " Og blir spilt av " + skuespiller;
    }
}
