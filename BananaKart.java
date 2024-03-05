public class BananaKart extends AbstractRacer

{
    private int Gas = (int )(Math.random() * 15);
    public BananaKart(String name)
    {
        super(name);
        // deisel, normal, vegetable oil
    }
    public void move()
    {
        if (Gas < 3) //Deisel
        {
            setPosition(getPosition() + 7);
        }
        else if (Gas < 9) //Normal
        {
            setPosition(getPosition() + 2);
        }
        else // vegetable
        {
            double moveC = Math.random();
            if (moveC < 0.5)
                setPosition(getPosition() + 1);

        }

    }


}
