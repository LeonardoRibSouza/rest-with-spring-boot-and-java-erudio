package br.com.erudio.util;

import br.com.erudio.exeception.ResourceNotFoundException;

public class ConversaoUtil {

    public Double convertToDouble(String srcName) throws IllegalArgumentException {
        if (srcName == null || srcName.isEmpty() ) throw new ResourceNotFoundException("Invalid character, please re-enter");
        String number = srcName.replace(",", ".");
        return Double.parseDouble(number);
    }

}
