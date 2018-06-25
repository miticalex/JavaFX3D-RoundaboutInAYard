/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundaboutinayard;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import objects.Chair;
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
    
    private static final double POINT_LIGHT_HEIGHT = -100; 
    private static final Color POINT_LIGHT_COLOR = Color.WHITE;
    
    private Group root = new Group();
    private PerspectiveCamera perspectiveCamera;
    private PointLight pointLight;
    
    private Turntable turntable;

    private PerspectiveCamera makePerspectiveCamera(){
        PerspectiveCamera camera = new PerspectiveCamera(true);
        
        camera.setFarClip(1000.0);
        Translate translate = new Translate(0, 0, -800.0);
        Rotate rotate = new Rotate(-30.0, Rotate.X_AXIS);
        camera.getTransforms().addAll(rotate,translate);
        
        return camera;
    }
    
    private PointLight makePointLight(Color color, double positionX, double positionY, double positionZ){
        PointLight pointLight = new PointLight();
        
        pointLight.setTranslateX(positionX);
        pointLight.setTranslateY(positionY);
        pointLight.setTranslateZ(positionZ);
        pointLight.setColor(Color.WHITE);
        
        return pointLight;
    }
    
    private Turntable makeTurntableWithChairs(int numChairs) {
        Turntable turntable = new Turntable(TURNTABLE_R, TURNTABLE_H);
        turntable.setMaterial(new PhongMaterial(TURNTABLE_COLOR));
        turntable.setInfiniteRotation(TURNTABLE_ROTATION_PERIOD, SpecificTransitions.COUNTERCLOCKWISE_ROTATION);
        
        Chair[] chairs = new Chair[numChairs];
        
        for (int i = 0; i < numChairs; i++) {
            chairs[i] = new Chair();
            
            chairs[i].setTranslateY(-(TURNTABLE_H/2 + Chair.CHAIR_STAND_HEIGHT/2));
            chairs[i].setTranslateX(0.75 * TURNTABLE_R * Math.cos(i * 2*Math.PI/numChairs));
            chairs[i].setTranslateZ(0.75 * TURNTABLE_R * Math.sin(i * 2*Math.PI/numChairs));
            
            chairs[i].setRotationAxis(Rotate.Y_AXIS);
            chairs[i].setRotate(-(i*SpecificTransitions.FULL_ROTATION / numChairs - 90));
            
//            Translate translate1 = new Translate(0, -(TURNTABLE_H/2 + Chair.CHAIR_STAND_HEIGHT/2), 0);
//            Rotate rotate2 = new Rotate(i*SpecificTransitions.FULL_ROTATION / numChairs, Rotate.Y_AXIS);
//            Translate translate3 = new Translate(0, 0, 0.75 * TURNTABLE_R);
//            chairs[i].getTransforms().setAll(translate1, rotate2, translate3);

            chairs[i].setInfiniteRotation(Chair.CHAIR_STAND_ROTATION_PERIOD, SpecificTransitions.CLOCKWISE_ROTATION);
        }
        turntable.getChildren().addAll(chairs);
        
        return turntable;
    }
    
    @Override
    public void start(Stage primaryStage) {
        perspectiveCamera = makePerspectiveCamera();
        turntable = makeTurntableWithChairs(4);
        pointLight = makePointLight(POINT_LIGHT_COLOR, 0, POINT_LIGHT_HEIGHT, 0);
        
        root.getChildren().addAll(turntable, pointLight);
        
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, true, SceneAntialiasing.BALANCED);
        scene.setCamera(perspectiveCamera);
        
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
