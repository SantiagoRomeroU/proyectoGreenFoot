import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Cohete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cohete extends Actor
{
    public static final int UP=0;
    public static final int DOWN=1;
    public static final int LEFT=2;
    public static final int RIGHT=3;
    
    private int vidas = 3; // Número de vidas inicial
    
    public void Cohete() {
        
    }
    /**
     * Act - do whatever the Cohete wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("up")) {
            setDireccion(UP);
        }
        if (Greenfoot.isKeyDown("down")) {
            setDireccion(DOWN);
        }
        if (Greenfoot.isKeyDown("left")) {
            setDireccion(LEFT);
        }
        if (Greenfoot.isKeyDown("right")) {
            setDireccion(RIGHT);
        }
    }
    public void setDireccion (int direccion) {
        switch (direccion) {
            //en caso de presiona hacia arriba el objeto rota 270
            case UP:
                //setRotation (270);
            //en este if se establece que si se presiona la barra
            //de espacio, el cohete acelera
            if (Greenfoot.isKeyDown("space")) {
                setLocation (getX(),getY()-10);
            } else {
                setLocation (getX(),getY()-1);
            }
            break;
            
            //en caso de presiona hacia abajo el objeto rota 90
            case DOWN:
                //setRotation (90);
            //en este if se establece que si se presiona la barra
            //de espacio, el cohete acelera
            if (Greenfoot.isKeyDown("space")) {
                setLocation (getX(),getY()+10);
            } else {
                setLocation (getX(),getY()+1);
            }
            break;
            
            //en caso de presiona hacia la izquierda el objeto rota 180
            case LEFT:
                //setRotation (180);
            //en este if se establece que si se presiona la barra
            //de espacio, el cohete acelera
            if (Greenfoot.isKeyDown("space")) {
                setLocation (getX()-10,getY());
            } else {
                setLocation (getX()-1,getY());
            }
            break;
            
            //en caso de presiona hacia la derecha el objeto rota 360
            case RIGHT:
                //setRotation (360);
            //en este if se establece que si se presiona la barra
            //de espacio, el cohete acelera
            if (Greenfoot.isKeyDown("space")) {
                setLocation (getX()+10,getY());
            } else {
                setLocation (getX()+1,getY());
            }
            break;
        }
    }
    
    public void perderVida () {
        vidas--;
        if (vidas <= 0) {
            // Si las vidas llegan a 0, se termina el juego
            Greenfoot.stop(); // Detiene el juego
            System.out.println("¡Juego terminado! Has perdido todas tus vidas.");
        }
    }
}
