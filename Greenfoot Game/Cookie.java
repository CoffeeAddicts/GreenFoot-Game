import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cookie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cookie extends Actor
{
    /**
     * Act - do whatever the Cookie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter = 0;
    int interval = 2;
    
    public void act()
    {
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
