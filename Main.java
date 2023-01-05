import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {



        PriorityQueue pq = new PriorityQueue();
        System.out.println("Enter space separated number for insertion in heap");
        Scanner scan = new Scanner(System.in);
        String[] nums = (scan.nextLine()).split(" ");
        for(String num: nums){
          pq.add(Integer.parseInt(num.trim()));
        }
        System.out.println(pq);
        System.out.println(pq.toTree());
    }
}
