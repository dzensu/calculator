import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main (String[] args) throws IOException {
		List<String> charall = new ArrayList<>(Arrays.asList());
		String[] romanL = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
        };
		//
		System.out.println("Введите число в формате (2 + 2) или же (V + V): ");
		String eq = scanner.nextLine();
		//
		String[] words = eq.split(" ");
        for (String word : words) {
            charall.add(word);
        }
		
		//
        if(charall.size() != 3){
			try{
				throw new IOException();
			}  catch (IOException e ){
				System.out.println("введен не корректный формат уровнение");
				System.exit(1);
			}
		}
		
		String temp = charall.get(1);
		char operation = temp.charAt(0);
		//
		String roman1 = charall.get(0);
		String roman2 = charall.get(2);
        //
		
		
		number1 = romanToNumber(roman1);
		number2 = romanToNumber(roman2);
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else if (number1 < 0 && number2 > -1 || number2 < 0 && number1 > -1){
            System.out.println("не допустимый формат чисел");
            System.exit(1);
        } else {
            result = calculated(number1, number2, operation);
            if (result < 0){
                try{
                    throw new ArrayIndexOutOfBoundsException();
                } catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("в римских цифрах нету отрицацельных чисел");
                    System.exit(1);
                }
            }
            String resultRoman = convertNumToRoman(result);
            System.out.println(resultRoman);
            System.exit(1);
        }



		
		number1 = Integer.parseInt(roman1);
		number2 = Integer.parseInt(roman2);
		if ((number1 + number2) > 20){
			try{
				throw new IOException();
			} catch (IOException e){
                System.out.println("одна из ведденых цифр больше 10");
				System.exit(1);
			}
		}
		
		

		result = calculated(number1, number2, operation);
        System.out.println(result);
	    
	}

    static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    

    }
    static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
	}

	public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}

  