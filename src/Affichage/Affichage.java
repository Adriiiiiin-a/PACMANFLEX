package Affichage;

import Jeu.*;
import Outils.Direction;
import Outils.Entites;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.animation.AnimationTimer;
import javafx.util.Duration;

import static java.lang.Thread.sleep;

public class Affichage extends Application{

    Fantome[] tabFantome;

    Pacman pac;
    Touche touche;
    Direction dernier;

    int[] compteurDeBoucle = {0,0,0,0};
    int[] direction = {0,0,0,0};

    @Override
    public void start(Stage stage)throws Exception{
        stage.setTitle("Preview PacmanFX");
        GridPane root = new GridPane();
        Partie p1 = new Partie();
        touche = new Touche(this, p1);

        int x;

        for (int i = 0; i < 22; i++) {
            for (x = 0; x<22;x++) {
                Entites actualEntite = p1.getGrille()[x][i];
//                System.out.println(actualEntite);
                ImageView iv = new ImageView();
                if (actualEntite.equals(Entites.MUR)){
                    FileInputStream input = new FileInputStream("externes/images/MUR.png");
                    Image image = new Image(input,20,20 ,true,true);
                    iv.setImage(image);
                } else if (actualEntite.equals(Entites.PORTE)){
                    FileInputStream input = new FileInputStream("externes/images/FOND_BLANC.png");
                    Image image = new Image(input,20,20 ,true,true);
                    iv.setImage(image);
                } else if (actualEntite.equals(Entites.GROS_BONBON)){
                    FileInputStream input = new FileInputStream("externes/images/GBBN.png");
                    Image image = new Image(input,20,20 ,true,true);
                    iv.setImage(image);
                }else if (actualEntite.equals(Entites.BONBON)){
                    FileInputStream input = new FileInputStream("externes/images/PBBN.png");
                    Image image = new Image(input,20,20 ,true,true);
                    iv.setImage(image);
                }
                else{
                    FileInputStream inputN = new FileInputStream("externes/images/FOND_NOIR.png");
                    Image img = new Image(inputN,20,20 ,true,true);
                    iv.setImage(img);
                }
                root.add(iv, i, x);
            }
        }
        Scene scene = new Scene(root, 440, 440);
        scene.setOnKeyPressed(touche);
        stage.setScene(scene);


        tabFantome = p1.getFantome();

        pac = p1.getPacman();

        dernier = Direction.DROITE;



        root.add(tabFantome[0].getFantome(), tabFantome[0].getSpawnX(), tabFantome[0].getSpawnY());
        root.add(tabFantome[1].getFantome(), tabFantome[1].getSpawnX(), tabFantome[1].getSpawnY());
        root.add(tabFantome[2].getFantome(), tabFantome[2].getSpawnX(), tabFantome[2].getSpawnY());
        root.add(tabFantome[3].getFantome(), tabFantome[3].getSpawnX(), tabFantome[3].getSpawnY());
        root.add(pac.getImPac(), p1.pacman.coordonees[0],p1.pacman.coordonees[1]);


        stage.show();
        new AnimationTimer() {


            int count = 0;


            @Override
            public void handle(long now){

                p1.afficheGrille(p1.getGrille());


                count += 1;
                System.out.println(count);


                for (int j = 0; j < 4; j++) {
//                    System.out.println("Fantome:"+j+","+compteurDeBoucle[j]+","+direction[j]);
//                    if(compteurDeBoucle[j] == 20){
//                    System.out.println("20");
//                        compteurDeBoucle[j] = 0;
                        int t = (int) (Math.random() * 4);
                        switch (t) {
                            case (0) -> tabFantome[j].getFantome().setTranslateX(20);
                            case (1) -> tabFantome[j].getFantome().setTranslateX(-20);
                            case (2) -> tabFantome[j].getFantome().setTranslateY(20);
                            case (3) -> tabFantome[j].getFantome().setTranslateY(-20);
                            default -> System.out.println("Error:" + t);
                        }





//                        direction[j] = t;
//                        compteurDeBoucle[j]++;
//                    }
//                    else{
//                        System.out.println("pas 20");
//                        compteurDeBoucle[j]++;
//                        switch (direction[j]) {
//                            case (0) -> tabFantome[j].getFantome().setTranslateX(1);
//                            case (1) -> tabFantome[j].getFantome().setTranslateX(-1);
//                            case (2) -> tabFantome[j].getFantome().setTranslateY(1);
//                            case (3) -> tabFantome[j].getFantome().setTranslateY(-1);
//                            default -> System.out.println("Error:" + direction[j]);
//                        }
//                    }
                }

                //

                System.out.println(dernier);


                //if(Fonctions.estTraversable(touche.lastTouche, p1)){
                    dernier = touche.lastTouche;
                //}






                switch (dernier){

                    case BAS -> {
                        try {
                            pac.movePacman(dernier, p1);
                            if(Fonctions.estTraversable(dernier, p1)) {

                                pac.getImPac().setTranslateY(pac.coordonees[0] * 20);
                                System.out.println("Va bas");
                            }else{
                                System.out.println("BLOQUE");
                            }

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case HAUT -> {
                        try {
                            pac.movePacman(dernier, p1);
                            if(Fonctions.estTraversable(dernier, p1)) {
                                pac.getImPac().setTranslateY(pac.coordonees[0] * -20);
                                System.out.println("Va haut");
                            }else{
                                System.out.println("BLOQUE");
                            }

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case DROITE -> {
                        try {
                            pac.movePacman(dernier, p1);
                            if(Fonctions.estTraversable(dernier, p1)) {
                                pac.getImPac().setTranslateX(pac.coordonees[1] * 20);
                                System.out.println("Va droite");
                            }else{
                                System.out.println("BLOQUE");
                            }

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case GAUCHE -> {
                        try {
                            pac.movePacman(dernier, p1);
                            if(Fonctions.estTraversable(dernier, p1)) {
                                pac.getImPac().setTranslateX(pac.coordonees[1] * -20);
                                System.out.println("Va gauche");
                            }else{
                                System.out.println("BLOQUE");
                            }

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    default -> System.out.println("ERREUR");
                }

                boolean cond = pac.isTP();

                if (cond){

                    switch (dernier){

                        case DROITE -> {pac.getImPac().setTranslateX(-21);break;}
                        case GAUCHE -> {pac.getImPac().setTranslateX(21);break;}
                        default -> System.out.println("ERREUR CHANGEMENT DIR");
                    }
                }
                System.out.println(pac.coordonees[0] + " " +  pac.coordonees[1]);


                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        p1.afficheGrille(p1.getGrille());
        System.out.println(pac.score);


    }
    public static void main(String[] args){
        launch(args);
    }


}


