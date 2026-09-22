import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // ============================================================
    // GLOBAL DATA
    // ============================================================

    static ArrayList<Customer> customers =
            new ArrayList<>();

    static ArrayList<Parcel> parcels =
            new ArrayList<>();

    static Scanner scanner =
            new Scanner(System.in);


    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        FileManager.loadCustomers(customers);
        FileManager.loadParcels(parcels);

        System.out.println();
        System.out.println("============================================================");
        System.out.println("       COURIER & PARCEL MANAGEMENT SYSTEM");
        System.out.println("============================================================");

        System.out.println(
                "Saved customer records: " + customers.size()
        );

        System.out.println(
                "Saved parcel records: " + parcels.size()
        );

        mainMenu();
    }


    // ============================================================
    // MAIN MENU
    // ============================================================

    public static void mainMenu() {

        while (true) {

            System.out.println();
            System.out.println("============================================================");
            System.out.println("                       MAIN MENU");
            System.out.println("============================================================");

            System.out.println("1. Customer Management");
            System.out.println("2. Parcel Management");
            System.out.println("3. Search");
            System.out.println("4. Sort and Filter");
            System.out.println("5. Reports");
            System.out.println("6. Dashboard");
            System.out.println("7. Save Data");
            System.out.println("0. Exit");

            System.out.println("------------------------------------------------------------");

            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    customerMenu();
                    break;

                case 2:
                    parcelMenu();
                    break;

                case 3:
                    searchMenu();
                    break;

                case 4:
                    sortFilterMenu();
                    break;

                case 5:
                    reportMenu();
                    break;

                case 6:

                    ReportManager.displayDashboard(
                            customers,
                            parcels
                    );

                    break;

                case 7:
                    saveData();
                    break;

                case 0:

                    saveData();

                    System.out.println();
                    System.out.println(
                            "Thank you for using the system."
                    );

                    System.out.println(
                            "Program closed successfully."
                    );

                    return;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }
    }


    // ============================================================
    // CUSTOMER MENU
    // ============================================================

    public static void customerMenu() {

        while (true) {

            System.out.println();
            System.out.println("============================================================");
            System.out.println("                  CUSTOMER MANAGEMENT");
            System.out.println("============================================================");

            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Search Customer");
            System.out.println("6. Sort Customers by Name");
            System.out.println("7. Sort Customers by ID");
            System.out.println("0. Back");

            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    ReportManager.displayCustomerReport(
                            customers
                    );
                    break;

                case 3:
                    updateCustomer();
                    break;

                case 4:
                    deleteCustomer();
                    break;

                case 5:
                    searchCustomer();
                    break;

                case 6:

                    SortFilterManager.sortCustomersByName(
                            customers
                    );

                    ReportManager.displayCustomerReport(
                            customers
                    );

                    break;

                case 7:

                    SortFilterManager.sortCustomersByID(
                            customers
                    );

                    ReportManager.displayCustomerReport(
                            customers
                    );

                    break;

                case 0:
                    return;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // ============================================================
    // ADD CUSTOMER
    // ============================================================

    public static void addCustomer() {

        System.out.println();
        System.out.println("--------------- ADD CUSTOMER ---------------");

        System.out.print("Enter Customer ID: ");

        int id = readInt();

        if (!ValidationManager.isValidCustomerID(id)) {

            System.out.println(
                    "Customer ID must be greater than 0."
            );

            return;
        }

        if (SortFilterManager.searchCustomerByID(
                customers,
                id
        ) != null) {

            System.out.println(
                    "Customer ID already exists."
            );

            return;
        }

        System.out.print("Enter Name: ");

        String name =
                scanner.nextLine();

        if (!ValidationManager.isValidName(name)) {

            System.out.println(
                    "Name cannot be empty."
            );

            return;
        }

        System.out.print("Enter Phone: ");

        String phone =
                scanner.nextLine();

        if (!ValidationManager.isValidPhone(phone)) {

            System.out.println(
                    "Invalid phone number."
            );

            System.out.println(
                    "Phone must contain 7 to 15 digits."
            );

            return;
        }

        System.out.print("Enter Address: ");

        String address =
                scanner.nextLine();

        if (!ValidationManager.isValidAddress(address)) {

            System.out.println(
                    "Address cannot be empty."
            );

            return;
        }

        Customer customer =
                new Customer(
                        id,
                        name,
                        phone,
                        address
                );

        customers.add(customer);

        FileManager.saveCustomers(customers);

        System.out.println(
                "Customer added successfully."
        );
    }


    // ============================================================
    // UPDATE CUSTOMER
    // ============================================================

    public static void updateCustomer() {

        System.out.println();

        System.out.print(
                "Enter Customer ID to update: "
        );

        int id = readInt();

        Customer customer =
                SortFilterManager.searchCustomerByID(
                        customers,
                        id
                );

        if (customer == null) {

            System.out.println(
                    "Customer not found."
            );

            return;
        }

        System.out.println();
        System.out.println(
                "Current Customer Information:"
        );

        System.out.println(
                "Name: " + customer.getName()
        );

        System.out.println(
                "Phone: " + customer.getPhone()
        );

        System.out.println(
                "Address: " + customer.getAddress()
        );

        System.out.println();

        System.out.print(
                "Enter new name: "
        );

        String name =
                scanner.nextLine();

        if (!ValidationManager.isValidName(name)) {

            System.out.println(
                    "Name cannot be empty."
            );

            return;
        }

        System.out.print(
                "Enter new phone: "
        );

        String phone =
                scanner.nextLine();

        if (!ValidationManager.isValidPhone(phone)) {

            System.out.println(
                    "Invalid phone number."
            );

            return;
        }

        System.out.print(
                "Enter new address: "
        );

        String address =
                scanner.nextLine();

        if (!ValidationManager.isValidAddress(address)) {

            System.out.println(
                    "Address cannot be empty."
            );

            return;
        }

        customer.setName(name);

        customer.setPhone(phone);

        customer.setAddress(address);

        FileManager.saveCustomers(customers);

        System.out.println(
                "Customer updated successfully."
        );
    }


    // ============================================================
    // DELETE CUSTOMER
    // ============================================================

    public static void deleteCustomer() {

        System.out.println();

        System.out.print(
                "Enter Customer ID to delete: "
        );

        int id = readInt();

        Customer customer =
                SortFilterManager.searchCustomerByID(
                        customers,
                        id
                );

        if (customer == null) {

            System.out.println(
                    "Customer not found."
            );

            return;
        }

        System.out.println(
                "Customer found: "
                        + customer.getName()
        );

        System.out.print(
                "Are you sure you want to delete this customer? (Y/N): "
        );

        String confirmation =
                scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {

            customers.remove(customer);

            FileManager.saveCustomers(customers);

            System.out.println(
                    "Customer deleted successfully."
            );

        } else {

            System.out.println(
                    "Delete operation cancelled."
            );
        }
    }


    // ============================================================
    // SEARCH CUSTOMER
    // ============================================================

    public static void searchCustomer() {

        System.out.print(
                "Enter Customer ID to search: "
        );

        int id = readInt();

        Customer customer =
                SortFilterManager.searchCustomerByID(
                        customers,
                        id
                );

        if (customer == null) {

            System.out.println(
                    "Customer not found."
            );

            return;
        }

        System.out.println();
        System.out.println("Customer Found");
        System.out.println("-------------------------");

        System.out.println(
                "Customer ID: "
                        + customer.getCustomerID()
        );

        System.out.println(
                "Name: "
                        + customer.getName()
        );

        System.out.println(
                "Phone: "
                        + customer.getPhone()
        );

        System.out.println(
                "Address: "
                        + customer.getAddress()
        );
    }


    // ============================================================
    // PARCEL MENU
    // ============================================================

    public static void parcelMenu() {

        while (true) {

            System.out.println();
            System.out.println("============================================================");
            System.out.println("                    PARCEL MANAGEMENT");
            System.out.println("============================================================");

            System.out.println("1. Add Parcel");
            System.out.println("2. View Parcels");
            System.out.println("3. Update Parcel");
            System.out.println("4. Delete Parcel");
            System.out.println("5. Update Parcel Status");
            System.out.println("6. Search Parcel");
            System.out.println("0. Back");

            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    addParcel();
                    break;

                case 2:
                    ReportManager.displayParcelReport(
                            parcels
                    );
                    break;

                case 3:
                    updateParcel();
                    break;

                case 4:
                    deleteParcel();
                    break;

                case 5:
                    updateParcelStatus();
                    break;

                case 6:
                    searchParcel();
                    break;

                case 0:
                    return;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // ============================================================
    // ADD PARCEL
    // ============================================================

    public static void addParcel() {

        System.out.println();
        System.out.println("--------------- ADD PARCEL ---------------");

        System.out.print("Enter Tracking ID: ");

        String trackingID =
                scanner.nextLine();

        if (!ValidationManager.isValidTrackingID(
                trackingID)) {

            System.out.println(
                    "Tracking ID cannot be empty."
            );

            return;
        }

        if (SortFilterManager.searchByTrackingID(
                parcels,
                trackingID
        ) != null) {

            System.out.println(
                    "Tracking ID already exists."
            );

            return;
        }

        System.out.print("Enter Sender Name: ");

        String sender =
                scanner.nextLine();

        if (!ValidationManager.isValidName(sender)) {

            System.out.println(
                    "Sender name cannot be empty."
            );

            return;
        }

        System.out.print("Enter Receiver Name: ");

        String receiver =
                scanner.nextLine();

        if (!ValidationManager.isValidName(receiver)) {

            System.out.println(
                    "Receiver name cannot be empty."
            );

            return;
        }

        System.out.print("Enter Receiver Phone: ");

        String receiverPhone =
                scanner.nextLine();

        if (!ValidationManager.isValidPhone(
                receiverPhone)) {

            System.out.println(
                    "Invalid receiver phone number."
            );

            return;
        }

        System.out.print("Enter Destination: ");

        String destination =
                scanner.nextLine();

        if (!ValidationManager.isValidAddress(
                destination)) {

            System.out.println(
                    "Destination cannot be empty."
            );

            return;
        }

        System.out.print("Enter Weight (kg): ");

        double weight =
                readDouble();

        if (!ValidationManager.isValidWeight(
                weight)) {

            System.out.println(
                    "Weight must be greater than 0."
            );

            return;
        }

        String status = "Pending";

        Parcel parcel =
                new Parcel(
                        trackingID,
                        sender,
                        receiver,
                        receiverPhone,
                        destination,
                        weight,
                        status
                );

        parcels.add(parcel);

        FileManager.saveParcels(parcels);

        System.out.println();

        System.out.println(
                "Parcel added successfully."
        );

        System.out.printf(
                "Delivery Charge: Rs. %.2f%n",
                parcel.getDeliveryCharge()
        );
    }


    // ============================================================
    // UPDATE PARCEL
    // ============================================================

    public static void updateParcel() {

        System.out.println();

        System.out.print(
                "Enter Tracking ID to update: "
        );

        String trackingID =
                scanner.nextLine();

        Parcel parcel =
                SortFilterManager.searchByTrackingID(
                        parcels,
                        trackingID
                );

        if (parcel == null) {

            System.out.println(
                    "Parcel not found."
            );

            return;
        }

        System.out.println();
        System.out.println(
                "Current Parcel Information:"
        );

        System.out.println(
                "Sender: "
                        + parcel.getSenderName()
        );

        System.out.println(
                "Receiver: "
                        + parcel.getReceiverName()
        );

        System.out.println(
                "Receiver Phone: "
                        + parcel.getReceiverPhone()
        );

        System.out.println(
                "Destination: "
                        + parcel.getDestination()
        );

        System.out.println(
                "Weight: "
                        + parcel.getWeight()
                        + " kg"
        );

        System.out.println();

        System.out.print(
                "Enter new sender name: "
        );

        String sender =
                scanner.nextLine();

        if (!ValidationManager.isValidName(sender)) {

            System.out.println(
                    "Sender name cannot be empty."
            );

            return;
        }

        System.out.print(
                "Enter new receiver name: "
        );

        String receiver =
                scanner.nextLine();

        if (!ValidationManager.isValidName(receiver)) {

            System.out.println(
                    "Receiver name cannot be empty."
            );

            return;
        }

        System.out.print(
                "Enter new receiver phone: "
        );

        String phone =
                scanner.nextLine();

        if (!ValidationManager.isValidPhone(phone)) {

            System.out.println(
                    "Invalid phone number."
            );

            return;
        }

        System.out.print(
                "Enter new destination: "
        );

        String destination =
                scanner.nextLine();

        if (!ValidationManager.isValidAddress(
                destination)) {

            System.out.println(
                    "Destination cannot be empty."
            );

            return;
        }

        System.out.print(
                "Enter new weight (kg): "
        );

        double weight =
                readDouble();

        if (!ValidationManager.isValidWeight(
                weight)) {

            System.out.println(
                    "Weight must be greater than 0."
            );

            return;
        }

        parcel.setSenderName(sender);

        parcel.setReceiverName(receiver);

        parcel.setReceiverPhone(phone);

        parcel.setDestination(destination);

        parcel.setWeight(weight);

        FileManager.saveParcels(parcels);

        System.out.println(
                "Parcel updated successfully."
        );

        System.out.printf(
                "New Delivery Charge: Rs. %.2f%n",
                parcel.getDeliveryCharge()
        );
    }


    // ============================================================
    // DELETE PARCEL
    // ============================================================

    public static void deleteParcel() {

        System.out.println();

        System.out.print(
                "Enter Tracking ID to delete: "
        );

        String trackingID =
                scanner.nextLine();

        Parcel parcel =
                SortFilterManager.searchByTrackingID(
                        parcels,
                        trackingID
                );

        if (parcel == null) {

            System.out.println(
                    "Parcel not found."
            );

            return;
        }

        System.out.println(
                "Parcel found: "
                        + parcel.getTrackingID()
        );

        System.out.print(
                "Are you sure you want to delete this parcel? (Y/N): "
        );

        String confirmation =
                scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {

            parcels.remove(parcel);

            FileManager.saveParcels(parcels);

            System.out.println(
                    "Parcel deleted successfully."
            );

        } else {

            System.out.println(
                    "Delete operation cancelled."
            );
        }
    }


    // ============================================================
    // UPDATE PARCEL STATUS
    // ============================================================

    public static void updateParcelStatus() {

        System.out.print(
                "Enter Tracking ID: "
        );

        String trackingID =
                scanner.nextLine();

        Parcel parcel =
                SortFilterManager.searchByTrackingID(
                        parcels,
                        trackingID
                );

        if (parcel == null) {

            System.out.println(
                    "Parcel not found."
            );

            return;
        }

        System.out.println();
        System.out.println("Select New Status:");

        System.out.println("1. Pending");
        System.out.println("2. In Transit");
        System.out.println("3. Delivered");
        System.out.println("4. Cancelled");

        System.out.print("Enter choice: ");

        int choice = readInt();

        String newStatus;

        switch (choice) {

            case 1:
                newStatus = "Pending";
                break;

            case 2:
                newStatus = "In Transit";
                break;

            case 3:
                newStatus = "Delivered";
                break;

            case 4:
                newStatus = "Cancelled";
                break;

            default:

                System.out.println(
                        "Invalid status choice."
                );

                return;
        }

        parcel.setStatus(newStatus);

        FileManager.saveParcels(parcels);

        System.out.println(
                "Parcel status updated successfully."
        );
    }


    // ============================================================
    // SEARCH PARCEL
    // ============================================================

    public static void searchParcel() {

        System.out.print(
                "Enter Tracking ID to search: "
        );

        String trackingID =
                scanner.nextLine();

        Parcel parcel =
                SortFilterManager.searchByTrackingID(
                        parcels,
                        trackingID
                );

        if (parcel == null) {

            System.out.println(
                    "Parcel not found."
            );

            return;
        }

        System.out.println();
        System.out.println("Parcel Found");
        System.out.println("-------------------------");

        System.out.println(
                "Tracking ID: "
                        + parcel.getTrackingID()
        );

        System.out.println(
                "Sender: "
                        + parcel.getSenderName()
        );

        System.out.println(
                "Receiver: "
                        + parcel.getReceiverName()
        );

        System.out.println(
                "Receiver Phone: "
                        + parcel.getReceiverPhone()
        );

        System.out.println(
                "Destination: "
                        + parcel.getDestination()
        );

        System.out.println(
                "Weight: "
                        + parcel.getWeight()
                        + " kg"
        );

        System.out.println(
                "Status: "
                        + parcel.getStatus()
        );

        System.out.printf(
                "Delivery Charge: Rs. %.2f%n",
                parcel.getDeliveryCharge()
        );
    }


    // ============================================================
    // SEARCH MENU
    // ============================================================

    public static void searchMenu() {

        while (true) {

            System.out.println();
            System.out.println("============================================================");
            System.out.println("                       SEARCH");
            System.out.println("============================================================");

            System.out.println("1. Search Customer by ID");
            System.out.println("2. Search Parcel by Tracking ID");
            System.out.println("0. Back");

            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    searchCustomer();
                    break;

                case 2:
                    searchParcel();
                    break;

                case 0:
                    return;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // ============================================================
    // SORT AND FILTER MENU
    // ============================================================

    public static void sortFilterMenu() {

        while (true) {

            System.out.println();
            System.out.println("============================================================");
            System.out.println("                    SORT & FILTER");
            System.out.println("============================================================");

            System.out.println("1. Sort Customers by Name");
            System.out.println("2. Sort Customers by ID");
            System.out.println("3. Sort Parcels by Weight");
            System.out.println("4. Sort Parcels by Tracking ID");
            System.out.println("5. Filter Parcels by Status");
            System.out.println("6. Filter Parcels by Destination");
            System.out.println("0. Back");

            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:

                    SortFilterManager.sortCustomersByName(
                            customers
                    );

                    ReportManager.displayCustomerReport(
                            customers
                    );

                    break;

                case 2:

                    SortFilterManager.sortCustomersByID(
                            customers
                    );

                    ReportManager.displayCustomerReport(
                            customers
                    );

                    break;

                case 3:

                    SortFilterManager.sortParcelsByWeight(
                            parcels
                    );

                    ReportManager.displayParcelReport(
                            parcels
                    );

                    break;

                case 4:

                    SortFilterManager.sortParcelsByTrackingID(
                            parcels
                    );

                    ReportManager.displayParcelReport(
                            parcels
                    );

                    break;

                case 5:

                    filterByStatus();

                    break;

                case 6:

                    filterByDestination();

                    break;

                case 0:

                    return;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // ============================================================
    // FILTER BY STATUS
    // ============================================================

    public static void filterByStatus() {

        System.out.println();

        System.out.println("1. Pending");
        System.out.println("2. In Transit");
        System.out.println("3. Delivered");
        System.out.println("4. Cancelled");

        System.out.print("Enter status choice: ");

        int choice = readInt();

        String status;

        switch (choice) {

            case 1:
                status = "Pending";
                break;

            case 2:
                status = "In Transit";
                break;

            case 3:
                status = "Delivered";
                break;

            case 4:
                status = "Cancelled";
                break;

            default:

                System.out.println(
                        "Invalid choice."
                );

                return;
        }

        ArrayList<Parcel> result =
                SortFilterManager.filterByStatus(
                        parcels,
                        status
                );

        System.out.println();

        System.out.println(
                "Parcels with status: " + status
        );

        SortFilterManager.displayParcels(result);
    }


    // ============================================================
    // FILTER BY DESTINATION
    // ============================================================

    public static void filterByDestination() {

        System.out.print(
                "Enter destination: "
        );

        String destination =
                scanner.nextLine();

        ArrayList<Parcel> result =
                SortFilterManager.filterByDestination(
                        parcels,
                        destination
                );

        System.out.println();

        System.out.println(
                "Parcels going to: "
                        + destination
        );

        SortFilterManager.displayParcels(result);
    }


    // ============================================================
    // REPORT MENU
    // ============================================================

    public static void reportMenu() {

        while (true) {

            System.out.println();
            System.out.println("============================================================");
            System.out.println("                       REPORTS");
            System.out.println("============================================================");

            System.out.println("1. Customer Report");
            System.out.println("2. Parcel Report");
            System.out.println("3. Parcel Status Report");
            System.out.println("4. Weight Report");
            System.out.println("5. Charge Report");
            System.out.println("6. Destination-wise Report");
            System.out.println("7. Complete Report");
            System.out.println("0. Back");

            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:

                    ReportManager.displayCustomerReport(
                            customers
                    );

                    break;

                case 2:

                    ReportManager.displayParcelReport(
                            parcels
                    );

                    break;

                case 3:

                    ReportManager.displayStatusReport(
                            parcels
                    );

                    break;

                case 4:

                    ReportManager.displayWeightReport(
                            parcels
                    );

                    break;

                case 5:

                    ReportManager.displayChargeReport(
                            parcels
                    );

                    break;

                case 6:

                    ReportManager.displayDestinationReport(
                            parcels
                    );

                    break;

                case 7:

                    ReportManager.displayCompleteReport(
                            customers,
                            parcels
                    );

                    break;

                case 0:

                    return;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // ============================================================
    // SAVE DATA
    // ============================================================

    public static void saveData() {

        FileManager.saveCustomers(customers);

        FileManager.saveParcels(parcels);

        System.out.println(
                "All data saved successfully."
        );
    }


    // ============================================================
    // READ INTEGER SAFELY
    // ============================================================

    public static int readInt() {

        while (true) {

            try {

                int value =
                        Integer.parseInt(
                                scanner.nextLine()
                        );

                return value;

            } catch (NumberFormatException e) {

                System.out.print(
                        "Please enter a valid number: "
                );
            }
        }
    }


    // ============================================================
    // READ DOUBLE SAFELY
    // ============================================================

    public static double readDouble() {

        while (true) {

            try {

                double value =
                        Double.parseDouble(
                                scanner.nextLine()
                        );

                return value;

            } catch (NumberFormatException e) {

                System.out.print(
                        "Please enter a valid number: "
                );
            }
        }
    }
}