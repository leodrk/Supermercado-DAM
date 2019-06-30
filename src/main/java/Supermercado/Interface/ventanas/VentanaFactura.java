package Supermercado.Interface.ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Supermercado.Service.UsuarioService;
 
public class VentanaFactura extends JFrame {
	
	public static void main (String [] args) {
    JLabel datosFactura = new JLabel(args[0], SwingConstants.LEFT);
    datosFactura.setBounds(25, -200, 380, 500);
    JButton botonImprimir = new JButton("Imprimir");
    botonImprimir.setBounds(75, 470, 100, 30);
    JButton botonFinalizar = new JButton("Finalizar");
    botonFinalizar.setBounds(225, 470, 100, 30);
	JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.WHITE);
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
    
	}
	public VentanaFactura(){
	    setTitle("Factura");
	    setSize(400, 550);
	    setLocation(500, 50);
	    setResizable(false);
	    }

}
