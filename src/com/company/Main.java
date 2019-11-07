package com.company;

import Transactions.AddMoney;
import Transactions.Transaction;
import com.company.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int choice;

        List<User> users = new ArrayList<>();

        do {
            printmenu();

            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("----------------Sukurti vartotoja----------------------");

                    System.out.println("Iveskite savo varda");
                    String name = scn.next();
                    System.out.println("Kiek norite tureti pinigu savo saskaitoje?");
                    double balance = scn.nextDouble();

                    User user = new User(name, balance);
                    users.add(user);
                    break;
                case 2:
                    System.out.println("-----------------Perziureti vartotoja--------------------");
                    printusers(users);
                    break;
                case 3:
                    System.out.println("-----------Vartotojo trinimas-------------");
                    printusers(users);
                    System.out.println("Pasirinkite kuri vartotoja norite istrinti : ");
                    int deleteuser = scn.nextInt();
                    System.out.println("Jeigu esate tikras kad norite istrinti spauskite [1], kitu atveju spauskite [0]");
                    int userchoice = scn.nextInt();

                    if (userchoice == 1) {
                        users.remove(deleteuser);
                        System.out.println("Jus sekmingai istrynete vartotoja " + deleteuser);
                    }
                    printusers(users);
                    break;
                case 4:
                    printusers(users);
                    System.out.println("Iveskite sask. numeri is kurio darysite pavedima");
                    String accFrom = scn.next();

                    System.out.println("Iveskite sask. numeri i kuri darysite pavedima");
                    String accTo = scn.next();

                    System.out.println("Iveskite suma kuria norite pervesti");
                    double amount = scn.nextDouble();

                    User from = null;
                    User to = null;
                    for (User u : users) {
                        if (u.getAccNumber().equals(accFrom)) {
                            from = u;
                        }
                        if (u.getAccNumber().equals(accTo)) {
                            to = u;
                        }
                    }

                    users.remove(from);
                    users.remove(to);

                    Transaction transaction = new Transaction(from, to, amount);

                    List<User> transactedUsers = transaction.execute().stream()
                            .filter(u -> u != null)
                            .collect(Collectors.toList());

                    users.addAll(transactedUsers);
                    break;
                case 5:
                    printusers(users);
                    System.out.println("I kuria saskaita noretumete inest pinigus?");
                    String depositTo = scn.next();
                    System.out.println("Kiek noretumete inesti?");
                    double depositAmount = scn.nextDouble();
                    for (User x : users) {
                        if (x.getAccNumber().equals(depositTo)) {
                            x.setBalance(x.getBalance() + depositAmount);
                            break;
                        }
                    }
                case 0:
                    System.out.println("------------------Baigti programa------------------------");
                    break;
                default:
                    System.out.println("Bloga ivestis!");
            }
        } while (choice != 0);
    }

    public static void printmenu() {
        System.out.println();
        System.out.println("1. Sukurti vartotoja");
        System.out.println("2. Perziureti vartotoja");
        System.out.println("3. Istrinti vartotoja");
        System.out.println("4. Daryti pavedima");
        System.out.println("5. Pinigu idejimas");
        System.out.println("------------------------------------------------------------");
        System.out.println("0. Baigti programa");
    }

    private static void printusers(List<User> users) {
        System.out.println("Vartotoju sarasas : ");
        int i = 0;
        for (User u : users) {
            System.out.println(i + ". " + u.toString());
            i++;
        }
    }


}
