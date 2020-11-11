import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teleporter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teleporter extends Entity
{
    private World nextWorld;
    
    public Teleporter(World nextWorld){
        this.nextWorld = nextWorld;
    }
    
    public void teleport(PlayerRabbit pr){
        this.nextWorld.addObject(pr, 0, 0);
        Greenfoot.setWorld(this.nextWorld);
    }
    
    
    /**
     * Act - do whatever the Teleporter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!this.getIntersectingObjects(PlayerRabbit.class).isEmpty()){
            PlayerRabbit pr = this.getIntersectingObjects(PlayerRabbit.class).get(0);
            this.teleport(pr);
        }
    }    
}
