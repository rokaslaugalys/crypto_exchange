package Transactions;

import com.company.users.User;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private User from;
    private User to;
    private double amount;

    public Transaction(User from, User to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
    public boolean isValid(){
        return to != null && from != null && from.getBalance() >= amount;
    }
    public List<User> execute(){
        // Sukuriam nauja sarasa
        List<User> transactedUsers = new ArrayList<>();

        if(isValid()){
            // Padarom pavedima
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        }
        else{
            System.out.println("ERROR, tranzakcija nevalidi!");
        }
        // Sudedam i nauja sarasa
        transactedUsers.add(from);
        transactedUsers.add(to);

        return transactedUsers;
    }
}

