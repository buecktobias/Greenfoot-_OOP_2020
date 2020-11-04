    import greenfoot.*;
    import java.util.List;
    
    public class PlayerRabbit extends MovingActor {
    
    //Attribute
    
    
    
    //Konstruktoren
    
    
    //Methoden
    /**
     * Wird einmal pro Zeiteinheit aufgerufen
     */
    public void act() {
        performMovement();
    }
    
    public void setDirection(int direction){
        this.setImageRotationAndImage(direction);
    }
    
    public void moveUp(){
        this.setDirection(Direction.UP);
        this.move();
    }
    
    public void moveLeft(){
        this.setDirection(Direction.LEFT);
        this.move();
    }
    
    public void moveRight(){
        this.setDirection(Direction.RIGHT);
        this.move();
    }
    public void moveDown(){
        this.setDirection(Direction.DOWN);
        this.move();
    }
    //TODO: Steuerung über die Tasten W - A - S - D realisieren
    private void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            this.moveUp();
        }if(Greenfoot.isKeyDown("A")){
            this.moveLeft();
        }if(Greenfoot.isKeyDown("D")){
            this.moveRight();
        }if(Greenfoot.isKeyDown("S")){
           this.moveDown();
        }
    }
    
    
     /**
     * moves one step forward
     */
    public void move(){
        move(1);
    }

}
