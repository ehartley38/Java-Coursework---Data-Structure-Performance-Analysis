public class Entry {

    String surname, initials, extension;


    public Entry(String surname, String initials, String extension){
        this.surname = surname;
        this.initials = initials;
        this.extension = extension;
    }

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
