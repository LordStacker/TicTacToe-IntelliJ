package tictactoe.tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Main extends Application {

    private InfoCenter infocenter;
    private TileBoard tileBoard;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root, UIConstant.APP_WIDTH, UIConstant.APP_HEIGHT);
        initLayout(root);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
    }
    private void initLayout(BorderPane root){
        initInfoCenter(root);
        initTileBoard(root);
    }

    private void initTileBoard(BorderPane root) {
        tileBoard = new TileBoard(infocenter);
        root.getChildren().add(tileBoard.getStackPane());
    }

    private void initInfoCenter(BorderPane root) {
        infocenter = new InfoCenter();
        infocenter.setStartGameButtonOnAction(startNewGame());
        root.getChildren().add(infocenter.getStackPane());

    }
    private EventHandler<ActionEvent> startNewGame(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                infocenter.hideStartButton();
                infocenter.updateMessage("Player X's TURN");
                tileBoard.startNewGame();
            }
        };
    }


    public static void main(String[] args) {
        launch();
    }
}