package mal.artur.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Contact {

    private final String name;
    private final Gender gender;
    private final LocalDate date;

    public Contact(String name, Gender gender, LocalDate date) {
        this.name = name;
        this.gender = gender;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
                gender == contact.gender &&
                Objects.equals(date, contact.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, date);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", date=" + date +
                '}';
    }
}
