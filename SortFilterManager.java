import java.util.ArrayList;
import java.util.Comparator;

public class SortFilterManager {

    // ============================================================
    // SORT CUSTOMERS BY NAME
    // ============================================================

    public static void sortCustomersByName(
            ArrayList<Customer> customers) {

        customers.sort(
                Comparator.comparing(
                        Customer::getName,
                        String.CASE_INSENSITIVE_ORDER
                )
        );

        System.out.println(
                "Customers sorted by name successfully."
        );
    }


    // ============================================================
    // SORT CUSTOMERS BY ID
    // ============================================================

    public static void sortCustomersByID(
            ArrayList<Customer> customers) {

        customers.sort(
                Comparator.comparingInt(
                        Customer::getCustomerID
                )
        );

        System.out.println(
                "Customers sorted by ID successfully."
        );
    }


    // ============================================================
    // SORT PARCELS BY WEIGHT
    // ============================================================

    public static void sortParcelsByWeight(
            ArrayList<Parcel> parcels) {

        parcels.sort(
                Comparator.comparingDouble(
                        Parcel::getWeight
                )
        );

        System.out.println(
                "Parcels sorted by weight successfully."
        );
    }


    // ============================================================
    // SORT PARCELS BY TRACKING ID
    // ============================================================

    public static void sortParcelsByTrackingID(
            ArrayList<Parcel> parcels) {

        parcels.sort(
                Comparator.comparing(
                        Parcel::getTrackingID,
                        String.CASE_INSENSITIVE_ORDER
                )
        );

        System.out.println(
                "Parcels sorted by tracking ID successfully."
        );
    }


    // ============================================================
    // FILTER PARCELS BY STATUS
    // ============================================================

    public static ArrayList<Parcel> filterByStatus(
            ArrayList<Parcel> parcels,
            String status) {

        ArrayList<Parcel> result =
                new ArrayList<>();


        for (Parcel parcel : parcels) {

            if (parcel.getStatus()
                    .equalsIgnoreCase(status)) {

                result.add(parcel);
            }
        }


        return result;
    }


    // ============================================================
    // FILTER PARCELS BY DESTINATION
    // ============================================================

    public static ArrayList<Parcel> filterByDestination(
            ArrayList<Parcel> parcels,
            String destination) {

        ArrayList<Parcel> result =
                new ArrayList<>();


        for (Parcel parcel : parcels) {

            if (parcel.getDestination()
                    .equalsIgnoreCase(destination)) {

                result.add(parcel);
            }
        }


        return result;
    }


    // ============================================================
    // SEARCH PARCEL BY TRACKING ID
    // ============================================================

    public static Parcel searchByTrackingID(
            ArrayList<Parcel> parcels,
            String trackingID) {

        for (Parcel parcel : parcels) {

            if (parcel.getTrackingID()
                    .equalsIgnoreCase(trackingID)) {

                return parcel;
            }
        }


        return null;
    }


    // ============================================================
    // SEARCH CUSTOMER BY ID
    // ============================================================

    public static Customer searchCustomerByID(
            ArrayList<Customer> customers,
            int customerID) {

        for (Customer customer : customers) {

            if (customer.getCustomerID() == customerID) {

                return customer;
            }
        }


        return null;
    }


    // ============================================================
    // DISPLAY FILTERED PARCELS
    // ============================================================

    public static void displayParcels(
            ArrayList<Parcel> parcels) {

        if (parcels.isEmpty()) {

            System.out.println(
                    "No matching parcels found."
            );

            return;
        }


        System.out.println();
        System.out.println(
                "=========================================================================="
        );

        System.out.printf(
                "%-12s %-18s %-18s %-15s %-10s %-12s%n",
                "Tracking ID",
                "Sender",
                "Receiver",
                "Destination",
                "Weight",
                "Status"
        );

        System.out.println(
                "--------------------------------------------------------------------------"
        );


        for (Parcel parcel : parcels) {

            System.out.printf(
                    "%-12s %-18s %-18s %-15s %-10.2f %-12s%n",
                    parcel.getTrackingID(),
                    parcel.getSenderName(),
                    parcel.getReceiverName(),
                    parcel.getDestination(),
                    parcel.getWeight(),
                    parcel.getStatus()
            );
        }


        System.out.println(
                "--------------------------------------------------------------------------"
        );

        System.out.println(
                "Matching Parcels: " + parcels.size()
        );
    }
}