import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int speed = 4;
    private int leftTurn = 270;
    private int rightTurn = 480;
    
    Platform()
    {
        getImage().scale(100, 30);
    }
    public void act()
    {
        setLocation(getX() + speed,getY());
        Actor actor = getOneIntersectingObject(null);
        if(actor!=null)
        {
            actor.setLocation(actor.getX()+speed,actor.getY());
        }
            
        if(atTurningPoint())
        {
            speed = -speed;
        }   
    }
    
    public boolean atTurningPoint()
    {
        return (getX() <= leftTurn || getX() >= rightTurn);
    }
}
    
    
