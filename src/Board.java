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

    /***
     * Constructor for Board class
     *
     * @param width Width of application screen
     * @param height Height of application screen
     */

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

    /***
     * Resetting Snake and Apple object to start new game
     */

    public void resetBoard() {
        //Adding snake to game
        snake = new Snake(new Point(nrOfColumns / 2, nrOfRows / 2));

        //Adding apple to board
        apple = new Apple(new Point(5, 5));
    }

    /***
     * Paint board with background, snake, apple and score
     *
     * @param context JavaFX GraphicsContext object
     */

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

        // Drawing score field
        double fontSize = context.getFont().getSize();
        context.fillText("SCORE : " + snake.getScore(), 10, 2 * fontSize);

    }

    /***
     * Getting random number in range specified range
     *
     * @param from From number
     * @param to To number
     * @return Random number
     */
    private static Integer getRandomIntFromRange(int from, int to) {
        return ((int) (Math.random() * (to - from))) + from;
    }

    /***
     * Getting snake object
     *
     * @return Snake object
     */
    public Snake getSnake() {
        return snake;
    }


    /***
     * Method updates snake position and checks if snake didn't collide with a wall or collide with itself
     */
    public void updateBoard() {

        // Moving snake based on velocity direction
        snake.moveSnake();

        // Checking if snake hit the apple
        if (snake.getPointsList().get(0).isEqual(apple.getPoint())) {
            snake.extendSnake(apple.getPoint());
            apple.setPoint(getRandomPoint());
        }
        // Checking if snake hit the wall or collide with itself
        else if ((!snake.getPointsList().get(0).inRange(0, 0, nrOfRows - 1, nrOfColumns - 1)) || (snake.checkItselfCollision())) {
            resetBoard();
        }

    }

    /***
     * Getting random Point class object which is not part of snake
     *
     * @return Random Point
     */
    private Point getRandomPoint() {
        outerLoop:
        while (true) {
            int randomX = getRandomIntFromRange(0, nrOfRows);
            int randomY = getRandomIntFromRange(0, nrOfColumns);

            for (Point point : snake.getPointsList()) {
                if (randomX == point.getX() && randomY == point.getY()) {
                    continue outerLoop;
                }
            }
            return new Point(randomX, randomY);
        }
    }
}
