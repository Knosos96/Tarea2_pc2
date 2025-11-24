package org.example;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Integer> inventory = new HashMap<>();

    public void addItem(String item, int quantity) {


        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }


        String trimmed = item.trim();
        if (trimmed.length() < 2 || trimmed.length() > 50) {
            throw new IllegalArgumentException("El nombre del producto debe tener entre 2 y 50 caracteres");
        }


        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }

        // Validación: máximo permitido 1000
        if (quantity > 1000) {
            throw new IllegalArgumentException("La cantidad no puede ser mayor a 1000");
        }

        inventory.put(trimmed, inventory.getOrDefault(trimmed, 0) + quantity);
    }

    public int getStock(String item) {
        return inventory.getOrDefault(item, 0);
    }
}

