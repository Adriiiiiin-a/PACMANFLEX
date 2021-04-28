package Jeu;

import Outils.Constantes;
import Outils.entites;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.io.*;

public class Partie implements Observable, Runnable{




    public Pacman pacman;

    private entites[][] grille;

    public Fantome fantome1;
    public Fantome fantome2;
    public Fantome fantome3;
    public Fantome fantome4;

    private boolean isBoosted = false;


    public Partie() throws IOException {

        entites[][] tab = initGrille();

        this.grille = tab;

        afficheGrille(this.grille);


        this.pacman = new Pacman();

        this.fantome1 = new Fantome();

        this.fantome2 = new Fantome();

        this.fantome3 = new Fantome();

        this.fantome4 = new Fantome();


    }

    /**
     * RETOURNE LA GRILLE DE JEU
     * @return la grille de jeu
     * @throws IOException
     */
    private entites[][] initGrille() throws IOException {

        char[][] tab = new char[22][22];

        entites[][] toReturn = new entites[22][22];

        // Le fichier d'entrée
        File file = new File(Constantes.getCheminCarte());
        // Créer l'objet File Reader
        FileReader fileReader = new FileReader(file);
        // Créer l'objet BufferedReader
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int c = 0;
        // Lire caractère par caractère

        int x = 0;
        int y = 0;
        while((c = bufferedReader.read()) != '-')
        {
            // convertir l'entier en char
            char ch = (char) c;
            // Afficher le caractère
            //System.out.print(ch);


            //System.out.println(ch);

            entites convert;
            if (ch != '\n') {
                tab[x][y] = ch;

                switch (ch) {
                    case '0':
                        convert = entites.VIDE;
                        break;
                    case '1':
                        convert = entites.MUR;
                        break;
                    case '2':
                        convert = entites.SPAWN;
                        break;
                    case '3':
                        convert = entites.PORTE;
                        break;
                    case '4':
                        convert = entites.TELEPORT;
                        break;


                    default:
                        convert = entites.ERREUR;


                }

                toReturn[y][x] = convert;

                //System.out.print(toReturn[x][y] + " ");

                //System.out.print(convert + " ");

                //System.out.print("Pedro");
                //System.out.print(tab[x][y]);
                y++;
            }else{
                //System.out.print('\n');
                y=0;
                x++;
            }

        }
        return toReturn;

    }


    public entites[][] getGrille() {
        return grille;
    }

    @Override
    public void run() {
        return;
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

        return;

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

        return;

    }


    //@Override
    //public void run() {

    // }

    //  @Override
    // public void addListener(InvalidationListener invalidationListener) {

    //  }

    //@Override
    // public void removeListener(InvalidationListener invalidationListener) {

    //}

    //public


    public void afficheGrille(entites[][] aAfficher){

        for (int i = 0; i < 22; i++) {

            for (int j = 0; j < 22; j++) {
                System.out.print(aAfficher[i][j]);
            }

            System.out.print('\n');

        }

    }
}
