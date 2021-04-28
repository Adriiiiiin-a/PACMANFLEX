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
                if(Fonctions.estTraversable(Direction.HAUT, this.partie)){
                    System.out.println("haut marche");
                    this.lastTouche = Direction.HAUT;
                }
                break;
            case DOWN:
                if(Fonctions.estTraversable(Direction.BAS, this.partie)){
                    System.out.println("bas marche");
                    this.lastTouche = Direction.BAS;
                }
                break;
            case RIGHT:
                if(Fonctions.estTraversable(Direction.DROITE, this.partie)){
                    System.out.println("droite marche");
                    this.lastTouche = Direction.DROITE;
                }
                break;
            case LEFT:
                if(Fonctions.estTraversable(Direction.GAUCHE, this.partie)){
                    System.out.println("gauche marche");

                    this.lastTouche = Direction.GAUCHE;


                }
                break;
        }

    }




}
