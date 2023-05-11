package africa.semicolon.IdealBvas.Utils;

import java.util.Random;

public class Trial {

    public static void main(String[] args) {
    Random random = new Random();

    char firstLetter = (char) (random.nextInt(26) + 'A');
    char secondLetter = (char) (random.nextInt(26) + 'A');
    char thirdLetter = (char) (random.nextInt(26) + 'A');
    char fourthLetter = (char) (random.nextInt(26) + 'A');


        int firstDigit = random.nextInt(1000);
        int secondDigit = random.nextInt(1000);
        int thirdDigit = random.nextInt(1000);
        int fourthDigit = random.nextInt(1000);
        StringBuilder VIN = new StringBuilder();

        for (int i = 0; i < 1; i++) {
            VIN.append(firstDigit);
            VIN.append(firstLetter);
            VIN.append(" ");

            VIN.append(secondDigit);
            VIN.append(secondLetter);
            VIN.append(" ");

            VIN.append(thirdDigit);
            VIN.append(thirdLetter);
            VIN.append(" ");

            VIN.append(fourthDigit);
            VIN.append(fourthLetter);
            VIN.append(" ");
        }

        System.out.println("VIN " +VIN);

    }
}
