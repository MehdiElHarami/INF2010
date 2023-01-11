package Interface;

import Point.Point2d;

import java.util.Collection;

public class Transform implements Rotate, Translate{
    /**
     * Rotate all points of collections given in parameters
     * with the angle given
     * @param coords collections of Point2d
     * @param angle angle by which to rotate
     * @return rotated collection
     * */
    public Collection<Point2d> rotate(Collection<Point2d> coords, Double angle) {
        for (Point2d point : coords)
            point.rotate(angle);
        return coords;
    }

    /**
     * Translate all points of a collection by a given vector
     * @param coords Collection of Point2d
     * @param translateVector Vector of translation
     * @return translated coords
     * */
    public Collection<Point2d> translate(Collection<Point2d> coords, Point2d translateVector) {
        for (Point2d point : coords)
            point.translate(translateVector);
        return coords;
    }
}
