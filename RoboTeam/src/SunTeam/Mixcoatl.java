
package SunTeam;
import java.io.IOException;
import java.util.Hashtable;
import robocode.*;

public class Mixcoatl extends TeamRobot{
    
    double energy;
    //String[] compañeros;
    double altura_tablero;
    double ancho_tablero;
    //double[] coordXY;
    double X;
    Hashtable<String, double[]> compis_coordXY;
    
    @Override
    public void run() {
		// Initialization of the robot should be put here
                
        while(true) {
            // Replace the next 4 lines with any behavior you would like
            inicializarRobot();
            String[] compis = getTeammates();
            compartirPosicion(compis);
            ahead(100);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
        }
    }
    
    public void inicializarRobot(){
        //compañeros = getTeammates();
        altura_tablero = getBattleFieldHeight();
        ancho_tablero = getBattleFieldWidth();
    }
    
    /*public void obtenerPosicion(){
        //coordXY = new double[]{ getX(), getY()};
        X = getX();
    }*/
    
    public void compartirPosicion(String[] compis){
        //obtenerPosicion();
        try{
            for(String compi: compis){
                //sendMessage(compi, coordXY);
                sendMessage(compi, getX());
            }
        } catch(IOException e){
            out.println("Ningún compañero encontrado");
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
            // Replace the next line with any behavior you would like
            fire(1);
    }

    public void onHitByBullet(HitByBulletEvent e) {
            // Replace the next line with any behavior you would like
            back(10);
    }

    public void onHitWall(HitWallEvent e) {
            // Replace the next line with any behavior you would like
            back(20);
    }
}
