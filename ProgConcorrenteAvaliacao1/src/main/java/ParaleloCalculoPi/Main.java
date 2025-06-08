package ParaleloCalculoPi;
import Grafico.GraficoEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] numThreadsArray = {1, 2, 4, 8, 16};
        int numeroIteracoes = 1_000_000_000;
        int amostragem = 3;

        List<Integer> threadsList = new ArrayList<>();
        List<Long> temposMediosList = new ArrayList<>();
        List<Long> desviosPadraoList = new ArrayList<>();

        System.out.println("==== Versão Paralelo sem objeto compartilhado ====");
        
        for (int NumeroThreads : numThreadsArray) {
            long tempo = 0;
            long tempoTotal;
            long tempoMedio;
            long[] tempoParcial = new long[amostragem];

            long[] desvioPadrao = new long[amostragem];
            long desvioPadraoParcial = 0;
            long totalDesvioPadrao;

            int repeticoes = 0;
            double somaTotaldePI = 0;

            while (repeticoes < amostragem) {
                long tempoInicial = System.currentTimeMillis();
                double somaTotal = 0;
                final double[] somaParcial = new double[NumeroThreads];

                Thread[] threads = new ParaleloCalculoPi[NumeroThreads];

                for (int i = 0; i < NumeroThreads; i++) {
                    int inicio = numeroIteracoes / NumeroThreads * i;
                    int fim = (i == NumeroThreads - 1) ? numeroIteracoes : numeroIteracoes / NumeroThreads * (i + 1);
                    threads[i] = new ParaleloCalculoPi(i, somaParcial, inicio, fim);
                    threads[i].start();
                }

                for (Thread v : threads) {
                    v.join();
                }

                for (int j = 0; j < NumeroThreads; j++) {
                    somaTotal += somaParcial[j];
                }

                long tempoFinal = System.currentTimeMillis();
                tempoTotal = tempoFinal - tempoInicial;
                tempoParcial[repeticoes] = tempoTotal;
                tempo += tempoTotal;
                repeticoes++;

                somaTotaldePI = somaTotal * 4;
            }

            tempoMedio = tempo / amostragem;

            for (int k = 0; k < amostragem; k++) {
                desvioPadrao[k] = tempoMedio - tempoParcial[k];
                desvioPadrao[k] *= desvioPadrao[k];
                desvioPadraoParcial += desvioPadrao[k];
            }

            totalDesvioPadrao = desvioPadraoParcial / amostragem;
            totalDesvioPadrao = (long) Math.sqrt(totalDesvioPadrao);

            System.out.println("==== Threads: " + NumeroThreads + " ====");
            System.out.println("Tempo médio: " + tempoMedio + " ms");
            System.out.println("Valor aproximado de PI: " + somaTotaldePI);
            System.out.println("Desvio padrão: " + totalDesvioPadrao + " ms");
            System.out.println();

            // salvar dados p/ gráfico
            threadsList.add(NumeroThreads);
            temposMediosList.add(tempoMedio);
            desviosPadraoList.add(totalDesvioPadrao);
        }

        GraficoEstatisticas.mostrarGrafico(threadsList, 
        		temposMediosList, desviosPadraoList, "Versão Paralelo sem objeto compartilhado - Tempo Médio x Nº de Threads");
    }
}
