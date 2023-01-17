import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    public void act()
    {
    move(1);
    if (Greenfoot.getRandomNumber(10)<1)
    {
            turn(Greenfoot.getRandomNumber(90)-90);
    }
    
    if (isAtEdge())
    {
            turn(180);
    }
    }
}

