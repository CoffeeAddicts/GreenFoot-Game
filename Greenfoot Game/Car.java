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
    
    private static final int speed = 7;
    private int vSpeed = 0;
    private static final int acceleration = 2;
    private static final int jumpStrength = 30;
    
    public void act()
    {
        checkKeys();   
        checkFall();
    }
    
    public void fall()
    {
        setLocation(getX(),getY()+vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    private void checkKeys()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            setImage("blob_right-removebg-preview.png");
            moveRight();
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setImage("blob_left-removebg-preview.png");
            moveLeft();
        }
        if(Greenfoot.isKeyDown("w"))
        {
            if(onGround())
            {
                jump();
            }
        }
    }
    public void jump()
    {
        setVSpeed(-jumpStrength);
        fall();
    }
    public void setVSpeed(int speed)
    {
        vSpeed = speed;
    }
    private void checkFall()
    {
        if(onGround())
        {
            setVSpeed(0);
        }
        else
        {
            fall();
        }
    }
    public boolean onGround()
    {
        Object under = getOneObjectAtOffset(0,getImage().getHeight()/2-8,null);
        return under != null;
    }

    public void moveRight()
    {   
        setLocation(getX() + speed, getY());
    }
    public void moveLeft()
    {
        setLocation(getX() - speed, getY());
    }
    

}
