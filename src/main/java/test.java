import java.util.Random;

public class test {
    static void main(String[] args) {
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        System.out.println(cardno);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        System.out.println(pin);
    }
}
