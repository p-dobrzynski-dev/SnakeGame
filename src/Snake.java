import java.util.LinkedList;
import java.util.List;

public class Snake {

    Point point;
    private List<Point> listOfPoints;
    private int xDirection;
    private int yDirection;
    private Point collisionPoint;

    public Snake(Point point) {
        listOfPoints = new LinkedList<>();
        listOfPoints.add(point);
        this.point = point;
    }

    public int getScore() {
        int score = (listOfPoints.size() - 1) * 10;
        return score;
    }

    public List<Point> getPointsList() {
        return listOfPoints;
    }

    public void setCollisionPoint() {
        collisionPoint = new Point(listOfPoints.get(0));
    }

    public Point getCollisionPoint() {
        return collisionPoint;
    }

    public boolean isCollision() {
        if (collisionPoint == null) {
            return false;
        } else {
            return true;
        }
    }

    public void setDirUp() {
        if (yDirection == 1 && listOfPoints.size() > 1) {
            return;
        }
        xDirection = 0;
        yDirection = -1;
    }

    public void setDirDown() {
        if (yDirection == -1 && listOfPoints.size() > 1) {
            return;
        }
        xDirection = 0;
        yDirection = 1;
    }

    public void setDirLeft() {
        if (xDirection == 1 && listOfPoints.size() > 1) {
            return;
        }
        xDirection = -1;
        yDirection = 0;
    }

    public void setDirRight() {
        if (xDirection == -1 && listOfPoints.size() > 1) {
            return;
        }
        xDirection = 1;
        yDirection = 0;
    }

    public void moveSnake() {
        for (int i = listOfPoints.size() - 1; i >= 1; i--) {
            listOfPoints.get(i).updateByPoint(listOfPoints.get(i - 1));
        }
        listOfPoints.get(0).shiftPoint(xDirection, yDirection);
    }

    public void extendSnake(Point point) {
        listOfPoints.add(point);
    }

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
