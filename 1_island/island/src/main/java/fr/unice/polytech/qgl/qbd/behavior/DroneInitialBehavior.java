package fr.unice.polytech.qgl.qbd.behavior;

import fr.unice.polytech.qgl.qbd.GameState;
import fr.unice.polytech.qgl.qbd.actions.Action;
import fr.unice.polytech.qgl.qbd.driver.DroneDriver;
import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.gameObject.map.Coords;
import fr.unice.polytech.qgl.qbd.gameObject.map.DroneMap;
import fr.unice.polytech.qgl.qbd.results.EchoResult;
import fr.unice.polytech.qgl.qbd.results.Result;


/*
 * Un état qui scanne les dimensions de la map avant de passer à un autre état
 * Après avoir effectuer les 3 premier echos,
 * les utilise pour créer la carte
 *
 * Résultat :
 * La carte est créée
 * La position est initialisé
 *
 */
public class DroneInitialBehavior extends Behavior {
    private Direction initialHeading;
    private DroneDriver driver;
    private int relativeWidth;
    private int relativeHeight;
    //Relative positions
    private int relX;
    private int relY;

    public DroneInitialBehavior(GameState game, DroneDriver d, Direction initialHeading) {
        super(game);
        this.initialHeading = initialHeading;
        relativeWidth = relativeHeight = relX = relY =  0;
        driver = d;
        //Deux echos initiaux
        driver.addInformations(Action.INFO.MISC, "echoLeft");
        driver.echoLeft();
        driver.addInformations(Action.INFO.MISC, "echoRight");
        driver.echoRight();
    }

    @Override
    public void makeAction() {
        //Si on est apparu dans un coin, avancement d'une case pour le Behavior suivant
        if (relX == 0 || relX == relativeWidth - 1){
            driver.fly();
            ++relY;
        }
        //Si on est apparu a 1 case d'un coin, mouvements à faire pour se coller au bord
        else if (relX == 1){
            driver.turnRight();driver.turnLeft();driver.turnLeft();
            driver.fly();driver.turnRight();
            relY += 4;
            relX = 0;

        }else if (relX == relativeWidth - 2){
            driver.turnLeft();driver.turnRight();driver.turnRight();
            driver.fly();driver.turnLeft();
            relY += 4;
            relX = relativeWidth - 1;
        }
        //Sinon on est apparu plus vers le milieu du bord et on va chercher un bord
        //On va vers le bord le plus proche
        //Gauche
        else if (relX < relativeWidth / 2){
            driver.turnLeft();
            --relX;
            while (relX-- > 1)
                driver.fly();
            driver.turnRight();
            relY = 2;
            relX = 0;
        }
        //Droite
        else{
            driver.turnRight();
            ++relX;
            while (relX++ < relativeWidth - 2)
                driver.fly();
            driver.turnLeft();
            relY = 2;
            relX = relativeWidth - 1;
        }
        driver.addInformations(Action.INFO.MISC, "echoFront");
        driver.echoFront();
    }

    @Override
    public Behavior acknowledgeResults(Result result) {
        Action a = result.getAction();
        if (a.getName() == Action.NAME.ECHO){
            EchoResult echo = (EchoResult) result;
            String information = a.getInformation(Action.INFO.MISC);
            if (information.equals("echoLeft")){
                relativeWidth += echo.getRange();
                relX = echo.getRange();
            }else if (information.equals("echoRight")){
                relativeWidth += echo.getRange() + 1;
            }else if (information.equals("echoFront")){
                relativeHeight = echo.getRange() + relY + 1;
                //On a fini ce behavior, on prépare le suivant
                game.setMap(new DroneMap(initialHeading, relativeWidth, relativeHeight));
                int x, y;
                switch (initialHeading){
                    case N:
                        x = relX;
                        y = relativeHeight - relY - 1;
                        break;
                    case E:
                        x = relY;
                        y = relX;
                        break;
                    case S:
                        x = relativeWidth - relX - 1;
                        y = relY;
                        break;
                    default:
                        x = relativeHeight - relY - 1;
                        y = relativeWidth - relX - 1;
                        break;
                }
                return new DroneEchoBehavior(game, new DroneDriver(
                        driver,
                        initialHeading,
                        new Coords(x, y),
                        game.getMap().getWidth(),
                        game.getMap().getHeight()
                )
                );
            }
        }

        return this;
    }
}
