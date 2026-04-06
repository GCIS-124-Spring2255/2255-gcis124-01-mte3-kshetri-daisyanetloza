// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 1
// Filename: Converter.java (inside tempconvert package)

package mte3.tempconvert;
import java.util.Scanner;

public class Converter {
    
    private static class CelsiusToFahrenheit implements TempConvert {

        @Override
        public double convert(double temp) {    
            return temp * 9.0 / 5.0 + 32;    
        }
        
    } // CelciusToFahrenheit closed

    public static void main(String[] args) {
        
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter temperature (for conversion): ");
            //using 47 as test input

            // (part 1) conversion from C to F
            CelsiusToFahrenheit cToF = new CelsiusToFahrenheit(); //static inner class used
            System.out.println(cToF.convert(47.0));

            
            // (part 2) conversion from F to C
            CelsiusToFahrenheit fToC = new CelsiusToFahrenheit() { //anonymous class
                @Override
                public double convert(double temp) {
                    return (temp - 32) * 5.0 / 9.0;
                }
            };
            System.out.println(fToC.convert(47.0));
            
            // (part 3) conversion from F to K
            TempConvert fToK = (temp) -> ((temp - 32) * 5.0 / 9.0 + 273.15); //lambda
            System.out.println(fToK.convert(47.0));


        }  // try { } block closed

    } // main () method closed

} // Converter { } class closed