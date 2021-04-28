package Affichage;

import Jeu.Fantome;
import Jeu.Partie;
import Outils.Entites;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Objects;

public class FenetreArthur extends Application {

    Scene sceneJeu, sceneMenu, sceneRecord, sceneOption;
    final int WIDTH = 782;
    final int HEIGHT =  440;
    Fantome[] tabFantome;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Pacman");
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        // Menu principale


        GridPane root = new GridPane();
        root.setId("pane");


        for(int i=0;i<3;i++){
            ColumnConstraints column = new ColumnConstraints(260);//460
            root.getColumnConstraints().add(column);
        }

        for(int i=0;i<6;i++){
            RowConstraints row = new RowConstraints(73);//110
            root.getRowConstraints().add(row);
        }



        Button buttonPlay= new Button("Jouer");
        buttonPlay.setId("button");

        buttonPlay.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        GridPane.setHalignment(buttonPlay, HPos.CENTER);
        buttonPlay.setOnAction(e -> primaryStage.setScene(sceneJeu));
        root.add(buttonPlay,1,2);


        Button buttonRecord = new Button("Records");
        buttonRecord.setId("button");
        buttonRecord.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        GridPane.setHalignment(buttonRecord,HPos.CENTER);
        buttonRecord.setOnAction(e -> primaryStage.setScene(sceneRecord));
        root.add(buttonRecord,1,3);


        Button buttonOption = new Button("Comment jouer");
        buttonOption.setId("button");
        buttonOption.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        GridPane.setHalignment(buttonOption,HPos.CENTER);
        root.add(buttonOption,1,4);


        sceneMenu = new Scene(root, 300, 250);
 //       sceneMenu.getStylesheets().add(getClass().getResource("stylePacman.css").toExternalForm());

        // Page de jeu

        GridPane game = new GridPane();

        Partie p1 = new Partie();
        int x;

        for (int i = 0; i < 22; i++) {
            for (x = 0; x<22;x++) {
                Entites actualEntite = p1.getGrille()[i][x];
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
                }
                else{
                    FileInputStream inputN = new FileInputStream("externes/images/FOND_NOIR.png");
                    Image img = new Image(inputN,20,20 ,true,true);
                    iv.setImage(img);
                }
                game.add(iv, i, x);
            }
        }
        //Scene scene = new Scene(game, 440, 440);
        //stage.setScene(scene);


        tabFantome = p1.getFantome();

        game.add(tabFantome[0].getFantome(), tabFantome[0].getSpawnX(), tabFantome[0].getSpawnY());
        game.add(tabFantome[1].getFantome(), tabFantome[1].getSpawnX(), tabFantome[1].getSpawnY());
        game.add(tabFantome[2].getFantome(), tabFantome[2].getSpawnX(), tabFantome[2].getSpawnY());
        game.add(tabFantome[3].getFantome(), tabFantome[3].getSpawnX(), tabFantome[3].getSpawnY());



        Label label1 = new Label("Ici ce trouvera la page de jeu ");
        VBox layout = new VBox();

        Button buttonJeu= new Button("Menu principale");
        buttonJeu.setOnAction(e -> primaryStage.setScene(sceneMenu));
        layout.getChildren().addAll(label1,buttonJeu);
        sceneJeu = new Scene(game,500,550);

        //  Page Record







        Label label2= new Label("Ici sera la scène record ");
        Button button2= new Button("Menu principale");
        button2.setOnAction(e -> primaryStage.setScene(sceneMenu));
        VBox layout2= new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        sceneRecord= new Scene(layout2,300,250);



     //   sceneMenu.getStylesheets().add(getClass().getResource("stylePacman.css").toExternalForm());
 //       final URL cssURL = getClass().getResource("stylePacman.css");
        System.out.println(getClass().getResource("menuPrincipal.png"));
 //       assert cssURL != null;
    //    sceneMenu.getStylesheets().add(cssURL.toExternalForm());
        primaryStage.setScene(sceneMenu);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}