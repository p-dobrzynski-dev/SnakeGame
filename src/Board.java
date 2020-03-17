import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board {
    private int nrOfRows;
    private int nrOfColumns;

    private int boardWidth;
    private int boardHeight;

    private Snake snake;
    private Apple apple;

    private int pixelSize = 30;

    public Board(int width, int height) {
        // Setting board size
        this.boardWidth = width;
        this.boardHeight = height;

        // Getting number of rows and columns needed to create board
        nrOfRows = width / pixelSize;
        nrOfColumns = height / pixelSize;

        //Adding snake to game
        snake = new Snake(new Point(nrOfRows / 2, nrOfColumns / 2));

        //Adding apple to board
        apple = new Apple(new Point(5, 5));

    }

    public void resetBoard() {
        //Adding snake to game
        snake = new Snake(new Point(nrOfColumns / 2, nrOfRows / 2));

        //Adding apple to board
        apple = new Apple(new Point(5, 5));
    }


    public void paintBoard(GraphicsContext context) {

        updateBoard();

        // Drawing background
        Color boardColor = Color.web("#6ab04c");
        context.setFill(boardColor);
        context.fillRect(0, 0, this.boardWidth, this.boardHeight);

        //Drawing apple
        Color appleColor = Color.web("#e55039");
        context.setFill(appleColor);
        context.fillRect(apple.getPoint().getX() * pixelSize + 1, apple.getPoint().getY() * pixelSize + 1, pixelSize - 2, pixelSize - 2);

        //Drawing snake
        Color snakeColor = Color.web("#576574");
        context.setFill(snakeColor);

        for (Point point : snake.getPointsList()) {
            int topLeftX = point.getX() * pixelSize;
            int topLeftY = point.getY() * pixelSize;
            context.fillRect(topLeftX + 1, topLeftY + 1, pixelSize - 2, pixelSize - 2);
        }
        context.setFill(Color.WHITE);
        double fontSize = context.getFont().getSize();
        context.fillText("SCORE : " + snake.getScore(), 10, 2 * fontSize);

    }


    private static Integer getRandomIntFromRange(int from, int to) {
        int value = ((int) (Math.random() * (to - from))) + from;
        return value;
    }

    public Snake getSnake() {
        return snake;
    }

    public void updateBoard() {
        snake.moveSnake();

        if (snake.getPointsList().get(0).isEqual(apple.getPoint())) {
            snake.extendSnake(apple.getPoint());
            apple.setPoint(getRandomPoint());
        } else if (!snake.getPointsList().get(0).inRange(0, 0, nrOfRows - 1, nrOfColumns - 1)) {
            snake.setCollisionPoint();
            resetBoard();
            return;
        } else if (snake.checkItselfCollision()) {
            resetBoard();
            return;
        }
    }

    private Point getRandomPoint() {
        outerLoop:
        while (true) {
            int randomX = getRandomIntFromRange(0, nrOfRows);
            int randomY = getRandomIntFromRange(0, nrOfColumns);

            for (Point point : snake.getPointsList()) {
                if (randomX != point.getX() && randomY != point.getY()) {
                    continue;
                } else {
                    continue outerLoop;
                }
            }
            return new Point(randomX, randomY);
        }
    }
}
