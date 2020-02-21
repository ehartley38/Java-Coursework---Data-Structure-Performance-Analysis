public class Entry {

    private String surname, initials, extension;


    public Entry(String surname, String initials, String extension){
        //Initialise surname, initials and extension of entry object
        this.surname = surname;
        this.initials = initials;
        this.extension = extension;
    }

    //Getters and setters for values
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String toString(){
        return (this.surname + " " + this.initials + " " + this.extension);
    }

    public static void main(String[] args) {

    }
}
