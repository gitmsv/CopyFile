package ua.jvdevpro.smlnk;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/** Для копирования любого типа файлов применяются байтовые потоки ввода-вывода.

 Алгоритм копирования файла:

 1) Создать объекты классов FileInputStream и FileOutputStream для копируемого файла и копии соответственно.

 2) Объявить буферный массив byte размером, примерно, 1024 или больше байт (внимание не слишком большой), так как это
 может увеличить объем памяти, потребляемой вашим  приложением.

 3) В цикле сначала вычитывать этот массив из файла, потом записывать в копию, и так до конца файла.*/

public class Main {

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("a.txt"); // Входной поток для файла;
             FileOutputStream fos = new FileOutputStream("acopy.txt")) { // Выходной поток для файла;

            byte[] bufer = new byte[1024]; // Буферный массив;
            int byteread = 0;

            // Копирование байтового содержимого из файла в его копию;
            for (; (byteread = fis.read(bufer)) > 0;) {
                fos.write(bufer, 0, byteread);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
