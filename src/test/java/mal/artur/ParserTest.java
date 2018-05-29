package mal.artur;

import mal.artur.domain.Contact;
import mal.artur.domain.Gender;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParserTest {

    private Parser underTest;

    @Before
    public void setUp() {
        underTest = new Parser();
    }

    @Test
    public void canParseText() {
        List<String> lineOfText = new ArrayList<>();
        lineOfText.add("Artur, Male, 12/12/12");

        Contact contact = underTest.toContacts(lineOfText).get(0);

        assertThat(contact.getName(), is("Artur"));
        assertThat(contact.getGender(), is(Gender.Male));
        assertThat(contact.getDate(), is(LocalDate.of(2012,12,12)));
    }
}