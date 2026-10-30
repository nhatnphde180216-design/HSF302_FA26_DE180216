package com.fu.ch08.b3;

import java.time.LocalDate;
import java.util.*;

public final class UserStore {
    private static final Map<String, User> USERS = new HashMap<>();
    static {
        USERS.put("admin", new User("Quản trị viên", "admin@example.com", "admin",
                "Admin@123", "Khác", LocalDate.of(2000, 1, 1),
                "Kỹ thuật phần mềm", List.of()));
        USERS.put("hoainhat", new User("Nguyen Phuoc Hoai Nhat", "nhatnphde180216@fpt.edu.vn", "hoainhat",
                "HoaiNhat@123", "Nam", LocalDate.of(2004, 1, 1),
                "Kỹ thuật phần mềm", List.of("Game", "Đọc sách")));
    }
    private UserStore() {}

    public static boolean exists(String username) {
        return USERS.containsKey(username.trim().toLowerCase());
    }
    public static void add(User u) { USERS.put(u.username(), u); }
    public static Optional<User> login(String username, String password) {
        return Optional.ofNullable(USERS.get(username.trim().toLowerCase()))
                .filter(u -> u.password().equals(password));
    }
}
