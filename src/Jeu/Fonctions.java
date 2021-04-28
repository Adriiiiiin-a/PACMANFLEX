package Jeu;

import Outils.Direction;
import Outils.Entites;

public class Fonctions {
    public static boolean estTraversable(Direction dir, Partie partie) {

        int initX = partie.pacman.coordonees[0];
        int initY = partie.pacman.coordonees[1];

        Entites[][] grille = partie.getGrille();

        Entites nextEntite = nextCase(dir, partie);
        System.out.println(nextEntite);

        if(nextEntite.equals(Entites.BONBON) ||nextEntite.equals(Entites.GROS_BONBON) || nextEntite.equals(Entites.VIDE)||nextEntite.equals(Entites.FANTOME) || nextEntite.equals(Entites.TELEPORT) ||nextEntite.equals(Entites.FANTOME)){
            System.out.println("ABLE");
            return true;
        }



        return false;
    }


    public static Entites nextCase(Direction dir, Partie p){

        Entites[][] grille = p.getGrille();

        int X = p.pacman.coordonees[0];
        int Y = p.pacman.coordonees[1];

        switch(dir){

            case GAUCHE -> {
                return grille[X-1][Y];

            }
            case DROITE -> {
                return grille[X+1][Y];

            }
            case BAS -> {
                System.out.println(X + " " + Y);
                return grille[X][Y+1];

            }
            case HAUT -> {
                return grille[X][Y-1];

            }
            default -> System.out.println("ERREUR RETOUR DIR");

        }
        return grille[X][Y];



    }

    public static boolean isBonbon(Direction dir, Partie p){

        if(nextCase(dir, p).equals(Entites.BONBON)){
            return true;
        }
        return false;
    }

    public boolean isGrosBonbon(Direction dir, Partie p){

        if(nextCase(dir, p).equals(Entites.GROS_BONBON)){
            return true;
        }
        return false;
    }


}
