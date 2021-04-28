package Jeu;

import Affichage.*;
import Outils.Direction;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;



public class Touche implements EventHandler<KeyEvent> {

    Affichage scene;
    Partie partie;
    Pacman joueur;

    public Direction lastTouche;

    public Touche(Affichage scene, Partie partie){
        this.scene = scene;
        this.joueur = partie.pacman;
        this.partie = partie;
        this.lastTouche = Direction.DROITE;
    }

    @Override
    public void handle(KeyEvent entre) {



        switch (entre.getCode()) {
            case ENTER:
                System.out.println("marche Entrer");

                break;
            case UP:
                System.out.println("TOUCHE HAUT");
                    this.lastTouche = Direction.HAUT;
                break;
            case DOWN:
                System.out.println("TOUCHE BAS");
                    this.lastTouche = Direction.BAS;
                break;
            case RIGHT:
                System.out.println("TOUCHE DROITE");
                    this.lastTouche = Direction.DROITE;
                break;
            case LEFT:
                System.out.println("TOUCHE GAUCHE");
                    this.lastTouche = Direction.GAUCHE;
                break;
        }

    }




}
