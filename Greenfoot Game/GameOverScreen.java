import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{

    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    
    GreenfootSound backgroundMusic = new GreenfootSound("youlose.mp3");
    int stagestart = 1;
    
    public GameOverScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        
        PlayAgain button = new PlayAgain();
        addObject(button,500,340);
    }
    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new Level_One()); 
        }
        if (stagestart == 1);
        {
            backgroundMusic.playLoop();
        }
    }
}
