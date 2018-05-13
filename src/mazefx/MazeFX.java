/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazefx;

import Controller.CellFactory;
import Controller.Database;
import Controller.Interactions;
import MazeModel.*;
import MazeModel.Runner;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author MaramH
 */
public class MazeFX extends Application {

    CellFactory f = new CellFactory();
    Database d = new Database();
    int initmatrix[][] = d.readInit();
    int currentMatrix[][] = initmatrix;
    Cell[][] maze = f.mazeFactory(initmatrix);

    Timer timer = new Timer();
    int seconds = 0;
    //SimpleStringProperty sec = new SimpleStringProperty(String.valueOf(seconds));
    String text;
     
     TextField notification = new TextField ();
     
  
   
    //long endTime = 

    public MazeFX() {
    }
    /*
        DateFormat timeFormat= new SimpleDateFormat("HH:mm:ss"); 
        final Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(500),
                        event -> {
                            final long diff= endTime - System.currentTimeMillis();
                            if (diff<0)
                            { timeLabel.setText(timeFormat.format(0));
                            }
                        }
                )
        )*/
    Interactions check = new Interactions();
    GridPane objectsPane = new GridPane();
    GridPane runnerPane = new GridPane();
    GridPane observerPane = new GridPane();
    Node current;
    Pane borderPane = new Pane();

    @Override
    public void start(Stage stage) throws Exception {
      
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        //runnerPane.set
        // ImageView view = new ImageView("file:/C:/Users/MaramH/Desktop/649675876.jpg");
        objectsPane.setStyle("-fx-background-color: green");
        runnerPane.setStyle("-fx-background-color: transparent");
        observerPane.setStyle("-fx-background-color: grey");

        initializeMaze();

       
        Label l = new Label("Lives");
        l.setStyle("-fx-background-color: white");
        ImageView img2 = new ImageView(new HealthGift().getImage());
        img2.setFitWidth(35);

        img2.setFitHeight(21);
        ImageView img3 = new ImageView(new HealthGift().getImage());
        img3.setFitWidth(35);

        img3.setFitHeight(21);
          ImageView img4 = new ImageView(new HealthGift().getImage());
        img4.setFitWidth(35);

        img4.setFitHeight(21);
        //runTimer();
      notification.setStyle("-fx-background-color: white");
      notification.setEditable(false);
      
        //observerPane.add(notification, 39, 1);
       // observerPane.add(img2, 39, 0);
        observerPane.add(img3, 38, 0);
         observerPane.add(img4 , 37, 0);
        observerPane.add(l, 26, 0);
        
        Scene scene = new Scene(borderPane);
        try {
            Image image = Runner.getPlayer().getImage();
            scene.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.UP) {
                    Runner.getPlayer().setDir("up");
                    if (Runner.getPlayer().row > 0) {

                        if (maze[Runner.getPlayer().row - 1][Runner.getPlayer().column].isWay()) {

                            Node temp = current;
                            runnerPane.getChildren().remove(current);

                            //       Image image1 = Runner.getPlayer().getImage();
                            ImageView img1 = new ImageView(image);
                            img1.setFitWidth(35);

                            img1.setFitHeight(21);

                            runnerPane.add(temp, Runner.getPlayer().column, Runner.getPlayer().row - 1);

                            Runner.getPlayer().row--;
                            if (check.checkBombs(maze[Runner.getPlayer().row][Runner.getPlayer().column])) {
                                currentMatrix[Runner.getPlayer().row][Runner.getPlayer().column] = 0;
                            }
                            if (check.checkGift(maze[Runner.getPlayer().row][Runner.getPlayer().column])) {
                                currentMatrix[Runner.getPlayer().row][Runner.getPlayer().column] = 0;
                            }
                            drawMaze();
                        }
                    }
                } else if (event.getCode() == KeyCode.DOWN) {
                    Runner.getPlayer().setDir("down");

                    if (maze[Runner.getPlayer().row + 1][Runner.getPlayer().column].isWay()) {

                        Node temp = current;
                        runnerPane.getChildren().remove(current);

                        Image image1 = Runner.getPlayer().getImage();
                        ImageView img1 = new ImageView(image);

                        img1.setFitWidth(35);
                        img1.setFitHeight(21);

                        runnerPane.add(temp, Runner.getPlayer().column, Runner.getPlayer().row + 1);

                        Runner.getPlayer().row++;
                        if (check.checkBombs(maze[Runner.getPlayer().row][Runner.getPlayer().column])) {
                            currentMatrix[Runner.getPlayer().row][Runner.getPlayer().column] = 0;
                        }
                        if (check.checkGift(maze[Runner.getPlayer().row][Runner.getPlayer().column])) {
                            currentMatrix[Runner.getPlayer().row][Runner.getPlayer().column] = 0;
                           
                                
                        }
                        drawMaze();
                        if (Runner.getPlayer().row == 29) {
                            new Alert(Alert.AlertType.INFORMATION, "GOAL!").showAndWait();
                        }
                        // runnerPane.getChildren().remove(maze[Runner.getPlayer().row-1] [Runner.getPlayer().column].getImage());

                    }
                } else if (event.getCode() == KeyCode.RIGHT) {
                    Runner.getPlayer().setDir("right");

                    if (maze[Runner.getPlayer().row][Runner.getPlayer().column + 1].isWay()) {
                        Node temp = current;
                        runnerPane.getChildren().remove(current);

                        Image image1 = Runner.getPlayer().getImage();
                        ImageView img1 = new ImageView(image);

                        img1.setFitWidth(35);
                        img1.setFitHeight(21);

                        runnerPane.add(temp, Runner.getPlayer().column + 1, Runner.getPlayer().row);

                        Runner.getPlayer().column++;
                        if (check.checkBombs(maze[Runner.getPlayer().row][Runner.getPlayer().column])) {
                            currentMatrix[Runner.getPlayer().row][Runner.getPlayer().column] = 0;
                        }
                        if (check.checkGift(maze[Runner.getPlayer().row][Runner.getPlayer().column])) {
                            currentMatrix[Runner.getPlayer().row][Runner.getPlayer().column] = 0;
                        }
                        drawMaze();
                    }

                } else if (event.getCode() == KeyCode.LEFT) {
                    Runner.getPlayer().setDir("left");

                    if (maze[Runner.getPlayer().row][Runner.getPlayer().column - 1].isWay()) {
                        Node temp = current;
                        runnerPane.getChildren().remove(current);

                        Image image1 = Runner.getPlayer().getImage();
                        ImageView img1 = new ImageView(image);

                        img1.setFitWidth(35);
                        img1.setFitHeight(21);

                        runnerPane.add(temp, Runner.getPlayer().column - 1, Runner.getPlayer().row);

                        Runner.getPlayer().column--;
                        if (check.checkBombs(maze[Runner.getPlayer().row][Runner.getPlayer().column])) {
                            currentMatrix[Runner.getPlayer().row][Runner.getPlayer().column] = 0;
                        }
                        if (check.checkGift(maze[Runner.getPlayer().row][Runner.getPlayer().column])) {
                            currentMatrix[Runner.getPlayer().row][Runner.getPlayer().column] = 0;
                        }
                        drawMaze();
                    }
                } else if (event.getCode() == KeyCode.SPACE) {
                    Bullet shot = new Bullet();
                    if(Runner.getPlayer().getW() != null)
                    {
                    
                    Node current2;
                    Image imageb = shot.getImage();
                    ImageView imgb = new ImageView(imageb);
                    imgb.setFitWidth(35);
                    imgb.setFitHeight(21);
                    current2 = imgb;
                    }
                    if (Runner.getPlayer().getW() != null)
                        Runner.getPlayer().getW().setAmmo(Runner.getPlayer().getW().getAmmo()-1);
                  
                   
                try{
                        if(Runner.getPlayer().getW().getAmmo()==0)
                            {
                                AmmoGift m =new AmmoGift(Runner.getPlayer());
                                m.destroy();
                            }
                }
                catch (java.lang.NullPointerException e)
                {
                    System.out.println("NotEnoughAmmo");
                }
                   
                      
                   
                   
                    if(Runner.getPlayer().getW() != null)
                    {
                    shot.column = Runner.getPlayer().column;
                    shot.row = Runner.getPlayer().row;

                    switch (Runner.getPlayer().getDir()) {
                        case "up":

                            while (maze[shot.row - 1][shot.column].isWay() && !maze[shot.row - 1][shot.column].isUseful() && !maze[shot.row - 1][shot.column].isHarmful()) {

                                currentMatrix[shot.row - 1][shot.column] = 8;
                                currentMatrix[shot.row][shot.column] = 0;
                                drawMaze();

                                shot.row--;

                            }

                            if (maze[shot.row - 1][shot.column].isDestructible()) {
                                currentMatrix[shot.row - 1][shot.column] = 0;
                                int s = Runner.getPlayer().getScore();
                                s += 200;
                                Runner.getPlayer().setScore(s);
                            }
                            drawMaze();

                            currentMatrix[shot.row][shot.column] = 0;

                            break;

                        case "down":

                            while (maze[shot.row + 1][shot.column].isWay() && !maze[shot.row + 1][shot.column].isUseful() && !maze[shot.row + 1][shot.column].isHarmful()) {

                                currentMatrix[shot.row + 1][shot.column] = 8;
                                currentMatrix[shot.row][shot.column] = 0;
                                drawMaze();

                                shot.row++;

                            }

                            if (maze[shot.row + 1][shot.column].isDestructible()) {
                                currentMatrix[shot.row + 1][shot.column] = 0;
                                int s = Runner.getPlayer().getScore();
                                s += 200;
                                Runner.getPlayer().setScore(s);
                            }
                            drawMaze();

                            currentMatrix[shot.row][shot.column] = 0;

                            break;
                        case "left":
                            while (maze[shot.row][shot.column - 1].isWay() && !maze[shot.row][shot.column - 1].isUseful() && !maze[shot.row][shot.column - 1].isHarmful()) {

                                currentMatrix[shot.row][shot.column - 1] = 8;
                                currentMatrix[shot.row][shot.column] = 0;
                                drawMaze();

                                shot.column--;

                            }

                            if (maze[shot.row][shot.column - 1].isDestructible()) {
                                currentMatrix[shot.row][shot.column - 1] = 0;
                                int s = Runner.getPlayer().getScore();
                                s += 200;
                                Runner.getPlayer().setScore(s);
                            }
                            drawMaze();
                            currentMatrix[shot.row][shot.column] = 0;
                            break;
                        case "right":
                            while (maze[shot.row][shot.column + 1].isWay() && !maze[shot.row][shot.column + 1].isUseful() && !maze[shot.row][shot.column + 1].isHarmful()) {
                                currentMatrix[shot.row][shot.column + 1] = 8;
                                currentMatrix[shot.row][shot.column] = 0;
                                drawMaze();
                                shot.column++;
                            }
                            if (maze[shot.row][shot.column + 1].isDestructible()) {
                                currentMatrix[shot.row][shot.column + 1] = 0;
                                int s = Runner.getPlayer().getScore();
                                s += 200;
                                Runner.getPlayer().setScore(s);
                            }
                            drawMaze();
                            currentMatrix[shot.row][shot.column] = 0;
                            break;
                    }
                    }

                    
   
               

                } else if (event.getCode() == KeyCode.P) {
                    new Alert(Alert.AlertType.INFORMATION, "Game Paused \n Press Okay To Continue").showAndWait();
                } else if (event.getCode() == KeyCode.S) {
                    d.save(currentMatrix);
                } else if (event.getCode() == KeyCode.L) {
                    int matrix[][] = d.load();
                    maze = f.mazeFactory(matrix);
                    objectsPane.getChildren().clear();
                    runnerPane.getChildren().clear();
                    int i, j;
                    for (i = 0; i < 30; i++) {
                        for (j = 0; j < 30; j++) {//Label l = new Label();

                            Image image1 = maze[i][j].getImage();
                            ImageView img = new ImageView(image1);
                            img.setFitWidth(35);
                            img.setFitHeight(21);
                            //l.setGraphic(img);
                            objectsPane.add(img, j, i);
                        }
                    }
                    for (i = 0; i < 30; i++) {
                        for (j = 0; j < 30; j++) {
                            Image image2 = null;
                            ImageView img = new ImageView(image2);
                            img.setFitWidth(35);
                            img.setFitHeight(21);
                            runnerPane.add(img, j, i);
                        }
                    }
                    Image runner = Runner.getPlayer().getImage();
                    ImageView img1 = new ImageView(runner);
                    img1.setFitWidth(35);
                    img1.setFitHeight(21);
                    runnerPane.add(img1, Runner.getPlayer().column, Runner.getPlayer().row);
                }
                event.consume();
            });
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        //  Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setScene(scene);
        stage.show();

    }

    public void initializeMaze() {
        int i, j;
        for (i = 0; i < 30; i++) {
            for (j = 0; j < 30; j++) {//Label l = new Label();

                Image image = maze[i][j].getImage();
                ImageView img = new ImageView(image);
                img.setFitWidth(35);
                img.setFitHeight(21);
                //l.setGraphic(img);
                objectsPane.add(img, j, i);
            }
        }

        for (i = 0; i < 30; i++) {
            for (j = 0; j < 30; j++) {
                Image image = null;
                ImageView img = new ImageView(image);
                img.setFitWidth(35);
                img.setFitHeight(21);
                runnerPane.add(img, j, i);
            }
        }

        for (i = 0; i < 40; i++) {
            for (j = 0; j < 40; j++) {
                Image image = null;
                ImageView img = new ImageView(image);
                img.setFitWidth(35);
                img.setFitHeight(21);
                observerPane.add(img, j, i);
            }
        }
        // Cell cell = f.cellFactory(3);
        Image image = Runner.getPlayer().getImage();
        ImageView img = new ImageView(image);
        img.setFitWidth(35);
        img.setFitHeight(21);
        current = img;
        //runnerPane.getChildren().remove(1);
        runnerPane.add(img, 1, 0);

        borderPane.getChildren().add(observerPane);
        borderPane.getChildren().add(objectsPane);
        borderPane.getChildren().add(runnerPane);

    }

    int i = 0;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            //seconds++;
            //System.out.println(i);
            text = Integer.toString(i);
 
            notification.setText(text);
        
        System.out.println(text);
            i++;
            
         
            
        }

    };

    public void drawMaze() {
        
       

        maze = f.mazeFactory(currentMatrix);
        objectsPane.getChildren().clear();
        int i, j;
        for (i = 0; i < 30; i++) {
            for (j = 0; j < 30; j++) {//Label l = new Label();

                Image image = maze[i][j].getImage();
                ImageView img = new ImageView(image);
                img.setFitWidth(35);
                img.setFitHeight(21);
                //l.setGraphic(img);
                objectsPane.add(img, j, i);
            }
        }

        objectsPane.requestLayout();

    }

    public void runTimer(){
      timer.schedule(task, 0 , 1000);  
     
  
   }
    public static void main(String[] args) {

        try {
            //new MazeFX().runTimer();
            launch(args);

        } catch (ArrayIndexOutOfBoundsException e) {
        }

    }

}
