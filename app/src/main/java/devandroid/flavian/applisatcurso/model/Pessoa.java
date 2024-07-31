package devandroid.flavian.applisatcurso.model;

public class Pessoa {

    private String firstName;
    private String surName;
    private String desiredCourse;
    private String phoneNumber;
    private String eCode;

    public Pessoa(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDesiredCourse() {
        return desiredCourse;
    }

    public void setDesiredCourse(String desiredCourse) {
        this.desiredCourse = desiredCourse;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return
                " Primeiro Nome = '" + firstName + '\'' +
                ", Sobrenome = '" + surName + '\'' +
                ", Curso Desejado = '" + desiredCourse + '\'' +
                ", Telefone Contato = '" + phoneNumber + '\'';
    }
}
