package klausurUebungen.jbay;

public class Bieter {

    private String firstName, lastName;

    public Bieter(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

}
