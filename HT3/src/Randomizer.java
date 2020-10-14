package lab2;

import java.util.Collection;
import java.io.*;

public class Randomizer {
    public static boolean randomFill_int(Collection<Integer> collection, long numbers) {
        if (numbers <= 0)
        {
            return false;
        }
        for (int i = 0; i < numbers; i++) {
            collection.add((int)(Math.random() * 100));
        }
        return true;
    }
    public static boolean randomFill_double(Collection<Double> collection, long numbers) {
        if (numbers <= 0)
        {
            return false;
        }
        for (int i = 0; i < numbers; i++) {
            collection.add((Math.random() * 100));
        }
        return true;
    }
    public static String random_string(int max_length) {
        int length = Math.max(1, (int)(Math.random() * max_length));
        StringBuilder str = new StringBuilder("");
        while (str.length() < length) {
            int b = 65 + (int)(Math.random() * 57);
            if ((b > 96) || (b < 91))
                str.append((char)b);
        }
        String res = str.toString();
        return res;
    }
}
