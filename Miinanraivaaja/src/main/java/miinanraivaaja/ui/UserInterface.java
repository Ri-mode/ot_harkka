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
        Minefield field = new Minefield(n, n, n);
        field.scatterMines();

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                gamePane.add(new Button(Integer.toString(field.cell(j, i))), i, j);
                
                
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
