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
import miinanraivaaja.logic.GameLogic;

/**
 *
 * @author antti
 */
public class UserInterface extends Application {

    private GameLogic gameLogic;
    

    @Override
    public void init() {

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Miinanraivaaja");

        this.gameLogic = this.createNewGame(10);

        BorderPane primaryPane = new BorderPane();

        HBox buttons = new HBox();

        Button startGame = new Button("Aloita peli");
        Button showMines = new Button("Näytä miinat");

        buttons.getChildren().add(startGame);
        buttons.getChildren().add(showMines);

        GridPane gamePane = drawPlayerPane(gameLogic);

        primaryPane.setTop(buttons);
        primaryPane.setCenter(gamePane);

        Scene primaryScene = new Scene(primaryPane);

        showMines.setOnAction((event) -> {
            Scene showMineField = new Scene(openMinePane(gameLogic));
            primaryStage.setScene(showMineField);
        });
        

        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    private GameLogic createNewGame(int n) {
        return new GameLogic(n);
    }

    private GridPane openMinePane(GameLogic gLogic) {
        GridPane gamePane = new GridPane();
        for (int j = 1; j <= gLogic.getN(); j++) {
            for (int i = 1; i <= gLogic.getN(); i++) {
                gamePane.add(new Button(Integer.toString(gLogic.getMineField().cell(j, i))), i, j);
            }
        }
        gamePane.setGridLinesVisible(true);
        return gamePane;
    }

    private GridPane drawPlayerPane(GameLogic gLogic) {
        GridPane playerPane = new GridPane();
        for (int j = 1; j <= gLogic.getN(); j++) {
            for (int i = 1; i <= gLogic.getN(); i++) {
                playerPane.add(new Button(Integer.toString(gLogic.getPlayerField().cell(j, i))), i, j);
            }
        }
        playerPane.setGridLinesVisible(true);
        return playerPane;
    }

    private Button buttonFactory(int y, int x, String name) {

        return (new Button(name));
    }

    @Override
    public void stop() {
        System.out.println("Peli sulkeutuu");
    }

    public static void main(String[] args) {
        launch(UserInterface.class);
    }

}
