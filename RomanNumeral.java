package RomanNumeral;

public class RomanNumeral {
    private int integerValue;
    private String strValue;
    private String[] romanLetters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    private int[] romanNumbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    // constructors
    RomanNumeral(int inInt) {
        integerValue = inInt;
        strValue = convertToRoman(inInt);
    }

    RomanNumeral(String inStr) {
        strValue = inStr;
        integerValue = convertToInteger(inStr);
    }

    // setters
    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    // getters
    public int getIntegerValue() {
        integerValue = convertToInteger(strValue);
        return integerValue;
    }

    public String getStrValue() {
        strValue = convertToRoman(integerValue);
        return strValue;
    }

    // converts integers to roman numerals
    public String convertToRoman(int inInt) {
        int inputInt = inInt;
        String output = "";
        int i = 0;
        // Go through the romanLetters array and for each item in the array
        for (int j = 0; j < romanLetters.length; j++) {
            // as long as the number is larger than the index, subtract the index from it
            // and score it
            while (inputInt >= romanNumbers[i]) {
                output += romanLetters[i];
                inputInt -= romanNumbers[i];
            }
            i++;
        }
        return output;
    }

    // Take in numeral string, convert it to an integer
    public int convertToInteger(String inStr) {
        String inputStr = inStr;
        int output = 0;
        int compare1 = 0;
        int compare2 = 0;
        String doubleLetter = "";

        // Create an array using the values in the inputString
        String[] inputArray = new String[inputStr.length()];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = Character.toString(inputStr.charAt(i));
        }

        // go through each value in the inputArray
        for (int i = 0; i < inputArray.length; i++) {

            // Check the value of inputArray at the index of "i" against the values of the romanLetters array 
            for (int j = 0; j < romanLetters.length; j++) {
                // When a match is found, set compare1 to the integer equivalent of the Roman Numeral
                if (inputArray[i].equals(romanLetters[j])) {
                    compare1 = romanNumbers[j];
                }
                // Also loop through for the next number in inputArray, set compare2 to the integer equivalent of the letter
                if (i != inputStr.length() - 1) {
                    if (inputArray[(i + 1)].equals(romanLetters[j])) {
                        compare2 = romanNumbers[j];
                    }
                }else{
                    compare2 = 0;
                }
            }
            // Check if compare1 is less than compare2
            if (compare1 < compare2) {
                // If so, create the double letter and find the correct integer value of it
                doubleLetter = inputArray[i] + inputArray[i + 1];
                for (int k = 0; k < romanLetters.length; k++) {
                    // Once value is found, add to the output variable
                    if (doubleLetter.equals(romanLetters[k])) {
                        output = (output + romanNumbers[k]);
                    }
                }
                i++;// Increment "i" due to double letter
                // if no double values, set the value of the character
            } else {
                output += compare1;
            }
            compare1 = 0;
            compare2 = 0;
        }
        return output;
    }
}