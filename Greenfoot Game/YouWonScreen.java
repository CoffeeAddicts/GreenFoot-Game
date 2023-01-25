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
    
    GreenfootSound backgroundMusic = new GreenfootSound("youwin.mp3");
    int stagestart = 1;
    
    public YouWonScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        
        PlayAgain button = new PlayAgain();
        addObject(button,490,390);
    
}
    public void act()
    {
        //If button pressed then moves the user to Level One starting the game over
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