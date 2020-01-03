package demo;

import com.taobao.arthas.common.AnsiLog;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MathGame {
    private static Random random = new Random();
    public int illegalArgumentCount = 0;

    public List<Integer> primeFactors(int number) {
        if (number < 2) {
            ++this.illegalArgumentCount;
            throw new IllegalArgumentException("number is: " + number + ", need >= 2");
        }
        ArrayList<Integer> result = new ArrayList<>();
        int i = 2;
        while (i <= number) {
            if (number % i == 0) {
                result.add(i);
                number /= i;
                i = 2;
                continue;
            }
            ++i;
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
//        MathGame game = new MathGame();
//        do {
//            game.run();
//            TimeUnit.SECONDS.sleep(1L);
//        } while (true);
        AnsiLog.info("arthas-boot version: ");
    }

    public void run() throws InterruptedException {
        try {
            int number = random.nextInt() / 10000;
            List<Integer> primeFactors = this.primeFactors(number);
            MathGame.print(number, primeFactors);
        } catch (Exception e) {
            System.out.println(String.format("illegalArgumentCount:%3d, ", this.illegalArgumentCount) + e.getMessage());
        }
    }

    public static void print(int number, List<Integer> primeFactors) {
        StringBuffer sb = new StringBuffer(number + "=");
        for (int factor : primeFactors) {
            sb.append(factor).append('*');
        }
        if (sb.charAt(sb.length() - 1) == '*') {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }
}

//                   target : the object
//                   clazz : the object's class
//                   method : the constructor or method
//                   params : the parameters array of method
//                   params[0..n] : the element of parameters array
//                   returnObj : the returned object of method
//                   throwExp : the throw exception of method
//                   isReturn : the method ended by return
//                   isThrow : the method ended by throwing exception
//                   #cost : the execution time in ms of method invocation