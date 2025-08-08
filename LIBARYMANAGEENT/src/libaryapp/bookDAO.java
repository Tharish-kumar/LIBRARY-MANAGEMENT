package libaryapp;

import java.sql.*;

public class bookDAO {

    public void productivitygenre() throws SQLException {
        getbookgenre("productivity");
    }

    public void lovegenre() throws SQLException {
        getbookgenre("love");
    }

    public void scificgenre() throws SQLException {
        getbookgenre("sci-fi");
    }

    public void motivationgenre() throws SQLException {
        getbookgenre("motivation");
    }

    void getbookgenre(String genre) throws SQLException {
        String query = "SELECT * FROM books WHERE genre = ?";
        Connection con = dbconnection.getconnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, genre);
        ResultSet rs = pst.executeQuery();

        System.out.println("\n🔎 Showing results for genre: " + genre.toUpperCase());
        System.out.println("========================================");

        while (rs.next()) {
            String title = rs.getString("title");
            String author = rs.getString("author");
            double price = rs.getDouble("price");

            System.out.println("📘 Title   : " + title);
            System.out.println("✍️  Author  : " + author);
            System.out.println("💰 Price   : ₹" + price);
            System.out.println("----------------------------------------");
        }
    }

    public double getbookamount(String bookname) throws SQLException {
        String query = "SELECT price FROM books WHERE title = ?";
        Connection con = dbconnection.getconnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, bookname);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            double bookprice = rs.getDouble("price");
            System.out.println("\n📕 Book Found: " + bookname);
            System.out.println("💰 Price to Pay: ₹" + bookprice);
            return bookprice;
        } else {
            System.out.println("❌ Book not found. Please check the name and try again.");
            return 0;
        }
    }
}
