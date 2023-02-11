import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Flight {
    private Lock lock = new ReentrantLock();
    LinkedList<Passenger> passengerList = new LinkedList(); //Create a LinkedList to store a collection of passengers flying on an airplane.
    HashMap<String, Aircrew> map = new HashMap<>(); // Create a HashMap to store the crew operating the flight and their associated roles.
    private String flightCode;
    private String origin;
    private String destination;
    private String aircraftType;
    private int numberOfSeats; // number of available seats

    public Flight(String flightCode, String origin, String destination,  String aircraftType, int numberOfSeats) {
        this.flightCode = flightCode;
        this.origin = origin;
        this.destination = destination;
        this.aircraftType = aircraftType;
        this.numberOfSeats = numberOfSeats;

    }

    /**
     * Check if seats are available on the flight and, if so, add passengers to the flight.
     */
    public void addPassenger(Passenger passenger){
        // The passenger cannot be empty.
        if(passenger == null)
            throw new IllegalArgumentException("The passenger path cannot be null!!!");

        if(numberOfSeats > 0){
            if(!passengerList.contains(passenger)){
                lock.lock();
                try{
                    passengerList.add(passenger);
                    numberOfSeats--;
                } finally {
                    try{
                        lock.unlock();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            // The passenger cannot be added repeatedly.
            else{
                throw new IllegalArgumentException(passenger.getName() + " has been added. Duplicate passengers cannot be added!!!");
            }
        }
        else {
            System.out.println("The flight is fully booked. No available seat anymore.");
        }
    }

    /**
     * Remove the passenger from the flight.
     */
    public void removePassenger(Passenger passenger){
        // The passenger who has been chosen to be removed cannot be empty.
        if(passenger == null)
            throw new IllegalArgumentException("The passenger path cannot be null!!!");

        if(passengerList.contains(passenger)){
            lock.lock();
            try {
                // Remove the passenger from the flight.
                passengerList.remove(passenger);
            }finally {
                try{
                    lock.unlock();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        // The passenger is not on this flight.
        else {
            throw new IllegalArgumentException(passenger.getName() + " was not a passenger on this flight!!!");
        }
    }

    /**
     * Return the number of passengers on the flight.
     */
    public int numberOfPassengers(){
        System.out.println("The number of passengers on the flight: " + passengerList.size());
        System.out.println();
        return passengerList.size();
    }

    /**
     * Print the details of all passengers on the flight.
     */
    public void printPassengers(){
        Iterator<Passenger> iterator = passengerList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println();
        }
    }

    /**
     * Returns the LinkedList
     */
    public LinkedList<Passenger> allPassengers(){
        return passengerList;
    }

    /**
     * Sort the LinkedList.
     */
    public void sortPassengers(){
        TestCompare comparator = new TestCompare("Tony", "gfsrd64@student.scu.edu.au", 35, "UJNKOY", "L13", 6);
        lock.lock();
        try {
            Collections.sort(passengerList, comparator);
        }finally {
            try{
                lock.unlock();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Add the crew and their roles to HashMap.
     */
    public void addAircrew(String role, Aircrew aircrews){
        // The crew cannot be empty.
        if(role == null || aircrews == null)
            throw new IllegalArgumentException("The aircrew path cannot be null!!!");

        if(!map.containsKey(role)){
            map.put(role, aircrews);
        }
        // Cabin crew cannot be added repeatedly.
        else{
            throw new IllegalArgumentException(role + " has been added. Do not add repeats!!!");
        }
    }

    /**
     * Remove crew members and their roles from HashMap.
     */
    public void removeAircrew(String role){
        if(map.containsKey(role)){
            map.remove(role);
        }
        // This crew member is not on this flight.
        else {
            throw new IllegalArgumentException(role + " was not on the flight!!!");
        }
    }

    /**
     * Print the details of all crew operating flights.
     */
    public void printAircrew(){
        Iterator<HashMap.Entry<String, Aircrew>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println();
        }
    }

    /**
     * Write the details of all passengers travelling on the flight to a file.
     */
    public void exportPassengerManifest(){
        File writeFile = new File("file.csv");
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(writeFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            lock.lock();
            try {
                for (Passenger passenger : passengerList) {
                    bufferedWriter.write(""+ passenger);
                    bufferedWriter.newLine();
                }
            }finally {
                try{
                    lock.unlock();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Reading from a file.
     * @param file
     */
    public void importPassengerManifest(File file){
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the information read from the file into separate values.
                String item[] = line.split(", ");
                // Converts two String types to int.
                String str2 = item[2];
                String str5 = item[5];
                int inum2 = Integer.parseInt(str2);
                int inum5 = Integer.parseInt(str5);
                // Create a passenger object.
                Passenger p1 = new Passenger(item[0],item[1], inum2, item[3], item[4], inum5);
                // Add the created passenger object to the flight.
                addPassenger(p1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode){
        if (flightCode != null)
        {
            this.flightCode = flightCode;
        }
        else
        {
            throw new IllegalArgumentException("The data of parameter flightCode must be valid!!!");
        }
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin){
        if (origin != null)
        {
            this.origin = origin;
        }
        else
        {
            throw new IllegalArgumentException("The data of parameter origin must be valid!!!");
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination){
        if (destination != null)
        {
            this.destination = destination;
        }
        else
        {
            throw new IllegalArgumentException("The parameter data must be valid!!!");
        }
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType){
        if (aircraftType != null)
        {
            this.aircraftType = aircraftType;
        }
        else
        {
            throw new IllegalArgumentException("The data of aircraftType must be valid!!!");
        }
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }


    public void setNumberOfSeats(int numberOfSeats){
        if (numberOfSeats <= 0)
        {
            throw new IllegalArgumentException("The number of numberOfSeats must be greater than 0!!!");
        }
        else
        {
            this.numberOfSeats = numberOfSeats;
        }
    }

}
