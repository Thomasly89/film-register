package main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import main.controller.FilmHandtering;
import main.controller.FilmOversiktController;
import main.controller.RedigerFilmController;
import main.model.Film;
import main.model.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import static main.controller.FilmHandtering.FilmLaster;


public class MainJavaFx extends Application {
    public static MainJavaFx javaFXApplikasjonen;
    private Stage primaryStage;
    public MainJavaFx(){
        FilmLaster();
        new Film("Batman Begins","Batman",  40.0, LocalDate.of(2005, Month.JULY,15),"",
                new Person("Christopher Nolan",LocalDate.of(1970, Month.JULY,30),"England"));

        new Film("Justice League","Superhelt film", (double) 20,LocalDate.of(2017,11,15), "",new Person(
                "Zack snyder",LocalDate.of(1966,3,1),"USA"));

    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainJavaFx.javaFXApplikasjonen = this;

        this.primaryStage= primaryStage;

        filmovOversiktScene();
    }

    public void filmovOversiktScene() {
        try {
            FXMLLoader fxmlInnlaster = new FXMLLoader();

            fxmlInnlaster.setLocation(getClass().getResource("view/FilmOversikt.fxml"));
            Parent rootNode = fxmlInnlaster.load();

            Scene hovedScene = new Scene(rootNode, 600, 410);

            primaryStage.setTitle("Film Oversikt");
            primaryStage.setScene(hovedScene);
            primaryStage.show();


        }
        catch (IOException | IllegalStateException ioexc) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);

            errorAlert.setTitle("Noe feil skjedde");
            errorAlert.setHeaderText("ERROR!");
            errorAlert.setContentText("Feil med innlasting av fxml" + ioexc.getMessage());
            errorAlert.showAndWait();
        }
    }



    public void gaaTilRedigeringsScene(int Film) throws IOException {
        FXMLLoader fxmlInnlaster = new FXMLLoader();

        fxmlInnlaster.setLocation(getClass().getResource("view/RedigerFilm.fxml"));
        Parent rootNode = fxmlInnlaster.load();

        Scene listeScene = new Scene(rootNode);
        RedigerFilmController rediger = fxmlInnlaster.getController();
        rediger.setText(Film);

        primaryStage.setTitle("Rediger Film");
        primaryStage.setScene(listeScene);
        primaryStage.show();
    }

    public void gaaTilNyFilmScene() throws IOException {
        FXMLLoader fxmlInnlaster = new FXMLLoader();

        fxmlInnlaster.setLocation(getClass().getResource("view/nyFilm.fxml"));
        Parent rootNode = fxmlInnlaster.load();
        Scene listeScene = new Scene(rootNode);


        primaryStage.setTitle("Legg til Film");
        primaryStage.setScene(listeScene);
        primaryStage.show();
    }
        //try {
            //FXMLLoader fxmlInnlaster = new FXMLLoader();
            //fxmlInnlaster.setLocation(getClass().getResource("view/FilmOversikt.fxml"));
            //Parent hovedLayout = fxmlInnlaster.load();
            //Scene hovedscene = new Scene(hovedLayout, 600, 305);

            //primaryStage.setScene(hovedscene);
            //primaryStage.setTitle("Filmoversikt");
            //primaryStage.show();
        //} catch (IOException | IllegalStateException ioexc) {
            //Alert errorAlert = new Alert(Alert.AlertType.ERROR);

            //errorAlert.setTitle("Noe feil skjedde");
            //errorAlert.setHeaderText("ERROR!");
            //errorAlert.setContentText("Feil med innlasting av fxml" + ioexc.getMessage());
            //errorAlert.showAndWait();

}
