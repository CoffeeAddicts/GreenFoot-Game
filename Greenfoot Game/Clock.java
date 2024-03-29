import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Clock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clock extends Actor
{
    /**
     * Act - do whatever the Clock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter = 0;
    int interval = 2;
    
    public Clock()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
    }
    
    public void act()
    {
        //Allows for the object  to hover in place.
        //Every 10 frames the objects moves and when it reachs a top point it stops 
        //and changes it's direction
        if(counter == 0)
        {
            setLocation(getX(),getY() - interval);  
            counter = counter + 1;
        }
        else if(counter == 10)
        {
            setLocation(getX(),getY() - interval);  
            counter = counter + 1;
        }
        else if(counter == 20)
        {
            setLocation(getX(),getY() - interval);  
            counter = counter + 1;
        }
        else if(counter == 30)
        { 
            counter = counter + 1;
        }
        else if(counter == 40)
        {
            setLocation(getX(),getY() + interval);  
            counter = counter + 1;
        }
        else if(counter == 50)
        {
            setLocation(getX(),getY() + interval);  
            counter = counter + 1;
        }
        else if(counter == 60)
        {
            setLocation(getX(),getY() + interval);  
            counter = counter + 1;
        }
        else if(counter == 70)
        {
            counter = counter + 1;
        }
        else if(counter == 80)
        {  
            counter = 0;
        }
        else {
            counter = counter + 1;
        }
    }
}
