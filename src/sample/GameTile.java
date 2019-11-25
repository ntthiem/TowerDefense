package sample;

import javafx.scene.canvas.GraphicsContext;
public abstract class GameTile {

    public double posX, posY;

    public GameTile(){};

    public GameTile(double posX, double posY) {
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

}


