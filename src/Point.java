public class Point {

    private int x;
    private int y;

    /***
     * Constructor for Point class
     *
     * @param x X value of point
     * @param y Y value of point
     */
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /***
     * Getting X value of point
     *
     * @return X point value
     */
    public int getX() {
        return x;
    }

    /***
     * Getting Y value of point
     *
     * @return Y point value
     */
    public int getY() {
        return y;
    }

    /***
     * Checking if point is equal to selected point
     *
     * @param point Point ot compare
     * @return Is equal
     */
    public boolean isEqual(Point point) {
        return (point.getX() == this.x) && (point.getY() == this.y);
    }

    /***
     * Checking if point position is in range
     *
     * @param fromX Minimum X value
     * @param fromY Minimum Y value
     * @param toX Maximum X value
     * @param toY Maximum Y value
     * @return Is in range
     */
    public boolean inRange(int fromX, int fromY, int toX, int toY) {
        return x >= fromX && x <= toX && y >= fromY && y <= toY;
    }

    /***
     * Updating point by new Point object
     *
     * @param point New point
     */
    public void setPoint(Point point) {
        x = point.getX();
        y = point.getY();
    }

    /***
     * Shifting point position by dx and dy value
     *
     * @param dx Shift in X
     * @param dy Shift in Y
     */
    public void shiftPoint(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }
}
