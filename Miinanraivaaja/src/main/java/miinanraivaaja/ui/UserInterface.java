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

        buttons.getChildren().add(startGame);

        GridPane gamePane = createGamePane(10);

        primaryPane.setTop(buttons);
        primaryPane.setCenter(gamePane);

        Scene primaryScene = new Scene(primaryPane);

        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    private GridPane createGamePane(int n) {

        GridPane gamePane = new GridPane();

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                gamePane.add(new Button("*"), x, y);
            }
        }
        gamePane.setGridLinesVisible(true);
        return gamePane;

    }

    @Override
    public void stop() {
        System.out.println("Peli sulkeutuu");
    }

    public static void main(String[] args) {
        launch(UserInterface.class);
    }

}
