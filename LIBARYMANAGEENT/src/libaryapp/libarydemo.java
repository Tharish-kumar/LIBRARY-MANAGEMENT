package libaryapp;
import java.util.*;
import java.sql.*;

public class libarydemo {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("--------------------------");
        System.out.println("📚 Welcome to BookCart");
        System.out.println("--------------------------");
		
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.print("Enter your choice: ");
		int useropt = sc.nextInt();
		sc.nextLine();  // consume newline
		
		boolean login=false;
		
		// Credential option
		
		Credential cr = new Credential();
		
		if(useropt==1) {
			login=cr.login();
			
		}
		else if(useropt==2) {
			cr.register();
		}
		else {
			System.out.println("Invalid Option");
		}
		
		if(login) {
			System.out.println();
			
			System.out.println("\n📖 Explore Genres Available in BookCart");
            System.out.println("-----------------------------------------");
            System.out.println("🔹 Productivity\n🔹 Love\n🔹 Sci-Fi\n🔹 Motivation");
            System.out.println("-----------------------------------------");
			
            System.out.print("📘 Want to explore and buy books? (yes/no): ");
            String userbuy = sc.nextLine().toUpperCase();
		
			
			while(userbuy.equals("YES")) {
				bookDAO bg=new bookDAO();
				
				System.out.print("\n📌 Type the Genre Name you're interested in: ");
				String genreopt=sc.nextLine().toUpperCase();
				
				switch (genreopt) {
                case "PRODUCTIVITY":
                    bg.getbookgenre("Productivity");
                    break;
                case "LOVE":
                    bg.getbookgenre("Love");
                    break;
                case "SCI-FI":
                    bg.getbookgenre("Sci-Fi");
                    break;
                case "MOTIVATION":
                    bg.getbookgenre("Motivation");
                    break;
                default:
                    System.out.println("❌ No Genre Found. Please try again.");
            }
				
				
				 System.out.print("\n🛒 Want to buy a book from " + genreopt + " genre? (yes/no): ");
	             String buybook = sc.nextLine().toUpperCase();
				
				if(buybook.equals("YES")) {
					System.out.print("📕 Enter the Book Name: ");
					String bookname=sc.nextLine().toUpperCase();
					
					bookDAO br=new bookDAO();
					double price=br.getbookamount(bookname);
					
					if(price!=-1) {
						System.out.println("\n💳 Payment Options");
                        System.out.println("1. CreditCard\n2. UPI");
                        System.out.print("Choose payment method: ");
                        String payopt = sc.nextLine().toUpperCase();
						
						if(payopt.equals("CREDITCARD")) {
							payment pg=new creditcard(bookname);
							pg.validate();
						}
						else if(payopt.equals("UPI")) {
							payment uq=new upi(bookname);
							uq.validate();
						}

					}
					
					
					
				}
				else if(buybook.equals("NO")) {
					System.out.println("🔁 You can explore other genres too.");
				}
				else {
					System.out.println("Invalid Answer From You sry ");
				}
				
				System.out.print("\n🔄 Want to buy another book or switch genre? (yes/no): ");
                userbuy = sc.nextLine().toUpperCase();
				
			}
		}
		
		 System.out.println("\n🙏 Thank you for visiting BookCart!");
		
		
		
	}

}
