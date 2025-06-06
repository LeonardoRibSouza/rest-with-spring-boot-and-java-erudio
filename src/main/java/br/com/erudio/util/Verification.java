package br.com.erudio.util;

public class Verification {

    public boolean isNumeric(String srcName) {
        if (srcName == null || srcName.isEmpty() ) return false;
        String number = srcName.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }

}
