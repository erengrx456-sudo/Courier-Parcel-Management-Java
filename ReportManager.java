import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportManager {

    // ============================================================
    // CUSTOMER REPORT
    // ============================================================

    public static void displayCustomerReport(
            ArrayList<Customer> customers) {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("                  CUSTOMER REPORT");
        System.out.println("============================================================");

        if (customers.isEmpty()) {

            System.out.println("No customer records found.");

            return;
        }

        System.out.printf(
                "%-12s %-20s %-15s %-25s%n",
                "Customer ID",
                "Name",
                "Phone",
                "Address"
        );

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        for (Customer customer : customers) {

            System.out.printf(
                    "%-12d %-20s %-15s %-25s%n",
                    customer.getCustomerID(),
                    customer.getName(),
                    customer.getPhone(),
                    customer.getAddress()
            );
        }

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        System.out.println(
                "Total Customers: " + customers.size()
        );
    }


    // ============================================================
    // PARCEL REPORT
    // ============================================================

    public static void displayParcelReport(
            ArrayList<Parcel> parcels) {

        System.out.println();
        System.out.println(
                "=============================================================================================="
        );

        System.out.println(
                "                              PARCEL REPORT"
        );

        System.out.println(
                "=============================================================================================="
        );

        if (parcels.isEmpty()) {

            System.out.println("No parcel records found.");

            return;
        }

        System.out.printf(
                "%-12s %-18s %-18s %-15s %-10s %-12s %-12s%n",
                "Tracking ID",
                "Sender",
                "Receiver",
                "Destination",
                "Weight",
                "Status",
                "Charge"
        );

        System.out.println(
                "----------------------------------------------------------------------------------------------"
        );

        for (Parcel parcel : parcels) {

            System.out.printf(
                    "%-12s %-18s %-18s %-15s %-10.2f %-12s Rs.%-8.2f%n",
                    parcel.getTrackingID(),
                    parcel.getSenderName(),
                    parcel.getReceiverName(),
                    parcel.getDestination(),
                    parcel.getWeight(),
                    parcel.getStatus(),
                    parcel.getDeliveryCharge()
            );
        }

        System.out.println(
                "----------------------------------------------------------------------------------------------"
        );

        System.out.println(
                "Total Parcels: " + parcels.size()
        );
    }


    // ============================================================
    // PARCEL STATUS REPORT
    // ============================================================

    public static void displayStatusReport(
            ArrayList<Parcel> parcels) {

        int pending = 0;
        int inTransit = 0;
        int delivered = 0;
        int cancelled = 0;

        for (Parcel parcel : parcels) {

            String status =
                    parcel.getStatus().toLowerCase();

            if (status.equals("pending")) {

                pending++;

            } else if (status.equals("in transit")) {

                inTransit++;

            } else if (status.equals("delivered")) {

                delivered++;

            } else if (status.equals("cancelled")) {

                cancelled++;
            }
        }

        System.out.println();
        System.out.println("============================================================");
        System.out.println("                    PARCEL STATUS REPORT");
        System.out.println("============================================================");

        System.out.println(
                "Pending      : " + pending
        );

        System.out.println(
                "In Transit   : " + inTransit
        );

        System.out.println(
                "Delivered    : " + delivered
        );

        System.out.println(
                "Cancelled    : " + cancelled
        );

        System.out.println(
                "------------------------------------------------------------"
        );

        System.out.println(
                "Total Parcels: " + parcels.size()
        );
    }


    // ============================================================
    // WEIGHT REPORT
    // ============================================================

    public static void displayWeightReport(
            ArrayList<Parcel> parcels) {

        if (parcels.isEmpty()) {

            System.out.println();
            System.out.println("No parcel records found.");

            return;
        }

        double totalWeight = 0;
        double highestWeight = 0;
        double lowestWeight = Double.MAX_VALUE;

        for (Parcel parcel : parcels) {

            double weight =
                    parcel.getWeight();

            totalWeight += weight;

            if (weight > highestWeight) {

                highestWeight = weight;
            }

            if (weight < lowestWeight) {

                lowestWeight = weight;
            }
        }

        double averageWeight =
                totalWeight / parcels.size();

        System.out.println();
        System.out.println("============================================================");
        System.out.println("                     WEIGHT REPORT");
        System.out.println("============================================================");

        System.out.printf(
                "Total Weight   : %.2f kg%n",
                totalWeight
        );

        System.out.printf(
                "Average Weight : %.2f kg%n",
                averageWeight
        );

        System.out.printf(
                "Highest Weight : %.2f kg%n",
                highestWeight
        );

        System.out.printf(
                "Lowest Weight  : %.2f kg%n",
                lowestWeight
        );
    }


    // ============================================================
    // CHARGE REPORT
    // ============================================================

    public static void displayChargeReport(
            ArrayList<Parcel> parcels) {

        if (parcels.isEmpty()) {

            System.out.println();
            System.out.println("No parcel records found.");

            return;
        }

        double totalCharge = 0;

        for (Parcel parcel : parcels) {

            totalCharge +=
                    parcel.getDeliveryCharge();
        }

        System.out.println();
        System.out.println("============================================================");
        System.out.println("                    CHARGE REPORT");
        System.out.println("============================================================");

        for (Parcel parcel : parcels) {

            System.out.printf(
                    "%-12s %-15s Rs. %.2f%n",
                    parcel.getTrackingID(),
                    parcel.getDestination(),
                    parcel.getDeliveryCharge()
            );
        }

        System.out.println(
                "------------------------------------------------------------"
        );

        System.out.printf(
                "Total Delivery Charges: Rs. %.2f%n",
                totalCharge
        );
    }


    // ============================================================
    // SYSTEM DASHBOARD
    // ============================================================

    public static void displayDashboard(
            ArrayList<Customer> customers,
            ArrayList<Parcel> parcels) {

        int pending = 0;
        int inTransit = 0;
        int delivered = 0;
        int cancelled = 0;

        double totalWeight = 0;
        double totalCharge = 0;

        for (Parcel parcel : parcels) {

            String status =
                    parcel.getStatus().toLowerCase();

            if (status.equals("pending")) {

                pending++;

            } else if (status.equals("in transit")) {

                inTransit++;

            } else if (status.equals("delivered")) {

                delivered++;

            } else if (status.equals("cancelled")) {

                cancelled++;
            }

            totalWeight +=
                    parcel.getWeight();

            totalCharge +=
                    parcel.getDeliveryCharge();
        }

        double averageWeight = 0;

        if (!parcels.isEmpty()) {

            averageWeight =
                    totalWeight / parcels.size();
        }

        System.out.println();

        System.out.println(
                "============================================================"
        );

        System.out.println(
                "                    SYSTEM DASHBOARD"
        );

        System.out.println(
                "============================================================"
        );

        System.out.println();

        System.out.println(
                "CUSTOMER INFORMATION"
        );

        System.out.println(
                "------------------------------------------------------------"
        );

        System.out.println(
                "Total Customers       : "
                        + customers.size()
        );

        System.out.println();

        System.out.println(
                "PARCEL INFORMATION"
        );

        System.out.println(
                "------------------------------------------------------------"
        );

        System.out.println(
                "Total Parcels         : "
                        + parcels.size()
        );

        System.out.println(
                "Pending Parcels       : "
                        + pending
        );

        System.out.println(
                "In Transit Parcels    : "
                        + inTransit
        );

        System.out.println(
                "Delivered Parcels     : "
                        + delivered
        );

        System.out.println(
                "Cancelled Parcels     : "
                        + cancelled
        );

        System.out.println();

        System.out.println(
                "WEIGHT INFORMATION"
        );

        System.out.println(
                "------------------------------------------------------------"
        );

        System.out.printf(
                "Total Parcel Weight   : %.2f kg%n",
                totalWeight
        );

        System.out.printf(
                "Average Parcel Weight : %.2f kg%n",
                averageWeight
        );

        System.out.println();

        System.out.println(
                "DELIVERY CHARGE INFORMATION"
        );

        System.out.println(
                "------------------------------------------------------------"
        );

        System.out.printf(
                "Total Delivery Charge : Rs. %.2f%n",
                totalCharge
        );

        System.out.println();

        System.out.println(
                "============================================================"
        );
    }


    // ============================================================
    // DESTINATION-WISE REPORT
    // ============================================================

    public static void displayDestinationReport(
            ArrayList<Parcel> parcels) {

        if (parcels.isEmpty()) {

            System.out.println();
            System.out.println(
                    "No parcel records found."
            );

            return;
        }

        // Store number of parcels for each destination
        HashMap<String, Integer> parcelCount =
                new HashMap<>();

        // Store total weight for each destination
        HashMap<String, Double> destinationWeight =
                new HashMap<>();

        // Store total charge for each destination
        HashMap<String, Double> destinationCharge =
                new HashMap<>();


        // ========================================================
        // PROCESS PARCEL DATA
        // ========================================================

        for (Parcel parcel : parcels) {

            String destination =
                    parcel.getDestination();

            double weight =
                    parcel.getWeight();

            double charge =
                    parcel.getDeliveryCharge();


            // Parcel count

            parcelCount.put(
                    destination,
                    parcelCount.getOrDefault(
                            destination,
                            0
                    ) + 1
            );


            // Total weight

            destinationWeight.put(
                    destination,
                    destinationWeight.getOrDefault(
                            destination,
                            0.0
                    ) + weight
            );


            // Total charge

            destinationCharge.put(
                    destination,
                    destinationCharge.getOrDefault(
                            destination,
                            0.0
                    ) + charge
            );
        }


        // ========================================================
        // DISPLAY REPORT
        // ========================================================

        System.out.println();

        System.out.println(
                "================================================================================"
        );

        System.out.println(
                "                         DESTINATION-WISE REPORT"
        );

        System.out.println(
                "================================================================================"
        );

        System.out.printf(
                "%-20s %-15s %-18s %-18s%n",
                "Destination",
                "Parcels",
                "Total Weight",
                "Total Charge"
        );

        System.out.println(
                "--------------------------------------------------------------------------------"
        );


        for (Map.Entry<String, Integer> entry
                : parcelCount.entrySet()) {

            String destination =
                    entry.getKey();

            int count =
                    entry.getValue();

            double weight =
                    destinationWeight.get(
                            destination
                    );

            double charge =
                    destinationCharge.get(
                            destination
                    );


            System.out.printf(
                    "%-20s %-15d %-18.2f Rs. %-12.2f%n",
                    destination,
                    count,
                    weight,
                    charge
            );
        }


        System.out.println(
                "--------------------------------------------------------------------------------"
        );

        System.out.println(
                "Different Destinations: "
                        + parcelCount.size()
        );
    }


    // ============================================================
    // COMPLETE SYSTEM REPORT
    // ============================================================

    public static void displayCompleteReport(
            ArrayList<Customer> customers,
            ArrayList<Parcel> parcels) {

        displayCustomerReport(customers);

        displayParcelReport(parcels);

        displayStatusReport(parcels);

        displayWeightReport(parcels);

        displayChargeReport(parcels);

        displayDestinationReport(parcels);

        displayDashboard(
                customers,
                parcels
        );
    }
}