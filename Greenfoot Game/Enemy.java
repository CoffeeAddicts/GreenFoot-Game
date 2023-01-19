import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor

{

    private int speed;
    private int leftTurn;
    private int rightTurn;
    private int up;
    private int down;
    
    public GreenfootImage image1 = new GreenfootImage("enemy-left-removebg-preview.png");
    public GreenfootImage image2 = new GreenfootImage("enemy-right.png");
    

    public Enemy(){
        this(0,0,0,0,0);
    }
    public Enemy(

        int leftTurnChanged,
        int rightTurnChanged,
        int speedChanged,
        int upChanged,
        int downChanged) 
    {   
        setLeftTurn(leftTurnChanged);
        setRightTurn(rightTurnChanged);
        setSpeed(speedChanged);
        setUp(upChanged);
        setDown(downChanged);
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
        image1.scale(image1.getWidth()/2, image1.getHeight()/2);
        image2.scale(image2.getWidth()/2, image2.getHeight()/2);
        
    }
    public void act()
    {

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
                ChangeImage();
            } 
        }
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
    public void ChangeImage()
    {
       if(getImage().equals(image1))
       {
           setImage(image2);
       }
       else
       {
           setImage(image1);
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




