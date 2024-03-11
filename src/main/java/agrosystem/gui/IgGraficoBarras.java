package agrosystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.category.DefaultCategoryDataset;

import agrosystem.dominio.Bovino;
import agrosystem.dominio.enumeracao.Raca;


public class IgGraficoBarras {
	
	public static JPanel gerarGraficoBarras(List<Bovino> bovinoList, int numeroTotalBovinos) {
		if (numeroTotalBovinos == 0) {
       	 final JPanel contentPanel = new JPanel();
       	    contentPanel.setBackground(new Color(255, 255, 255));
       	    contentPanel.setBounds(100, 100, 450, 300);
       	    contentPanel.setLayout(new BorderLayout());

       	    JTextPane textPane = new JTextPane();
       	    textPane.setText("Para exibir o gráfico. \nRealize os cadastro dos Bovinos.");
       	    textPane.setFont(new Font("SansSerif", Font.PLAIN, 16));
       	    textPane.setEditable(false);
       	    textPane.setOpaque(false);

       	    StyledDocument doc = textPane.getStyledDocument();
       	    SimpleAttributeSet centerAlignment = new SimpleAttributeSet();
       	    StyleConstants.setAlignment(centerAlignment, StyleConstants.ALIGN_CENTER);
       	    doc.setParagraphAttributes(0, doc.getLength(), centerAlignment, false);

       	    contentPanel.add(textPane, BorderLayout.CENTER);

       	    JLabel imagemLabel = new JLabel("");
       	    imagemLabel.setHorizontalAlignment(SwingConstants.CENTER);
       	    imagemLabel.setIcon(new ImageIcon(IgGraficoBarras.class.getResource("/agrosystem/imagens/icon.png")));

       	    contentPanel.add(imagemLabel, BorderLayout.NORTH);

       	    return contentPanel;
       }
		
		// Criação do conjunto de dados
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		Locale.setDefault(Locale.US);

		dataset.addValue(totalDeBovisnosDeDeterminadaRaca(bovinoList, Raca.GIR) / numeroTotalBovinos * 100, Raca.GIR.getRaca(), "");
		dataset.addValue(totalDeBovisnosDeDeterminadaRaca(bovinoList, Raca.GIROLANDO) / numeroTotalBovinos * 100, Raca.GIROLANDO.getRaca(), "");
		dataset.addValue(totalDeBovisnosDeDeterminadaRaca(bovinoList, Raca.HOLANDES) / numeroTotalBovinos * 100, Raca.HOLANDES.getRaca(), "");
		dataset.addValue(totalDeBovisnosDeDeterminadaRaca(bovinoList, Raca.JERSEY) / numeroTotalBovinos * 100, Raca.JERSEY.getRaca(), "");
	

		// Criação do gráfico de barras
		JFreeChart chart = ChartFactory.createBarChart(
				"",  // Título do gráfico
				"Raças cadastradas", // Rótulo do eixo x
				"",            // Rótulo do eixo y
				dataset,              // Dados
				PlotOrientation.VERTICAL,
				true,
				false,
				false
				);

		// Personalização do estilo das barras
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setBarPainter(new StandardBarPainter());
		renderer.setSeriesPaint(0, new Color(255, 192, 203));
		renderer.setSeriesPaint(1, new Color(150, 75, 0));
		renderer.setSeriesPaint(0, new Color(128, 0, 128));
		renderer.setSeriesPaint(0, new Color(255, 165, 0));
		
		// Definir largura máxima para as barras
		double maxBarWidth = .1; 
		double barMargin = (1.0 - maxBarWidth) / 2.0;
		renderer.setMaximumBarWidth(maxBarWidth);
		renderer.setItemMargin(barMargin);

		// Personalização do fundo e das linhas do gráfico
		plot.setBackgroundPaint(Color.WHITE); 
		plot.setRangeGridlinePaint(Color.GRAY); 
		
		// Ajustar posição das legendas
		LegendTitle legend = chart.getLegend();
		legend.setPosition(RectangleEdge.RIGHT);

		// Personalização do rótulo do eixo y com formato personalizado
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		DecimalFormat decimalFormat = new DecimalFormat("0.00'%'");
		rangeAxis.setNumberFormatOverride(decimalFormat);
		double maxValue = rangeAxis.getUpperBound(); 
		// Ajuste da escala com 10 unidades a mais
		rangeAxis.setRange(0, maxValue + 10); 

		// Personalização dos rótulos dos valores acima das barras com formato personalizado
		renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", decimalFormat));
		renderer.setDefaultItemLabelsVisible(true);


		// Criação do painel do gráfico
		ChartPanel chartPanel = new ChartPanel(chart);
		// Desativar funcionalidade de zoom
		chartPanel.setDomainZoomable(false);
		chartPanel.setRangeZoomable(false);

		return chartPanel;
	}//JPanel()
	
	public static float totalDeBovisnosDeDeterminadaRaca(List<Bovino> bovinoList, Raca raca) {
		return bovinoList.stream().filter(bovino -> bovino.getRaca().equals(raca)).toList().size();
	}//totalDeBovisnosDeDeterminadaRaca()
}//IgGraficoBarras