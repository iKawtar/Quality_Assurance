package mock2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CalculatriceTest {

    @Test
    void testCalcSomme() {
        Iaddition addService = Mockito.mock(Iaddition.class);
        when(addService.add(10, 20)).thenReturn(30);

        Calculatrice calculatrice = new Calculatrice(addService);

        assertEquals(30, calculatrice.calcSomme(10, 20));
        verify(addService).add(10, 20);
    }

    // @Test
    //void testCalcSomme() {
    //    Iaddition addService = new Additionneur();

    //    Calculatrice calculatrice = new Calculatrice(addService);

    //    assertEquals(30, calculatrice.calcSomme(10, 20));
    //}
}