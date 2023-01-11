package Letter;

import Point.Point2d;
import Shape.*;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;


    /**
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {
        Rectangle base = new Rectangle(halfMaxWidth, halfStripeThickness);
        Rectangle diagonal = new Rectangle(halfStripeThickness, maxHeight);
        diagonal.rotate(diagonal.getCoords(), -3*Math.PI/64);
        diagonal.translate(diagonal.getCoords(), new Point2d(halfMaxWidth/2, 0.0));
        base.add(diagonal);
        diagonal.rotate(diagonal.getCoords(), 3*Math.PI/32);
        diagonal.translate(diagonal.getCoords(), new Point2d(-halfMaxWidth, 0.0));
        return base.add(diagonal);
    }

    /**
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        Rectangle stripe = new Rectangle(maxWidth/3, maxHeight);
        stripe.translate(stripe.getCoords(),new Point2d(-maxWidth/3.0,0.0));
        Circle circle = new Circle(halfMaxWidth+halfStripeThickness);
        circle.remove(new Circle(halfMaxWidth));
        circle.translate(circle.getCoords(), new Point2d(halfStripeThickness, maxHeight/4));
        stripe.add(circle);
        circle.translate(circle.getCoords(), new Point2d(0.0, -maxHeight/2));
        return stripe.add(circle);
    }

    /**
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        Ellipse base = new Ellipse(maxWidth, maxHeight);
        base.remove(new Ellipse(maxWidth-stripeThickness, maxHeight-stripeThickness));
        Rectangle hole = new Rectangle(maxWidth, maxHeight-2*stripeThickness);
        hole.translate(hole.getCoords(), new Point2d(halfMaxWidth, 0.0));
        return base.remove(hole);
    }

    /**
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        Rectangle base = new Rectangle(maxWidth,maxHeight);
        Square hole = new Square(maxWidth);
        hole.translate(hole.getCoords(), new Point2d(halfStripeThickness, halfMaxHeight/2));
        base.remove(hole);
        hole.translate(hole.getCoords(), new Point2d(0.0, -halfMaxHeight));
        return base.remove(hole);
    }

    /**
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        Rectangle base = new Rectangle(maxWidth+halfMaxWidth,maxHeight);
        Rectangle hole = new Rectangle(maxWidth, halfMaxHeight);
        hole.translate(hole.getCoords(), new Point2d(0.0, halfMaxHeight/2 + halfStripeThickness));
        base.remove(hole);
        hole.translate(hole.getCoords(), new Point2d(0.0, -halfMaxHeight - stripeThickness));
        return base.remove(hole);
    }

    /**
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        Rectangle stripes = new Rectangle(maxWidth, maxHeight);
        stripes.remove(new Rectangle(maxWidth-stripeThickness,maxHeight));
        Rectangle diagonal = new Rectangle(halfStripeThickness, maxHeight);
        diagonal.rotate(diagonal.getCoords(), -3*Math.PI/32);
        return stripes.add(diagonal);
    }

    /** 
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        return new Ellipse(maxWidth, maxHeight).remove(new Ellipse(maxWidth-stripeThickness, maxHeight-stripeThickness));
    }

}
