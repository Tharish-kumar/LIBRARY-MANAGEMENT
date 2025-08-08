package libaryapp;
import java.sql.SQLException;
import java.util.*;
import java.util.UUID;

// Abstract Payment Class
abstract public class payment {

    double price;
    String username;

    payment(String bookname) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("👤 Your Name: ");
        username = sc.nextLine();

        bookDAO bp = new bookDAO();
        price = bp.getbookamount(bookname);
    }

    abstract void validate();
}

// Credit Card Payment
class creditcard extends payment {

    int cardnumber;
    int cvv;
    String transactionid = UUID.randomUUID().toString();

    creditcard(String bookname) throws SQLException {
        super(bookname);
    }

    void validate() {
        Scanner sc = new Scanner(System.in);

        System.out.print("💳 Enter the Card Number: ");
        cardnumber = sc.nextInt();

        System.out.print("🔐 Enter the CVV: ");
        cvv = sc.nextInt();

        System.out.println("💰 Pay The Amount: ₹" + price);
        System.out.print("💵 Enter the Amount You Are Paying: ");
        int paid = sc.nextInt();

        if (price == paid) {
            System.out.println("✅ Payment Successful!");
            System.out.println("🧾 Transaction ID: " + transactionid);
            System.out.println("💳 Card Used: " + cardnumber);
        } else {
            System.out.println("⚠️ Payment Failed! Correct Price is ₹" + price);
        }
    }
}

// UPI Payment
class upi extends payment {

    String email;
    String transactionid = UUID.randomUUID().toString();

    upi(String bookname) throws SQLException {
        super(bookname);
    }

    void validate() {
        Scanner sc = new Scanner(System.in);

        System.out.print("📧 Enter your UPI Email ID: ");
        email = sc.nextLine();

        System.out.println("💰 Pay The Amount: ₹" + price);
        System.out.print("💵 Enter the Amount You Are Paying: ");
        int paid = sc.nextInt();

        if (price == paid) {
            System.out.println("✅ Payment Successful!");
            System.out.println("🧾 Transaction ID: " + transactionid);
            System.out.println("📧 UPI Email: " + email);
        } else {
            System.out.println("⚠️ Payment Failed! Correct Price is ₹" + price);
        }
    }
}
