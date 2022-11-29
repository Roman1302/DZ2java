//4*. К калькулятору из предыдущего дз добавить логирование.

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;  
import java.io.IOException;

public class dz2_4 {
    private static Logger logger = Logger.getLogger(dz2_2.class.getName());
    public static void main(String[] args) throws SecurityException, IOException {
        
        FileHandler fh = new FileHandler("calLogs.txt"); 
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        System.out.print("Введите первое число для операции: ");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        logger.info("Пользователь ввел первое число: " + a);

        System.out.print("Введите тип операции( + ; - ; * ; / ; %): ");
        char symbol = in.next().charAt(0);
        logger.info("Пользователь ввел действие: " + symbol);

        System.out.print("Введите второе число для операции: ");
        // Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        logger.info("Пользователь ввел второе число: " + b);

        calculator(a, b, symbol);
        in.close();
        
    }

    public static int calculator(int a, int b, char symbol) {
        int result = 0;
        if (symbol == '+') {
            result = a + b;
            logger.info("Сложение");

        } else if (symbol == '-') {
            result = a - b;
            logger.info("Вычитание");

        } else if (symbol == '*') {
            result = a * b;
            logger.info("Умножение");
        } else if (symbol == '%') {
            result = a % b;
            logger.info("Определение остатка");

        } else if (symbol == '/') {
            result = a / b;
            logger.info("Деление");
        }

        System.out.println("Ответ: " + result);
        logger.info("Расчет окончен, результат: " + result);
        return result;
    }
}