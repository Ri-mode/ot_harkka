/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinanraivaaja.ui;

import javafx.application.Application;
import javafx.event.Event;
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
    private Stage primaryStage;

    @Override
    public void init() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Miinanraivaaja");

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
            this.primaryStage.setScene(showMineField);
        });

        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }

    private GameLogic createNewGame(int n) {
        return new GameLogic(n);
    }

    private GridPane openMinePane(GameLogic gLogic) {
        GridPane gamePane = new GridPane();
        for (int j = 1; j <= gLogic.getN(); j++) {
            for (int i = 1; i <= gLogic.getN(); i++) {
                gamePane.add(new Button(Integer.toString(gLogic.getMineField().cell(j, i))), j, i);
            }
        }
        gamePane.setGridLinesVisible(true);
        return gamePane;
    }

    private GridPane drawPlayerPane(GameLogic gLogic) {
        GridPane playerPane = new GridPane();
        for (int j = 1; j <= gLogic.getN(); j++) {
            for (int i = 1; i <= gLogic.getN(); i++) {
                String bName = Integer.toString(gLogic.getPlayerField().checkCell(j, i));
                Button nButton = buttonFactory(j, i, bName);
                playerPane.add(nButton, j, i);
            }
        }
        playerPane.setGridLinesVisible(true);
        return playerPane;
    }

    private Button buttonFactory(int y, int x, String name) {
        Button nButton = new Button(name);
        nButton.setOnAction((event) -> {
            if (gameLogic.openPlayerCell(y, x) == 9) {
                Scene showMineField = new Scene(openMinePane(gameLogic));
                this.primaryStage.setScene(showMineField);
            } else {
//            gameLogic.getPlayerField().setCell(y, x, gameLogic.getMineField().cell(y, x));
//            System.out.println(gameLogic.getPlayerField().checkCell(y, x));
                Scene showPlayerField = new Scene(drawPlayerPane(gameLogic));
                this.primaryStage.setScene(showPlayerField);
            }
        });
        return (nButton);
    }

    @Override
    public void stop() {
        System.out.println("Peli sulkeutuu");
    }

    public static void main(String[] args) {
        launch(UserInterface.class);
    }

}
