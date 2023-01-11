package Shape;

import Point.Point2d;
import java.util.Collection;

public class Rectangle extends BaseShape {
    /**
     * Create a filled rectangle centered on (0, 0)
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    public Rectangle(Double width, Double height) {
        Point2d brush = new Point2d(-width/2.0, -height/2.0);
        do {
            do {
                this.add(brush);
            } while ( brush.translate(new Point2d(0.5, 0.0)).X() <= width/2.0 );
        } while(brush.translate(new Point2d(-(width + 0.5), 0.5)).Y() <= height/2.0);
    }

    /**
     * Create a filled rectangle centered on (0, 0)
     * @param dimensions 2D point containing the width and height of the rectangle
     */
    public Rectangle(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    /**
     * Create a rectangle from a given collection of Points
     * @param coords The collection of 2D points
     */
    private Rectangle(Collection<Point2d> coords) { super(coords); }

    /**
     * @return Deep copy of the rectangle
     */
    @Override
    public Rectangle clone() {
        return new Rectangle(getCoords());
    }
}