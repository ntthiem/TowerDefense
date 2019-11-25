package sample.Enemy;

import javafx.scene.image.Image;

public class TankerEnemy extends Enemy {
    public TankerEnemy(double posX, double posY) {
        super(posX, posY);
        this.health = 200;
        this.armor = 200;
        image = new Image("file:image/Enemy3.png");
    }
}
