import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Actor
{
    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Sword() 
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
    }
    public void act()
    {
        // Add your action code here.
    }
}
