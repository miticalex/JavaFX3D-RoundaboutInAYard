/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundaboutinayard;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author AM
 */
public class RoundaboutInAYard extends Application {
    private static final double WINDOW_WIDTH = 1200;
    private static final double WINDOW_HEIGHT = 700;
    
    private static final double POSITIVE_ROTATION = 1;
    private static final double NEGATIVE_ROTATION = -1;
    
    private static final double TURNTABLE_R = 200;
    private static final double TURNTABLE_H = 20;
    private static final double TURNTABLE_PERIOD = 10;
    private static final Color TURNTABLE_COLOR = Color.TURQUOISE;
    
    private static final double CHAIR_WIDTH = 40; 
    private static final double CHAIR_HEIGHT = 20;
    private static final Color CHAIR_COLOR = Color.ORANGE;
    
    private static final double CHAIR_STAND_R = 40;
    private static final double CHAIR_STAND_H = 10;
    private static final double CHAIR_STAND_PERIOD = 3;
    
    private static final double CHAIR_REST_HEIGHT = 20; 
    private static final double CHAIR_REST_THICKNESS = 10;
    
    private static final double POINT_LIGHT_HEIGHT = -100; 
    
    Group root = new Group();

    private void addTurntable() {
        
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
