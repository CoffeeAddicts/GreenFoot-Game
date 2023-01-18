import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jewel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jewel extends Actor
{
    /**
     * Act - do whatever the Jewel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Jewel()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);        
    }
    
    public void act()
    {
        // Add your action code here.
        
        // might make jewel go up and down
    }
}
