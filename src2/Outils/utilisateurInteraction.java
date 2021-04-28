package Outils;




import java.util.logging.Level;
import java.util.logging.Logger;

import Jeu.Partie;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class utilisateurInteraction
{
    public static void addEvents(Stage currentStage, Partie partie)
    {
        currentStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent event)
            {
                //goes up
                if(event.getCode() == KeyCode.UP)
                {

                       // if(partie.getState().getPacman().isTravellable(Direction.HAUT))
                        //{
                       //     partie.setDirection(Direction.HAUT);
                       // }
                       // else
                       // {
                       //     partie.setLastTriedDirection(Direction.HAUT);
                       // }
                }
                //goes down
                else if(event.getCode() == KeyCode.DOWN)
                {

                        //if(partie.getState().getPacman().isTravellable(Direction.HAUT))
                       // {
                        //    partie.setDirection(Direction.HAUT);
                       // }
                        //else
                       // {
                         //   partie.setLastTriedDirection(Direction.HAUT);
                        //}

                }
                // goes right
                else if(event.getCode() == KeyCode.RIGHT)
                {
                        //if(partie.getState().getPacman().isTravellable(Direction.DROITE))
                        //{
                        //    partie.setDirection(Direction.DROITE);
                      //  }
                        //else
                        //{
                       //     partie.setLastTriedDirection(Direction.DROITE);
                        //}

                }
                // goes left
                else if(event.getCode() == KeyCode.LEFT)
                {

                        //if(partie.getState().getPacman().isTravellable(Direction.GAUCHE))
                        //{
                            //partie.setDirection(Direction.GAUCHE);
                        //}
                        //else
                        //{
                        //    partie.setLastTriedDirection(Direction.GAUCHE);
                       // }
                }
            }
        });
    }

}