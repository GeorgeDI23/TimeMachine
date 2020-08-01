package org.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public void sortStringNumbers(String[] testArray) {
        Boolean isSorted = false;
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < testArray.length-1; i++) {
                Boolean dontSwap = customComparator(testArray[i], testArray[i+1]);
                if(!dontSwap){
                    String temp = testArray[i];
                    testArray[i] = testArray[i+1];
                    testArray[i+1] = temp;
                    isSorted = false;
                }
            }
            System.out.println(Arrays.toString(testArray));
        }
        System.out.println(Arrays.toString(testArray));
    }

    public Boolean customComparator(String first, String second) {
        if(first.charAt(0) == '-' && second.charAt(0) != '-'){
            return true;
        }else if(second.charAt(0) == '-' && first.charAt(0) != '-'){
            return false;
        }else if(first.charAt(0) == '-' && second.charAt(0) == '-'){
            first = first.substring(1);
            second = second.substring(1);
            return !customComparator(first, second);
        }

        first = removeLeadingZeros(first);
        second = removeLeadingZeros(second);

        String firstNoDecimal = removeDecimal(first);
        String secondNoDecimal = removeDecimal(second);

        if(!firstNoDecimal.equals(secondNoDecimal)){
            if(firstNoDecimal.length() > secondNoDecimal.length()){
                return false;
            }else if(secondNoDecimal.length() > firstNoDecimal.length()){
                return true;
            } else if(firstNoDecimal.compareTo(secondNoDecimal) > 0){
                return false;
            }
        }else{
            return !(first.compareTo(second) > 0);
        }
        return true;
    }

    public String removeDecimal(String input) {
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '.'){
                return input.substring(0, i);
            }
        }
        return input;
    }

    public String removeLeadingZeros(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != '0'){
                return input.substring(i);
            }
        }
        return "0";
    }


}
