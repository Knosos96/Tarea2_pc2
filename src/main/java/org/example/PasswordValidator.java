package org.example;

public class PasswordValidator {

    public static boolean isValid(String password) {

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        if (password.length() < 8 || password.length() > 64) {
            return false;
        }

        // Solo 1 espacio permitido, y no al inicio ni final
        if (password.startsWith(" ") || password.endsWith(" ")) return false;
        if (password.chars().filter(c -> c == ' ').count() > 1) return false;

        // Validaciones simples con regex
        if (!password.matches(".*[A-Z].*")) return false;          // mayúscula
        if (!password.matches(".*[a-z].*")) return false;          // minúscula
        if (!password.matches(".*[0-9].*")) return false;          // número
        if (!password.matches(".*[!@#$%^&*()_\\-+={}\\[\\]|\\\\:;\"'<>.,?/].*")) return false; // especial

        // Revisar caracteres NO permitidos (solo letras, números, especiales y 1 espacio)
        if (!password.matches("[A-Za-z0-9 !@#$%^&*()_\\-+={}\\[\\]|\\\\:;\"'<>.,?/]+")) {
            return false;
        }

        return true;
    }
}