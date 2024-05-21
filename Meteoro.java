import greenfoot.*;  // Importación necesaria para Greenfoot

/**
 * Write a description of class Meteoro here.
 * Esta clase representa los meteoritos que se mueven horizontalmente por el mundo.
 * @author Tu nombre
 * @version 1.0 (fecha)
 */
public class Meteoro extends Actor
{
    private int speed = 5; // Velocidad predeterminada
    private boolean inactivo = false; // Indica si el meteoro está inactivo
    private int tiempoInactivo = 0; // Contador de tiempo inactivo
    
    /**
     * Act - do whatever the Meteoro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * Este método se llama automáticamente cuando se ejecuta el juego.
     */
    public void act()
    {
        if (!inactivo) {
            // Mueve el meteoro hacia la izquierda a una velocidad determinada
            move(-speed); 
            
            // Si el meteoro toca el borde izquierdo del mundo
            if (getX() <= 0) {
                // Reinicia su posición al borde derecho del mundo
                setLocation(getWorld().getWidth(), Greenfoot.getRandomNumber(getWorld().getHeight()));
                // Genera una nueva velocidad aleatoria para el meteoro
                speed = Greenfoot.getRandomNumber(6) + 5;
            }
            
            // Detecta colisiones con el cohete
            if (isTouching(Cohete.class)) {
                Cohete cohete = (Cohete) getOneIntersectingObject(Cohete.class);
                cohete.perderVida(); // Reduce una vida del cohete
                inactivo = true; // Marca el meteoro como inactivo
                tiempoInactivo = 300; // Establece el tiempo de inactividad en 300 actos (aproximadamente 5 segundos)
                // Establece la posición del meteoro en el borde derecho del mundo
                setLocation(getWorld().getWidth(), Greenfoot.getRandomNumber(getWorld().getHeight()));
                // Genera una nueva velocidad aleatoria para el meteoro
                speed = Greenfoot.getRandomNumber(6) + 5;
            }
        } else {
            // El meteoro está inactivo, cuenta el tiempo de inactividad
            tiempoInactivo--;
            if (tiempoInactivo <= 0) {
                inactivo = false; // Vuelve a activar el meteoro
            }
        }
    }
    
    /**
     * Establece la velocidad del meteoro.
     * @param speed La velocidad a establecer.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
