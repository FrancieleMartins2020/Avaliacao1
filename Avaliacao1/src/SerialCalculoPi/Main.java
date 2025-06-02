package SerialCalculoPi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    	Scanner scan = new Scanner(System.in);
        System.out.print("Quantidade de Thread: ");
        final int NumeroThreads = scan.nextInt();
        int numIteracoes = 1_000_000;
        double[] resultados = new double[NumeroThreads];
        int intervalo = numIteracoes / NumeroThreads;

        Thread[] threads = new Thread[NumeroThreads];

        for (int i = 0; i < NumeroThreads; i++) {
            int inicio = i * intervalo;
            int fim = (i == NumeroThreads - 1) ? numIteracoes : inicio + intervalo;

            SerialCalculoPi tarefa = new SerialCalculoPi(i, inicio, fim, resultados);
            threads[i] = new Thread(tarefa);
            threads[i].start();
        }

        for (int i = 0; i < NumeroThreads; i++) {
            threads[i].join();
        }

        double pi = 0;
        for (double resultado : resultados) {
            pi += resultado;
        }

        pi *= 4;

        System.out.println("Valor aproximado de pi: " + pi);
    }
}

