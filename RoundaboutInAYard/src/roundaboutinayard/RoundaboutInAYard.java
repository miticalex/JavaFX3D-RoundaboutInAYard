/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundaboutinayard;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.image.Image;
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
    
    private Group root = new Group();
    private PerspectiveCamera perspectiveCamera;
    
    private Turntable turntable;

    private PerspectiveCamera makePerspectiveCamera(){
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setFarClip(1000.0);
        Translate translate = new Translate(0, 0, -800.0);
        Rotate rotate = new Rotate(-30.0, Rotate.X_AXIS);
        camera.getTransforms().addAll(rotate,translate);
        
        return camera;
    }
    
//    private Turntable makeTurntableWithChairs(int numChairs) {
//        Turntable turntable = new Turntable(TURNTABLE_R, TURNTABLE_H);
//        turntable.setInfiniteRotation(TURNTABLE_ROTATION_PERIOD, SpecificTransitions.POSITIVE_ROTATION);
//        
//        Chair[] chairs = new Chair[numChairs];
//        
//        for (int i = 0; i < numChairs; i++) {
//            chairs[i] = new Chair();
//            turntable.getChildren().add(chairs[i]);
//            
//            chairs[i].setTranslateY(TURNTABLE_R/2 + Chair.CHAIR_STAND_HEIGHT/2);
//            chairs[i].setRotationAxis(Rotate.Y_AXIS);
//            chairs[i].setRotate(i*SpecificTransitions.FULL_ROTATION / numChairs);
//            chairs[i].setTranslateX(0.75 * TURNTABLE_R);
//            
//            chairs[i].setInfiniteRotation(Chair.CHAIR_STAND_ROTATION_PERIOD, SpecificTransitions.CLOCKWISE_ROTATION);
//        }
//        
////        Image image = new Image("metal.jpg");
////        
////        PhongMaterial material = new PhongMaterial();
////        material.setDiffuseMap(image);
////        turntable.setMaterial(material);
//        
//        root.getChildren().add(turntable);
//        
//        return turntable;
//    }
    
    private void addChair(){
        Chair chair = new Chair();
        chair.setInfiniteRotation(Chair.CHAIR_STAND_ROTATION_PERIOD, SpecificTransitions.POSITIVE_ROTATION);
        root.getChildren().add(chair);
    }
    
    @Override
    public void start(Stage primaryStage) {
        perspectiveCamera = makePerspectiveCamera();
//        turntable = makeTurntableWithChairs(4);
        addChair();

        
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
