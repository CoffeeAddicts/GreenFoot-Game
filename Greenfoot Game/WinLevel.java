import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_Two here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinLevel extends World
{
    public static final int WIDE = 1000;
    public static final int HIGH = 800;
    public static final int CELL = 1;
    
    GreenfootSound backgroundMusic = new GreenfootSound("stage2.mp3");
    int stagestart = 1;
    Ghost ghost = new Ghost();
    
    public WinLevel()
    {    
        super(WIDE, HIGH, CELL, false); 

        addObject(ghost,75,760);
        CreatePlatforms();
        CreateCookie();
        
        
        //Declares the values of the counters
    }
    public void SetStageStart(int newStageStart)
    {
        stagestart = newStageStart;
        backgroundMusic.stop();
    }
    public void CreateCookie()
    {
        Cookie cookie = new Cookie();;
        addObject(cookie,850, 475);
    }
    public void CreatePlatforms()
    {
            /**
             *This function creates platfroms on preset coordinates
             */
        
            
            
        BetterPlatform box1 = new BetterPlatform(800,50,0,0,0,0,0);
        addObject(box1,600,775);
        BetterPlatform box2 = new BetterPlatform(800,50,0,0,0,0,0);
        addObject(box2,650,725);
        BetterPlatform box3 = new BetterPlatform(800,50,0,0,0,0,0);
        addObject(box3,700,675);
        BetterPlatform box4 = new BetterPlatform(800,50,0,0,0,0,0);
        addObject(box4,750,625);
        BetterPlatform box5 = new BetterPlatform(800,50,0,0,0,0,0);
        addObject(box5,800,575);
        BetterPlatform box6 = new BetterPlatform(800,50,0,0,0,0,0);
        addObject(box6,850,525);
        
    }
    
    public void act()
    {
       if (stagestart == 1)
        {
            backgroundMusic.playLoop();
        }     
    }

}
