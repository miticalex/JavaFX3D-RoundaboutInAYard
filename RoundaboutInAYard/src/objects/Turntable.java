package objects;

import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;

/**
 *
 * @author AM
 */
public class Turntable extends RotatingGroup{
    private Cylinder podium;
    public Cylinder getPodium() {
        return podium;
    }
    
    public void setMaterial(PhongMaterial material) { podium.setMaterial(material); }
    
    public Turntable(double radius, double height){
        podium = new Cylinder(radius, height, 100);
        this.getChildren().add(podium);
    }
}
