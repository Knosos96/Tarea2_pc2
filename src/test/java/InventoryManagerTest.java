import org.example.InventoryManager;
import org.example.PasswordValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventoryManagerTest {

    private InventoryManager inventoryManager;

    @BeforeEach
    public void setUp(){
        inventoryManager = new InventoryManager();
    }

    @Test
    public void AddItemInventory() {
        String item ="Laptop";
        int quantity =1;
        inventoryManager.addItem(item,quantity);
        assertEquals(quantity,inventoryManager.getStock(item));
    }

    @Test
    public void NameEmpty() {
        String item ="";
        int quantity =5;
        Exception exception= assertThrows(IllegalArgumentException.class, () ->
                inventoryManager.addItem(item,quantity));
        String message = exception.getMessage();
        String expMessage = "El nombre del producto no puede estar vacío";
        assertEquals(expMessage, message);
    }

    @Test
    public void NameWithSpaces() {
        String item =" ";
        int quantity =5;
        Exception exception= assertThrows(IllegalArgumentException.class, () ->
                inventoryManager.addItem(item,quantity));
        String message = exception.getMessage();
        String expMessage = "El nombre del producto no puede estar vacío";
        assertEquals(expMessage, message);
    }

    @Test
    public void QuantityNegative(){
        String item ="Mouse";
        int quantity =-1;
        Exception exception= assertThrows(IllegalArgumentException.class, () ->
                inventoryManager.addItem(item,quantity));
        String message = exception.getMessage();
        String expMessage="La cantidad debe ser mayor que cero";
        assertEquals(expMessage, message);
    }

    @Test
    public void QuantityZero(){
        String item ="Teclado";
        int quantity =0;
        Exception exception= assertThrows(IllegalArgumentException.class, () ->
                inventoryManager.addItem(item,quantity));
        String message = exception.getMessage();
        String expMessage="La cantidad debe ser mayor que cero";
        assertEquals(expMessage, message);
    }

    @Test
    public void AddItemForSecondTime(){
        String item ="Monitor";
        int quantity =4;
        inventoryManager.addItem(item,quantity);
        int secondQuantity = 6;
        inventoryManager.addItem(item,secondQuantity);
        int TotalQuantity = quantity + secondQuantity;
        assertEquals(TotalQuantity,inventoryManager.getStock(item));
    }

//    @Test
//    public void ItemNull() {
//        String item = null;
//        int quantity = 5;
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                inventoryManager.addItem(item, quantity));
//
//        assertEquals("El nombre del producto no puede estar vacío", exception.getMessage());
//    }
//
//    @Test
//    public void ItemLessThanTwoChars() {
//        String item = "A";
//        int quantity = 5;
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                inventoryManager.addItem(item, quantity));
//
//        assertEquals("El nombre del producto debe tener entre 2 y 50 caracteres", exception.getMessage());
//    }
//
//    @Test
//    public void ItemGreaterThanFiftyChars() {
//        String item = "a".repeat(51);
//        int quantity = 5;
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                inventoryManager.addItem(item, quantity));
//
//        assertEquals("El nombre del producto debe tener entre 2 y 50 caracteres", exception.getMessage());
//    }
//
//    @Test
//    public void QuantityGreaterThanThousand() {
//        String item = "Teclado";
//        int quantity = 1500;
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                inventoryManager.addItem(item, quantity));
//
//        assertEquals("La cantidad no puede ser mayor a 1000", exception.getMessage());
//    }
//    @Test
//    public void ItemWithSpaces() {
//        String item = "   Laptop   ";
//        int quantity = 10;
//
//        inventoryManager.addItem(item, quantity);
//
//        assertEquals(10, inventoryManager.getStock("Laptop"));
//    }




}
