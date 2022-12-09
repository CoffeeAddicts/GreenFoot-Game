import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int vSpeed = 0;
    final double GRAVITY = 1;
    public void act()
    {
        setGravity();
        moveAround();
        

    }
    public void setGravity()
    {
        Actor floor = getOneIntersectingObject(Floor.class);
        Actor floor2 = (Actor) getWorld().getObjects(Floor.class).get(0);
        
        if(!isTouching(Floor.class))
        {        
            vSpeed += GRAVITY;
            setLocation(getX(), getY()+ (vSpeed/2));
        }
        else
        {
            vSpeed = 0;   
            setLocation(getX(),floor2.getY()-60);
        }
    }
        public void moveAround()
    {
        if(Greenfoot.isKeyDown("s"))
        setLocation(getX(),getY()+3);
        if(Greenfoot.isKeyDown("w"))
        setLocation(getX(),getY()-10);
        if(Greenfoot.isKeyDown("a"))
        setLocation(getX()-3,getY());
        if(Greenfoot.isKeyDown("d"))
        setLocation(getX()+3,getY());
    }

}
