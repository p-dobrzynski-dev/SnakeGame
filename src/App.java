
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    private Board gameBoard;
    private GameEngine gameEngine;
    private GraphicsContext context;

    private final int screenWidth = 600;
    private final int screenHeight = 600;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        context = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);

        gameBoard = new Board(screenWidth,screenHeight);
        gameEngine = new GameEngine(gameBoard,context);
        gameBoard.paintBoard(context);

        canvas.setOnKeyPressed(e -> {
            if (gameEngine.isKeyAvailable()){
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
            else {
                return;
            }

        });

        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();

        gameEngine.startGame();
    }
}