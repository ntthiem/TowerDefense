package sample.Enemy;

import javafx.scene.image.Image;

public class BossEnemy extends Enemy{
    public BossEnemy(double posX, double posY) {
        super(posX, posY);
        this.health = 300;
        this.armor = 200;

        image = new Image("file:image/Enemy4.png");

    }
}
