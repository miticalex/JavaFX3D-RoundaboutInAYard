package wrappers;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author AM
 */
public abstract class SpecificTransitions {
    public static final double ZERO = 0;
    public static final double FULL_ANGLE = 360;
    public static final double FULL_ROTATION = FULL_ANGLE;
    public static final double COMPLETE_ANGLE = FULL_ANGLE;
    public static final double COMPLETE_ROTATION = FULL_ANGLE;
    
    public static final RotateTransition infiniteRotateTransition(Duration period, int direction, Point3D axis, Group object){
        RotateTransition rotation = new RotateTransition(period, object);
        rotation.setAxis(axis);
        rotation.setFromAngle(ZERO);
        rotation.setByAngle(direction<0 ? -FULL_ANGLE : FULL_ANGLE);
        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.setCycleCount(Animation.INDEFINITE);
        
        return rotation;
    }
    
    public static final RotateTransition infiniteRotateTransition(double period, int direction, Point3D axis, Group object){
        return infiniteRotateTransition(Duration.seconds(period), direction, axis, object);
    }
}