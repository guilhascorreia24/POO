package lab3.lab3A;
import java.util.Scanner;

public class Client {
    static final String TOTIME = "asTime";
    static final String TOSECS = "asSeconds";
    static final String ADDTIME = "add";

    // extract seconds from string
    static private int time2secs(String time) {
        int h = Integer.valueOf(time.substring(0, 2)) * 3600;
        int m = Integer.valueOf(time.substring(3, 5)) * 60;
        int s = Integer.valueOf(time.substring(6, 8));
        return (h + m + s);
    }

    // Simple but enough for this problem
    static private boolean isTime(String str) {
        if (str.length() < 8)
            return false;
        if (str.charAt(2) != ':')
            return false;
        return true;
    }

    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Read input
        String aString = sc.nextLine();
        String operator = sc.nextLine();
        String output = "";
        T2time receiver;
        switch (operator) {
            case TOTIME:
                receiver = new T2time(Integer.parseInt(aString));
                output = receiver.toString();
                break;
            case TOSECS:
                receiver = new T2time(time2secs(aString));
                output = "" + receiver.asSeconds();
                break;
            case ADDTIME:
                T2time argument;
                receiver = new T2time(time2secs(aString));
                String bString = sc.nextLine();
                if (Client.isTime(bString))
                    argument = new T2time(time2secs(bString));
                else
                    argument = new T2time(Integer.parseInt(bString));
                output = receiver.add(argument).toString();
                break;
            default:
                // Seems right to have a default statement ...
        }
        sc.close();
        // Write output
        System.out.println(output);
    }
}