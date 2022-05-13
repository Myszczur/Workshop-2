package pl.coderslab.entity;

import java.util.Arrays;
import java.util.Scanner;

public class MainDao {

    public static void main(String[] args) {
        User user = new User();
        UserDao userDao = new UserDao();
        Scanner scanner = new Scanner(System.in);

        String scan2;
        do {
            DbUtil.selectOption();
            scan2 = scanner.nextLine();
            switch (scan2) {
                case "add": {
                    System.err.println("Wprowadź nowego użytkownika");
                    System.err.print("Podaj Imię: ");
                    String userName = scanner.next();
                    System.err.print("Podaj email: ");
                    String userEmail = scanner.next();
                    System.err.print("Podaj hasło: ");
                    String userPass = scanner.next();
                    user.setUserName(userName);
                    user.setPassword(userPass);
                    user.setEmail(userEmail);
                    userDao.create(user);
                    break;
                }
                case "remove": {
                    System.err.print("Podaj Id Użytkownika do usunięcia: ");
                    int userId = DbUtil.getInt(scanner, "Podaj numer: ");
                    userDao.delete(userId);
                    break;
                }
                case "update": {
                    System.err.print("Podaj Id Użytkownika do zmiany: ");
                    int userName1w = scanner.nextInt();
                    User upDate = userDao.read(userName1w);
                    System.err.print("Podaj email: ");
                    String userEmail1 = scanner.next();
                    System.err.print("Podaj hasło: ");
                    String userPass1 = scanner.next();
                    System.err.print("Podaj Imię: ");
                    String userName1 = scanner.next();
                    upDate.setUserName(userName1);
                    upDate.setPassword(userPass1);
                    upDate.setEmail(userEmail1);
                    userDao.update(upDate);
                    break;
                }
                case "show": {
                    System.err.print("Podaj Id Użytkownika: ");
                    int userId = DbUtil.getInt(scanner, "Podaj Id Użytkownika: ");
                    User read = userDao.read(userId);
                    System.out.println(read);
                    break;
                }
                case "all": {
                    User[] allUsers = userDao.findAll();
                    for (User allUser : allUsers)
                        System.out.println(allUser);
                    break;
                }
                default:
                    System.out.println("Please select a correct option.");
                    break;
            }
        } while (!"exit".equals(scan2));

        System.err.println("Bye Bye :(");
    }


}

