//Final Project
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CustLinkedList custList = new CustLinkedList();
        MovieLinkedList movieList = new MovieLinkedList();

        custList.custAdd(new CustNode(new Customer("Jeffrey", "Yu", "0000000001")));
        custList.custAdd(new CustNode(new Customer("Porter", "Gregg", "0000000002")));

        movieList.movieAdd(new MovieNode(new Movie("Home Alone", "000000000001")));
        movieList.movieAdd(new MovieNode(new Movie("Elf", "000000000002")));
        movieList.movieAdd(new MovieNode(new Movie("The Grinch", "000000000003")));


        while (true) {
            System.out.println("Add Customer(AC), Add Movie(AM), Borrow(B), Return(R), Find(F), Quit(Q)?");
            String x = scan.nextLine();

            if (x.equalsIgnoreCase("AC")) {
                System.out.println("First name: ");
                String first = scan.nextLine();
                System.out.println("Last Name: ");
                String last = scan.nextLine();
                System.out.println("Phone number: ");
                String num = scan.nextLine();
                while (num.length() != 10) {
                    System.out.println("Please enter a valid phone number: ");
                    num = scan.nextLine();
                }
                custList.custAdd(new CustNode(new Customer(first, last, num)));
                System.out.println("Customer added");
            }

            else if (x.equalsIgnoreCase("AM")) {
                System.out.println("Title:");
                String name = scan.nextLine();
                System.out.println("Barcode:");
                String barcode = scan.nextLine();
                while (barcode.length() != 12) {
                    System.out.println("Please enter a valid barcode: ");
                    barcode = scan.nextLine();
                }
                movieList.movieAdd(new MovieNode(new Movie(name, barcode)));
                System.out.println(name + " added to system");
            }

            else if (x.equalsIgnoreCase("B")) {
                System.out.println("Phone number: ");
                String phoneNum = scan.nextLine();
                while (phoneNum.length() != 10) {
                    System.out.println("Please enter a valid phone number: ");
                    phoneNum = scan.nextLine();
                }
                Customer c = custList.findPhoneNum(phoneNum);
                if (c == null) {
                    System.out.println("Phone number not found");
                } else {
                    System.out.println("Barcode: ");
                    String barcode = scan.nextLine();
                    while (barcode.length() != 12) {
                        System.out.println("Please enter a valid barcode: ");
                        barcode = scan.nextLine();
                    }
                    Movie m = movieList.findBarcode(barcode);
                    if (m == null) {
                        System.out.println("We don't have that movie.");
                    } else {
                        if (m.borrowed == "") {
                            if (c.count < 3) {
                                m.borrowed = c.phoneNum;
                                c.count++;
                                System.out.println("Movie borrowed");
                            } else if (c.count == 3){
                                System.out.println("You can only borrow 3 movies at a time");
                            }
                        } else {
                            System.out.println("This movie is already rented.");
                        }
                    }
                }
            }

            else if (x.equalsIgnoreCase("R")) {
                System.out.println("Phone number: ");
                String phoneNum = scan.nextLine();
                while (phoneNum.length() != 10) {
                    System.out.println("Please enter a valid phone number: ");
                    phoneNum = scan.nextLine();
                }
                Customer c = custList.findPhoneNum(phoneNum);
                if (c == null) {
                    System.out.println("You didn't borrow this movie");
                } 
                else {
                    System.out.println("Barcode: ");
                    String barcode = scan.nextLine();
                    while (barcode.length() != 12) {
                        System.out.println("Please enter a valid barcode: ");
                        barcode = scan.nextLine();
                    }
                    Movie m = movieList.findBarcode(barcode);
                    if (c.phoneNum.equals(m.borrowed)) {
                        m.borrowed = "";
                        c.count--;
                        System.out.println("Movie Returned");
                    } else {
                        System.out.println("You didn't have this movie.");
                    }
                }
            }

            else if(x.equalsIgnoreCase("F")) {
                System.out.println("Movie name: ");
                String movie = scan.nextLine();
                String phone = movieList.getBorrowed(movie);
                Customer c = custList.findPhoneNum(phone);
                if (c == null) {
                    System.out.println("Nobody has this movie right now.");
                } else {
                    System.out.println(c.firstName + " " + c.lastName + " has " + movie);
                }
            }

            else if(x.equalsIgnoreCase("Q")) {
                break;
            }
        }
    }
}