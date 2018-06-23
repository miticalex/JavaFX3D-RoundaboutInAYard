package objects;

import javafx.animation.RotateTransition;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import wrappers.SpecificTransitions;

/**
 *
 * @author AM
 */
public class Turntable extends Cylinder{
    private RotateTransition rotation = new RotateTransition();

    public RotateTransition getRotation() {
        return rotation;
    }

    public void setRotation(double rotationPeriod, int rotationDirection) {
        rotation = SpecificTransitions.infiniteRotateTransition(rotationPeriod, rotationDirection, Rotate.Y_AXIS, this);
        rotation.play();
    }
    
    public Turntable(double radius, double height){
        super(radius, height, 100);
    }
}
