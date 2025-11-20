package com.library.dao;

import com.library.model.User;
import java.util.*;

public class UserDAO {

    private final String filePath = "src/main/resources/users.txt";

    public List<User> getAllUsers() {
        List<String> lines = FileDatabase.readData(filePath);
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            String[] arr = line.split(",");
            users.add(new User(arr[0], arr[1], arr[2]));
        }
        return users;
    }

    public void saveUsers(List<User> users) {
        List<String> lines = new ArrayList<>();
        for (User u : users) {
            lines.add(u.getUserId() + "," + u.getName() + "," + u.getEmail());
        }
        FileDatabase.writeData(filePath, lines);
    }

    public void addUser(User user) {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }
}
