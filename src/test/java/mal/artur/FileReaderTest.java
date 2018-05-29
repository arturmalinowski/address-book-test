package mal.artur;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileReaderTest {

    private FileReader underTest;

    @Before
    public void setUp(){
        underTest = new FileReader();
    }

    @Test
    public void canReadFile() {
        File file = new File("src/main/resources/AddressBook");
        List<String> addressBook = underTest.readFrom(file);
        assertThat(addressBook.size(), is(5));
    }
}