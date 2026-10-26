package ma.ensam.qualite;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DureeTest {

    @ParameterizedTest
    @ValueSource(ints = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
            50, 51, 52, 53, 54, 55, 56, 57, 58, 59
    })
    void testSetSecondesValeursValides(int secondes) {
        Duree duree = new Duree();

        assertDoesNotThrow(() -> duree.setSecondes(secondes));
    }


    @ParameterizedTest
    @CsvSource({
            "0, 0, 0, '00:00:00'",
            "2, 30, 23, '02:30:23'",
            "1, 5, 9, '01:05:09'",
            "12, 45, 59, '12:45:59'",
            "100, 0, 0, '100:00:00'"
    })
    void testFormatDuree(int heures, int minutes, int secondes,
                         String resultatAttendu) {

        Duree duree = new Duree(heures, minutes, secondes);

        assertEquals(resultatAttendu, duree.formatDuree());
    }


    @ParameterizedTest
    @CsvFileSource(
            resources = "/duree_comparer_tests.csv",
            numLinesToSkip = 0
    )
    void testComparer(int heures1, int minutes1, int secondes1,
                      int heures2, int minutes2, int secondes2,
                      int resultatAttendu) {

        Duree duree1 = new Duree(heures1, minutes1, secondes1);
        Duree duree2 = new Duree(heures2, minutes2, secondes2);

        assertEquals(resultatAttendu, duree1.comparer(duree2));
    }

    static Stream<Arguments> fournirCasIsEquals() {
        return Stream.of(
                Arguments.of(1, 20, 30, 1, 20, 30, true),
                Arguments.of(0, 0, 0, 0, 0, 0, true),
                Arguments.of(1, 20, 30, 1, 20, 31, false),
                Arguments.of(2, 0, 0, 1, 0, 0, false),
                Arguments.of(1, 30, 0, 1, 29, 59, false)
        );
    }

    @ParameterizedTest
    @MethodSource("fournirCasIsEquals")
    void testIsEquals(int h1, int m1, int s1,
                      int h2, int m2, int s2,
                      boolean resultatAttendu) {

        Duree duree1 = new Duree(h1, m1, s1);
        Duree duree2 = new Duree(h2, m2, s2);

        assertEquals(resultatAttendu, duree1.isEquals(duree2));
    }

    @RepeatedTest(5)
    void testNextSeconde() {
        Duree duree = new Duree(1, 20, 59);

        duree.nextSeconde();

        assertEquals("01:21:00", duree.formatDuree());
    }

}