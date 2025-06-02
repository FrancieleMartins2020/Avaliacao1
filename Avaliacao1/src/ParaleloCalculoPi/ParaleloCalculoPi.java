package ParaleloCalculoPi;
public class ParaleloCalculoPi extends Thread{
    private int MNumThreads;
    private int cont;
    private int inicio;
    private int fim;
    private double[] soma;
    private double pi=0;

    public ParaleloCalculoPi(int cont, double[] soma, int inicio, int fim){
        this.cont = cont;
        this.soma = soma;
        this.inicio = inicio;
        this.fim = fim;
    }
    @Override
    public void run(){
        for(int i=inicio;i<fim;i++){
            pi = Math.pow(-1,i)/((2*i)+1);
            this.soma[cont] += pi;
        }
    }
}
