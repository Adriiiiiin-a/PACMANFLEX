package Outils;

public class Constantes {

    private static int[] coordonneesSpawnJoueur = {0,0};

    public static int[] getCoordonneesSpawnJoueur() {
        return coordonneesSpawnJoueur;
    }

    //////////////////// CHEMINS ////////////////////////

    private static String cheminCarte = "externes/carte.txt";
    public static String getCheminCarte(){
        return cheminCarte;
    }


}
