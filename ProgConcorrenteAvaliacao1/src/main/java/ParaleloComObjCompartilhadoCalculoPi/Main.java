package ParaleloComObjCompartilhadoCalculoPi;

import Grafico.GraficoEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[] numThreadsArray = {1, 2, 4, 8, 16};
        int numeroIteracoes = 1_000_000_000;
        int amostragem = 3;

        List<Integer> threadsList = new ArrayList<>();
        List<Long> temposMedios = new ArrayList<>();
        List<Long> desviosPadrao = new ArrayList<>();

        System.out.println("==== Versão Paralelo com objeto compartilhado ====");
        
        for (int NumeroThreads : numThreadsArray) {
            long tempoTotal = 0;
            long[] tempoParcial = new long[amostragem];

            for (int repeticoes = 0; repeticoes < amostragem; repeticoes++) {
                SomaCompartilhada somaCompartilhada = new SomaCompartilhada();
                Thread[] threads = new Thread[NumeroThreads];
                long tempoInicial = System.currentTimeMillis();

                for (int i = 0; i < NumeroThreads; i++) {
                    int inicio = numeroIteracoes / NumeroThreads * i;
                    int fim = (i == NumeroThreads - 1) ? numeroIteracoes : numeroIteracoes / NumeroThreads * (i + 1);
                    threads[i] = new ParaleloCalculoPi(inicio, fim, somaCompartilhada);
                    threads[i].start();
                }

                for (Thread thread : threads) {
                    thread.join();
                }

                long tempoFinal = System.currentTimeMillis();
                tempoParcial[repeticoes] = tempoFinal - tempoInicial;
                tempoTotal += tempoParcial[repeticoes];
            }

            long tempoMedio = tempoTotal / amostragem;

            long somaQuadrados = 0;
            for (int i = 0; i < amostragem; i++) {
                long diferenca = tempoParcial[i] - tempoMedio;
                somaQuadrados += diferenca * diferenca;
            }

            long desvioPadrao = (long) Math.sqrt(somaQuadrados / amostragem);

            threadsList.add(NumeroThreads);
            temposMedios.add(tempoMedio);
            desviosPadrao.add(desvioPadrao);

            System.out.println("==== Threads: " + NumeroThreads + " ====");
            System.out.println("Tempo médio: " + tempoMedio + " ms");
            System.out.println("Desvio padrão: " + desvioPadrao + " ms");
            System.out.println();
        }

        // Mostrar gráfico com título específico para essa versão
        GraficoEstatisticas.mostrarGrafico(
                threadsList,
                temposMedios,
                desviosPadrao,
                "Versão Paralelo com objeto compartilhado - Tempo Médio x Nº de Threads"
        );
    }
}
