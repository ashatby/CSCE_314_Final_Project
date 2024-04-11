import java.util.Random;
public class RandomNumGen {
    public static int getrandint(int upperlimit) {
        Random rand = new Random();
        int randint = rand.nextInt(upperlimit);
        return randint;
    }
}
    
