package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.MainJavaFx;
import main.model.Film;
import main.model.Person;

import java.io.IOException;
import java.time.LocalDate;

public class nyFilmController {
    @FXML
    private TextField tittel3;
    @FXML
    private TextField beskrivelse3;
    @FXML
    private TextField utgivelsesdato3;
    @FXML
    private TextField spilletid3;
    @FXML
    private void closeButton1Action(ActionEvent event) throws IOException {
        MainJavaFx.javaFXApplikasjonen.filmovOversiktScene();
    }
    @FXML
    public void leggTilFilm(ActionEvent event) {

        new Film(tittel3.getText(),beskrivelse3.getText(),Double.valueOf(spilletid3.getText()),LocalDate.parse(utgivelsesdato3.getText()),"",
                new Person("",LocalDate.of(1000,10,10),""));

        MainJavaFx.javaFXApplikasjonen.filmovOversiktScene();
    }
}
