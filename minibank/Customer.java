public class Customer {

    private static int counter = 1;

    private String id;
    private String name;
    private String mobile;
    private String email;

    public Customer(String name, String mobile, String email) {

        this.name = name;
        this.mobile = mobile;
        this.email = email;

        this.id = "CUS" + counter;
        counter++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id
                + " | Name: " + name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Customer)) {
            return false;
        }

        Customer other = (Customer) obj;

        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}