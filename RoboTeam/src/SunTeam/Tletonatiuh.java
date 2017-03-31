
package SunTeam;

import java.awt.Color;
import robocode.*;
import java.io.IOException;
import java.util.Hashtable;

public class Tletonatiuh extends TeamRobot{
    
    double energy;
   // String[] compañeros;
    double altura_tablero;
    double ancho_tablero;
    //double[] coordXY;
    double X;
    Hashtable<String, double[]> compis_coordXY;
    
    @Override
    public void run() {
        // Initialization of the robot should be put here
        setColors(Color.yellow, Color.red, Color.white);
        while(true) {
                // Replace the next 4 lines with any behavior you would like
                inicializarRobot();
                //String[] compis = getTeammates();
                compartirPosicion();
                ahead(100);
                turnGunRight(360);
                back(100);
                turnGunRight(360);
        }
    }
    
    public Tletonatiuh(){
        //compañeros = getTeammates();
        //altura_tablero = getBattleFieldHeight();
        //ancho_tablero = getBattleFieldWidth();
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
    
    public void compartirPosicion(){
        //obtenerPosicion();
        try{
            if(getTeammates() == null)
                out.print("Ningún compañero encontrado");
            else{
                for(String compi: getTeammates()){
                    //sendMessage(compi, coordXY);
                    sendMessage(compi, getX());
                }
            }
        } catch(IOException e){
            out.println("Ningún compañero encontrado");
        }
    }
    
    @Override
    public void onMessageReceived(MessageEvent event){
        //double[] XY = innerArray.getDouble((String) event.getMessage());
        //double[] A = (event.getMessage()).getArray();
        //double[] A;
        //A = double[] SerializationUtils.deserialize(double[] e);
        //compis_coordXY.put(event.getSender(), event.getMessage());
        out.println(event.getMessage());
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
            // Replace the next line with any behavior you would like
            fire(1);
    }

    @Override
    public void onHitByBullet(HitByBulletEvent e) {
            // Replace the next line with any behavior you would like
            back(10);
    }

    @Override
    public void onHitWall(HitWallEvent e) {
            // Replace the next line with any behavior you would like
            back(20);
    }
        
}