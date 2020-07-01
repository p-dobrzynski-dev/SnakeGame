import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import javafx.geometry.Pos;
import javafx.stage.Stage;

public class SnakeGame extends Application {

    private Board gameBoard;
    private GameEngine gameEngine;


    public static void main(String[] args) {
        launch(args);
    }

    /***
     * Overriding build in JavaFx method "start"
     *
     * @param primaryStage -
     */
    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        int screenWidth = 600;
        int screenHeight = 600;
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext context = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);

        gameBoard = new Board(screenWidth, screenHeight);
        gameEngine = new GameEngine(gameBoard, context);
        gameBoard.paintBoard(context);

        // Capture keyboard keys
        canvas.setOnKeyPressed(e -> {
            if (gameEngine.isKeyAvailable()) {
                Snake snake = gameBoard.getSnake();
                switch (e.getCode()) {
                    case UP:
                        snake.setDirUp();
                        break;
                    case DOWN:
                        snake.setDirDown();
                        break;
                    case LEFT:
                        snake.setDirLeft();
                        break;
                    case RIGHT:
                        snake.setDirRight();
                        break;
                }
                gameEngine.setKeyAvailable(false);
            }
        });

        // Creating interface (menu and game scene)
        root.getChildren().add(canvas);
        Scene gameScene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake Game");
        primaryStage.setOnCloseRequest(e -> System.exit(0));


        VBox mainLayout = new VBox(175);
        Scene menuScene = new Scene(mainLayout, screenWidth, screenHeight);
        menuScene.getStylesheets().add("SnakeGameStylesheet.css");

        Label gameTitle = new Label("SNAKE GAME");
        gameTitle.getStyleClass().add("gameTitleLabel");
        mainLayout.getChildren().addAll(gameTitle);

        VBox menuLayout = new VBox(20);
        Label gameInfo = new Label("  Use arrow keys to control snake  ");
        gameInfo.getStyleClass().add("gameInfoLabel");
        Button startGameButton = new Button("START");
        startGameButton.setOnAction(event -> primaryStage.setScene(gameScene));
        menuLayout.getChildren().addAll(startGameButton, gameInfo);
        mainLayout.getChildren().add(menuLayout);

        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setPadding(new Insets(100,0,0,0));
        menuLayout.setAlignment(Pos.CENTER);
        primaryStage.setScene(menuScene);

        primaryStage.show();

        // Starting game engine
        gameEngine.startGame();
    }
}