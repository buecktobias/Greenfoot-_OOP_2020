    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Entity here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public abstract class Entity extends Actor
    {
        public GreenfootImage currentImage;
        public GreenfootImage imageRight;
        public GreenfootImage imageLeft;
        public Direction localRotation; // aktuelle Richtung
        
        public Entity(){
            this.currentImage = new GreenfootImage(this.getImage());
            this.imageRight = new GreenfootImage(this.getImage());
            this.imageLeft = new GreenfootImage(this.getImage());
            this.setDirection(Direction.RIGHT);
        }
        /**
         * Act - do whatever the Entity wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act() 
        {
            // Add your action code here.
        }
             /**
         * Gibt den Text über dem Character aus.
         */
        public void say(boolean text){
            say(String.valueOf(text));
        }
        
         /**
         * Gibt den Text über dem Character aus.
         */
        public void say(int text){
            say(String.valueOf(text));
        }
        
         /**
         * Gibt den Text über dem Character aus.
         */
        public void say(double text){
            say(String.valueOf(text));
        }
        
        /**
         * Gibt den Text über dem Character aus.
         */
        public void say(String text){
            int y = getY() - 1;
            if (y < 0){
                y = 1;
            }
            getWorld().showText(text, getX(), y);
            System.out.println("a " + this.getClass().getName() + " says: " + text); 
            Greenfoot.delay(1);
        }
        
        /**
        * Liefert das Objekt vom Typ RabbitWorld in dem der Hase sich befindet.
        **/
        public RabbitWorld getRabbitWorld(){
            return getWorldOfType(RabbitWorld.class);
        }
        
        public void setImage(GreenfootImage image){
            currentImage = image;
            super.setImage(new GreenfootImage(currentImage));
        }
        /**
         * Der Hase verändert die Blickrichtung
         */
        public void setDirection(Direction direction){
            this.setImageRotationAndImage(direction);
        }
            /**
         * Setze Richtung des Hasen.
         */
        public void setImageRotationAndImage(Direction direction) {
            this.localRotation = direction;
            switch (direction) {
            case DOWN:
                setImage(imageRight);
                setRotation(90);
                break;
            case RIGHT:
                setImage(imageRight);
                setRotation(0);
                break;
            case UP:
                setImage(imageLeft);
                setRotation(-90);
                break;
            case LEFT:
                setImage(imageLeft);
                setRotation(180);
                break;
            default:
                break;
            }
        }
        
        /**
         * Zeichnet den übergebenen Text auf das aktuelle Bild der Figur.
     */
    public void draw(String text){
        super.setImage(new GreenfootImage(currentImage));
        this.setDirection(Direction.RIGHT);
        switch(this.localRotation){
            case UP:
                getImage().drawString(text, 0, 10);
                break;
            case RIGHT:
                getImage().drawString(text, 0, 10);
                break;
            case LEFT:
                getImage().drawString(text, 0, 50);
                break;
        }
        
    }
    
    /**
     * Zeichnet den Wert auf das aktuelle Bild der Figur.
     */
    public void draw(int value){        
        draw(String.valueOf(value));
    }
}
