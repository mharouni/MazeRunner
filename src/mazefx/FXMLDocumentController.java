  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazefx;

import Controller.CellFactory;
import Controller.Database;
import MazeModel.Cell;
import MazeModel.Cells;
import MazeModel.Runner;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;

/**
 *
 * @author MaramH
 */
public class FXMLDocumentController implements Initializable,ActionListener {
   
    @FXML
    
    private GridPane pane;
    
   //Cells[30][30] mazelogic = new  ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          
   
     
   
    
    
   /* int i,j;
     for(i = 0 ; i<30 ; i++)
     {
         for(j=0 ; j<30 ; j++)
         {Label l = new Label();
        
        Image image = maze[i][j].getImage();
         ImageView img = new ImageView(image);
          img.setFitWidth(35);
        img.setFitHeight(21);
         l.setGraphic(img);
         pane.add(l, j, i);
     }}*/
}
    public void actionPerformed (ActionEvent e)
    {
    step();
    }

    private void step() {
       // Runner.move();
    }
    

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        
    }}
    


