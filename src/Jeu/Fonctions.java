package Jeu;

import Outils.Direction;

public class Fonctions {
    public static boolean estTraversable(Direction dir, Pacman joueur) {

        int initX = joueur.coordonees[0];
        int initY = joueur.coordonees[1];

        switch (dir) {
            case HAUT:
                if ((initY + 1) <= 22) {

                    if (true) {

                    }
                    return false;
                }
                break;
            case BAS:
                if ((initY - 1) <= 22) {

                    if (true) {

                    }
                    return false;
                }
                break;
            case DROITE:
                if ((initX + 1) <= 22) {

                    if (true) {

                    }
                    return false;
                }
                break;
            case GAUCHE:
                if ((initX - 1) <= 22) {

                    if (true) {

                    }
                    return false;
                }
                break;
        }
        return false;
    }
}
