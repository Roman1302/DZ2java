
/* Реализуйте алгоритм сортировки пузырьком числового массива, 
результат после каждой итерации запишите в лог-файл. */


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class dz2_2 {
    
    private static Logger logger = Logger.getLogger(dz2_2.class.getName());

    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler("Logs.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Array myArray = new Array();

        myArray.Sorter();
        myArray.prin();

    }  
}
class Array {
        int a;
        int[] ar;
        private static Logger logger = Logger.getLogger(dz2_2.class.getName());

        Array(){
            Scanner input = new Scanner(System.in);
            System.out.println("Введите размер массива:");
            try {
                a = input.nextInt();
            }catch(InputMismatchException inputMismatchException){
                logger.warning("Ошибка!");
            }
            input.close();

            ar=new int[a];
            for(int i = 0;i<a;i++){
                ar[i] = ((int) (Math.random() * 31) + 5);
                System.out.print(ar[i] + " ");
            } logger.info("Вывели массив в консоль");    
        }   


    void prin(){          
        for (int i = 0; i < a; i++){    
            System.out.print(ar[i] + " ");                                              

        } logger.info("Выполнился метод вывода");    
    }    

    void toSwap(int first, int second) { 
        int dummy = ar[first]; 
        ar[first] = ar[second]; 
        ar[second] = dummy; 
        logger.info("Выполнился метод замены");
    }

    void Sorter() {
        for (int i = a - 1; i >= 1; i--) { 
            for (int j = 0; j < i; j++) { 
                if (ar[j] > ar[j + 1]) 
                    toSwap(j, j + 1);
            }
        }
        logger.info("Cортировка выполненна\n");
    }
}