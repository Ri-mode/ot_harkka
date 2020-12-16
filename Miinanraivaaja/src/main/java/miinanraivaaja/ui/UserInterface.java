package miinanraivaaja.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import miinanraivaaja.logic.GameLogic;

/**
 * UI-luokka, jonka sisällä pyöritetään graafista JavaFX-sovellusta.
 */
public class UserInterface extends Application {

    private GameLogic gameLogic;
    private Stage primaryStage;

    @Override
    public void init() {

    }

    /**
     * JavaFX:n avulla toteutettu graafinen käyttöliittymä.
     *
     * @param primaryStage Käyttöliittymän perusnäkymä
     *
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Miinanraivaaja");

        this.gameLogic = this.createNewGame(8);

        BorderPane primaryPane = new BorderPane();

        HBox buttons = new HBox();

        Button startGame = new Button("Aloita kilpapeli");
        Button showMines = new Button("Aloita vapaapeli");

        buttons.getChildren().add(startGame);
        buttons.getChildren().add(showMines);

//        GridPane gamePane = drawPlayerPane(gameLogic);

        primaryPane.setTop(buttons);
//        primaryPane.setCenter(gamePane);

        Scene primaryScene = new Scene(primaryPane);

        showMines.setOnAction((event) -> {
            Scene showMineField = new Scene(openMinePane(gameLogic));
            this.primaryStage.setScene(showMineField);
        });
        
        startGame.setOnAction((event) -> {
            Scene drawPlayerField = new Scene (drawPlayerPane(gameLogic));
            this.primaryStage.setScene(drawPlayerField);
        });

        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }

    /**
     * Metodi uuden pelilogiikan luontiin.
     *
     * @param n Pelialueen mitat ja pommien lukumäärä
     *
     * @return uusi pelilogiikka
     */
    private GameLogic createNewGame(int n) {
        return new GameLogic(n);
    }

    /**
     * Metodi miinakentän näyttämiseen alkuvalikossa.
     *
     * @param gLogic Meneillään olevan pelin pelilogiikka
     *
     * @return miinakenttä GridPanena
     */
    private GridPane openMinePane(GameLogic gLogic) {
        GridPane gamePane = new GridPane();
        for (int j = 1; j <= gLogic.getN(); j++) {
            for (int i = 1; i <= gLogic.getN(); i++) {
                Button nButton = new Button(Integer.toString(gLogic.getMineField().mineCell(j, i)));
                nButton.setPrefSize(35, 35);
                gamePane.add(nButton, j, i);
            }
        }
        gamePane.setGridLinesVisible(true);
        return gamePane;
    }

    /**
     * Metodi pelaajanäkymän esittämiseen GridPane oliona.
     *
     * @param gLogic Meneillään olevan pelin pelilogiikka
     *
     * @return pelaajanäkyä GridPanena
     */
    private GridPane drawPlayerPane(GameLogic gLogic) {
        GridPane playerPane = new GridPane();
        for (int j = 1; j <= gLogic.getN(); j++) {
            for (int i = 1; i <= gLogic.getN(); i++) {
                String bName = Integer.toString(gLogic.getPlayerField().checkCell(j, i));
                Button nButton = buttonFactory(j, i, bName);
                nButton.setPrefSize(35, 35);
                playerPane.add(nButton, j, i);
            }
        }
        playerPane.setGridLinesVisible(true);
        return playerPane;
    }

    /**
     * Metodi pelaajakentän nappien luomiseen ja toiminnallisuuden
     * toteuttamiseen.
     *
     * @param y Napin sarake
     * @param x Napin rivi
     * @param name Napin nimi
     * @return oikein toimiva nappi
     */
    private Button buttonFactory(int y, int x, String name) {
        Button nButton = new Button(name);
        nButton.setOnMouseClicked((event) -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                if (gameLogic.getPlayerField().checkCell(y, x) == -1) {
                    if (gameLogic.openPlayerCell(y, x) == 9) {
                        Scene showMineField = new Scene(openMinePane(gameLogic));
                        this.primaryStage.setScene(showMineField);
                    } else {
                        Scene showPlayerField = new Scene(drawPlayerPane(gameLogic));
                        this.primaryStage.setScene(showPlayerField);
                    }
                }
            }
            if (event.getButton() == MouseButton.SECONDARY) {
                if (gameLogic.getPlayerField().checkCell(y, x) == -1) {
                    gameLogic.getPlayerField().flagCellMine(y, x);
                } else if (gameLogic.getPlayerField().checkCell(y, x) == -9) {
                    gameLogic.getPlayerField().unflagCellMine(y, x);
                }
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
