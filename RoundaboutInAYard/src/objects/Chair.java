package objects;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.util.Duration;
import wrappers.SpecificTransitions;
import static wrappers.SpecificTransitions.FULL_ANGLE;
import static wrappers.SpecificTransitions.ZERO;

/**
 *
 * @author AM
 */
public class Chair extends RotatingGroup{
    public static final double CHAIR_WIDTH = 40; 
    public static final double CHAIR_SEATING_HEIGHT = 20;
    public static final Color CHAIR_COLOR = Color.ORANGE;
    
    public static final double CHAIR_STAND_RADIUS=  40;
    public static final double CHAIR_STAND_HEIGHT = 10;
    public static final double CHAIR_STAND_ROTATION_PERIOD = 3;
    
    public static final double CHAIR_REST_HEIGHT = 20; 
    public static final double CHAIR_REST_THICKNESS = 10;

    private Cylinder chairStand;
    private Box chairSeating;
    
    public Cylinder getChairStand() {
        return chairStand;
    }
    public void setChairStand(Cylinder chairStand) {
        this.chairStand = chairStand;
    }

    public Box getChairSeating() {
        return chairSeating;
    }
    public void setChairSeating(Box chairSeating) {
        this.chairSeating = chairSeating;
    }

    public Box getChairRest() {
        return chairRest;
    }
    public void setChairRest(Box chairRest) {
        this.chairRest = chairRest;
    }
    private Box chairRest;
    
    public Chair(){
        super();
        
        PhongMaterial chairMaterial = new PhongMaterial(CHAIR_COLOR);
        
        chairStand = new Cylinder(CHAIR_STAND_RADIUS, CHAIR_STAND_HEIGHT, 100);
        chairStand.setMaterial(chairMaterial);
        
        chairSeating = new Box(CHAIR_WIDTH, CHAIR_SEATING_HEIGHT, CHAIR_WIDTH);
        chairSeating.setTranslateY(-(CHAIR_STAND_HEIGHT/2 + CHAIR_SEATING_HEIGHT/2));
        chairSeating.setMaterial(chairMaterial);
        
        chairRest = new Box(CHAIR_WIDTH, CHAIR_REST_HEIGHT, CHAIR_REST_THICKNESS);
        chairRest.setTranslateY(-(CHAIR_STAND_HEIGHT/2 + CHAIR_SEATING_HEIGHT
                + CHAIR_REST_HEIGHT/2));
        chairRest.setTranslateZ(CHAIR_WIDTH/2 - CHAIR_REST_THICKNESS/2);
        chairRest.setMaterial(chairMaterial);
        
        this.getChildren().addAll(chairStand, chairSeating, chairRest);
    }
}
