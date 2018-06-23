package objects;

import javafx.animation.RotateTransition;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;

/**
 *
 * @author AM
 */
public class Turntable extends Cylinder{
    private PhongMaterial material = new PhongMaterial();
    private RotateTransition rotation = new RotateTransition();

    public RotateTransition getRotation() {
        return rotation;
    }

    public void setRotation(RotateTransition rotation) {
        this.rotation = rotation;
    }
    
    public void setRotation(double rotationPeriod, double rotationDirection) {
        this.rotation = rotation;
    }
    
    public Turntable(double radius, double height, 
            double rotationPeriod, double rotationDirection){
        Cylinder p = new Cylinder(radius, height, 100);
    }
}
