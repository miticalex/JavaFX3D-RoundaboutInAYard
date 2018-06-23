package objects;

import javafx.animation.RotateTransition;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;

/**
 *
 * @author AM
 */
public class Turntable extends Cylinder{
    private double rotationPeriod = 10;
    private double rotationDirection = 1;
    
    private PhongMaterial material = new PhongMaterial();
    private RotateTransition rotation = new RotateTransition();
    
    public Turntable(double radius, double height){
        Cylinder p = new Cylinder(radius, height, 100);
    }
}
