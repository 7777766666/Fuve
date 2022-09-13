package SecondCulkKata;
import com.sun.source.tree.IfTree;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class CalkKata2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Ответ: " + calc(input));
    }
        public static String calc (String input) {

        String[] splitSpaceInput = input.split(" ");
        String[] splitInputEmpty = input.split("");     //array input nothing
        String[] splitInputSlesh = input.split("\"");  // делим по слэш
        String[] inputAll = new String[1];
        inputAll[0] = input;
        String[] number10 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] operation = new String[] {" + ", " - ", " * ", " / "} ;
        String[] op = new String[1];
        String[] operandTwo = new String[1];
        String result = "";
        if (splitSpaceInput[0].length() >12 ) {
            System.out.println("некорректный ввод данных в консоль.");
            System.exit(0);
        }
        if (input.length() < 7 ) {
            try {
                throw new IOException();
            } catch (Exception e) {
                System.out.println("некорректный ввод данных в консоль.");
                System.exit(0);
            }
            }
            boolean spaceFirst = input.startsWith(" ");
            if (spaceFirst) {
                try {
                    throw new IOException(); //первый пробел
                } catch (Exception e) {
                    System.out.println("некорректный ввод данных в консоль.");
                    System.exit(0);
                }
            }
            boolean spaceLast = input.endsWith(" ");
            if (spaceLast) {
                try {
                    throw new IOException();  //убираем последний пробел араб+рим
                } catch (Exception e) {
                    System.out.println("некорректный ввод данных в консоль.");
                    System.exit(0);
                }
            }
            boolean slesh1 = input.startsWith("\"\"");
            if (slesh1) {
                try {
                    throw new IOException(); //2 слэша
                } catch (Exception e) {
                    System.out.println("некорректный ввод данных в консоль.");
                    System.exit(0);
                }
            }
            boolean sleshStart = input.startsWith("\"");
            if (!sleshStart) {
                try {
                    throw new IOException(); //нет первых кавычек
                } catch (Exception e) {
                    System.out.println("некорректный ввод данных в консоль.");
                    System.exit(0);
                }
            }
            boolean slesh2 = input.endsWith("\"\"");
            if (slesh2) {
                try {
                    throw new IOException(); //2 слэша
                } catch (Exception e) {
                    System.out.println("некорректный ввод данных в консоль.");
                    System.exit(0);
                }
            }
            if (splitSpaceInput.length <3 ) {
                System.out.println("некорректный ввод данных в консоль.");
                System.exit(0);
            }
            int countSlesh=0;
            for (char element : input.toCharArray()) {
                if (element == '\"') countSlesh++;
            }

            if (countSlesh == 0 || countSlesh==1 || countSlesh==3) {        //считаем кавычки
                try {
                    throw new IOException();
                } catch (Exception e) {
                    System.out.println("некорректный ввод данных в консоль.");
                    System.exit(0);
                }
            }
            int oper = 0;
            String operat = new String();
            for (int i = 0; i < operation.length; i++) {
                if (inputAll[0].contains(operation[i])) {
                    op[0] = operation[i];
                    oper = i;
                    operat = operation[i];
                    break;
                }
            }
            if (op[0] == null) {
                try {
                    throw new IOException();
                } catch (Exception e) {
                    System.out.println("некорректный оператор");
                    System.exit(0);
                }
            }
            String[] inputSplit = input.split(op[0]);
            String[] quotesOper2 = new String[3];
            String[] quotesOper1 = new String[3];
            if (input.contains("\""+operat+"\"")) {
                quotesOper1 = input.split("\""+operat+"\"");
            } else if ( input.contains("\""+operat+"")) {
                quotesOper2 = input.split("\""+operat+"");
            } else {
                try {
                    throw new IOException();
                } catch (Exception e) {
                    System.out.println("некорректный ввод данных в консоль.");
                    System.exit(0);
                }
            }
            if (op[0].contains("+"))  {
                if (countSlesh != 4) {
                    try {
                        throw new IOException();
                    } catch (Exception e) {
                        System.out.println("некорректный ввод данных в консоль.");
                        System.exit(0);
                    }
                }
                StringBuilder builSum = new StringBuilder();
                builSum.append(quotesOper1[0]);
                String summ = builSum.toString();
                result = summ.replace("\" + \"", "");
            }
            if (op[0].contains("-")) {
                if (countSlesh != 4) {
                    try {
                        throw new IOException();
                    } catch (Exception e) {
                        System.out.println("некорректный ввод данных в консоль.");
                        System.exit(0);
                    }
                }
                StringBuilder buildMinus1 = new StringBuilder();
                buildMinus1.append(quotesOper1[0]);
                String minus1 = buildMinus1.toString();
                StringBuilder buildMinus2 = new StringBuilder();
                buildMinus2.append(quotesOper1[1]);
                String minus2 = buildMinus2.toString();
                minus1 = minus1.replaceAll("[" + (minus2) + "]", "");
                String quotes3 = "\"";
                result = quotes3 + minus1 + quotes3;
            }
            if (op[0].contains("*")) {
                if (countSlesh == 4) {
                    try {
                        throw new IOException();
                    } catch (Exception e){
                        System.out.println("некорректный ввод данных в консоль.");
                        System.exit(0);
                    }
                }
                StringBuilder buildMultiply = new StringBuilder();
                buildMultiply.append(quotesOper2[0]);
                String multiply = buildMultiply.toString();
                String multiFinish = multiply.substring(1);
                StringBuilder buildSeconMult = new StringBuilder();
                buildSeconMult.append(quotesOper2[1]);
                String seconMult = buildSeconMult.toString();
                String[] multi = seconMult.split(" ");
                int m = 0;
                String[] secondOperandM = new String[1];
                for (int i = 0; i < number10.length; i++) {
                    if (number10[i].equals(multi[1])) {
                        secondOperandM[0] = number10[i];
                        m = i + 1;
                        break;
                    }
                }
                if (secondOperandM[0] == null) {
                    try {
                        throw new IOException();
                    } catch (Exception e) {
                        System.exit(0);
                    }
                }
                String quote = "\"";
                String mmm = multiFinish.repeat(m);
                String points = "...";
                quote = quote + mmm + quote;

                if (mmm.length() >40) {
                    quote= mmm.substring(0,40) + points ;
                }
                result = quote;
            }
            if (op[0].contains("/")) {
                if (countSlesh == 4) {
                    try {
                        throw new IOException();
                    } catch (Exception e){
                        System.out.println("некорректный ввод данных в консоль.");
                        System.exit(0);
                    }
                }
                String[] secondOperandD = new String[1];
                int d = 0;
                StringBuilder division = new StringBuilder();
                division.append(quotesOper2[0]);
                String FirsttDivision = division.toString();
                String divisionFinish = division.substring(1);
                StringBuilder buildSeconDivision = new StringBuilder();
                buildSeconDivision.append(quotesOper2[1]);
                String seconDivision = buildSeconDivision.toString();
                String[] divisionSplit = seconDivision.split(" ");
                for (int i = 0; i < number10.length; i++) {
                    if (number10[i].equals(divisionSplit[0])) {
                        secondOperandD[0] = number10[i];
                        d = i + 1;
                        break;
                    }
                }
                if (secondOperandD[0] == null) {
                    try {
                        throw new IOException();
                    } catch (Exception e) {
                        System.out.println("некорректный ввод данных в консоль.");
                        System.exit(0);
                    }
                }
                int l = (divisionFinish.length() / d);
                String divis = divisionFinish.substring(0, l);
                String quotes2 = "\"";
                result = quotes2 + divis + quotes2;
            }
            input = result;
            if (input == null){
                try {
                    throw new IOException();
                } catch ( Exception e) {
                    System.out.println("некорректный ввод данных в консоль.");
                    System.exit(0);
                }
            }
        return input;
    }
}
