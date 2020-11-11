import java.util.List;

// imports Actor, World, Greenfoot, GreenfootImage
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.Greenfoot;

/**
 * Ac
 * 
 */
public abstract class MovingActor extends Entity {


    
    private GreenfootImage imageRight;
    private GreenfootImage imageLeft;
    

    /**
     * Erzeuge einen Hasen
     */
    public MovingActor() {
        imageRight = new GreenfootImage(getImage());
        imageLeft = new GreenfootImage(getImage());
        this.currentImage = imageRight;
        imageLeft.mirrorVertically();

        setImageRotationAndImage(Direction.RIGHT);
    }
    

     /**
     * Der Hase bewegt sich nach oben!
     * 
     */
    public void moveUp(){
        this.setDirection(Direction.UP);
        this.move();
    }
    
    /**
     * Der Hase bewegt sich nach Links.
     */
    public void moveLeft(){
        this.setDirection(Direction.LEFT);
        this.move();
    }
    /**
     * Der Hase bewegt sich nach rechts!
     */
    
    public void moveRight(){
        this.setDirection(Direction.RIGHT);
        this.move();
    }
    
    
    /**
     * Der Hase bewegt sich nach unten.
     */
    public void moveDown(){
        this.setDirection(Direction.DOWN);
        this.move();
    }    
    public void move(){
        if (this.canMove()){
            move(1);
        }
    }

    /**
     * Überprüft ob der Hase einen Schritt nach vorne laufen kann ohne auf ein Hindernis (Wand/Stein) zu treffen.
     */
    public boolean canMove(){
        return canMove(1);
    }

    /**
     * Überprüft, ob sich in distance Schritten vor dem Hasen kein Hindernis (Wand/Stein) befindet. 
     */
    public boolean canMove(int distance) {
        World myWorld = getWorld();
        int x = getNextX(distance);
        int y = getNextY(distance);

        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        } else if (x < 0 || y < 0) {
            return false;
        }

        List<BlockingObject> rocks = myWorld.getObjectsAt(x, y, BlockingObject.class);
        if (rocks.isEmpty()) {
            return true;
        }

        return false;

    }

    /**
     * Returns the x coordinate of the next field, 
     * that lays <b>distance</b> steps in the current direction.
     */
    public int getNextX(int distance) {
        int x = getX();
        switch (this.localRotation) {
        case RIGHT:
            x = x + distance;
            break;
        case LEFT:
            x = x - distance;
            break;
        }
        return x;
    }

    
    /**
     * Returns the y coordinate of the next field, 
     * that lays <b>distance</b> steps in the current direction.
     */
    public int getNextY(int distance) {

        int y = getY();
        switch (localRotation) {
        case DOWN:
            y = y + distance;
            break;
        case UP:
            y = y - distance;
            break;
        }
        return y;
    }

    



    /**
     * Tu, was ein Hase so tut
     */
    public void act() {
        super.act();
    }
   
    
}
