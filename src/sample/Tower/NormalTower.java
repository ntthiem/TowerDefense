package sample.Tower;

import javafx.scene.image.Image;

public class NormalTower extends Tower {

    public NormalTower(double posX, double posY) {
        super(posX, posY);
        image = new Image("file:image/Tower01.png");
    }
}
