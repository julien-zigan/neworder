package core.user;

import java.io.Serializable;


public class User implements Serializable {

    private String company;
    private String firstName;
    private String additional;
    private String lastName;
    private String street;
    private String zip;
    private String city;
    private String email;
    private String phone;
    private String website;
    private String bankname;
    private String iban;
    private String bic;

    public User() {
    }

    public User(
            String firstName,
            String lastName,
            String street,
            String zip,
            String city
    ) {
        this("", firstName, lastName, street, zip, city);
    }

    public User(
            String company,
            String firstName,
            String lastName,
            String street,
            String zip,
            String city
    ) {
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zipAndCity) {
        this.zip = zipAndCity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBankname() {
        return bankname;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

}
