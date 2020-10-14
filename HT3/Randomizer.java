package lab2;

import java.util.Collection;

public class Randomizer {
    public static boolean randomFill(Collection<Integer> collection, long numbers) {
        if (numbers <= 0)
        {
            return false;
        }
        for (int i = 0; i < numbers; i++) {
            collection.add((int)(Math.random() * 100));
        }
        return true;
    }
}
