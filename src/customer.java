class customer
{
    String name;             // stores name of the customer
    String address;          // stores address of the customer (house no, building name)
    String mobile_no;        // stores mobile number of the customer
    int location;            // stores an integer denoting the delivery location of the customer

    public customer(String n, String adr, int loc, String mn)  // parameterized constructor
    {
        name=n;
        address= adr;
        mobile_no= mn;
        location=loc;
    }
}