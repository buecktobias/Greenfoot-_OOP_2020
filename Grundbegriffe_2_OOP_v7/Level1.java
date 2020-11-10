import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RabbitLevel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends RabbitWorld
{

    /**
     * Constructor for objects of class RabbitLevel1.
     * 
     */
    public Level1()
    {
        super();
        PlayerRabbit rabbit = new PlayerRabbit(5, 3);
        this.addObject(rabbit, 4, 4);
        
        Rock newRock = new Rock();
        this.addObject(newRock, 5, 2);
        
        Rock newRock2 = new Rock();
        this.addObject(newRock2, 2, 2);
        
        /*zu Aufgabe1: 
         * b)  Erzeuge einen neuen Fels (Rock). Platziere den Fels auf (5, 5).
         * c)  Erstelle eine Karotte (Carrot) und platziere sie auf dem Feld (1, 5).
         * d)  Erstelle eine weitere Karotte mit dem Gewicht 3, hierzu muss ein anderer Konstruktor aufgerufen werden. Platziere sie auf dem Feld (1, 6).
         * e)  Fülle die komplette 7. Spalte der Welt Level1 mit Felsen auf.
           */

    
        
    }
    
}
