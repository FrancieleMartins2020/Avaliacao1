package ParaleloComObjCompartilhadoCalculoPi;

public class ParaleloCalculoPi extends Thread {
    private int inicio;
    private int fim;
    private SomaCompartilhada somaCompartilhada;

    public ParaleloCalculoPi(int inicio, int fim, SomaCompartilhada somaCompartilhada) {
        this.inicio = inicio;
        this.fim = fim;
        this.somaCompartilhada = somaCompartilhada;
    }

    @Override
    public void run() {
        double somaLocal = 0;
        for (int i = inicio; i < fim; i++) {
            somaLocal += Math.pow(-1, i) / ((2.0 * i) + 1);
        }

        // Adiciona a soma local ao objeto compartilhado de forma segura
        somaCompartilhada.adicionar(somaLocal);
    }
}
