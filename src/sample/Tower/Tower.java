package sample.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameEntity;
import sample.GameTile;

public class Tower extends GameTile implements GameEntity {
    private double posX, posY, speed, range, damage;
    public Image image;


    public Tower(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    //getter

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    //setter

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public void draw( GraphicsContext gc){
        gc.drawImage(image, posX, posY);
    }

}
