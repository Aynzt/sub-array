package subarray;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.function.Function;

public class SequenceChecker {

    private static final Logger LOGGER = System.getLogger(SequenceChecker.class.getName());

    public Function<Integer, int[]> populator() {
        return limit -> {
            SecureRandom secureRandom = new SecureRandom();

            int[] array = new int[limit];

            int i = 0;

            do {
                array[i] = secureRandom.nextInt(10);
                i++;
            } while (i < limit);

            return array;
        };
    }

    public boolean check(int[] array, int[] sequence) {

        LOGGER.log(Level.DEBUG, "Array : " + Arrays.toString(array));
        LOGGER.log(Level.DEBUG, "Sequence : " + Arrays.toString(sequence));

        int lastIndex = -1;
        int j = 0;
        int cpt = 0;

        for (int i = 0; i < sequence.length; i++) {

            LOGGER.log(Level.DEBUG, "S : " + sequence[i]);

            while (j < array.length) {
                if (array[j] == sequence[i]) {

                    LOGGER.log(Level.DEBUG, "A : " + array[j]);

                    lastIndex = j;

                    break;
                }

                j++;
            }

            if (j == array.length && j != lastIndex) {
                return false;
            }

            j = lastIndex;

            if (lastIndex != -1)
                cpt++;

        }

        return cpt == sequence.length;
    }

}
