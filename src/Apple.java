public class Apple {

    private Point point;

    /***
     * Constructor for Apple class
     *
     * @param point Point object
     */
    public Apple(Point point){
        this.point = point;
    }

    /***
     * Setting Apple position
     *
     * @param point Point object
     */
    public void setPoint(Point point){
        this.point = point;
    }

    /***
     * Getting Apple position
     *
     * @return Apple Point position
     */
    public Point getPoint() {
        return point;
    }
}
