import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static final int WIDE = 800;
    public static final int HIGH = 600;
    public static final int CELL = 1;
    
    SimpleTimer tim = new SimpleTimer();
    Counter CountDown = new Counter();
    int start = 1;
  
        
    public MyWorld()
    {   
        super(WIDE, HIGH, CELL, false); 

        
        
        //Actor ghost = new Ghost();
        //addObject(ghost,getWidth()/2,getHeight()/2);
        
        //Actor floor = new Floor();
        //addObject(floor,getWidth()/2,getHeight());
        
        //Actor platform = new Platform();
        //addObject(platform,getWidth()-100,getHeight()-150);
        //Actor platform2 = new Platform();
        //addObject(platform2,getWidth()-250,getHeight()-250);
        //Actor platform3 = new Platform();
        //addObject(platform3,getWidth()-350,getHeight()-350);
        
        addObject(CountDown,80,20);
        CountDown.setValue(60);
        
        Ghost ghost = new Ghost();
        addObject(ghost, 450,200);
        
        BetterPlatform plat = new BetterPlatform(150,270,200,470,1,0,0);
        addObject(plat, 450,400);
        
    }
    
    public void act()
    {
        if (start == 1)
        {
            if (tim.millisElapsed() > 1000)
            {
                CountDown.add(-1);
                tim.mark();
            }
            if (CountDown.getValue() == 0)
            {
                Greenfoot.stop();
            }
        }
    }
}
