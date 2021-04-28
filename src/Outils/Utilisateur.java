package Outils;

import java.util.logging.Level;
import java.util.logging.Logger;

import Jeu.Partie;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Utilisateur {
    public static void addEvents(Stage stage, Partie g) {
        stage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent event)
            {
                //goes up
                if(event.getCode() == KeyCode.UP)
                {



                }
                //goes down
                else if(event.getCode() == KeyCode.DOWN)
                {

                }
                // goes right
                else if(event.getCode() == KeyCode.RIGHT)
                {

                }
                // goes left
                else if(event.getCode() == KeyCode.LEFT)
                {

                }
            }
        });
    }

}
