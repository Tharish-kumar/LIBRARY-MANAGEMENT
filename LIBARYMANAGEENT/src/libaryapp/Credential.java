package libaryapp;

import java.sql.SQLException;
import java.util.Scanner;

public class Credential {
    String username;
    String password;

    Credential() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("👤 Enter the username: ");
        username = sc.nextLine();
        System.out.println();
        System.out.print("🔐 Enter the password: ");
        password = sc.nextLine();
    }

    public void register() throws SQLException {
        loginDAO dao = new loginDAO();
        dao.register(username, password);
    }

    public boolean login() throws SQLException {
        loginDAO dao = new loginDAO();
        if (dao.validate(username, password)) {
            System.out.println("\n------------------------");
            System.out.println("✅ Successfully Logged In!");
            System.out.println("------------------------");
            return true;
        } else {
            System.out.println("❌ Invalid username or password. Please try again.");
            return false;
        }
    }
}
