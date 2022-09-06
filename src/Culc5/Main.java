import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Введите операцию от 1 до 10, либо римскими, либо арабскими цифрами с операндами: + - * / через пробел");
        Scanner scanner = new Scanner(System.in); // call the scanner
        String input = scanner.nextLine(); // print input line
        System.out.println("Ответ: " + calc(input));
    }
    public static String calc(String input) throws IOException {

        String[] splitSpaceInput = input.split(" ");
        String[] splitEmptyInput = input.split("");
        String[] validValuesArabic = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] validValuesRoman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] operation = new String[]{"+", "-", "*", "/"};
        String[] correctNumber = new String[3];
        String[] correctArab = new String[2];
        String[] correctRome = new String[2];
        int numberArab1 = 0;
        int numberArab2 = 0;
        int numberRome1 = 0;
        int numberRome2 = 0;
        int resultArab = 0;
        int resultRome = 0;

        if (input.length() < 3) {  //длина ввода <=2 символов для араб+рим
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
                System.exit(0);
            }
        }
        if (splitSpaceInput.length == 2) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        }
        if (input.length() > 11) {  //длина ввода >= 11 символам, араб+рим. Для араба надо >7 прописать!!!!
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        }
        if (input.length() < 5) {  //длина ввода до 4х символов, араб+рим
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        }
        boolean rr = input.contains("  ");  //выкидываем двойные пробелы, араб+рим
        if (rr) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *");
                System.exit(0);
            }
        }
        boolean tt = input.startsWith(" ");
        if (tt) {
            try {
                throw new IOException(); //первый пробел араб+рим
            } catch (Exception e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *");
                System.exit(0);
            }
        }
        boolean yy = input.endsWith(" ");
        if (yy) {
            try {
                throw new IOException();  //убираем последний пробел араб+рим
            } catch (Exception e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *");
                System.exit(0);
            }
        }
        for (int i = 0; i < validValuesArabic.length; i++) {    //первое арабское число
            if (splitSpaceInput[0].equals(validValuesArabic[i])) {
                correctNumber[0] = validValuesArabic[i];
                correctArab[0] = validValuesArabic[i];
                break;
            } else if (splitSpaceInput[0].equals(validValuesRoman[i])) { // first rome
                correctNumber[0] = validValuesRoman[i];
                correctRome[0] = validValuesRoman[i];
                break;
            }
        }
        for (int i = 0; i < validValuesArabic.length; i++) {   //второе арабское число
            if (splitSpaceInput[2].equals(validValuesArabic[i])) {
                correctNumber[2] = validValuesArabic[i];
                correctArab[1] = validValuesArabic[i];
                break;
            } else if (splitSpaceInput[2].equals(validValuesRoman[i])) {   //second rome
                correctNumber[2] = validValuesRoman[i];
                correctRome[1] = validValuesRoman[i];
            }
        }
        for (int i = 0; i < operation.length; i++) {    //арифметический оператор араб+rome
            if (splitSpaceInput[1].equals(operation[i])) {
                correctNumber[1] = operation[i];
                break;
            }
        }
        if (correctRome[0] != (correctRome[1]) && correctArab[0] != correctArab[1]) {
            try {
                throw new IOException();
            } catch (Exception e) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                System.exit(0);
            }
        }
        if (correctNumber[0] == null || correctNumber[1] == null || correctNumber[2] == null) {
            try {
                throw new IOException(); //Dell all rubbish
            } catch (Exception e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *");
                System.exit(0);
            }
        }
        for (int i = 0; i < validValuesRoman.length; i++) {
            if (validValuesRoman[i] == correctNumber[0]) {
                numberRome1 = i + 1;
                break;
            }
        }
        for (int i = 0; i < validValuesRoman.length; i++) {
            if (validValuesRoman[i] == correctNumber[2]) {
                numberRome2 = i + 1;
                break;
            }
        }
         if (correctRome[0] == null && correctRome[1] == null ) {
            numberArab1 = Integer.valueOf(correctArab[0]);  //переводим строку в первое число
            numberArab2 = Integer.valueOf(correctArab[1]);  // переводим строку во второе число

            switch (correctNumber[1]) {    //подставляем в цикл свитч кейсы по знаку второго элемента массива
                case "+":
                    resultArab = numberArab1 + numberArab2;
                    break;
                case "-":
                    resultArab = numberArab1 - numberArab2;
                    break;
                case "*":
                    resultArab = numberArab1 * numberArab2;
                    break;
                case "/":
                    resultArab = numberArab1 / numberArab2;
                    break;
            }
        }
        if (correctArab[0] == null && correctArab[1] == null) {
            switch (correctNumber[1]) {    //подставляем в цикл свитч кейсы по знаку второго элемента массива
                case "+":
                    resultRome = numberRome1 + numberRome2;
                    break;
                case "-":
                    resultRome = numberRome1 - numberRome2;
                    break;
                case "*":
                    resultRome = numberRome1 * numberRome2;
                    break;
                case "/":
                    resultRome = numberRome1 / numberRome2;
                    break;
            }
            if (resultRome < 1) {
                try {
                    throw new IOException();
                } catch (Exception e) {
                    System.out.println( "Exception //т.к. в римской системе нет отрицательных чисел");
                    System.exit(0);
                }
            }
        }
        String[] roma100 = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII",
                "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        int fff = resultRome; // number resultRome in Romf100
        String[] resultRomeFinal = new String [1];  // mass for number of Rome
        resultRomeFinal[0] = roma100[fff];
        StringBuilder builder = new StringBuilder();  //new String builder
        for (int i = 0; i < resultRomeFinal.length; i++) {     //check all massiv
            builder.append(resultRomeFinal[i]).append(" ");     // mass to string
        }
        String resultRom = builder.toString();

        String empty = new String(""); //empty String for +
        if (resultRom != null) {            //result Arab final !=null
            input=empty+resultArab;
        }
        if (resultArab == 0) {              //result String final !=0
            input = empty+resultRom;
        }
        return input;
    }
}



