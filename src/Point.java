public class Point {

    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point(Point point){
        this.x = point.getX();
        this.y = point.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEqual(Point point) {
        if ((point.getX() == this.x) && (point.getY() == this.y)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean inRange(int fromX, int fromY, int toX, int toY) {
        if (x >= fromX && x <= toX && y >= fromY && y <= toY) {
            return true;
        } else {
            return false;
        }
    }

    public void updateByPoint(Point point) {
        x = point.getX();
        y = point.getY();
    }

    public void shiftPoint(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }
}
