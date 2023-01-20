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
    
    GreenfootSound backgroundMusic = new GreenfootSound("stage1.wav");
    /**
     * For some reason, the background music wouldn't play the same way
     * as the sound effects that play when the blob picks up items or 
     * jumps. Only way to get it to play was to declare it like so
     */
    
    SimpleTimer tim = new SimpleTimer(); //Creates a timer
    Counter CountDown = new Counter(); //Creates the yellow counter
    CounterP JewelCount = new CounterP(); //Creates the purple counter
    int start = 1;
    int stagestart = 1;
    //These two int variables help out with starting the timer and
    //Playing the background music
    Ghost ghost = new Ghost();
        
    public Level_One()
    {   
        super(WIDE, HIGH, CELL, false); 

        addObject(ghost,75,760);
        
        addObject(CountDown,80,50);
        CountDown.setValue(60);
        getBackground().drawImage(new GreenfootImage("TIME", 30, Color.WHITE, null), 50, 10);
        addObject(JewelCount,180,50);
        JewelCount.setValue(0);
        getBackground().drawImage(new GreenfootImage("JEWELS", 30, Color.WHITE, null), 140, 10);
        //Declares the values of the counters
        
        CreatePlatforms();
        PlaceJewels();
        PlaceClocks();
        PlaceEnemies();
        PlacePotions();
        

    }
    
    public void PlacePortal()
    {
        
        PortalToNextLvl portal = new PortalToNextLvl();
        addObject(portal,35,120);
 
    }
    
    public void PlaceClocks()
    {
        Clock clock = new Clock();
        addObject(clock,325,750);
        
        Clock clock2 = new Clock();
        addObject(clock2,900,215);
    }
    
    public void PlaceEnemies()
    {
        Enemy enemy = new Enemy(425,525,1,0,0);
        addObject(enemy,475,580);
    }
    
    public void TimeDisplay()
    {
        TIMEDISPLAY time = new TIMEDISPLAY();
        addObject(time,80,20);
    }
    
    public void PlacePotions()
    {
        Potion potion = new Potion();
        addObject(potion,35,120);
    }
    
    public void PlaceJewels()
    {
             /**
             *This function creates jewels on preset coordinates
             */
            
        Jewel jewel = new Jewel();
        addObject(jewel,200,720);
        
        Jewel jewel2 = new Jewel();
        addObject(jewel2,325,620);
        
        Jewel jewel3 = new Jewel();
        addObject(jewel3,50,400);
        
        Jewel jewel4 = new Jewel();
        addObject(jewel4,900,750);
        
        Jewel jewel5 = new Jewel();
        addObject(jewel5,650,150);
    }
    
    public void CreatePlatforms()
    {
            /**
             *This function creates platfroms on preset coordinates
             */
        
        BetterPlatform firstBox = new BetterPlatform(100,50,0,0,0,0,0);
        addObject(firstBox,200,775);
        
        BetterPlatform firstPlat = new BetterPlatform(150,30,0,0,0,0,0);
        addObject(firstPlat,325,675);
        
        BetterPlatform bigBox = new BetterPlatform(150,150,0,0,0,0,0);
        addObject(bigBox,475,675);
        
        BetterPlatform secondPlat = new BetterPlatform(150,30,0,0,0,0,0);
        addObject(secondPlat,675,650);
        
        BetterPlatform elevator = new BetterPlatform(200,30,0,0,2,250,620);
        addObject(elevator,900,615);
        
        BetterPlatform firstHighPlat = new BetterPlatform(300,30,0,0,0,0,0);
        addObject(firstHighPlat,600,300);
        
        BetterPlatform firstMovingWall = new BetterPlatform(30,100,465,700,1,0,0);
        addObject(firstMovingWall,650,235);
        
        BetterPlatform firstHighMovingPlat = new BetterPlatform(100,30,200,375,1,0,0);
        addObject(firstHighMovingPlat,350,250);
        
        BetterPlatform portalPlat = new BetterPlatform(150,200,0,0,0,0,0);
        addObject(portalPlat,50,250);
        
        BetterPlatform jumpPotPlat = new BetterPlatform(100,30,0,0,0,0,0);
        addObject(jumpPotPlat,50,450);
        
    }
    public void act()
    {
        if (start == 1)
        {
            if(JewelCount.getValue() == 5) PlacePortal();
            
            if (tim.millisElapsed() > 1000)
            {
                CountDown.add(-1);
                tim.mark();
            }
            /**
             * Greenfoot seems to only count in milliseconds rather than
             * seconds. With this, every time it passes 1000 milliseconds
             * (1 second) it will add -1 to the value of 60 which will
             * make it count down
             */
            if (CountDown.getValue() == 0)
            {
                ghost.DeathScreenLevelOne();
            }
            /**
             * This constantly checks the value of the timer. As soon as it
             * hits 0 however, the game will go to the game over screen
             */
            if (stagestart == 1)
            {
                backgroundMusic.playLoop();
            }
            /**
             * This starts the music. The reason why this is under the act
             * method and not under the world constructor is because placing 
             * it there would make the music play constantly even if we 
             * didn't click start. Whilst it is playing music as intended
             * This would've been incredibly annoying to us as developers
             * if we're having to listen to it constantly whilst working on
             * the game
             */
        }   
    }
    public void IncrementJewel()
    {
        JewelCount.add(1);
    }
    public void IncrementClock()
    {
        CountDown.add(10);
    }
    public void SetStageStart(int newStageStart)
    {
        stagestart = newStageStart;
        backgroundMusic.stop();
    }
}


