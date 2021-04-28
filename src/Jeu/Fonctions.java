package Jeu;

import Outils.Direction;
import Outils.Entites;

public class Fonctions {
    public static boolean estTraversable(Direction dir, Partie partie) {

        int initX = partie.pacman.coordonees[0];
        int initY = partie.pacman.coordonees[1];

        Entites[][] grille = partie.getGrille();

        switch (dir) {
            case HAUT:
                //System.out.println("haut");
                if ((initY + 1) <= 22) {

                    if (!(grille[initX][initY+1]).equals(Entites.MUR) || !(grille[initX][initY+1]).equals(Entites.PORTE)) {

                        System.out.println("Traversable !");

                        return true;

                    }

                    return false;
                }
                System.out.println("Non traversable");
                break;
            case BAS:
                //System.out.println("bas");
                if ((initY - 1) >= 0) {

                    if (!(grille[initX][initY-1]).equals(Entites.MUR) || !(grille[initX][initY-1]).equals(Entites.PORTE)) {

                        System.out.println("Traversable !");

                        return true;

                    }

                    return false;
                }
                System.out.println("Non traversable");
                break;
            case DROITE:
                //System.out.println("droite");
                if ((initX + 1) <= 22) {

                    if (!(grille[initX+1][initY]).equals(Entites.MUR) || !(grille[initX+1][initY]).equals(Entites.PORTE)) {

                        System.out.println("Traversable !");

                        return true;

                    }
                    return false;

                }
                System.out.println("Non traversable");
                break;
            case GAUCHE:
                //System.out.println("gauche");
                if ((initX - 1) >= 0) {

                    if (!(grille[initX-1][initY]).equals(Entites.MUR) || !(grille[initX-1][initY]).equals(Entites.PORTE)) {

                        System.out.println("Traversable !");

                        return true;

                    }

                    return false;
                }
                System.out.println("Non traversable");
                break;
        }
        return false;
    }
}
