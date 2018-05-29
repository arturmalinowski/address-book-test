package mal.artur;

import mal.artur.domain.Contact;
import mal.artur.domain.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public List<Contact> toContacts(List<String> addressBook){
        List<Contact> contacts = new ArrayList<Contact>();
        addressBook.forEach(c -> {
            List<String> strings = Arrays.asList(c.split("\\s*,\\s*"));
            contacts.add(new Contact(strings.get(0), Gender.valueOf(strings.get(1)), getDate(strings.get(2))));
        });
        return contacts;
    }

    private LocalDate getDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
}
