package mal.artur;

import mal.artur.domain.Contact;
import mal.artur.domain.Gender;

import java.io.File;
import java.util.List;

public class AddressBookRunner {

    public static void main(String[] args) {
        File file = ((args.length == 0) ? new File("src/test/resources/AddressBook") : new File(args[0]));
        FileReader fileReader = new FileReader();

        Parser parser = new Parser();
        List<String> strings = fileReader.readFrom(file);
        List<Contact> contacts = parser.toContacts(strings);

        AddressBook addressBook = new AddressBook(contacts);
        Integer numberOfMales = addressBook.getNumberOf(Gender.Male);
        String oldestContactName = addressBook.getOldestContactName();
        Integer ageDifference = addressBook.getAgeDifferenceBetween(addressBook.getContactByName("Bill"), addressBook.getContactByName("Paul"));

        System.out.format("There are %d males in the address book.\n", numberOfMales);
        System.out.format("%s is the oldest person.\n", oldestContactName);
        System.out.format("Bill is %d days older than Paul.\n", ageDifference);
    }
}
