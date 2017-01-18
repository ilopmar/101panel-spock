package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHelper {

    public static List<Integer> someFibonacciNumbers() {
        List<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.addAll(Arrays.asList(1, 1, 2, 3, 5, 8, 13));

        return fibonacciList;
    }

    public static List<User> makeUserList() {
        return Arrays.asList(
            new User("Sheldon", "Cooper"),
            new User("Leonard", "Hofstadter"),
            new User("Raj", "Koothrappali"),
            new User("Howard", "Wolowitz")
        );
    }

    public static Map<String, ?> makeUserMap() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "Iván");
        userMap.put("lastName", "López");
        userMap.put("age", 37);

        return userMap;
    }
}
