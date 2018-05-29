package mal.artur;

import mal.artur.domain.Contact;
import mal.artur.domain.Gender;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class AddressBook {

    private final List<Contact> contacts;

    public AddressBook(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Integer getNumberOf(Gender gender) {
        return contacts.stream()
                .filter(c -> c.getGender().equals(gender))
                .collect(Collectors.toList())
                .size();
    }

    public String getOldestContactName() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getDate))
                .findFirst()
                .get()
                .getName();
    }

    public Integer getAgeDifferenceBetween(Contact firstContact, Contact secondContact) {
        return Math.toIntExact(DAYS.between(firstContact.getDate(), secondContact.getDate()));
    }
}
