    import greenfoot.*;
    import java.util.List;
    
public class PlayerRabbit extends MovingActor {
    // KEYS
    private final String MOVE_LEFT_KEY = "A";
    private final String MOVE_RIGHT_KEY = "D";
    private final String MOVE_UP_KEY = "W";
    private final String MOVE_DOWN_KEY = "S";
    private final String PUT_CARROT_KEY = "P";
    
    private final int MAX_CARROTS = 20;
    public int currentCarrotCount = MAX_CARROTS;
    
    //Attribute
    private int life;
    
    
    //Konstruktoren
    public PlayerRabbit(){
       this.life = 100;
    }
    
    public PlayerRabbit(int newLife){
       this.life = newLife;
    }
    
    //Methoden
    /**
     * Wird einmal pro Zeiteinheit aufgerufen
     */
    public void act() {
        this.listenToKeys();
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
    
    public void putCarrot(){
        if (this.currentCarrotCount > 0){
            Carrot newCarrot = new Carrot();
            this.currentCarrotCount--;
            this.getWorld().addObject(newCarrot, this.getX(), this.getY());
        }
    }
    
    private void listenToKeys(){
        this.performMovement();
        if (Greenfoot.isKeyDown(this.PUT_CARROT_KEY)){
            this.putCarrot();
        }
    }
    //TODO: Steuerung über die Tasten W - A - S - D realisieren
    private void performMovement() {
        if (Greenfoot.isKeyDown(this.MOVE_UP_KEY)) {
            this.moveUp();
        }if(Greenfoot.isKeyDown(this.MOVE_LEFT_KEY)){
            this.moveLeft();
        }if(Greenfoot.isKeyDown(this.MOVE_RIGHT_KEY)){
            this.moveRight();
        }if(Greenfoot.isKeyDown(this.MOVE_DOWN_KEY)){
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
