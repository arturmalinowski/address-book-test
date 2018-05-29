package mal.artur;

import mal.artur.domain.Contact;
import mal.artur.domain.Gender;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddressBookTest {

    private AddressBook underTest;
    private Contact artur = new Contact("Artur", Gender.Male, LocalDate.of(2000, 10, 10));
    private Contact pete = new Contact("Pete", Gender.Male, LocalDate.of(2001, 11, 10));

    @Before
    public void setUp() {
        List<Contact> contacts = new ArrayList<>(Arrays.asList(artur, pete));
        underTest = new AddressBook(contacts);
    }

    @Test
    public void canGetNumberOfSpecificGender() {
        Integer number = underTest.getNumberOf(Gender.Male);

        assertThat(number, is(2));
    }

    @Test
    public void canGetOldestContactName() {
        String oldestContactName = underTest.getOldestContactName();

        assertThat(oldestContactName, is("Artur"));
    }

    @Test
    public void canGetDifferenceBetweenTwoContactsInDays() {
        Integer ageDifferenceBetween = underTest.getAgeDifferenceBetween(artur, pete);

        assertThat(ageDifferenceBetween, is(396));
    }
}