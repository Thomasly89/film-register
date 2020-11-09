package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.MainJavaFx;
import main.model.Film;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class FilmOversiktController {

    ArrayList<Film> filmListe = Film.getAlleFilmer();

    //Fikk ikke denne til å fungere
    //Film.alleFilmer.setCellFactory(new Callback<ListView<Film>, ListCell<Film>>)(){
      //@Override
        //public ListCell<Film> call(ListView<Film> param){
          //return new FilmCelle();
        //}

    //}

    public static class FilmCelle extends ListCell<Film> {
        @Override
        public void updateItem(Film enFilm, boolean empty){
            super.updateItem(enFilm, empty);
            if(enFilm != null){
                setText("Tittel:" + enFilm.getTittel() + " Utgivelsesdato" + enFilm.getUtgivelsesdato());
            }
        }

    }


    @FXML
    private ListView listView;
    @FXML
    private TextField beskrivelse;
    @FXML
    private TextField utgivelsesdato;
    @FXML
    private TextField spilletid;
    @FXML
    public ImageView filmBilde;

    @FXML
    public void initialize() {

        for(Film enFilm : Film.alleFilmer) {
            listView.getItems().add(enFilm.getTittel() + " (" + enFilm.getUtgivelsesdato() + " )");

        }



    }


    @FXML
    public void redigerButton(ActionEvent event) throws IOException{
        MainJavaFx.javaFXApplikasjonen.gaaTilRedigeringsScene(listView.getSelectionModel().getSelectedIndex());

    }

    @FXML
    public void velgFilm(MouseEvent mouseEvent) {

        beskrivelse.setText(Film.alleFilmer.get(listView.getSelectionModel().getSelectedIndex()).getBeskrivelse());
        spilletid.setText(Film.alleFilmer.get(listView.getSelectionModel().getSelectedIndex()).getSpilletid().toString());
        utgivelsesdato.setText(Film.alleFilmer.get(listView.getSelectionModel().getSelectedIndex()).getUtgivelsesdato().toString());
        filmBilde.setImage(new Image(Film.alleFilmer.get(listView.getSelectionModel().getSelectedIndex()).getPosterURL()));
    }
    @FXML
    public void nyFilm(ActionEvent event) throws IOException {
        MainJavaFx.javaFXApplikasjonen.gaaTilNyFilmScene();
    }

    public void slettFilm(ActionEvent event) {
        listView.getItems().remove(listView.getSelectionModel().getSelectedIndex());
    }

    public void alfabetiskSynkende(MouseEvent mouseEvent) {
        sorter(3);
        MainJavaFx.javaFXApplikasjonen.filmovOversiktScene();
    }

    public void alfabetiskStigende(MouseEvent mouseEvent) {
        sorter(2);
        MainJavaFx.javaFXApplikasjonen.filmovOversiktScene();
    }

    public void aarSynkende(MouseEvent mouseEvent) {
        sorter(1);
        MainJavaFx.javaFXApplikasjonen.filmovOversiktScene();
    }

    public void aarStigende(MouseEvent mouseEvent) {
        sorter(0);
        MainJavaFx.javaFXApplikasjonen.filmovOversiktScene();
    }

    private void sorter(int sortering){
        Film.alleFilmer.sort(new Comparator<Film>() {
            @Override
            public int compare(Film film1, Film film2) {
                if(sortering ==0){
                    if(film1.getUtgivelsesdato().getYear() > film2.getUtgivelsesdato().getYear()){
                        return 1;
                    }else if (film1.getUtgivelsesdato().getYear() < film2.getUtgivelsesdato().getYear()){
                        return -1;
                    }
                }
                if (sortering == 1){
                    if(film1.getUtgivelsesdato().getYear() < film2.getUtgivelsesdato().getYear()){
                        return 1;
                    }else if(film1.getUtgivelsesdato().getYear() >film2.getUtgivelsesdato().getYear()){
                        return -1;
                    }else{
                        return 0;
                    }
                }
                if(sortering ==2){
                    return film1.getTittel().compareTo(film2.getTittel());
                }
                if(sortering ==3){
                    return film1.getTittel().compareTo(film2.getTittel()) * -1;
                }
                return 0;
            }
        });
    }
}
