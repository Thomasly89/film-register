package main.model;

import java.time.LocalDate;

public class Person {
    private String navn;
    private LocalDate fodselsdato;
    private String hjemmeland;

    public Person(String navn, LocalDate fodselsdato, String fodselssted) {
        this.navn = navn;
        this.fodselsdato = fodselsdato;
        this.hjemmeland = fodselssted;
    }

    public Person() {

    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }


    public LocalDate getFodselsdato() {
        return fodselsdato;
    }

    public void setFodselsdato(LocalDate fodselsdato) {
        this.fodselsdato = fodselsdato;
    }

    public String getHjemmeland() {
        return hjemmeland;
    }

    public void setHjemmeland(String fodselssted) {
        this.hjemmeland = hjemmeland;
    }
    @Override
    public String toString() {
        return "Navn " + navn + " Født " + fodselsdato + " Hjemmeland " + hjemmeland;
    }
}
