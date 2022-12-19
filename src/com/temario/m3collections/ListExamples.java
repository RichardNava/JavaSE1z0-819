package com.temario.m3collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListExamples {

    private final static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static void createUser(String nickName, String password, String email) {
        User user = new User(nickName, password, email);
        if (findUser(nickName) == null) {
            //if (!users.contains(user)) {
            users.add(user);
        } else {
            System.out.println("El nickName ya existe. Elige otro para continuar.");
        }
    }

    public static void createUser(User user) {
        if (user != null) {
            users.add(user);
        } else {
            System.out.println("Debe indicar un registro valido");
        }
    }

    public static boolean addUsers(User... users) {
        return ListExamples.users.addAll(Arrays.asList(users));

    }

    public static void showAllUsers() {
        if (!users.isEmpty()) {// users.size() > 0
            for (int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i));
            }
        } else {
            System.out.println("No hay valores que mostrar.");
        }
        System.out.println("-".repeat(40));
    }

    public static User findUser(String name) {
        for (User user : users) {
            if (user.getNickName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public static void updateUser(String nickName, String... args) {
        User user = findUser(nickName);
        if (user != null) {
            for (int i = 0; i < args.length; i++) {
                if (i == 0 && args[i] != null) {
                    user.setNickName(args[i]);
                }
                if (i == 1 && args[i] != null) {
                    user.setPassword(args[i]);
                }
                if (i == 2 && args[i] != null) {
                    user.setEmail(args[i]);
                }
            }
        }
    }

    public static boolean removeUser(String nickName) {
        return users.remove(findUser(nickName));
    }

    public static void showUser(String nickName) {
        System.out.println((findUser(nickName) != null)
                ? findUser(nickName)
                : "No existe ningún usario con ese nick");
    }
}
