package sample.Enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.Bullet;
import sample.GameEntity;
import sample.GameTile;
//import sample.GameStage;
//import sample.Point;

public class Enemy extends GameTile implements GameEntity {
    public int health = 200, status = 1;
    public int speed;
    public int armor;
    public int reward;
    public Image image;

    public Enemy(double posX, double posY) {
        super(posX, posY);
        this.health = 200;
        this.speed = 1;
        this.armor = 100;
        this.reward = 100;
        this.status = 1;
        this.image = new Image("file:image/Enemy1");
    }

    public int getStatus() {
        return status;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth() {
        this.health--;
    }


    public boolean collision(double x, double y, GraphicsContext gc) {
        if (Math.sqrt((x - posX) * (x - posX) + (y - posY) * (y - posY)) < 300) {
            Bullet B20 = new Bullet(x + 45, y + 25);
            B20.action(gc, posX + 30, posY + 40);
            return true;
        } else return false;
    }

    public void setPos() {
        if (status == 1) {
            this.posX += this.speed;
            if (posX >= 300) status = 2;
        } else if (status == 2) {
            this.posY -= this.speed;
            if (posY <= 100) status = 3;
        } else if (status == 3) {
            this.posX += this.speed;
            if (posX >= 720) status = 4;
        } else if (status == 4) {
            this.posY += this.speed;
            if (posY > 530) status = 5;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(image, posX, posY);

        //vẽ máu
        gc.strokeRect(posX + 10, posY - 10, 50, 5);
        int x = (200 - health) / 2;
        gc.setFill(Color.RED);
        gc.fillRect(posX + 10, posY - 10, 50, 5);
        gc.setFill(Color.BLUE);
        if (x > 50) x = 50;
        gc.fillRect(posX + 50 - x + 10, posY - 10, x, 5);
    }
}
