import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_One here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_One extends World
{

    /**
     * Constructor for objects of class Level_One.
     * 
     */

    public static final int WIDE = 1000;
    public static final int HIGH = 800;
    public static final int CELL = 1;
    
  
        
    public Level_One()
    {   
        super(WIDE, HIGH, CELL, false); 

        
        
        Actor car = new Car();
        addObject(car,getWidth()/2,getHeight()/2);
        
        Actor floor = new Floor();
        addObject(floor,getWidth()/2,getHeight());
        
        
        
    }
    
    public void act()
    {
        
    }
    

}


