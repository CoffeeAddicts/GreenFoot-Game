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
    setLocation(getX()-1, getY());
}

    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;
    
public void move()
{
  if(count1 == 0)
{
move(4);
count2 = count2 +1;
}
if(count2 == 20)
{
move(-4);
count3 = count3 +1;
count1 = 1;
}
if(count3 == 20)
{
count1 = 0;
count2 = 0;
count3 = 0;
}
}
}


