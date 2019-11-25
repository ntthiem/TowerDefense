package sample.Enemy;

import javafx.scene.image.Image;

public class NormalEnemy extends Enemy {
    public NormalEnemy(double posX, double posY) {
        super(posX, posY);
        image = new Image("file:image/Enemy1.png");
    }
}
