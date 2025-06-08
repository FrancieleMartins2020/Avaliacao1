package SerialCalculoPi;

public class Main {
    public static void main(String[] args) {
        int numeroIteracoes = 1_000_000_000;
        int amostragem = 3;


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
            double soma = 0;

            for (int i = 0; i < numeroIteracoes; i++) {
                soma += Math.pow(-1, i) / (2.0 * i + 1);
            }

            somaTotaldePI = soma * 4;

            long tempoFinal = System.currentTimeMillis();
            tempoTotal = tempoFinal - tempoInicial;
            tempoParcial[repeticoes] = tempoTotal;
            tempo += tempoTotal;
            repeticoes++;
        }

        tempoMedio = tempo / amostragem;

        // cálculo do desvio padrão
        for (int k = 0; k < amostragem; k++) {
            desvioPadrao[k] = tempoMedio - tempoParcial[k];
            desvioPadrao[k] *= desvioPadrao[k];
            desvioPadraoParcial += desvioPadrao[k];
        }

        totalDesvioPadrao = desvioPadraoParcial / amostragem;
        totalDesvioPadrao = (long) Math.sqrt(totalDesvioPadrao);

        System.out.println("==== Versão Serial ====");
        System.out.println("Tempo médio: " + tempoMedio + " ms");
        System.out.println("Valor aproximado de PI: " + somaTotaldePI);
        System.out.println("Desvio padrão: " + totalDesvioPadrao + " ms");
    }
}
