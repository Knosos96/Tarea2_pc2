import org.example.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    private Email emailTest;

    @BeforeEach
    public void setUp(){
        emailTest = new Email();
    }
    @Test
    public void EmailNull(){
        String correo=null;
        Exception exception= assertThrows(IllegalArgumentException.class, () ->
                emailTest.isValidEmail(correo)
                );
        String mensaje= exception.getMessage();
        String expectedMessage="El correo no puede ser nulo o vacío";
        assertEquals(expectedMessage,mensaje);
    }

    @Test
    public void EmailEmpty(){
        String correo="";
        Exception exception= assertThrows(IllegalArgumentException.class, () ->
                emailTest.isValidEmail(correo)
        );
        String mensaje= exception.getMessage();
        String expectedMessage="El correo no puede ser nulo o vacío";
        assertEquals(expectedMessage,mensaje);
    }

    @Test
    public void EmailWithOutArroba(){
        String correo="usuario.gmail.com";
        boolean expResult=false;
        boolean result=emailTest.isValidEmail(correo);
        assertTrue(expResult == result);
    }

    @Test
    public void EmailWithDominioInvalid(){
        String correo="usuario@com";
        boolean expResult=false;
        boolean result=emailTest.isValidEmail(correo);
        assertTrue(expResult == result);
    }

    @Test
    public void EmailValid(){
        String correo="cliente123@tienda.com";
        boolean expResult=true;
        boolean result=emailTest.isValidEmail(correo);
        assertEquals(expResult,result);
    }

    @Test
    public void EmailWithLocalInvalid(){
        String correo=".user@dominio.com";
        boolean expResult=false;
        boolean result=emailTest.isValidEmail(correo);
        assertEquals(expResult,result);

    }

}
