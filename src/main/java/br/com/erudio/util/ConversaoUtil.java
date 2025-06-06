package br.com.erudio.util;

import br.com.erudio.exeception.UnsupportedMathOperationExeception;

public class ConversaoUtil {

    public Double convertToDouble(String srcName) throws IllegalArgumentException {
        if (srcName == null || srcName.isEmpty() ) throw new UnsupportedMathOperationExeception("Invalid character, please re-enter");
        String number = srcName.replace(",", ".");
        return Double.parseDouble(number);
    }

}
