package Shape;

import Point.Point2d;

import java.util.Collection;

public class Ellipse extends BaseShape {
    /**
     * Create a filled Ellipse that is centered on (0, 0)
     * @param widthDiameter Width of the Ellipse
     * @param heightDiameter Height of the Ellipse
     */
    public Ellipse(Double widthDiameter, Double heightDiameter) {
        Point2d brush = new Point2d(-widthDiameter/2.0, -heightDiameter/2.0);
        do {
            do {
                if (Math.pow(brush.X(),2)/Math.pow(widthDiameter/2,2)+Math.pow(brush.Y(),2)/Math.pow(heightDiameter/2,2) <= 1)
                    this.add(brush);
            } while ( brush.translate(new Point2d(0.5, 0.0)).X() <= widthDiameter/2.0 );
        } while(brush.translate(new Point2d(-(widthDiameter+0.5), 0.5)).Y() <= heightDiameter/2.0);
    }

    /**
     * Create a filled Ellipse that is centered on (0,0)
     * @param dimensions 2D point containing the width and height of the Ellipse
     */
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    /**
     * Create an Ellipse from a given collection of 2D points
     * @param coords Collection of 2D points
     */
    private Ellipse(Collection<Point2d> coords) { super(coords); }

    /**
     * @return Deep Copy of the Ellipse
     */
    @Override
    public Ellipse clone() {
        return new Ellipse(getCoords());
    }
}