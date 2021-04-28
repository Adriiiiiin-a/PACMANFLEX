package Jeu;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Fantome {

    private String nom;
    private int spawnX;
    private int spawnY;
    private ImageView fantome;

        public Fantome(String nom, int X, int Y){
            this.nom = nom;
            this.spawnX = X;
            this.spawnY = Y;
        }

    public int getSpawnX() { return spawnX;
    }
    public int getSpawnY(){ return spawnY;
    }
    public String getNom(){return this.nom;}
    public ImageView getFantome(){return this.fantome;}

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }
    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }


    public void initFantome() throws FileNotFoundException {

            this.fantome = new ImageView();
            FileInputStream png = new FileInputStream("externes/images/"+this.nom+".png");
            Image image = new Image(png, 20, 20, true, true);
            this.fantome.setImage(image);

        }
}
