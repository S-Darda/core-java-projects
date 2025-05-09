import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ATMsystem {

    Scanner input =new Scanner(System.in);
    boolean login =true;
    boolean logout =false;
    HashMap<Integer, User> users = new HashMap<>();
    void initializeUsers() {
        users.put(12345, new User(1111, 500.0,"Darda"));
        users.put(22222, new User(2222, 300.0,"Erada"));
        users.put(111, new User(111, 300.0,"Admin"));
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
            if (acNum ==111 && pin ==111){
                System.out.println("---Admin Dashboard---");
            }else
            {
                operation(acNum);
            }
        }
        else {
            System.out.println("login Failed");
        }


    }
    boolean authenticate(int acNum,int pin)
    {
        User user = users.get(acNum);
        System.out.println(user.pin);
        if (user.pin == pin){
            return true;
        }else {
            System.out.println("Try again");
        }
        return false;

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
               case 3:
                   Deposit(accNum);
                   break;
               case 4:
                   Witdraw(accNum);
                   break;
               case 5:
                   logout(accNum);
                   break;
           }

       }
        while(login);
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
        System.out.println("Your Current Balance : £"+user.balance);
        System.out.println("--------------------");
    }
    void Deposit(int accNum){
        System.out.println("--------------------------");
        System.out.println("Enter Amount :");
        double depAm =input.nextDouble();
        User user =users.get(accNum);
        user.balance += depAm;
        Blance(accNum);
    }
    void Witdraw(int accNum){
        System.out.println("--------------------------");
        System.out.println("Enter Amount :");
        double W_Am =input.nextDouble();
        User user =users.get(accNum);
        user.balance -= W_Am;
        Blance(accNum);
    }
    void logout(int accNum){
        login =logout;
        System.out.println("You are logged out");
        System.out.println("----- Thank You -----");


    }

    public static void main(String[] args) {
        ATMsystem atMsystem =new ATMsystem();
        atMsystem.initializeUsers();
        atMsystem.display();
    }

    }



