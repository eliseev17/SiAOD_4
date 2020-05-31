import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер дека:");
        int size = in.nextInt();
        Deque deque = new Deque(size);
        setRandomChars(deque);
        BufferedReader reader = new BufferedReader(new FileReader(new File("README.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("DEK_README.txt")));
        int i;
        while ((i = reader.read()) != -1) {
            char ch = (char) i;
            writer.append(switchLetter(ch, deque));
            writer.flush();
        }
        reader.close();
        writer.close();
        for (char c : deque.getDequeArray()) {
            System.out.print(c + "");
        }
    }

    private static char switchLetter(char ch, Deque deque) {
        char outchar = '0';
        for (int i = 2; i < deque.getDequeSize(); i++) {
            char c = deque.getDequeArray()[i];
            if (c == ch) {
                outchar = deque.getDequeArray()[i - 2];
                break;
            }
        }
        if (outchar == '0')
            outchar = ch;
        return outchar;
    }

    public static void setRandomChars(Deque deque) {
        Random random = new Random();
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        boolean flag = false;
        for (int i = 0; i < deque.getDequeSize() - 1; i++) {
            flag = false;
            // генерируем случайное число между
            // 0 переменной длины AlphaNumericString
            int index = (int) (AlphaNumericString.length() * Math.random());
            // добавляем символ один за другим в конец
            for (char c : deque.getDequeArray()) {
                if (c == AlphaNumericString.charAt(index))
                    flag = true;
            }
            if (!flag) {
                if (i % 2 == 0)
                    deque.addElementBot(AlphaNumericString.charAt(index));
                else
                    deque.addElementTop(AlphaNumericString.charAt(index));
            } else i--;
        }
    }
}