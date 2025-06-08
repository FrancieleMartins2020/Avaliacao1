package ParaleloComObjCompartilhadoCalculoPi;

public class SomaCompartilhada {
    private double soma = 0;

    public synchronized void adicionar(double valor) {
        soma += valor;
    }

    public double getSoma() {
        return soma;
    }
}