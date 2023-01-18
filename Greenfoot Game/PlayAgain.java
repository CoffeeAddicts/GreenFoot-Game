import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgain extends Actor
{
    /**
     * Act - do whatever the PlayAgain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public PlayAgain()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());  
    }
    
    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
                Greenfoot.setWorld(new Level_One()); 
        }
        }
    }
    

