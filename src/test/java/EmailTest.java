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

//    @Test
//    public void EmailLocalTerminaPunto() {
//        String correo = "user.@dominio.com";
//        assertFalse(emailTest.isValidEmail(correo));
//    }
//
//    @Test
//    public void EmailLocalConPuntosConsecutivos() {
//        String correo = "us..er@dominio.com";
//        assertFalse(emailTest.isValidEmail(correo));
//    }
//
//    @Test
//    public void EmailDominioConPuntosConsecutivos() {
//        String correo = "user@do..minio.com";
//        assertFalse(emailTest.isValidEmail(correo));
//    }
//    @Test
//    public void EmailExtensionMuyCorta() {
//        String correo = "usuario@dominio.c";
//        assertFalse(emailTest.isValidEmail(correo));
//    }
//
//    @Test
//    public void EmailConEspacio() {
//        String correo = "us er@dominio.com";
//        assertFalse(emailTest.isValidEmail(correo));
//    }
//
//    @Test
//    public void EmailLocalCaracterInvalido() {
//        String correo = "us€r@dominio.com";
//        assertFalse(emailTest.isValidEmail(correo));
//    }
//
//    @Test
//    public void EmailConDobleArroba() {
//        String correo = "user@@dominio.com";
//        assertFalse(emailTest.isValidEmail(correo));
//    }
//
//    @Test
//    public void EmailDemasiadoLargo() {
//        String correo = "a".repeat(260) + "@dominio.com";
//        assertFalse(emailTest.isValidEmail(correo));
//    }
//    @Test
//    public void EmailDominioCaracteresInvalidos() {
//        String correo = "user@domiñio.com"; // 'ñ' NO permitido en dominio
//        assertFalse(emailTest.isValidEmail(correo));
//    }
//    @Test
//    public void EmailLengthLessThanSix() {
//        String correo = "a@b.c"; // 5 caracteres → inválido
//        assertFalse(emailTest.isValidEmail(correo));
//    }

}
