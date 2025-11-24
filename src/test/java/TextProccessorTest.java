import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.TextProccesor;
import static org.junit.jupiter.api.Assertions.*;

public class TextProccessorTest {

    private TextProccesor textprocessor;
    @BeforeEach
    public void setUp(){
        textprocessor = new TextProccesor();
    }

    @Test
    public void TextValid(){
        String text= " hola ";
        String expResult= "ALOH";
        String result= textprocessor.reverseAndCapitalize(text);
        assertEquals(expResult,result);
    }
    @Test
    public void TextNull(){
        String text= null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           textprocessor.reverseAndCapitalize(text);
        });
        String expectedMessage = "El texto no puede ser nulo";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void TextEmpty(){

        String text= "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            textprocessor.reverseAndCapitalize(text);
        });
        String expectedMessage = "El texto no puede estar vacío";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void TextWithSpaces(){
        String text= " ";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            textprocessor.reverseAndCapitalize(text);
        });
        String expectedMessage = "El texto no puede estar vacío";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void TextWithLenghtMaximun(){
        String text= "a";
        String text2="";
        for (int i=0; i<1002; i++){
            text2=text2+text;
        }
        String text3=text2;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           textprocessor.reverseAndCapitalize(text3);
        });
        String expectedMessage = "El texto excede el límite de 1000 caracteres";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void TextWithOutSpaces(){
        String text= "programa";
        String expResult="AMARGORP";
        String result= textprocessor.reverseAndCapitalize(text);
        assertEquals(expResult,result);
    }

}
