import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Apple {
    public static String threadName="A";
    public static Lock lock=new ReentrantLock();
    public static Condition conA=lock.newCondition();
    public static Condition conB=lock.newCondition();
    public static Condition conC=lock.newCondition();
    public static void main(String args[]){
    System.out.println("helll");
    }

}
