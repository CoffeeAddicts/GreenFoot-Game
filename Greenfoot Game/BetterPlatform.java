import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BetterPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BetterPlatform extends Actor
{
    private int speed;
    private int leftTurn;
    private int rightTurn;
    private int up;
    private int down;

    public BetterPlatform(){
        this(100, 25,0,0,0,0,0);
    }
    public BetterPlatform(
        int width,
        int height,
        int leftTurnChanged,
        int rightTurnChanged,
        int speedChanged,
        int upChanged,
        int downChanged) 
    {
        GreenfootImage image = getImage();
        image.scale(width,height);
        setImage(image);
        
        setLeftTurn(leftTurnChanged);
        setRightTurn(rightTurnChanged);
        setSpeed(speedChanged);
        setUp(upChanged);
        setDown(downChanged);
    }
    public void act()
    {
        //controls the platform if it is meant to be moving left and right
        if(leftTurn != 0 || rightTurn != 0)
        {
            setLocation(getX() + speed,getY());
            Actor actor = getOneIntersectingObject(null);
            if(actor!=null)
            {
                actor.setLocation(actor.getX()+speed,actor.getY());
            }
            if(atTurningPointX())
            {
                speed = -speed;
            } 
        }
        //controls the platform if it is meant to be moving up and down
        if(up != 0 || down != 0)
        {
            setLocation(getX(),getY()+ speed);
            Actor actor = getOneIntersectingObject(null);
            if(actor!=null)
            {
                actor.setLocation(actor.getX(),actor.getY()+speed);
            }
            if(atTurningPointY())
            {
                speed = -speed;
            }   
        }
    }
    public void setLeftTurn(int leftTurnChanged)
    {
        leftTurn = leftTurnChanged;
    }
    public void setRightTurn(int rightTurnChanged)
    {
        rightTurn = rightTurnChanged;
    }
    public void setSpeed(int speedChanged)
    {
        speed = speedChanged;
    }
    public void setUp(int upChanged)
    {
        up = upChanged;
    }
    public void setDown(int downChanged)
    {
        down = downChanged;
    }
    public boolean atTurningPointX()
    {
        return (getX() <= leftTurn || getX() >= rightTurn);
    }
        public boolean atTurningPointY()
    {
        return (getY() <= up || getY() >= down);
    }
}
