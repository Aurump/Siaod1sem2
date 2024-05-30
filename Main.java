import java.io.File;import java.io.FileNotFoundException;
import java.util.Scanner;import java.io.PrintWriter;
import java.util.Stack;public class Main {
    static void towerOfHanoi(int n, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C, PrintWriter writer,String num1,String num2,String num3){
        if(n > 0){
        towerOfHanoi(n-1, A, C, B, writer,num1,num3,num2);
        int disk = A.pop();
        C.push(disk);            writer.println("Переместить диск " + disk + " сo столба " +num1+" " + " на столб " +num3+" " + " ");
        writer.println(A+" "+B+" "+C);
        towerOfHanoi(n-1, B, A, C, writer,num2,num1,num3);
    }
    }
    static void restoreOriginalOrder(Stack<Integer> source, Stack<Integer> destination, Stack<Integer> auxiliary) {
        while (!destination.isEmpty()) {
            source.push(destination.pop());
        }
        while (!auxiliary.isEmpty()) {
            source.push(auxiliary.pop());
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        Stack<Integer> stackC = new Stack<>();
        String num1="1";
        String num2="2";
        String num3="3";
        Scanner sc= new Scanner(System.in);
        File file = new File("диски.txt");
        PrintWriter writer = new PrintWriter(new File("результат.txt"));
        PrintWriter righter = new PrintWriter("диски.txt");
        System.out.print("Введите число дисков: ");
        int kolDis=sc.nextInt();
        for(int i =kolDis;i>0;i--){
            righter.println(i);
            righter.flush();
        }
        Scanner in = new Scanner(file);
        while (in.hasNextInt()) {
            stackA.push(in.nextInt());
        }
        in.close();
        towerOfHanoi(stackA.size(), stackA, stackB, stackC, writer,num1,num2,num3);
        restoreOriginalOrder(stackA, stackC, stackB); // Восстанавливаем исходный порядок
        writer.println("Диски в исходном порядке: " + stackA);        writer.close();
    }}