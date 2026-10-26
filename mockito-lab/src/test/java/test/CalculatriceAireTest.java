package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.CalculatriceAire;
import main.Cercle;
import main.IForme;
import main.Rectangle;

class CalculatriceAireTest {
    CalculatriceAire calculatriceAire = new CalculatriceAire();

    @Test
    void testAire() {
        IForme carre = Mockito.mock(IForme.class);
        when(carre.aire()).thenReturn(4.0);

        List<IForme> formes = Arrays.asList(new Cercle(2.0), new Rectangle(2, 4), carre);
        assertEquals(24.56, calculatriceAire.aire(formes), 0.01);
        verify(carre, times(1)).aire();
    }
}
