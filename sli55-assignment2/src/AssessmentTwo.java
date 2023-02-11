import java.io.File;

public class AssessmentTwo {

    public static void main(String[] args) {
        partOne();
        partTwo();
        partThree();
        partFour();
        partFive();
        partSix();
    }

    public static void partOne(){
        System.out.println("---part one:");
        Flight flight1 = new Flight("3U8968", "Chongqing", "Shenzhen", "Domestic flight", 7); //Create a new Flight object.

        Passenger passenger1 = new Passenger("Prajwal", "p.aryal.10@student.scu.edu.au", 19, "ASDFGH", "A11", 5);
        Passenger passenger2 = new Passenger("Barinder", "b.adhikari.11@student.scu.edu.au", 27, "ZXCVBN", "B12", 4);
        Passenger passenger3 = new Passenger("Nitin", "n.ale.magar.10@student.scu.edu.au", 35, "MNBVCX", "L20", 5);
        Passenger passenger4 = new Passenger("Scott", "s.b.c.10@student.scu.edu.au", 33, "LKJHGF", "C16", 5);
        Passenger passenger5 = new Passenger("Jenish", "j.mohsin.10@student.scu.edu.au", 24, "POIUYT", "J21", 5);
        // Add 5 passengers into the flight using the addPassenger method.
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.addPassenger(passenger3);
        flight1.addPassenger(passenger4);
        flight1.addPassenger(passenger5);

        flight1.removePassenger(passenger3); // Remove a passenger using the removePassenger method.

        flight1.numberOfPassengers(); // Print the number of passengers on the flight.

        flight1.printPassengers(); // Print the details of all passengers in the flight.
        System.out.println("------------------------------------------");
    }


    public static void partTwo(){
        System.out.println("---part two:");
        Flight flight2 = new Flight("MU508", "Tokyo", "Beijing", "International flight", 6); //Create a new Flight object.

        Passenger passenger6 = new Passenger("Santiago", "abc2@student.scu.edu.au", 22, "QAZXSW", "J17", 5);
        Passenger passenger7 = new Passenger("Melodie", "uylj60@student.scu.edu.au", 41, "XSWQAZ", "A18", 4);
        Passenger passenger8 = new Passenger("Kaden", "bggdr9@student.scu.edu.au", 60, "CDEWSX", "C10", 9);
        Passenger passenger9 = new Passenger("Clarke", "brsh60@student.scu.edu.au", 52, "EDCVFR", "L24", 4);
        Passenger passenger10 = new Passenger("Ella", "fuji55@student.scu.edu.au", 18, "VFREDC", "K12", 3);
        // Add 5 passengers into the flight using the addPassenger method.
        flight2.addPassenger(passenger6);
        flight2.addPassenger(passenger7);
        flight2.addPassenger(passenger8);
        flight2.addPassenger(passenger9);
        flight2.addPassenger(passenger10);

        flight2.printPassengers(); // Print the details of all passengers in the flight.

        flight2.sortPassengers(); // Sort the LinkedList.
        System.out.println("-----The following are sorted passenger information:----- \n");
        flight2.printPassengers(); // Print the sorted details of all passengers.
        System.out.println("------------------------------------------");
    }

    public static void partThree(){
        System.out.println("---part three:");
        Flight flight3 = new Flight("CA1206", "Beijing", "Xi'an", "Domestic flight", 8); //Create a new Flight object.

        String role1 = "Pilot";
        String role2 = "Co-Pilot";
        String role3 = "FlightAttendantOne";
        String role4 = "FlightAttendantTwo";
        String role5 = "FlightAttendantThree";
        Aircrew aircrew1 = new Aircrew("Lucas", "hjdqj9@student.scu.edu.au", 35, "ppppppp");
        Aircrew aircrew2 = new Aircrew("Bob", "jkwg32@student.scu.edu.au", 30, "oooooooo");
        Aircrew aircrew3 = new Aircrew("Betty", "ehg88@student.scu.edu.au", 26, "iiiiiii");
        Aircrew aircrew4 = new Aircrew("Sally", "kdia21@student.scu.edu.au", 23, "hhhhhhh");
        Aircrew aircrew5 = new Aircrew("Ronnie", "igqo10@student.scu.edu.au", 21, "fffffff");
        // Add 5 aircrews into the flight
        flight3.addAircrew(role1, aircrew1);
        flight3.addAircrew(role2, aircrew2);
        flight3.addAircrew(role3, aircrew3);
        flight3.addAircrew(role4, aircrew4);
        flight3.addAircrew(role5, aircrew5);

        flight3.removeAircrew(role4); // Remove an aircrew member.

        flight3.printAircrew(); // Print details of all crew members on the aircraft.
        System.out.println("------------------------------------------");
    }

    public static void partFour(){
        System.out.println("---part four:");
        Passenger passenger11 = new Passenger("Stacey", "s.hjwcb.20@student.scu.edu.au", 19, "MJUYHN", "L10", 5);
        // This is a demonstration of passing the correct parameters.
        try {
            passenger11.setAge(19);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        // This is a demonstration of passing the wrong parameters.
        try {
            passenger11.setAge(-1);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        System.out.println("------------------------------------------");
    }

    public static void partFive(){
        System.out.println("---part five:");
        Flight flight5 = new Flight("6U3474", "Changsha", "Shenzhen", "International flight", 6); //Create a new Flight object.

        Passenger passenger14 = new Passenger("Alex", "jyfy3@student.scu.edu.au", 36, "PGNKFE", "C13", 4);
        Passenger passenger15 = new Passenger("Peter", "hdtj21@student.scu.edu.au", 47, "JLKIUB", "A16", 3);
        Passenger passenger16 = new Passenger("Max", "guki40@student.scu.edu.au", 15, "SRCVHU", "L15", 5);
        Passenger passenger17 = new Passenger("White", "kudt22@student.scu.edu.au", 54, "GVHJFR", "B19", 6);
        Passenger passenger18 = new Passenger("Coco", "kfyukp6@student.scu.edu.au", 29, "OJLMST", "J20", 5);
        // Add 5 passengers into the flight using the addPassenger method.
        flight5.addPassenger(passenger14);
        flight5.addPassenger(passenger15);
        flight5.addPassenger(passenger16);
        flight5.addPassenger(passenger17);
        flight5.addPassenger(passenger18);
        // Generate a passenger maniest to a file by calling the exportPassengerManifest method.
        flight5.exportPassengerManifest();
        System.out.println("------------------------------------------");
    }

    public static void partSix(){
        System.out.println("---part six:");
        Flight flight6 = new Flight("2U8764", "Chengdu", "Shanghai", "International flight", 7); //Create a new Flight object.
        File writeFile = new File("file.csv"); // Import the created file.
        flight6.importPassengerManifest(writeFile); // Read the file.
        flight6.numberOfPassengers(); // Print the number of passengers on the flight.
        flight6.printPassengers(); // Print the details of all passengers in the flight.
        System.out.println("------------------------------------------");
    }
}
