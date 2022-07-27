import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> futureInteger = executor.submit(getCallableInteger());
        System.out.println(futureInteger.get());
        executor.shutdown();
    }
    public static Callable<Integer> getCallableInteger() {
        // your code here
        Scanner scanner = new Scanner(System.in);

        Callable<Integer> callable = () -> {
            System.out.println(Thread.currentThread().getName()+ " is responsible for this call");
            System.out.println("Enter a number");
            int num = scanner.nextInt();
            return num;
        };
        return callable;
    }


}