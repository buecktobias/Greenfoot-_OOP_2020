    import greenfoot.*;
    import java.util.List;
    
public class PlayerRabbit extends MovingActor {
    // KEYS
    private final String MOVE_LEFT_KEY = "A";
    private final String MOVE_RIGHT_KEY = "D";
    private final String MOVE_UP_KEY = "W";
    private final String MOVE_DOWN_KEY = "S";
    private final String PUT_CARROT_KEY = "P";
    private Car drivingCar = null;
    private int MAX_CARROTS;
    public int currentCarrotCount;
    
    //Attribute
    private int life;
    
    
    //Konstruktoren
    /**
     * Konstruktor ohne Parameter
     */
    public PlayerRabbit(){
       this.life = 100;
       this.MAX_CARROTS = 20;
       this.currentCarrotCount = this.MAX_CARROTS;
    }
    
    /**
     * Konstruktor mit Leben
     */
    public PlayerRabbit(int newLife){
       this.life = newLife;
       this.MAX_CARROTS = 20;
       this.currentCarrotCount = this.MAX_CARROTS;
    }
    /**
     * Konstruktor mit Leben und Anzahl Karotten.
     */
    public PlayerRabbit(int newLife, int maxCarrots){
        this.life = newLife;
        this.MAX_CARROTS = maxCarrots;
        this.currentCarrotCount = this.MAX_CARROTS;
    }
    
    //Methoden
    /**
     * Wird einmal pro Zeiteinheit aufgerufen
     */
    public void act() {
        this.getCar();
        this.listenToKeys();
        this.draw(this.life);
        this.drive();
    }

   
    
    /**
     * Legt eine Karotte auf den Boden
     */
    private void putCarrot(){
        if (this.currentCarrotCount > 0){
            Carrot newCarrot = new Carrot();
            this.currentCarrotCount--;
            this.getWorld().addObject(newCarrot, this.getX(), this.getY());
        }
    }
    /**
     * Reagieren auf Tasten drücke
     */
    private void listenToKeys(){
        this.checkMovementKeys();
        if (Greenfoot.isKeyDown(this.PUT_CARROT_KEY)){
            this.putCarrot();
        }
    }
    private void getCar(){
        if(!this.getIntersectingObjects(Car.class).isEmpty()){
            Car c = this.getIntersectingObjects(Car.class).get(0);
            this.drivingCar = c;
        }
    }
    private void drive(){
        if (this.drivingCar != null){
            this.drivingCar.setLocation(this.getX(), this.getY());
        }
    }
    //TODO: Steuerung über die Tasten W - A - S - D realisieren
    /**
     *  Steuerung mit den Tasten
     */
    private void checkMovementKeys() {
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
    


}
