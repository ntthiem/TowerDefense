package sample.Tower;

import javafx.scene.image.Image;

public class MachineGunTower extends Tower{
    public MachineGunTower(double posX, double posY) {
        super(posX, posY);
        image = new Image("file:image/Tower03.png");
    }
}
