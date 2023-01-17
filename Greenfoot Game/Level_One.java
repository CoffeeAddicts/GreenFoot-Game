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
    
  
        
    public Level_One()
    {   
        super(WIDE, HIGH, CELL, false); 

        
        
        Actor ghost = new Ghost();
        addObject(ghost,75,760);
        
        
        Actor enemy = new Enemy();
        addObject(enemy,getWidth(),getHeight()/2);
        
        CreatePlatforms();
    
        
        
    }
    
    public void CreatePlatforms()
    {
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
        
    }
    

}


