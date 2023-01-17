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
    private final int ABOVEOFFSET = 30;
    private int velocity;
    public Ghost()
    {
        velocity = 0;
    }
    public void act()
    {
        fall();
        if(Greenfoot.isKeyDown("w") && isOnSolidGround()) jump();
        move();
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
        velocity = -20;
    }
    public void move()
    {
        int y = getY();
        int x = getX();
        if(Greenfoot.isKeyDown("a") && canMoveLeft())
        {
            x -=STEP;
            setImage("blob_left-removebg-preview.png");
        }
        if(Greenfoot.isKeyDown("d")&& canMoveRight())
        {
            x +=STEP;
            setImage("blob_right-removebg-preview.png");
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
    
}
