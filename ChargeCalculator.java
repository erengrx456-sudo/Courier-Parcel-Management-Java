public class ChargeCalculator {

    // ============================================================
    // BASIC DELIVERY CHARGE
    // ============================================================

    public static double calculateCharge(double weight) {

        double charge;

        if (weight <= 1) {

            charge = 100;

        } else if (weight <= 3) {

            charge = 150;

        } else if (weight <= 5) {

            charge = 200;

        } else {

            charge = 200 + ((weight - 5) * 50);
        }

        return charge;
    }


    // ============================================================
    // DESTINATION-BASED CHARGE
    // ============================================================

    public static double calculateCharge(
            double weight,
            String destination) {

        double charge =
                calculateCharge(weight);

        String location =
                destination.toLowerCase();


        // Kathmandu Valley
        if (location.equals("kathmandu")
                || location.equals("lalitpur")
                || location.equals("bhaktapur")) {

            charge += 0;
        }

        // Nearby cities
        else if (location.equals("pokhara")
                || location.equals("chitwan")) {

            charge += 100;
        }

        // Other destinations
        else {

            charge += 200;
        }

        return charge;
    }


    // ============================================================
    // DISPLAY CHARGE
    // ============================================================

    public static void displayCharge(
            double weight,
            String destination) {

        double charge =
                calculateCharge(
                        weight,
                        destination
                );

        System.out.println();
        System.out.println(
                "----------------------------------------"
        );

        System.out.printf(
                "Parcel Weight : %.2f kg%n",
                weight
        );

        System.out.println(
                "Destination   : " + destination
        );

        System.out.printf(
                "Delivery Charge: Rs. %.2f%n",
                charge
        );

        System.out.println(
                "----------------------------------------"
        );
    }
}