package Grafico;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.List;

public class GraficoEstatisticas {

    public static void mostrarGrafico(List<Integer> numThreads,
                                      List<Long> temposMedios,
                                      List<Long> desviosPadrao,
                                      String titulo) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < numThreads.size(); i++) {
            String categoria = numThreads.get(i) + " Threads";
            dataset.addValue(temposMedios.get(i), "Tempo Médio (ms)", categoria);
            dataset.addValue(desviosPadrao.get(i), "Desvio Padrão (ms)", categoria);
        }

        JFreeChart grafico = ChartFactory.createBarChart(
                titulo,                         // título passado por parâmetro
                "Número de Threads",            // eixo X
                "Tempo (ms)",                   // eixo Y
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        JFrame janela = new JFrame("Gráfico de Estatísticas");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(new ChartPanel(grafico));
        janela.setSize(800, 600);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
}
