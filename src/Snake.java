import java.util.LinkedList;
import java.util.List;

public class Snake {

    private List<Point> listOfPoints;
    private int xDirection;
    private int yDirection;

    /***
     * Constructor for Snake class
     *
     * @param point - Staring Point for Snake
     */
    public Snake(Point point) {
        listOfPoints = new LinkedList<>();
        listOfPoints.add(point);
    }

    /***
     * Getting current score based on snake length
     *
     * @return Current score
     */
    public int getScore() {
        return (listOfPoints.size() - 1) * 10;
    }

    /***
     * Getting list of Points in snake
     *
     * @return list of points in snake
     */
    public List<Point> getPointsList() {
        return listOfPoints;
    }

    /***
     * Setting snake direction to move UP
     */
    public void setDirUp() {
        if (yDirection == 1 && listOfPoints.size() > 1) {
            return;
        }
        xDirection = 0;
        yDirection = -1;
    }

    /***
     * Setting snake direction to move DOWN
     */
    public void setDirDown() {
        if (yDirection == -1 && listOfPoints.size() > 1) {
            return;
        }
        xDirection = 0;
        yDirection = 1;
    }

    /***
     * Setting snake direction to move LEFT
     */
    public void setDirLeft() {
        if (xDirection == 1 && listOfPoints.size() > 1) {
            return;
        }
        xDirection = -1;
        yDirection = 0;
    }

    /***
     * Setting snake direction to move RIGHT
     */
    public void setDirRight() {
        if (xDirection == -1 && listOfPoints.size() > 1) {
            return;
        }
        xDirection = 1;
        yDirection = 0;
    }

    /***
     * Move snake towards next point based on directions
     */
    public void moveSnake() {
        for (int i = listOfPoints.size() - 1; i >= 1; i--) {
            listOfPoints.get(i).setPoint(listOfPoints.get(i - 1));
        }
        listOfPoints.get(0).shiftPoint(xDirection, yDirection);
    }

    /***
     * Extending Snake points list by point
     *
     * @param point Point of extension
     */
    public void extendSnake(Point point) {
        listOfPoints.add(point);
    }

    /***
     * Checking if snake didn't collide with itself
     *
     * @return Collision detected
     */
    public boolean checkItselfCollision() {
        for (int i = 0; i < listOfPoints.size(); i++) {
            for (int j = i + 1; j < listOfPoints.size(); j++) {
                if (listOfPoints.get(i).getX() == listOfPoints.get(j).getX() && listOfPoints.get(i).getY() == listOfPoints.get(j).getY()) {
                    return true;
                }
            }
        }
        return false;
    }
}
