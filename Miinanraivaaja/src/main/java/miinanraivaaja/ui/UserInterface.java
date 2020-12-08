/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinanraivaaja.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import miinanraivaaja.domain.Minefield;
import miinanraivaaja.domain.Playerfield;

/**
 *
 * @author antti
 */
public class UserInterface extends Application {

    @Override
    public void init() {

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Miinanraivaaja");

        BorderPane primaryPane = new BorderPane();

        HBox buttons = new HBox();

        Button startGame = new Button("Aloita peli");
        Button showMines = new Button("Näytä miinat");
        
//        Scene showMineField = new Scene(showMines);

        buttons.getChildren().add(startGame);
        buttons.getChildren().add(showMines);

        GridPane gamePane = createGamePane(10);

        primaryPane.setTop(buttons);
        primaryPane.setCenter(gamePane);

        Scene primaryScene = new Scene(primaryPane);
        
//        showMines.setOnAction((event) -> {
//            GridPane mineFieldPane = gamePane;
//            Scene showMineField = new Scene(mineFieldPane);
//            primaryStage.setScene(showMineField);
//        });

        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    // Tämä tarvinnee refraktoroida omaksi luokakseen, koska tämän
    // hetkisellä toteutuksella tulee ongelmia siirryttäessä ikkunasta toiseen
    private GridPane createGamePane(int n) {

//        GridPane gamePane = new GridPane();
        Minefield mField = new Minefield(n, n, n);
        Playerfield pField = new Playerfield(n, n);
        mField.scatterMines();
        mField.prepareField();
        pField.preparePlayerField();

        return this.openPlayerPane(mField, pField, n);

//        for (int j = 1; j <= n; j++) {
//            for (int i = 1; i <= n; i++) {
//                gamePane.add(new Button(Integer.toString(mField.cell(j, i))), i, j);
//            }
//        }
//        gamePane.setGridLinesVisible(true);
//        return gamePane;
    }

    private GridPane openMinePane(Minefield mField, Playerfield pField, int n) {
        GridPane gamePane = new GridPane();
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                gamePane.add(new Button(Integer.toString(mField.cell(j, i))), i, j);
            }
        }
        gamePane.setGridLinesVisible(true);
        return gamePane;
    }

    private GridPane openPlayerPane(Minefield mField, Playerfield pField, int n) {
        GridPane playerPane = new GridPane();
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                playerPane.add(new Button(Integer.toString(pField.cell(j, i))), i, j);
            }
        }
        playerPane.setGridLinesVisible(true);
        return playerPane;
    }
    
    

    @Override
    public void stop() {
        System.out.println("Peli sulkeutuu");
    }

    public static void main(String[] args) {
        launch(UserInterface.class);
    }

}
