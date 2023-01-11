package Shape;

public class Circle extends Ellipse {
    /**
     * Create a filled circle that is centered on (0, 0)
     * @param radius Radius of the Circle
     */
    public Circle(Double radius) {
        super(radius*2, radius*2);
    }
}