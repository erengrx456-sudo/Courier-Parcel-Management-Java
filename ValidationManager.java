public class ValidationManager {

    // ============================================================
    // VALIDATE CUSTOMER ID
    // ============================================================

    public static boolean isValidCustomerID(int customerID) {

        return customerID > 0;
    }


    // ============================================================
    // VALIDATE PHONE NUMBER
    // ============================================================

    public static boolean isValidPhone(String phone) {

        if (phone == null) {

            return false;
        }

        phone = phone.trim();

        if (phone.length() < 7
                || phone.length() > 15) {

            return false;
        }

        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(
                    phone.charAt(i))) {

                return false;
            }
        }

        return true;
    }


    // ============================================================
    // VALIDATE NAME
    // ============================================================

    public static boolean isValidName(String name) {

        if (name == null
                || name.trim().isEmpty()) {

            return false;
        }

        return true;
    }


    // ============================================================
    // VALIDATE ADDRESS
    // ============================================================

    public static boolean isValidAddress(
            String address) {

        if (address == null
                || address.trim().isEmpty()) {

            return false;
        }

        return true;
    }


    // ============================================================
    // VALIDATE TRACKING ID
    // ============================================================

    public static boolean isValidTrackingID(
            String trackingID) {

        if (trackingID == null
                || trackingID.trim().isEmpty()) {

            return false;
        }

        return true;
    }


    // ============================================================
    // VALIDATE WEIGHT
    // ============================================================

    public static boolean isValidWeight(
            double weight) {

        return weight > 0;
    }
}