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
public class Turntable extends RotatingGroup{
    private Cylinder podium;
    public Cylinder getPodium() {
        return podium;
    }
    
    public Turntable(double radius, double height){
        podium = new Cylinder(radius, height, 100);
    }
}
