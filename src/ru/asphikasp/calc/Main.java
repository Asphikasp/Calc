package ru.asphikasp.calc;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        // write your code here

        if(args.length != 3){
            System.out.println("Wrong number of args");
            System.exit(1);
        }

        char op = args[1].charAt(0);

        Double a1 = 0d, a2 = 0d;

        try {
            a1 = Double.parseDouble(args[0]);
            a2 = Double.parseDouble(args[2]);
        } catch (Exception e){
            System.out.println("Argument parse error");
            System.exit(1);
        }

        try {
            System.out.println(calc(a1, a2, op));
        } catch(ArithmeticException e) {
            System.out.println("NaN");
            System.exit(1);
        }

    }

    public static Double calc(Double x, Double y, char operation) {
        Double rtrn = 0d;
        switch (operation) {
            case '+':
                rtrn = x + y;
                break;
            case '-':
                rtrn = x - y;
                break;
            case 'x':
                rtrn = x * y;
                break;
            case '/':
                rtrn = x / y;
                break;
            default:
                System.out.println("Unknown operator");
                System.exit(1);
        }
        if (Double.isInfinite(rtrn) || rtrn == Double.NaN)
            throw new ArithmeticException("потеря точности или деление на ноль");
        return rtrn;
    }
}
