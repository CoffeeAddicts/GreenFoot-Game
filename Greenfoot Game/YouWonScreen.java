import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouWonScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWonScreen extends World
{

    /**
     * Constructor for objects of class YouWonScreen.
     * 
     */
    public YouWonScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
    
}
    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new Level_One()); 
        }
    }
}