public class Parcel {

    // ============================================================
    // PARCEL DETAILS
    // ============================================================

    private String trackingID;
    private String senderName;
    private String receiverName;
    private String receiverPhone;
    private String destination;
    private double weight;
    private String status;


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public Parcel(
            String trackingID,
            String senderName,
            String receiverName,
            String receiverPhone,
            String destination,
            double weight,
            String status) {

        this.trackingID = trackingID;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.destination = destination;
        this.weight = weight;
        this.status = status;
    }


    // ============================================================
    // GET TRACKING ID
    // ============================================================

    public String getTrackingID() {

        return trackingID;
    }


    // ============================================================
    // GET SENDER NAME
    // ============================================================

    public String getSenderName() {

        return senderName;
    }


    // ============================================================
    // GET RECEIVER NAME
    // ============================================================

    public String getReceiverName() {

        return receiverName;
    }


    // ============================================================
    // GET RECEIVER PHONE
    // ============================================================

    public String getReceiverPhone() {

        return receiverPhone;
    }


    // ============================================================
    // GET DESTINATION
    // ============================================================

    public String getDestination() {

        return destination;
    }


    // ============================================================
    // GET WEIGHT
    // ============================================================

    public double getWeight() {

        return weight;
    }


    // ============================================================
    // GET STATUS
    // ============================================================

    public String getStatus() {

        return status;
    }


    // ============================================================
    // SET SENDER NAME
    // ============================================================

    public void setSenderName(String senderName) {

        this.senderName = senderName;
    }


    // ============================================================
    // SET RECEIVER NAME
    // ============================================================

    public void setReceiverName(String receiverName) {

        this.receiverName = receiverName;
    }


    // ============================================================
    // SET RECEIVER PHONE
    // ============================================================

    public void setReceiverPhone(String receiverPhone) {

        this.receiverPhone = receiverPhone;
    }


    // ============================================================
    // SET DESTINATION
    // ============================================================

    public void setDestination(String destination) {

        this.destination = destination;
    }


    // ============================================================
    // SET WEIGHT
    // ============================================================

    public void setWeight(double weight) {

        this.weight = weight;
    }


    // ============================================================
    // SET STATUS
    // ============================================================

    public void setStatus(String status) {

        this.status = status;
    }


    // ============================================================
    // CALCULATE DELIVERY CHARGE
    // ============================================================

    public double getDeliveryCharge() {

        return ChargeCalculator.calculateCharge(
                weight,
                destination
        );
    }
}