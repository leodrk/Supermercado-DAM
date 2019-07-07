package Supermercado.Interface.ventanas;

import Supermercado.Service.ProductService;
import Supermercado.model.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaModificarStock extends JFrame {
    public static void main (String [] args) {
    ProductService pService = new ProductService();

    Producto productoAModificar = pService.getProduct(3313);
   //Producto productoAModificar = pService.getProduct(Integer.parseInt(args[0]));
        // Usar este cuando se llame esta ventana desde otra pasandole un codigo por el parametro de arreglo de strings


    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.gray);
    JTextField nuevoStockTF = new JTextField();
    nuevoStockTF.requestFocusInWindow();
    JLabel nombreProducto = new JLabel (productoAModificar.getNombre());
    JButton botonModificar = new JButton("Modificar");

    nombreProducto.setBounds(150 , 80 , 150,25);
    nuevoStockTF.setBounds(150 , 110 , 200,30);
    botonModificar.setBounds(200 , 150 , 100,25);

    panel.add(nombreProducto);
    panel.add(nuevoStockTF);
    panel.add(botonModificar);
    VentanaModificarStock ventana = new VentanaModificarStock();

    botonModificar.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent ae) {

           int nuevacantidad = Integer.parseInt(nuevoStockTF.getText());
           productoAModificar.setCantidad(nuevacantidad);
           pService.actualizarStock(productoAModificar);

           JOptionPane.showMessageDialog(new JFrame(), "el producto " + productoAModificar.getNombre() + " ahora tiene " + productoAModificar.getCantidad() + " unidades");
           nuevoStockTF.setText("");
       }

        });

        ventana.setVisible(true);
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
    }

    public VentanaModificarStock() {
        setTitle("Supermercado-Dame Modificar Stock");
        setSize(500, 370);
        setLocation(400, 150);
    }
}
