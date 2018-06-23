package wrappers;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.shape.Shape3D;
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
    
    public static final int POSITIVE_ROTATION = 1;
    public static final int NEGATIVE_ROTATION = -1;
    public static final int COUNTERCLOCKWISE_ROTATION = 1;
    public static final int CLOCKWISE_ROTATION = - 1;
    
    public static final RotateTransition infiniteRotateTransition(Duration period, int direction, Point3D axis, Shape3D object){
        RotateTransition rotation = new RotateTransition(period, object);
        rotation.setAxis(axis);
        rotation.setFromAngle(ZERO);
        rotation.setByAngle(direction<0 ? -FULL_ANGLE : FULL_ANGLE);
        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.setCycleCount(Animation.INDEFINITE);
        
        return rotation;
    }
    
    public static final RotateTransition infiniteRotateTransition(double period, int direction, Point3D axis, Shape3D object){
        return infiniteRotateTransition(Duration.seconds(period), direction, axis, object);
    }
}