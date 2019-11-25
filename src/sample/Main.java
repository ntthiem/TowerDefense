package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.Enemy.*;
import sample.Tower.MachineGunTower;
import sample.Tower.NormalTower;
import sample.Tower.SniperTower;
import sample.Tower.Tower;

import java.util.ArrayList;
import java.util.Objects;


public class Main extends Application {

    private int ENEMY_SIZE = 7, ENEMY_START_X = 0, ENEMY_START_Y = 450,
            POS_DELAY =150, TIME_DELAY_START = 500, STATUS = 1, LEVER = 1;
    private int inp_tower = 0, n = 0,money = 10000, m = 6;
    private double mouseX = -1, mouseY = -1, lobby = 0, startX, startY, endX, endY;

    ArrayList<Tower> towers = new ArrayList<Tower>();
    ArrayList<Enemy> enemys = new ArrayList<Enemy>();




    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage theStage) throws Exception {


        theStage.setTitle(" TOWERDEFEN ");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(1200, 600);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();



        if(LEVER == 1){
        for (int i = 0; i < ENEMY_SIZE; i++)
            enemys.add(new NormalEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
        } else if(LEVER ==2){
            for (int i = 0; i < ENEMY_SIZE; i++)
                enemys.add(new SmallerEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
        } else if(LEVER ==3){
            for (int i = 0; i < ENEMY_SIZE; i++)
                enemys.add(new TankerEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
        } else if(LEVER ==4){
            for (int i = 0; i < ENEMY_SIZE; i++)
                enemys.add(new BossEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
        }else if(LEVER ==5){
            for (int i = 0; i < 2; i++)
                enemys.add(new SmallerEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
            for (int i = 0; i < 3; i++)
                enemys.add(new TankerEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
            for (int i = 0; i < 3; i++)
                enemys.add(new NormalEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
            for (int i = 0; i < 1; i++)
                enemys.add(new BossEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
        }


        Image start = new Image( "file:image/start.png" );
        Image background = new Image("file:image/Back.png");
        Image start01 = new Image("file:image/start01.png");
        Image start02 = new Image("file:image/start02.png");
        Image nen = new Image( "file:image/16.png" );
        Image end1 = new Image( "file:image/end1.png" );
        Image end2 = new Image( "file:image/end2.png" );



        gc.drawImage(start, 0, 0);

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (STATUS == 1) {
                    canvas.setOnMouseMoved( //di chuyển chuột
                            new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent m) {
                                    if (m.getX() > 460 && m.getX() < 724) {
                                        if (m.getY() > 360 && m.getY() < 426) {
                                            gc.drawImage(start01, 0, 0);
                                        } else if (m.getY() > 452 && m.getY() < 518) {
                                            gc.drawImage(start02, 0, 0);
                                        } else {
                                            gc.drawImage(start, 0, 0);
                                        }
                                    } else {
                                        gc.drawImage(start, 0, 0);
                                    }
                                }
                            }
                    );
                    canvas.setOnMouseClicked(
                            new EventHandler<MouseEvent>() {
                                public void handle(MouseEvent c) {
                                    if (c.getX() > 460 && c.getX() < 724) {
                                        if (c.getY() > 360 && c.getY() < 426) {
                                            gc.drawImage(start01, 0, 0);
                                            STATUS = 2;
                                        } else if (c.getY() > 452 && c.getY() < 518) {
                                            gc.drawImage(start02, 0, 0);
                                            STATUS = 4;
                                        } else {
                                            gc.drawImage(start, 0, 0);
                                        }
                                    } else {
                                        gc.drawImage(start, 0, 0);
                                    }
                                }
                            });

                } else if (STATUS == 2) {


                    gc.drawImage(background, 0, 0);

                    canvas.setOnMouseMoved(
                            new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    if (inp_tower != 0 && mouseEvent.getX() <= 950) {
                                        mouseX = mouseEvent.getX();
                                        mouseY = mouseEvent.getY();
                                    } else {
                                        mouseX = -1;
                                        mouseY = -1;
                                    }
                                }
                            }
                    );
                    canvas.setOnMouseClicked(
                            new EventHandler<MouseEvent>() {
                                public void handle(MouseEvent e) {

                                    if (e.getX() > 950 && e.getX() < 1020 && e.getY() > 65 && e.getY() < 130 &&
                                            money >= 1000) {
                                        inp_tower = 1;
                                    }else if(e.getX() > 1020 && e.getX() < 1100 && e.getY() > 30 && e.getY() < 130 &&
                                            money >= 1000){
                                        inp_tower = 2;
                                    }
                                    else if(e.getX() > 1100 && e.getX() < 1180 && e.getY() > 25 && e.getY() < 130 &&
                                            money >= 1000){
                                        inp_tower = 3;

                                    }
                                    else if (e.getX() < 950 && inp_tower > 0 && money >= 1000) {
                                        if (inp_tower == 1) {
                                            towers.add(new NormalTower(e.getX() - 35, e.getY() - 25));
                                            money -= 1000;
                                        } else if (inp_tower == 2) {
                                            towers.add(new SniperTower(e.getX() - 45, e.getY() - 40));
                                            money -= 2000;
                                        } else if (inp_tower == 3){
                                            towers.add(new MachineGunTower(e.getX() - 55, e.getY() - 55));
                                            money -= 4000;
                                        }
                                        inp_tower = 0;
                                    }
                                    else if(e.getX() > 970 && e.getX() < 1170 && e.getY() > 400 && e.getY() < 440 && LEVER < 5){
                                        LEVER += 1;
                                        STATUS = 5;
                                    }


                                }
                            });

                    for (int i = 0; i < towers.size(); i++) {
                        towers.get(i).draw(gc);

                    }

                    Font theFont1 = Font.font("Times New Roman", 30);
                    gc.setFont(theFont1);
                    gc.drawImage(nen, 970, 200, 200, 40);
                    gc.fillText("Lever " + LEVER, 1000, 235);
                    gc.strokeText("Lever " + LEVER, 1000, 235);

                    gc.drawImage(nen, 970, 300, 200, 40);
                    gc.fillText("Money :  " + money/ 20, 975, 330);

                    gc.drawImage(nen, 970, 400, 200, 40);
                    gc.fillText("NEXT LEVER", 980, 435);
                    gc.strokeText("NEXT LEVER " , 980, 435);


                    if (mouseX != -1) {

                        if (inp_tower == 1) {
                            Tower move_tower = new NormalTower(mouseX -35, mouseY -25);
                            move_tower.draw(gc);
                        } else if (inp_tower == 2) {
                            Tower move_tower = new SniperTower(mouseX -45, mouseY -40);
                            move_tower.draw(gc);
                        } else if (inp_tower == 3){
                            Tower move_tower = new MachineGunTower(mouseX -55, mouseY -55);
                            move_tower.draw(gc);
                        }

                    }


                    if(!enemys.isEmpty()) {

                        for (int i = 0; i < enemys.size(); i++) {
                            enemys.get(i).setPos();
                            if (enemys.get(i).getPosX() > ENEMY_START_X && enemys.get(i).getStatus() <5) {
                                enemys.get(i).draw(gc);
                            }
                        }

                        for (int i = 0; i < towers.size(); i++) {
                            for (int j = 0; j < enemys.size(); j++) {
                                if (!enemys.isEmpty()&&
                                        enemys.get(j).getPosX() > ENEMY_START_X
                                        && enemys.get(j).collision(towers.get(i).getPosX(), towers.get(i).getPosY(), gc)) {
                                    money += 3;
                                    enemys.get(j).setHealth();
                                    if (enemys.get(j).getHealth() < 0 && !enemys.isEmpty())
                                        enemys.remove(j);
                                    break;
                                }

                            }
                            if (enemys.isEmpty()) {STATUS =3;break;}
                        }

                    }


                    if (enemys.get(enemys.size()-1).getStatus() >4 || LEVER == 6) STATUS = 3;
                    if(enemys.isEmpty()) STATUS =5;




                }
                if (STATUS == 3) {


                    canvas.setOnMouseMoved(
                            new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    if (mouseEvent.getY() < 250) {
                                        gc.drawImage(end1, 0, 0);
                                    } else {
                                        gc.drawImage(end2, 0, 0);
                                    }
                                }
                            }
                    );
                    canvas.setOnMouseClicked(
                            new EventHandler<MouseEvent>() {
                                public void handle(MouseEvent e) {
                                    if (e.getY() > 250) {
                                        STATUS = 1;
                                        for (int i = 0; i < ENEMY_SIZE; i++) {
                                            enemys.add(new NormalEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
                                        }
                                        while (!towers.isEmpty()) towers.remove(0);
                                    }
                                }
                            });

                }
                if( STATUS == 5){
                    for (int i = 0; i < enemys.size(); i++)
                        enemys.remove(0);
                    for (int i = 0; i <towers.size(); i++)
                        towers.remove(0);
                    gc.drawImage(background,0,0);
                    if(LEVER == 1){
                        for (int i = 0; i < ENEMY_SIZE; i++)
                            enemys.add(new NormalEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
                    } else if(LEVER ==2){
                        for (int i = 0; i < ENEMY_SIZE; i++)
                            enemys.add(new SmallerEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
                    } else if(LEVER ==3){
                        for (int i = 0; i < ENEMY_SIZE; i++)
                            enemys.add(new TankerEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
                    } else if(LEVER ==4){
                        for (int i = 0; i < ENEMY_SIZE; i++)
                            enemys.add(new BossEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
                    }else if(LEVER ==5){
                        for (int i = 0; i < 2; i++)
                            enemys.add(new SmallerEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
                        for (int i = 0; i < 3; i++)
                            enemys.add(new TankerEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
                        for (int i = 0; i < 3; i++)
                            enemys.add(new NormalEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
                        for (int i = 0; i < 1; i++)
                            enemys.add(new BossEnemy(ENEMY_START_X - i * POS_DELAY  - 130, ENEMY_START_Y - 65));
                    }
                    STATUS = 2;

                }


            }
        }.start();
        theStage.show();
    }
}





