package Jeu;

import Outils.Direction;

public class Fonctions {
    public static boolean estTraversable(Direction dir, Pacman joueur) {

        int initX = joueur.coordonees[0];
        int initY = joueur.coordonees[1];

        switch (dir) {
            case HAUT:
                System.out.println("haut");
                if ((initY + 1) <= 22) {

                    if (true) {

                    }
                    return false;
                }
                break;
            case BAS:
                System.out.println("bas");
                if ((initY - 1) <= 22) {

                    if (true) {

                    }
                    return false;
                }
                break;
            case DROITE:
                System.out.println("droite");
                if ((initX + 1) <= 22) {

                    if (true) {

                    }
                    return false;
                }
                break;
            case GAUCHE:
                System.out.println("gauche");
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
