/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundaboutinayard;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.stage.Stage;
import objects.Turntable;
import wrappers.SpecificTransitions;

/**
 *
 * @author AM
 */
public class RoundaboutInAYard extends Application {
    private static final double WINDOW_WIDTH = 1200;
    private static final double WINDOW_HEIGHT = 700;
    
    private static final double TURNTABLE_R = 200;
    private static final double TURNTABLE_H = 20;
    private static final double TURNTABLE_ROTATION_PERIOD = 10;
    private static final Color TURNTABLE_COLOR = Color.TURQUOISE;
    
    private static final double CHAIR_WIDTH = 40; 
    private static final double CHAIR_HEIGHT = 20;
    private static final Color CHAIR_COLOR = Color.ORANGE;
    
    private static final double CHAIR_STAND_R = 40;
    private static final double CHAIR_STAND_H = 10;
    private static final double CHAIR_STAND_ROTATION_PERIOD = 3;
    
    private static final double CHAIR_REST_HEIGHT = 20; 
    private static final double CHAIR_REST_THICKNESS = 10;
    
    private static final double POINT_LIGHT_HEIGHT = -100; 
    
    Group root = new Group();
    Turntable turntable;

    private void addTurntable() {
        turntable = new Turntable(TURNTABLE_R, TURNTABLE_H);
        turntable.setInfiniteRotate(TURNTABLE_ROTATION_PERIOD, SpecificTransitions.POSITIVE_ROTATION);
        
        Image image = new Image("metal.jpg");
        
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(image);
        
        root.getChildren().add(turntable);
    }
    
    @Override
    public void start(Stage primaryStage) {
        addTurntable();
        
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        
        primaryStage.setTitle("Roundabout In The Yard!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
