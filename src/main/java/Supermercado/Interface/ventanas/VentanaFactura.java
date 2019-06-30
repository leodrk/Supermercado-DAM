package Supermercado.Interface.ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Supermercado.Service.UsuarioService;

public class VentanaFactura extends JFrame {
	
	public static String darFormatoAFactura(String factura) {
		return factura.replaceAll("<html>", "").replaceAll("</html>", "").replaceAll("<br/>", "\n");
	}
	
	public static void main (String [] args) {
    JLabel datosFactura = new JLabel(args[0], SwingConstants.LEFT);
    datosFactura.setBounds(15, -100 , 300, 500);
    JButton botonImprimir = new JButton("Imprimir");
    botonImprimir.setBounds(15, 470, 100, 30);
    JButton botonFinalizar = new JButton("Finalizar");
    botonFinalizar.setBounds(155, 470, 100, 30);
	JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.WHITE);
    panel.setSize(300,550);
    panel.add(datosFactura);
    panel.add(botonImprimir);
    panel.add(botonFinalizar);
	VentanaFactura ventana = new VentanaFactura();
    ventana.setVisible(true);
    ventana.add(panel);
    ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventana.setResizable(false);
   
    botonFinalizar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            	String[] arguments = new String[]{args[1]};
                VentanaPrincipal.main(arguments);
                ventana.dispose();
        }
    });
    
    botonImprimir.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            	try {
            		Document document = new Document();
            		PdfWriter.getInstance(document,new FileOutputStream("E:\\factura.pdf"));
            		document.open();
            		document.add(new Paragraph(VentanaFactura.darFormatoAFactura(args[0])));
            		document.close();
            	}
            	catch (Exception e) {
            		System.out.println("Error al imprimir");
            	}
            	System.out.println("Impresión finalizada");
        }
    });
    
	}
	public VentanaFactura(){
	    setTitle("Factura");
	    setSize(280,550);
	    setLocation(500, 50);
	    setResizable(false);
	    }

}
