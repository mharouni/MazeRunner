/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazefx;

import Controller.CellFactory;
import Controller.Database;
import MazeModel.Cell;
import MazeModel.Runner;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author MaramH
 */
public class MazeFX extends Application {

    CellFactory f = new CellFactory();
    Database d = new Database();
    int matrix[][] = d.readInit();
    Cell[][] maze = f.mazeFactory(matrix);
  
    @Override
    public void start(Stage stage) throws Exception {
        GridPane objectsPane = new GridPane();
        GridPane runnerPane = new GridPane();
        Node current;
        //runnerPane.set
        ImageView view = new ImageView("file:/C:/Users/MaramH/Desktop/649675876.jpg");
        objectsPane.setStyle("-fx-background-color: GREEN");
        runnerPane.setStyle("-fx-background-color: transparent");
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
        Cell cell = f.cellFactory(3);
        Image image = Runner.getPlayer().getImage();
        ImageView img = new ImageView(image);
        img.setFitWidth(35);
        img.setFitHeight(21);
        current = img;
        //runnerPane.getChildren().remove(1);
        runnerPane.add(img, 1, 0);
        Pane borderPane = new Pane();
        borderPane.getChildren().add(objectsPane);
        borderPane.getChildren().add(runnerPane);

        Scene scene = new Scene(borderPane);
    try{
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
              if(Runner.getPlayer().row>0){
                if (maze[Runner.getPlayer().row - 1][Runner.getPlayer().column].isWay()) {
                   Node temp=current;
                    runnerPane.getChildren().remove(current);
                    
                    
                    Image image1 = Runner.getPlayer().getImage();
                    ImageView img1 = new ImageView(image);
                    
                    img1.setFitWidth(35);
                    img1.setFitHeight(21);
                    
                    runnerPane.add(temp, Runner.getPlayer().column, Runner.getPlayer().row-1);
                     
                    Runner.getPlayer().row--;
                     //runnerPane.getChildren().remove(maze[Runner.getPlayer().row-1] [Runner.getPlayer().column].getImage());
                }}
            } else if (event.getCode() == KeyCode.DOWN) {
                
                System.out.println("key down");
                
                if (maze[Runner.getPlayer().row + 1][Runner.getPlayer().column].isWay()) {
                    System.out.println("Down");
                      
                      Node temp=current;
                    runnerPane.getChildren().remove(current);
                    
                    
                    Image image1 = Runner.getPlayer().getImage();
                    ImageView img1 = new ImageView(image);
                    
                    img1.setFitWidth(35);
                    img1.setFitHeight(21);
                    
                    runnerPane.add(temp, Runner.getPlayer().column, Runner.getPlayer().row + 1);
                     
                    Runner.getPlayer().row++;
                    if (Runner.getPlayer().row==29) {new Alert(Alert.AlertType.INFORMATION, "GOAL!").showAndWait();
                    }
                    // runnerPane.getChildren().remove(maze[Runner.getPlayer().row-1] [Runner.getPlayer().column].getImage());
                  

                }
            } else if (event.getCode() == KeyCode.RIGHT) {
                if (maze[Runner.getPlayer().row][Runner.getPlayer().column+1].isWay()) {
                   Node temp=current;
                    runnerPane.getChildren().remove(current);
                    
                    
                    Image image1 = Runner.getPlayer().getImage();
                    ImageView img1 = new ImageView(image);
                    
                    img1.setFitWidth(35);
                    img1.setFitHeight(21);
                    
                    runnerPane.add(temp, Runner.getPlayer().column+1, Runner.getPlayer().row);
                     
                    Runner.getPlayer().column++;}

            } else if (event.getCode() == KeyCode.LEFT) {
                if (maze[Runner.getPlayer().row][Runner.getPlayer().column-1].isWay()) {
                   Node temp=current;
                    runnerPane.getChildren().remove(current);
                    
                    
                    Image image1 = Runner.getPlayer().getImage();
                    ImageView img1 = new ImageView(image);
                    
                    img1.setFitWidth(35);
                    img1.setFitHeight(21);
                    
                    runnerPane.add(temp, Runner.getPlayer().column-1, Runner.getPlayer().row);
                     
                    Runner.getPlayer().column--;
                }}
            
            event.consume();
        });
}
catch(ArrayIndexOutOfBoundsException e)
{
  
}
            

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setScene(scene);
        stage.show();
    
}
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        try{
        launch(args);}
        catch(ArrayIndexOutOfBoundsException e)
{

}

    }



}
