package Supermercado.Interface.ventanas;


import Supermercado.Interface.ventanas.paneles.ProductListPanel;
import Supermercado.Service.CajaService;
import Supermercado.Service.UsuarioService;
import Supermercado.model.Caja;
import Supermercado.model.Factura;
import Supermercado.model.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal {
	
	public static String getFactura(CajaService caja, String cajero) {
		Factura factura = caja.generarFactura();
		String agradecimiento = "Gracias por su compra! <br/>";
		String titulo = "Factura Supermercado DAME <br/> -Cajero: " + cajero + "<br/>";
		String productos = "";
		for (Producto p : factura.getProductosAbonados()) {
			productos = productos + p.getNombre() + " $" + p.getPrecio() + " x " + p.getCantidad() + " unidades" + "<br/>"; 
		}
		String total = "Total venta: $" + String.valueOf(caja.getTotalVentaActual()) + "<br/>";
		return "<html>" 
				+ "------------------------------------------------- <br/>"
				+ titulo
				+ "------------------------------------------------- <br/>"
				+ productos 
				+ "<br/> <br/> <br/> <br/> <br/>"
				+ total 
				+ "------------------------------------------------- <br/>"
				+ agradecimiento
				+ "</html>";
	}


    public static void main (String [] args) {
        ProductListPanel tablaProductos = new ProductListPanel();
        JPanel panel = new JPanel(); // Creamos el panel
        panel.setLayout(null);
        JButton botonRegistrar = new JButton("Registrar");
        JButton num1 = new JButton("1");
        JButton num2 = new JButton("2");
        JButton num3 = new JButton("3");
        JButton num4 = new JButton("4");
        JButton num5 = new JButton("5");
        JButton num6 = new JButton("6");
        JButton num7 = new JButton("7");
        JButton num8 = new JButton("8");
        JButton num9 = new JButton("9");
        JButton num0 = new JButton("0");
        JButton finCompra = new JButton("Finalizar");
        JButton registrarProducto = new JButton ("Nuevo");
        Label labelAlerta = new Label();
        labelAlerta.setText("Producto Incorrecto");
        labelAlerta.setVisible(false);
        labelAlerta.setForeground(Color.red);

        JLabel labelCodigo = new JLabel("Ingrese Codigo");

        JTextField cajaDeTexto = new JTextField();
        cajaDeTexto.setEditable(false);
        JTextField totalVenta = new JTextField();
        totalVenta.setEditable(false);

        Marco marco = new Marco();
        marco.setVisible(true);
        panel.setBackground(Color.gray);
        marco.add(panel);
        cajaDeTexto.requestFocusInWindow();
        cajaDeTexto.setBounds(230,35,115 ,40);

        botonRegistrar.setBounds(230 , 90, 115 ,40);
        registrarProducto.setBounds(230,180,115,40);
        finCompra.setBounds(230, 135, 115, 40);

        num1.setBounds(50 , 30 , 45,45);
        num2.setBounds(103 , 30 , 45,45);
        num3.setBounds(155 , 30 , 45,45);
        num4.setBounds(50 , 80 , 45,45);
        num5.setBounds(103 , 80 , 45,45);
        num6.setBounds(155 , 80 , 45,45);
        num7.setBounds(50 , 130 , 45,45);
        num8.setBounds(103 , 130 , 45,45);
        num9.setBounds(155 , 130 , 45 ,45);
        num0.setBounds(103,180,45,45);
        labelAlerta.setBounds(230,60,130, 45);
        ArrayList <JButton> listaBotones = new ArrayList <>();
        listaBotones.add(num0);
        listaBotones.add(num1);
        listaBotones.add(num2);
        listaBotones.add(num3);
        listaBotones.add(num4);
        listaBotones.add(num5);
        listaBotones.add(num6);
        listaBotones.add(num7);
        listaBotones.add(num8);
        listaBotones.add(num9);
        labelCodigo.setBounds(230,5,115,40);
        cajaDeTexto.setBounds(230,35,115 ,40);
        totalVenta.setBounds(360,290,150,35);
        tablaProductos.getPanel().setBounds(360, 30, 150,250);
        
        CajaService cajaService = new CajaService(new Caja(), args[0]);

        botonRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textFieldValue = cajaDeTexto.getText();
                if (!textFieldValue.equals("")) {
                    Producto p = cajaService.registrarProducto(Integer.parseInt(textFieldValue));
                    if (p == null) {
                        labelAlerta.setVisible(true);
                    }
                    else
                    {
                        totalVenta.setText("Total: " + cajaService.getTotalVentaActual());
                        tablaProductos.añadirProducto(p);
                    }
                    cajaDeTexto.setText("");
                }
            }}
        );

        listaBotones.forEach(boton -> boton.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent ae) {
                cajaDeTexto.setText(cajaDeTexto.getText() + boton.getText());
                labelAlerta.setVisible(false);
            }
        }));
        
        finCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                tablaProductos.actualizarStocks();
                String[] arguments = new String[]{VentanaPrincipal.getFactura(cajaService, args[0]), cajaService.getCajero()
                };
                marco.dispose();
                VentanaFactura.main(arguments);
            }    
        });
        
        registrarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                tablaProductos.actualizarStocks();
                String[] arguments = new String[]{cajaService.getCajero()
                };
                VentanaRegistrarProducto.main(arguments);
            }    
        });

        listaBotones.forEach(boton -> panel.add(boton));
        panel.add(botonRegistrar);
        panel.add(finCompra);
        panel.add(labelCodigo);
        panel.add(cajaDeTexto);
        panel.add(tablaProductos.getPanel());
        panel.add(labelAlerta);
        panel.add(totalVenta);
        panel.add(registrarProducto);

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cajaDeTexto.requestFocusInWindow();
        marco.getRootPane().setDefaultButton(botonRegistrar);
        marco.setResizable(false);
        marco.setTitle("Supermercado DAME - cajero: " + args[0]);
    }


}

class Marco extends JFrame {

    public Marco() {
        setTitle("Supermercado-Dame");
        setSize(550, 370);
        setLocation(400, 150);
    }
}

