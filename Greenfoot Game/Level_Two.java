import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewLvl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_Two extends World
{
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
    
    public Level_Two()
    {    
        super(WIDE, HIGH, CELL, false); 

        addObject(ghost,75,760);
        
        addObject(CountDown,80,50);
        CountDown.setValue(60);
        getBackground().drawImage(new GreenfootImage("TIME", 30, Color.WHITE, null), 50, 10);
        addObject(JewelCount,180,50);
        JewelCount.setValue(0);
        getBackground().drawImage(new GreenfootImage("JEWELS", 30, Color.WHITE, null), 140, 10);
        
        PlacePlatforms();
        PlaceJewels();
        PlaceClocks();
        PlaceEnemies();
        
        Sword sword = new Sword();
        addObject(sword, 850, 300);
        
        
    }
    public void PlaceClocks()
    {
        Clock clock = new Clock();
        addObject(clock,275,475);
        
        Clock clock2 = new Clock();
        addObject(clock2,900,400);
    }
    public void PlacePortal()
    {
        PortalToNextLvl portal = new PortalToNextLvl();
        addObject(portal,900,775);
    }
    public void PlaceEnemies()
    {
        Enemy enemy = new Enemy(425,625,3,0,0);
        addObject(enemy,475,780);
        
        Enemy enemy2 = new Enemy();
        addObject(enemy2, 950, 315);
        
        Enemy enemy3 = new Enemy(400,600,1,0,0);
        addObject(enemy3, 450, 215);
    }
    public void PlaceJewels()
    {
        Jewel jewel = new Jewel();
        addObject(jewel,200,650);
        
        Jewel jewel2 = new Jewel();
        addObject(jewel2,365,550);
        
        Jewel jewel3 = new Jewel();
        addObject(jewel3,200,275);
        
        Jewel jewel4 = new Jewel();
        addObject(jewel4,450,700);
        
        Jewel jewel5 = new Jewel();
        addObject(jewel5,650,450);
    }
    public void PlacePlatforms()
    {
        BetterPlatform firstBox = new BetterPlatform(100,30,0,0,0,0,0);
        addObject(firstBox,175,725);
        
        BetterPlatform firstPlat = new BetterPlatform(150,30,0,0,0,0,0);
        addObject(firstPlat,75,625);
        
        BetterPlatform jumpPotPlat = new BetterPlatform(100,30,0,0,0,0,0);
        addObject(jumpPotPlat,175,525);
        
        BetterPlatform bigBox = new BetterPlatform(100,290,0,0,0,0,0);
        addObject(bigBox,275,655);
        
        BetterPlatform secondPlat = new BetterPlatform(600,30,0,0,0,0,0);
        addObject(secondPlat,700,525);
        
        BetterPlatform fourthPlat = new BetterPlatform(100,30,0,0,0,0,0);
        addObject(fourthPlat,50,425);

        BetterPlatform firstHighPlat = new BetterPlatform(300,30,0,0,0,0,0);
        addObject(firstHighPlat,500,250);
        
        BetterPlatform secondHighPlat = new BetterPlatform(150,30,0,0,0,0,0);
        addObject(secondHighPlat,200,325);
        
        BetterPlatform thirdHighPlat = new BetterPlatform(300,30,0,0,0,0,0);
        addObject(thirdHighPlat,850,350);
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
                ghost.DeathScreenLevelTwo();
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
    //Allows for other classes to control the music and stop it when changing levels
    public void SetStageStart(int newStageStart)
    {
        stagestart = newStageStart;
        backgroundMusic.stop();
    }
}
