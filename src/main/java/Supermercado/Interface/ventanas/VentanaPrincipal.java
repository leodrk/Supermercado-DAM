package Supermercado.Interface.ventanas;


import Supermercado.Interface.ventanas.paneles.ProductListPanel;
import Supermercado.Service.CajaService;
import Supermercado.model.Caja;
import Supermercado.model.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal {




    public static void main (String [] args) {
        ProductListPanel pl = new ProductListPanel();

        JPanel panel = new JPanel(); // Creamos el panel
        panel.setLayout(null);
        JButton boton1 = new JButton("Registrar");
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
        JButton punto = new JButton(".");

        JLabel labelCodigo = new JLabel("Ingrese Codigo");

        JTextField cajaDeTexto = new JTextField();

        JTextField cajaDeTexto1 = new JTextField("INGRESE PRECIO");

        //CREO Tabla
        String [] nombresColumnas = {"Producto" , "Precio"};
        String [] datosFilas = {"Coca" , "15.00"};
        //JTable tabla = new JTable();

        Marco marco = new Marco();
        marco.setVisible(true);
        panel.setBackground(Color.gray);
        marco.add(panel);
        cajaDeTexto.requestFocusInWindow();
        boton1.setBounds(230 , 175, 100 ,40);
        num1.setBounds(50 , 30 , 45,45);
        num2.setBounds(103 , 30 , 45,45);
        num3.setBounds(155 , 30 , 45,45);
        num4.setBounds(50 , 80 , 45,45);
        num5.setBounds(103 , 80 , 45,45);
        num6.setBounds(155 , 80 , 45,45);
        num7.setBounds(50 , 130 , 45,45);
        num8.setBounds(103 , 130 , 45,45);
        num9.setBounds(155 , 130 , 45,45);
        num0.setBounds(50,180,100,45);
        punto.setBounds(155 , 180 , 45,45);
        labelCodigo.setBounds(230,5,115,40);
        cajaDeTexto.setBounds(230,35,115 ,40);
        cajaDeTexto1.setBounds(230,80,115 ,40);
        pl.getPanel().setBounds(360, 30, 150,250);

        CajaService cajaService = new CajaService(new Caja());

        boton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textFieldValue = cajaDeTexto.getText();

                Producto p = cajaService.getProducto(Integer.parseInt(textFieldValue));

                pl.añadirProducto(p);
                cajaDeTexto.setText("");
            }}
            );

        panel.add(boton1);
        panel.add(num0);
        panel.add(num1);
        panel.add(num2);
        panel.add(num3);
        panel.add(num4);
        panel.add(num5);
        panel.add(num6);
        panel.add(num7);
        panel.add(num8);
        panel.add(num9);
        panel.add(punto);
        panel.add(labelCodigo);
        panel.add(cajaDeTexto);
       // panel.add(cajaDeTexto1);
        panel.add(pl.getPanel());




        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cajaDeTexto.requestFocusInWindow();
        marco.getRootPane().setDefaultButton(boton1);
    }


}



class Marco extends JFrame {

    public Marco() {
        setTitle("Supermercado-Dame");
        setSize(600, 400);

    }


}

