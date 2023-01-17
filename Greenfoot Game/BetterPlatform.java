import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BetterPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BetterPlatform extends Actor
{
    private int speed = 4;
    private int leftTurn = 270;
    private int rightTurn = 480;

    public BetterPlatform(){
        this(100, 25);
    }
    public BetterPlatform(int width, int height) 
    {
        GreenfootImage image = getImage();
        image.scale(width,height);
        setImage(image);
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
