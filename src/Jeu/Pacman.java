package Jeu;

import Outils.Constantes;
import Outils.Constantes.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pacman {

    public int score;

    public int nombreDeVies;

    public int[] coordonees;

    private ImageView imPac;





    public Pacman() throws FileNotFoundException {

        this.nombreDeVies = 3;

        this.score = 0;

        this.coordonees = Constantes.getCoordonneesSpawnJoueur();

        this.imPac = new ImageView();
        FileInputStream png = new FileInputStream("externes/images/PACMAN_DROITE.png");
        Image image = new Image(png, 20, 20, true, true);
        this.imPac.setImage(image);
    }




    public void movePacman(){





    }

}
