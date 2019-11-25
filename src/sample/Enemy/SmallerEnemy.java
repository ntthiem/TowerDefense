package sample.Enemy;

import javafx.scene.image.Image;

public class SmallerEnemy extends Enemy{
    public SmallerEnemy(double posX, double posY) {
        super(posX, posY);
        this.health = 100;
        this.speed = 2;
        image = new Image("file:image/Enemy2.png");

    }
}
