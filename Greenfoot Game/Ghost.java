import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestCode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    private final int GRAVITY = 1;
    private final int STEP = 3;
    private final int ABOVEOFFSET = 20;
    private int velocity;
    private int jumpStrength = 15;
    
    private boolean hasSword = false;
    

        
    
    public Ghost()
    {
        velocity = 0;
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
        
    }
    public void act()
    {     
        fall();
        if(Greenfoot.isKeyDown("w") && isOnSolidGround()) jump();
        move();
        
        PlayWorld();

        
    }
    
    public void PlayWorld()
    {
        if(this.getWorld() instanceof Level_One)
        {
            Level_One myWorld = (Level_One) getWorld();
            if(CheckPortal())LevelTwo();

            if(CheckEnemy())
            {
                DeathScreenLevelOne();
            }
            if(CheckJewel())
            {
                myWorld.IncrementJewel();
            }
            if(CheckClock())
            {
                myWorld.IncrementClock();
            }
        }
        else if (this.getWorld() instanceof Level_Two)
        {
            if(CheckPortal())WinLevel();
            Level_Two myWorld = (Level_Two) getWorld();
            if(CheckEnemy())
            {
                DeathScreenLevelTwo();
            }
            if(CheckJewel())
            {
                myWorld.IncrementJewel();
            }
            if(CheckClock())
            {
                myWorld.IncrementClock();
            }
        }
        
        if(CheckSword()) hasSword = true;
        if(CheckPotion())SetJump();
        if(CheckCookie())Win();        
    }
    public void fall()
    {
        setLocation(getX(),getY() + velocity);
        if(isOnSolidGround())
        {
            velocity = 0;
            while(isOnSolidGround())
            {
                setLocation(getX(),getY() -1);   
            }
            setLocation(getX(),getY()+1);
        }
        else if (velocity < 0 && didBumpHead())
        {
            velocity = 0;
            while(didBumpHead())
            {
                setLocation(getX(),getY() + 1);   
            }
        }
        else velocity += GRAVITY;
    }
    public void jump()
    {
        velocity = -jumpStrength;
        Greenfoot.playSound("jump.mp3");
        
    }
    public void move()
    {
        int y = getY();
        int x = getX();
        if(Greenfoot.isKeyDown("a") && canMoveLeft())
        {
            x -=STEP;
            if(hasSword)
            {
                setImage("blob_sword_left.png");
            }
            else
            {
               setImage("blob_left-removebg-preview.png"); 
            }
            
            GreenfootImage image = getImage();
            image.scale(image.getWidth()/2, image.getHeight()/2);
        }
        if(Greenfoot.isKeyDown("d")&& canMoveRight())
        {
            x +=STEP;
            if(hasSword)
            {
                setImage("blob_sword_right.png");
            }
            else
            {
               setImage("blob_right-removebg-preview.png"); 
            }
            GreenfootImage image = getImage();
            image.scale(image.getWidth()/2, image.getHeight()/2);
        }
        setLocation(x,y);
    }
    public boolean isOnSolidGround() 
    {
        boolean isOnGround = false;
        
        if(getY() > getWorld().getHeight() - ABOVEOFFSET) isOnGround = true;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth/-2,imageHeight/2,BetterPlatform.class) != null || 
        getOneObjectAtOffset(imageWidth/2,imageHeight/2,BetterPlatform.class) != null) 
        isOnGround = true;
        
        return isOnGround;
    }
    public boolean didBumpHead()
    {
        boolean bumpedHead = false;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth/-2,imageHeight/-2,BetterPlatform.class) != null || 
        getOneObjectAtOffset(imageWidth/2,imageHeight/-2,BetterPlatform.class) != null) 
        bumpedHead = true;
        
        return bumpedHead;
    }
    public boolean canMoveLeft() 
    {
        boolean canMoveLeft = true;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth/-2 - STEP,imageHeight/-2,BetterPlatform.class) != null || 
        getOneObjectAtOffset(imageWidth/-2 - STEP,imageHeight/2 - 1,BetterPlatform.class) != null) 
        canMoveLeft = false;
        
        return canMoveLeft;    
    }
    public boolean canMoveRight() 
    {
        boolean canMoveRight = true;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth/2 + STEP,imageHeight/-2,BetterPlatform.class) != null || 
        getOneObjectAtOffset(imageWidth/2 + STEP,imageHeight/2 - 1,BetterPlatform.class) != null) 
        canMoveRight = false;
        
        return canMoveRight;     
    }
    public void DeathScreenLevelOne()
    {
        Level_One myWorld = (Level_One) getWorld();
        myWorld.SetStageStart(0);
        
        GameOverScreen gameOver = new GameOverScreen();
        Greenfoot.setWorld(gameOver);
    }
    public void DeathScreenLevelTwo()
    {
        Level_Two myWorld = (Level_Two) getWorld();
        myWorld.SetStageStart(0);
        
        GameOverScreen gameOver = new GameOverScreen();
        Greenfoot.setWorld(gameOver);
    }
    public void LevelTwo()
    {
        Level_One myWorld = (Level_One) getWorld();
        myWorld.SetStageStart(0);
        
        Level_Two level_Two = new Level_Two();
        Greenfoot.setWorld(level_Two);
    }
    public void WinLevel()
    {
        Level_Two myWorld = (Level_Two) getWorld();
        myWorld.SetStageStart(0);
        
        WinLevel winLevel = new WinLevel();
        Greenfoot.setWorld(winLevel);
    }
    public void Win()
    {
         WinLevel myWorld = (WinLevel) getWorld();
         myWorld.SetStageStart(0);
        
         YouWonScreen win = new YouWonScreen();
         Greenfoot.setWorld(win);   
    }
    public boolean CheckPortal()
    {
        boolean touchingPortal = false;
        
        if(getOneIntersectingObject(PortalToNextLvl.class) != null)
        {
            touchingPortal = true;
            Greenfoot.playSound("portal.wav"); 
        }
        
        return touchingPortal;
    }
    public boolean CheckJewel()
    {
        boolean touchingJewel = false;
        Actor jewel = getOneIntersectingObject(Jewel.class);
        if(jewel != null) 
        {
            getWorld().removeObject(jewel);    
            touchingJewel = true;
            Greenfoot.playSound("pickup.wav");
        }
        return touchingJewel;
    }
    public boolean CheckClock()
    {
        boolean touchingClock = false;
        Actor clock = getOneIntersectingObject(Clock.class);
        if(clock != null) 
        {
            getWorld().removeObject(clock);    
            touchingClock = true;
            Greenfoot.playSound("clockgrab.wav");
        }
        return touchingClock;
    }
    public boolean CheckEnemy()
    {
        boolean touchingEnemy = false;
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if(enemy != null && !hasSword) 
        {   
            Greenfoot.playSound("enemyhityou.wav");
            touchingEnemy = true;
        }
        else if ( enemy != null && hasSword)
        {
            Greenfoot.playSound("enemygettinghit.wav");
            getWorld().removeObject(enemy); 
        }
        return touchingEnemy;
    }
    public boolean CheckSword()
    {
        boolean touchingSword = false;
        Actor sword = getOneIntersectingObject(Sword.class);
        if(sword != null) 
        {   
            getWorld().removeObject(sword); 
            //Greenfoot.playSound("enemyhityou.wav");
            touchingSword = true;
        }
        return touchingSword;
    }
    public void SetJump()
    {
        jumpStrength = jumpStrength + 10;
    }
    public boolean CheckPotion()
    {
        boolean touchingPotion = false;
        Actor potion = getOneIntersectingObject(Potion.class);
        if(potion != null) 
        {   
            getWorld().removeObject(potion);  
            touchingPotion = true;
            Greenfoot.playSound("clockgrab.wav");
        }
        return touchingPotion;
    }
        public boolean CheckCookie()
    {
        boolean touchingCookie = false;
        Actor cookie = getOneIntersectingObject(Cookie.class);
        if(cookie != null) 
        {   
            getWorld().removeObject(cookie);  
            touchingCookie = true;
            Greenfoot.playSound("biscuitgrab.wav");
        }
        return touchingCookie;
    }
    
    
}
