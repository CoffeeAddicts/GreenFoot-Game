import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    

        
    public MyWorld()
    {   
        super(1000, 400, 1); 
        

        
        Actor car = new Car();
        addObject(car,getWidth()/2,getHeight()/2);
        
        Actor floor = new Floor();
        addObject(floor,getWidth()/2,getHeight());
        
        
        
    }
    
    public void act()
    {
        
    }
}
