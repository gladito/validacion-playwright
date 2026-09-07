import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimerTest extends BaseTest {

    @Test
    void verificaTituloLogin() {
        page.navigate("https://the-internet.herokuapp.com");

        assertEquals("The Internet", page.title());
    }
}