import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        
        //se crea el cohete en el mundo y se posiciona en ciertas coordenadas
        Cohete n1= new Cohete();
        //addObject es una funcion de greenfoot que crea un
        //objeto y lo posiciona
        addObject (n1,70,300);
        
        //llama al metodo crearMeteoros que con un ciclo for va
        //creando N numero de meteoros
        crearMeteoros (4);
    }
    
    //Metodo o Funcion crear meteoros
    public void crearMeteoros (int numero) {
        int zonaPeligro = getWidth() / 2;
        
        //inicia un ciclo que se repite el numero de veces que se 
        //especifique en el metodo
        for (int i=0; i<numero;i++) {
            //crea el objeto meteoro
            Meteoro met= new Meteoro();
            //se inicializan variables x,y con una funcion de
            //generacion de numeros aleatorios, es decir esas
            //variables cada vez que se ejecute el metodo
            //tendran un numero aleatorio diferente
            int x=Greenfoot.getRandomNumber (zonaPeligro) + zonaPeligro; //se hace que las coordenadas de x solo se generen
                                                                         //despues de la mitad de la pantalla
            int y=Greenfoot.getRandomNumber (getWidth());
            
            //crea una variable que guarda la velocidad del meteorito, esta velocidad será aleatoria para cada meteoro
            int velocidad = Greenfoot.getRandomNumber(5) + 1;
            
            // Ajusta la velocidad del meteoro
            met.setSpeed(velocidad);
            
            //se posiciona el objeto en las coordenadas definidas
            //por las variables x,y
            addObject (met,x,y);
        }
    }
}
