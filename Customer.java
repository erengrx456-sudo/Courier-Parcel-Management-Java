public class Customer {

    // ============================================================
    // CUSTOMER DETAILS
    // ============================================================

    private int customerID;
    private String name;
    private String phone;
    private String address;


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public Customer(
            int customerID,
            String name,
            String phone,
            String address) {

        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    // ============================================================
    // GET CUSTOMER ID
    // ============================================================

    public int getCustomerID() {

        return customerID;
    }


    // ============================================================
    // GET NAME
    // ============================================================

    public String getName() {

        return name;
    }


    // ============================================================
    // GET PHONE
    // ============================================================

    public String getPhone() {

        return phone;
    }


    // ============================================================
    // GET ADDRESS
    // ============================================================

    public String getAddress() {

        return address;
    }


    // ============================================================
    // SET NAME
    // ============================================================

    public void setName(String name) {

        this.name = name;
    }


    // ============================================================
    // SET PHONE
    // ============================================================

    public void setPhone(String phone) {

        this.phone = phone;
    }


    // ============================================================
    // SET ADDRESS
    // ============================================================

    public void setAddress(String address) {

        this.address = address;
    }
}