package org.example;

public class Email {

    public boolean isValidEmail(String email) {

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        if (email.length() < 6 || email.length() > 254) {
            return false;
        }

        if (email.contains(" ")) {
            return false;
        }

        int atIndex = email.indexOf('@');
        if (atIndex < 1 || atIndex != email.lastIndexOf('@')) {
            return false;
        }

        String local = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);

        if (!local.matches("[A-Za-z0-9._-]+")) {
            return false;
        }

        if (local.startsWith(".") || local.endsWith(".")) {
            return false;
        }

        if (local.contains("..")) {
            return false;
        }

        int dotIndex = domain.lastIndexOf('.');
        if (dotIndex <= 1) {
            return false;
        }

        String extension = domain.substring(dotIndex + 1);

        if (extension.length() < 2) {
            return false;
        }

        if (!domain.matches("[A-Za-z0-9.-]+")) {
            return false;
        }

        if (domain.contains("..")) {
            return false;
        }

        return true;
    }
}