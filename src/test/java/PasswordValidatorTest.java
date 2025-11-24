import org.example.PasswordValidator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    public void setUp(){
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void PasswordNull(){

        String password = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           passwordValidator.isValid(password);
        });
        String expectedMessage = "La contraseña no puede ser nula o vacía";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }
   @Test
    public void PasswordEmpty(){
        String password = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            passwordValidator.isValid(password);
        });
       String expectedMessage = "La contraseña no puede ser nula o vacía";
       String actualMessage = exception.getMessage();
       assertEquals(expectedMessage, actualMessage);
   }
   @Test
    public void PasswordCorrect(){
        String password = "Secure123!";
        boolean expResult = true;
        boolean result=passwordValidator.isValid(password);
        assertEquals(expResult,result);
   }
   @Test
    public void PasswordLengthMinus8(){
        String password = "Ab1!e";
        boolean expResult = false;
        boolean result=passwordValidator.isValid(password);
        assertEquals(expResult,result);
   }
   @Test
    public void PasswordWithOutMayus(){
        String password = "nosecura!";
        boolean expResult = false;
        boolean result=passwordValidator.isValid(password);
        assertEquals(expResult,result);
   }
   @Test
    public void PasswordWithSpace(){
        String password = "Abc 123! x";
        boolean expResult = false;
        boolean result=passwordValidator.isValid(password);
        assertEquals(expResult,result);
   }

    @Test
    public void PasswordWithOutMinusculas() {
        String password = "AAAAA123!";
        assertFalse(passwordValidator.isValid(password));
    }

    @Test
    public void PasswordWithoutDigits() {
        String password = "SecureTest!";
        assertFalse(passwordValidator.isValid(password));
    }

    @Test
    public void PasswordWithoutSpecialChar() {
        String password = "Secure1234";
        assertFalse(passwordValidator.isValid(password));
    }

    @Test
    public void PasswordSpaceAtStart() {
        String password = " Secure123!";
        assertFalse(passwordValidator.isValid(password));
    }

    @Test
    public void PasswordSpaceAtEnd() {
        String password = "Secure123! ";
        assertFalse(passwordValidator.isValid(password));
    }

    @Test
    public void PasswordInvalidCharacter() {
        String password = "Secure123!ñ";
        assertFalse(passwordValidator.isValid(password));
    }

    @Test
    public void PasswordMultipleMissingRequirements() {
        String password = "aaaaaaaa";
        assertFalse(passwordValidator.isValid(password));
    }

    @Test
    public void PasswordLengthGreaterThan64() {
        String password = "A1!" + "a".repeat(62);
        assertFalse(passwordValidator.isValid(password));
    }





}
