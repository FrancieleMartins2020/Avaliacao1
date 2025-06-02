package SerialCalculoPi;

public class SerialCalculoPi implements Runnable {
    private int id;
    private int inicio;
    private int fim;
    private double[] resultados;

    public SerialCalculoPi(int id, int inicio, int fim, double[] resultados) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.resultados = resultados;
    }

    @Override
    public void run() {
        double soma = 0;
        for (int i = inicio; i < fim; i++) {
            soma += Math.pow(-1, i) / (2 * i + 1);
        }

        synchronized (resultados) {
            resultados[id] = soma;
        }
    }
}
