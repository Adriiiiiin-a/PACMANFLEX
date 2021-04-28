package Jeu;

import Outils.Constantes;
import Outils.Constantes.*;
import Outils.Direction;
import Outils.Entites;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pacman {

    public int score;

    public int nombreDeVies;

    public int[] coordonees;

    private ImageView imPac;

    private Direction lastDir;





    public Pacman() throws FileNotFoundException {

        this.nombreDeVies = 3;

        this.score = 0;

        this.coordonees = Constantes.getCoordonneesSpawnJoueur();

        this.imPac = new ImageView();
        FileInputStream png = new FileInputStream("externes/images/PACMAN_DROITE.png");
        Image image = new Image(png, 20, 20, true, true);
        this.imPac.setImage(image);
    }

    public ImageView getImPac() {
        return imPac;
    }

    public void setCoordonees(int[] coordonees) {
        this.coordonees = coordonees;
    }

    public void movePacman(Direction dir, Partie p) throws FileNotFoundException {

        if(Fonctions.estTraversable(dir, p)){

            if(Fonctions.isBonbon(dir, p)){
                this.score += 10;
                p.getGrille()[this.coordonees[0]][this.coordonees[1]] = Entites.MANGE;


            }



            switch(dir){
                case DROITE -> {this.coordonees[1] += 1;FileInputStream png = new FileInputStream("externes/images/PACMAN_DROITE.png"); Image image = new Image(png, 20, 20, true, true);this.imPac.setImage(image);break;}
                case GAUCHE -> {this.coordonees[1] -= 1;FileInputStream png = new FileInputStream("externes/images/PACMAN_GAUCHE.png"); Image image = new Image(png, 20, 20, true, true);this.imPac.setImage(image);break;}
                case HAUT -> {this.coordonees[0] -= 1;FileInputStream png = new FileInputStream("externes/images/PACMAN_HAUT.png"); Image image = new Image(png, 20, 20, true, true);this.imPac.setImage(image);break;}
                case BAS -> {this.coordonees[0] += 1;FileInputStream png = new FileInputStream("externes/images/PACMAN_BAS.png"); Image image = new Image(png, 20, 20, true, true);this.imPac.setImage(image);break;}
                default -> System.out.println("ERREUR DIRECTION");

            }
        }else{
            switch(dir){
                case DROITE -> {FileInputStream png = new FileInputStream("externes/images/PACMAN_DROITE.png"); Image image = new Image(png, 20, 20, true, true);this.imPac.setImage(image);break;}
                case GAUCHE -> {FileInputStream png = new FileInputStream("externes/images/PACMAN_GAUCHE.png"); Image image = new Image(png, 20, 20, true, true);this.imPac.setImage(image);break;}
                case HAUT -> {FileInputStream png = new FileInputStream("externes/images/PACMAN_HAUT.png"); Image image = new Image(png, 20, 20, true, true);this.imPac.setImage(image);break;}
                case BAS -> {FileInputStream png = new FileInputStream("externes/images/PACMAN_BAS.png"); Image image = new Image(png, 20, 20, true, true);this.imPac.setImage(image);break;}
                default -> System.out.println("ERREUR DIRECTION");

            }

        }

    }

    public boolean isTP(){

        int[] tab1 = {0,10};
        int[] tab2 = {0,11};
        int[] tab3 = {22,10};
        int[] tab4 = {22,11};

        if (this.coordonees.equals(tab1)|| this.coordonees.equals(tab2)) {

            this.coordonees[1] = 21;
            return true;

        }else if (this.coordonees.equals(tab3)|| this.coordonees.equals(tab4)){

            this.coordonees[1] = 1;
            return true;
        }

        return false;


    }


}


