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
                    System.out.println("haut marche");
                }
                break;
            case DOWN:
                if(Fonctions.estTraversable(Direction.BAS, this.joueur)){
                    System.out.println("bas marche");
                }
                break;
            case RIGHT:
                if(Fonctions.estTraversable(Direction.DROITE, this.joueur)){
                    System.out.println("droite marche");
                }
                break;
            case LEFT:
                if(Fonctions.estTraversable(Direction.GAUCHE, this.joueur)){
                    System.out.println("gauche marche");
                }
                break;
        }
    }
}
