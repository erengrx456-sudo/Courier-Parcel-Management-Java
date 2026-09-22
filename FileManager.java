import java.io.*;
import java.util.ArrayList;

public class FileManager {


    // ============================================================
    // CUSTOMER FILE
    // ============================================================

    private static final String CUSTOMER_FILE = "customers.txt";


    // ============================================================
    // PARCEL FILE
    // ============================================================

    private static final String PARCEL_FILE = "parcels.txt";


    // ============================================================
    // SAVE CUSTOMERS
    // ============================================================

    public static void saveCustomers(
            ArrayList<Customer> customers) {

        try {

            FileWriter writer =
                    new FileWriter(CUSTOMER_FILE);


            for (Customer customer : customers) {

                writer.write(
                        customer.getCustomerID()
                        + "|"
                        + customer.getName()
                        + "|"
                        + customer.getPhone()
                        + "|"
                        + customer.getAddress()
                        + "\n"
                );
            }


            writer.close();

        }

        catch (IOException e) {

            System.out.println(
                    "Error saving customer data."
            );
        }
    }


    // ============================================================
    // LOAD CUSTOMERS
    // ============================================================

    public static void loadCustomers(
            ArrayList<Customer> customers) {

        File file = new File(CUSTOMER_FILE);


        // If the file does not exist,
        // there is nothing to load.

        if (!file.exists()) {

            return;
        }


        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );


            String line;


            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {

                    continue;
                }


                String[] data =
                        line.split("\\|", -1);


                if (data.length == 4) {

                    try {

                        int customerID =
                                Integer.parseInt(data[0]);


                        Customer customer =
                                new Customer(
                                        customerID,
                                        data[1],
                                        data[2],
                                        data[3]
                                );


                        customers.add(customer);
                    }

                    catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid customer ID found."
                        );
                    }
                }
            }


            reader.close();

        }

        catch (IOException e) {

            System.out.println(
                    "Error loading customer data."
            );
        }
    }


    // ============================================================
    // SAVE PARCELS
    // ============================================================

    public static void saveParcels(
            ArrayList<Parcel> parcels) {

        try {

            FileWriter writer =
                    new FileWriter(PARCEL_FILE);


            for (Parcel parcel : parcels) {

                writer.write(
                        parcel.getTrackingID()
                        + "|"
                        + parcel.getSenderName()
                        + "|"
                        + parcel.getReceiverName()
                        + "|"
                        + parcel.getReceiverPhone()
                        + "|"
                        + parcel.getDestination()
                        + "|"
                        + parcel.getWeight()
                        + "|"
                        + parcel.getStatus()
                        + "\n"
                );
            }


            writer.close();

        }

        catch (IOException e) {

            System.out.println(
                    "Error saving parcel data."
            );
        }
    }


    // ============================================================
    // LOAD PARCELS
    // ============================================================

    public static void loadParcels(
            ArrayList<Parcel> parcels) {

        File file = new File(PARCEL_FILE);


        // If the file does not exist,
        // there is nothing to load.

        if (!file.exists()) {

            return;
        }


        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );


            String line;


            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {

                    continue;
                }


                String[] data =
                        line.split("\\|", -1);


                if (data.length == 7) {

                    try {

                        double weight =
                                Double.parseDouble(data[5]);


                        Parcel parcel =
                                new Parcel(
                                        data[0],
                                        data[1],
                                        data[2],
                                        data[3],
                                        data[4],
                                        weight,
                                        data[6]
                                );


                        parcels.add(parcel);
                    }

                    catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid parcel weight found."
                        );
                    }
                }
            }


            reader.close();

        }

        catch (IOException e) {

            System.out.println(
                    "Error loading parcel data."
            );
        }
    }


    // ============================================================
    // CLEAR CUSTOMER FILE
    // ============================================================

    public static void clearCustomerFile() {

        try {

            FileWriter writer =
                    new FileWriter(CUSTOMER_FILE);

            writer.close();

        }

        catch (IOException e) {

            System.out.println(
                    "Error clearing customer file."
            );
        }
    }


    // ============================================================
    // CLEAR PARCEL FILE
    // ============================================================

    public static void clearParcelFile() {

        try {

            FileWriter writer =
                    new FileWriter(PARCEL_FILE);

            writer.close();

        }

        catch (IOException e) {

            System.out.println(
                    "Error clearing parcel file."
            );
        }
    }
}