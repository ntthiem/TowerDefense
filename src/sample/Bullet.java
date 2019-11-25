package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class Bullet extends GameTile {
    public Bullet(double posX, double posY) {
        super(posX, posY);
    }

    public void action(GraphicsContext gc, double x, double y) {
        if((int) x% 5 == 0 && (int)y% 5 == 0) {
            gc.strokeLine(x, y, posX, posY);
        }

    }


}
