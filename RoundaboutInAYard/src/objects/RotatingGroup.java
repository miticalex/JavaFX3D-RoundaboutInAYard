package objects;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import wrappers.SpecificTransitions;

/**
 *
 * @author AM
 */
public class RotatingGroup extends Group{
    private RotateTransition rotation = new RotateTransition();
    
    public RotateTransition getInfiniteRotation() {
        return rotation;
    }

    public void setInfiniteRotation(double rotationPeriod, int rotationDirection) {
        rotation = SpecificTransitions.infiniteRotateTransition(rotationPeriod, rotationDirection, Rotate.Y_AXIS, this);
        rotation.play();
    }
    
    public RotatingGroup(){
        super();
    }
}
