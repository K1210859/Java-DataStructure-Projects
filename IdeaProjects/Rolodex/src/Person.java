public class Person {

    String firstN = "";
    String lastN = "";
    String phoneN = "";
    String address = "";

    public Person(String firstName, String lastName, String phoneNum, String address) {
        firstN = firstName;
        lastN = lastName;
        phoneN = phoneNum;
        this.address = address;
    }

    public String getFirstN() {
        return firstN;
    }

    public void setFirstN(String firstN) {
        this.firstN = firstN;
    }

    public String getLastN() {
        return lastN;
    }

    public void setLastN(String lastN) {
        this.lastN = lastN;
    }

    public String getPhoneN() {
        return phoneN;
    }

    public void setPhoneN(String phoneN) {
        this.phoneN = phoneN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String toString()
    {
        String str = lastN+", "+firstN;
        return str;
    }
}
