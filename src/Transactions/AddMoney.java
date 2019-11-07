package Transactions;

import com.company.users.User;

import java.util.ArrayList;
import java.util.List;

public class AddMoney {
    private double amount;
    private User user;

    public AddMoney(double amount, User user) {
        this.amount = amount;
        this.user = user;
    }
    public List<User> changeMoney(){
        List<User> moneyUser = new ArrayList<>();
        if(amount > 0){
            user.setBalance(user.getBalance() + amount);
        }
        else{
            System.out.println("Ivedete klaidinga suma");
        }
        moneyUser.add(user);

        return moneyUser;

    }
}
