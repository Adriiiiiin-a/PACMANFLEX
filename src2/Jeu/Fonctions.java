package Jeu;

import Outils.Direction;
import Outils.entites;

public class Fonctions {


    /**
     * La case suivante est-elle franchissable ?
     * @param dir Direction entrée par le user
     * @param partie la partie en cours
     * @return true si traversable, flase sinon
     */
    public boolean estTraversable(Direction dir, Partie partie){

        Pacman joueur = partie.pacman;
        entites[][] grille = partie.getGrille();


        int initX = joueur.coordonees[0];
        int initY = joueur.coordonees[1];

        if(dir.equals(Direction.DROITE)){

            if((initX+1) <= 22){

                entites bloc = grille[initX+1][initY];

                if(bloc.equals(entites.MUR) || bloc.equals(entites.PORTE)){
                    System.out.print("bloc non traversable");
                    return false;
                }else{
                    System.out.print("bloc traversable");
                    return true;
                }
            }
            return false;
        }else if(dir.equals(Direction.GAUCHE)){

            if((initX-1) >= 0){

                entites bloc = grille[initX-1][initY];

                if(bloc.equals(entites.MUR) || bloc.equals(entites.PORTE)){
                    System.out.print("bloc non traversable");
                    return false;
                }else{
                    System.out.print("bloc traversable");
                    return true;
                }
            }
            return false;
        }else if (dir.equals(Direction.HAUT)){

            if((initY-1) >= 0){

                entites bloc = grille[initX][initY-1];

                if(bloc.equals(entites.MUR) || bloc.equals(entites.PORTE)){
                    System.out.print("bloc non traversable");
                    return false;
                }else{
                    System.out.print("bloc traversable");
                    return true;
                }
            }
            return false;
        }else if (dir.equals(Direction.BAS)){

            if((initY+1) <= 22){

                entites bloc = grille[initX+1][initY];

                if(bloc.equals(entites.MUR) || bloc.equals(entites.PORTE)){
                    System.out.print("bloc non traversable");
                    return false;
                }else{
                    System.out.print("bloc traversable");
                    return true;
                }
            }
            return false;
        }

        return false;
    }



}
