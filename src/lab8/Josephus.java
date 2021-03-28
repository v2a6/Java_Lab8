package lab8;
import java.util.Scanner;
/**
 *
 * @author Azzoz 28/3/2020
 */
public class Josephus {
    public static int flag = 0;
   
    private static void jos(int numbers) {

        if (numbers == 1) {
            flag = 1;
        } else if (numbers % 2 == 0) {
            jos(numbers / 2);
            flag = flag * 2 - 1;
        } else if (numbers % 2 != 0) {
            jos((numbers - 1) / 2);
            flag = flag * 2 + 1;
        }
    }
    private static void jos2 (int[] arrNumbers) {

        int length = arrNumbers.length;
        int[] arrNumberNew = new int[0];
        while (length != 1) {
            if (length % 2 == 0) {
                length = length / 2;
                arrNumberNew = new int[length];
                for (int i = 0; i < arrNumberNew.length; i++)
                    arrNumberNew[i] = arrNumbers[2 * i];
            } else if (length % 2 != 0) {
                length = length / 2;
                arrNumberNew = new int[length];
                for (int i = 0; i < arrNumberNew.length; i++)
                    arrNumberNew[i] = arrNumbers[2 * i + 2];
            }
            arrNumbers = arrNumberNew;
        }
    }
     public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = input.nextInt();
        jos(number);
        System.out.println("the winner is"+ flag);
        int[] arrNumbers = new int[number];
        for (int i = 0; i < arrNumbers.length; i++) {
            arrNumbers[i] = i + 1;
        }
        jos2(arrNumbers);
    }
}
