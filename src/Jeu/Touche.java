package Jeu;

import Affichage.*;
import Outils.Direction;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;



public class Touche implements EventHandler<KeyEvent> {

    Affichage scene;
    Pacman joueur;

    public Touche(Affichage scene, Pacman joueur){
        this.scene = scene;
        this.joueur = joueur;
    }

    @Override
    public void handle(KeyEvent entre) {

        switch (entre.getCode()) {
            case ENTER:
                System.out.println("marche Entrer");
            case UP:
                if(Fonctions.estTraversable(Direction.HAUT, this.joueur)){

                }
                break;
            case DOWN:
                System.out.println("marche down");
            case RIGHT:
                System.out.println("marche right");
            case LEFT:
                System.out.println("marche left");
        }
    }
}
