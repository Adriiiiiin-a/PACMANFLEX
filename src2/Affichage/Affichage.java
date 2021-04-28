package Affichage;

import Jeu.Partie;
import Outils.entites;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Affichage extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Preview PacmanFX");
        stage.setResizable(false);
        GridPane root = new GridPane();

        Partie p1 = new Partie();
        int x = 0;


        for (int i = 0; i < 22; i++) {
            for (x = 0; x<22;x++) {
                entites actualEntite = p1.getGrille()[i][x];
                //System.out.println(actualEntite);
                ImageView iv = new ImageView();
                if (actualEntite.equals(entites.MUR)){
                    FileInputStream input = new FileInputStream("externes/images/MUR.png");
                    Image image = new Image(input,20,20 ,true,true);
                    iv.setImage(image);
                } else if (actualEntite.equals(entites.PORTE)){
                    FileInputStream input = new FileInputStream("externes/images/FOND_BLANC.png");
                    Image image = new Image(input,20,20 ,true,true);
                    iv.setImage(image);
                } else{
                    FileInputStream inputN = new FileInputStream("externes/images/FOND_NOIR.png");
                    Image img = new Image(inputN,20,20 ,true,true);
                    iv.setImage(img);
                }
                root.add(iv, i, x);
            }

        }
        Scene scene = new Scene(root, 440, 440);
        stage.setScene(scene);
        stage.show();
    }
}
