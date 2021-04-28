package Affichage;

import Jeu.Pacman;

public class testPacman {


    public static void main(String[] args) {

        Pacman pac = new Pacman();

        for (int i = 0; i < 12; i++) {

            System.out.println("Nombre de vies:" + pac.nombreDeVies + " - Score: " + pac.score);


            pac.nombreDeVies += 1;

            pac.score += 10;

        }




    }

}
