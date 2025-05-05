import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Classes.FilmePapel;
import com.Interface.PapelInterface;
import com.PapeisPackage.Ator;

public class FilmePapelTestes {

    @Test
    void testSetFilme() {
        FilmePapel filmePapel = new FilmePapel("Filme Original");
        filmePapel.setFilme("Novo Filme");

        assertEquals("Novo Filme", filmePapel.getFilme());
    }

    @Test
    void testSetPapel() {
        FilmePapel filmePapel = new FilmePapel("Filme");
        PapelInterface ator = new Ator(); //  Ator implementa PapelInterface **

        filmePapel.setPapel(ator);

        assertNotNull(filmePapel.getPapel());
        assertEquals(ator, filmePapel.getPapel());
    }
}
