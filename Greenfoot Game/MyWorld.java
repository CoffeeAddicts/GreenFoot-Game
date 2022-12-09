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
    public static final int WIDE = 800;
    public static final int HIGH = 600;
    public static final int CELL = 1;
    
  
        
    public MyWorld()
    {   
        super(WIDE, HIGH, CELL, false); 

        
        
        Actor car = new Car();
        addObject(car,getWidth()/2,getHeight()/2);
        
        Actor floor = new Floor();
        addObject(floor,getWidth()/2,getHeight());
        
        Actor platform = new Platform();
        addObject(platform,getWidth()-100,getHeight()-100);
        
        
        
    }
    
    public void act()
    {
        
    }
    

}
