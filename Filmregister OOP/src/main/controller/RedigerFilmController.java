package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.MainJavaFx;
import main.model.Film;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Double.valueOf;

public class RedigerFilmController {
    ArrayList<Film> filmListe = Film.getAlleFilmer();
    @FXML
    private TextField tittel2;
    @FXML
    private TextField beskrivelse2;
    @FXML
    private TextField utgivelsesdato2;
    @FXML
    private TextField spilletid2;

    private int redigerint;

    public void setText(int redigerint){
        this.redigerint = redigerint;

    }
    @FXML
    public void initialize() {


    }
    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    public void closeButtonAction(ActionEvent event) throws IOException {
        MainJavaFx.javaFXApplikasjonen.filmovOversiktScene();


    }
    @FXML
    public void okFerdig(ActionEvent event) {

            Film.alleFilmer.get(redigerint).setTittel(tittel2.getText());
            Film.alleFilmer.get(redigerint).setSpilletid(valueOf(spilletid2.getText()));
            Film.alleFilmer.get(redigerint).setBeskrivelse(beskrivelse2.getText());
            Film.alleFilmer.get(redigerint).setUtgivelsesdato(LocalDate.parse(utgivelsesdato2.getText()));

            MainJavaFx.javaFXApplikasjonen.filmovOversiktScene();
    }
}
