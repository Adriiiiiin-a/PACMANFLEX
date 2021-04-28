package Jeu;

import Outils.Constantes;
import Outils.Entites;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;

public class Partie implements Observable, Runnable{




    public Pacman pacman;

    private Entites[][] grille;

    public Fantome fantome1;
    public Fantome fantome2;
    public Fantome fantome3;
    public Fantome fantome4;

    private boolean isBoosted = false;


    public Partie() throws IOException {

        Entites[][] tab = initGrille();

        this.grille = tab;

        afficheGrille(this.grille);

        this.pacman = new Pacman();

        this.fantome1 = new Fantome("FANTOME_ROUGE", 10, 6);

        this.fantome2 = new Fantome("FANTOME_ROSE", 11, 6);

        this.fantome3 = new Fantome("FANTOME_ORANGE", 9, 6);

        this.fantome4 = new Fantome("FANTOME_ORANGE", 12, 6);

        fantome1.initFantome();
        fantome2.initFantome();
        fantome3.initFantome();
        fantome4.initFantome();


    }


    /**
     * RETOURNE LA GRILLE DE JEU
     * @return la grille de jeu
     * @throws IOException
     */
    private Entites[][] initGrille() throws IOException {

        char[][] tab = new char[22][22];

        Entites[][] toReturn = new Entites[22][22];

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

            Entites convert;
            if (ch != '\n') {
                tab[x][y] = ch;

                switch (ch) {
                    case '0':
                        convert = Entites.VIDE;
                        break;
                    case '1':
                        convert = Entites.MUR;
                        break;
                    case '2':
                        convert = Entites.SPAWN;
                        break;
                    case '3':
                        convert = Entites.PORTE;
                        break;
                    case '4':
                        convert = Entites.TELEPORT;
                        break;


                    default:
                        convert = Entites.ERREUR;


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


    public Entites[][] getGrille() {
        return grille;
    }
    public Fantome[] getFantome(){
        return new Fantome[]{this.fantome1, this.fantome2, this.fantome3, this.fantome4};
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


    public void afficheGrille(Entites[][] aAfficher){

        for (int i = 0; i < 22; i++) {

            for (int j = 0; j < 22; j++) {
                System.out.print(aAfficher[i][j]);
            }

            System.out.print('\n');

        }

    }



}