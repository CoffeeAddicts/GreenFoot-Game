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
    //Initalises global variables
    GreenfootSound backgroundMusic = new GreenfootSound("youlose.mp3");
    int stagestart = 1;
    PlayAgain button = new PlayAgain();
    
    public GameOverScreen()
    {    
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        
        
        addObject(button,500,340);
    }
    public void act()
    {
        //If button pressed then moves the user to Level One starting the game over
        if (Greenfoot.mousePressed(button))
        {
            Greenfoot.setWorld(new Level_One()); 
        }
        
        //Starts the music
        if (stagestart == 1);
        {
            backgroundMusic.playLoop();
        }
    }
}
