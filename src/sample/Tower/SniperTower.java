package sample.Tower;

import javafx.scene.image.Image;

public class SniperTower extends Tower{
    public SniperTower(double posX, double posY) {
        super(posX, posY);
        image = new Image("file:image/Tower02.png");
    }
}
