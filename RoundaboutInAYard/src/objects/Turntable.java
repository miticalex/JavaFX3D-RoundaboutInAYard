package objects;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import wrappers.SpecificTransitions;

/**
 *
 * @author AM
 */
public class Turntable extends Group{
    private Cylinder podium;
    private RotateTransition rotation = new RotateTransition();

    public Cylinder getPodium() {
        return podium;
    }
    
    public RotateTransition getRotation() {
        return rotation;
    }

    public void setInfiniteRotate(double rotationPeriod, int rotationDirection) {
        rotation = SpecificTransitions.infiniteRotateTransition(rotationPeriod, rotationDirection, Rotate.Y_AXIS, podium);
        rotation.play();
    }
    
    public Turntable(double radius, double height){
        podium = new Cylinder(radius, height, 100);
    }
}
