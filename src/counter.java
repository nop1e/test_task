import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;


public class counter {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("ip");
        int lineCount = 1000;   //кол-во ip-адресов в файле

        PrintWriter pw = new PrintWriter(file); //запись рандомных Ip в файл
        Random random = new Random();
        for (int i=0; i<lineCount; i++) {
            int[] ip_array = new int[4];
            for(int j=0;j<ip_array.length; j++) {
                ip_array[j] = random.nextInt(25);   //здесь указывается диапазон чисел для заполнения (от 0 до 10)
            }
            pw.println(ip_array[0] + "." + ip_array[1] + "." + ip_array[2] + "." + ip_array[3]);
        }
        pw.close();

        Scanner scanner = new Scanner(file);    //перенос строк из файла в строковый массив
        String[] ip = new String[lineCount];
        while (scanner.hasNextLine()){
            for(int i=0; i<lineCount; i++){
                ip[i] = scanner.nextLine();
            }
        }
        scanner.close();

        int counter = 0;    //счетчик кол-ва уникальных ip
        boolean checker;    //чек проверки уникальности
        for (int i=0; i<ip.length; i++){
            checker = true;
            for (int j=i+1; j<ip.length; j++){
                if (ip[j].equals(ip[i])){
                    checker = false;
                }
            }
            if (checker){
                counter++;
            }
        }
        System.out.println("\nКол-во уникальных ip: " + counter);
    }
}

