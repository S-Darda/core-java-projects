import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ATMsystem {

    Scanner input =new Scanner(System.in);
    HashMap<Integer, User> users = new HashMap<>();
    void initializeUsers() {
        users.put(12345, new User(1111, 500.0,"Darda"));
        users.put(67890, new User(2222, 300.0,"Erada"));
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
            operation(acNum);
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
    void operation(int accNum)
    {
        User user = users.get(accNum);
       do {
           System.out.println("-------welcome---------");
           System.out.println("1. Account Info");
           System.out.println("2. Balance");
           System.out.println("3. Deposit");
           System.out.println("4. Withdraw");
           System.out.println("5. Logout");
           System.out.println("#. Enter your Choice :");
           int choice = input.nextInt();
           switch (choice){
               case 1:
                   AcountInfo(accNum);
                   break;
               case 2:
                   Blance(accNum);
                   break;
           }
       }
        while(true);
    }
    void AcountInfo(int accNum)
    {
        User user = users.get(accNum);
        System.out.println("<---Account Info--->");
        System.out.println("Name : "+ user.name);
        System.out.println("Balance :"+user.balance);
        System.out.println("Pin :"+user.pin);
    }
    void Blance(int accNum){
        User user = users.get(accNum);
        System.out.println("--------------------");
        System.out.println("Your Current Balance :"+user.balance);
        System.out.println("--------------------");

    }

    public static void main(String[] args) {
        ATMsystem atMsystem =new ATMsystem();
        atMsystem.initializeUsers();
        atMsystem.display();
    }

    }



