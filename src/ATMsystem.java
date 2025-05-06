import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ATMsystem {

    Scanner input =new Scanner(System.in);
    HashMap<Integer, User> users = new HashMap<>();
    void initializeUsers() {
        users.put(12345, new User(1111, 500.0));
        users.put(67890, new User(2222, 300.0));
    }
    void display()
    {
        System.out.println("|--------------------|");
        System.out.println("Welcome to ATM 😊");
        System.out.println("Enter your login Details");
        System.out.println("Enter Account Number:");
        int acNum = input.nextInt();
        System.out.println("Enter Password:");
        int pin =input.nextInt();
        System.out.println("|--------------------|");
        if(authenticate(acNum,pin)){
            System.out.println("Login Successful");
        }
        else {
            System.out.println("login Failed");
        }


    }
    boolean authenticate(int acNum,int pin)
    {
        User user = users.get(acNum);
        System.out.println(user.pin);
        return user != null && user.pin == pin;

    }

    public static void main(String[] args) {
        ATMsystem atMsystem =new ATMsystem();
        atMsystem.initializeUsers();
        atMsystem.display();
    }
    class User {
        int pin;
        double balance;

        User(int pin, double balance) {
            this.pin = pin;
            this.balance = balance;
        }
    }

}

