package Supermercado.Interface.ventanas;

import Supermercado.Service.ProductService;
import Supermercado.model.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistrarProducto extends JFrame {


    public static void main (String [] args) {
        ProductService pService = new ProductService();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.gray);
        JButton botonRegistrar = new JButton("Registrar");

        JTextField nombreTF = new JTextField();
        nombreTF.requestFocusInWindow();
        JTextField precioTF = new JTextField();
        JTextField cantidadTF = new JTextField();

        JLabel ingreseNombre = new JLabel("Ingrese Nombre");
        JLabel ingresePrecio = new JLabel("Ingrese Precio");
        JLabel ingreseCantidad = new JLabel("Ingrese Cantidad");

        ingreseNombre.setBounds(150 , 80 , 150,25);
        nombreTF.setBounds(150 , 100 , 200,30);

        ingresePrecio.setBounds(150 , 130 , 150,25);
        precioTF.setBounds(150 , 150 , 200,30);

        ingreseCantidad.setBounds(150 , 180 , 150,25);
        cantidadTF.setBounds(150 , 200 , 200,30);

        botonRegistrar.setBounds(200,250,100,25);

        panel.add(ingreseNombre);
        panel.add(nombreTF);
        panel.add(ingresePrecio);
        panel.add(precioTF);
        panel.add(ingreseCantidad);
        panel.add(cantidadTF);
        panel.add(botonRegistrar);

        VentanaRegistrarProducto ventana = new VentanaRegistrarProducto();

        botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int codigo = pService.getLastCodigo() + 1;
                String nombre = nombreTF.getText();
                float precio = Float.parseFloat(precioTF.getText());
                int cantidad = Integer.parseInt(cantidadTF.getText());

                Producto p = new Producto(codigo, nombre,precio,cantidad );
                pService.registrarProducto(p);

                JOptionPane.showMessageDialog(new JFrame(), "se registro con exito el producto: " + nombre + " (código: " + codigo + ")" );

                nombreTF.setText("");
                precioTF.setText("");
                cantidadTF.setText("");
            }

            });

        ventana.setVisible(true);
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);

    }

    public VentanaRegistrarProducto(){
        setTitle("Supermercado-Dame Registrar Producto");
        setSize(500, 370);
        setLocation(400, 150);

    }
}
