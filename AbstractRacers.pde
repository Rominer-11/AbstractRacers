
 // Variables declared here
final int RACE_DISTANCE = 800;   // 100 px buffer before start and
                                 // after the finish
final int SCREENWIDTH = 1000;    // matches graphical window of
                                 // size(1000, 800)
final int racerWidth = 100;            // racer width in pixels;
Race r;
/**
 * This method is run once before the draw() loop starts repeating.
 * Initialize the race variables, set up the screen...
 */
    Hare h = new Hare("Hare");
  
    Tortoise t = new Tortoise("Tortoise");
    BananaKart b = new BananaKart("BananaKart");
void setup()
{
  size(900, 700);

    r = new Race(500);
    r.addRacer(t);
    r.addRacer(h);
    r.addRacer(b);


}

void drawStartFinish()
{

    line(r.getRaceLength(), height , r.getRaceLength(), 0);
   

}

void drawRacers()
{
    for (AbstractRacer racer : r.getRacers())
    {
       if (racer instanceof Tortoise)
       {

            rect(racer.getPosition(), height/4, 50, 50);
            fill(100);

       }
       else if (racer instanceof Hare)
       {

            rect(racer.getPosition(), height/2, 10, 10);
            fill(200);
       }
       else if (racer instanceof BananaKart)
       {
          rect(racer.getPosition(), height*3/4, 40, 40);
          color(0);
       }
    }
}

void draw()
{    
    background(255);                  // clear screen
    if (r.isRacing())
    {
      t.move();
        b.move();
        h.move();
        System.out.println(r.toString());
        r.update();
        drawStartFinish();
        drawRacers();
    }
    else
    {
        drawStartFinish();
        drawRacers();
        System.out.println("The race is over!");
        System.out.println("The winner is...." + r.update());
        noLoop();
    }
}
