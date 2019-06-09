package Supermercado.Interface;


import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {




    public static void main (String [] args) {
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
        JButton punto = new JButton(".");

        JTextField cajaDeTexto = new JTextField("INGRESE CODIGO");
        JTextField cajaDeTexto1 = new JTextField("INGRESE PRECIO");

        //CREO Tabla
        String [] nombresColumnas = {"Producto" , "Precio"};
        String [] datosFilas = {"Coca" , "15.00"};
        //JTable tabla = new JTable();

        Marco marco = new Marco();
        marco.setVisible(true);
        panel.setBackground(Color.gray);
        marco.add(panel);

        boton1.setBounds(300 , 175, 100 ,40);
        num1.setBounds(50 , 30 , 45,45);
        num2.setBounds(103 , 30 , 45,45);
        num3.setBounds(155 , 30 , 45,45);
        num4.setBounds(50 , 80 , 45,45);
        num5.setBounds(103 , 80 , 45,45);
        num6.setBounds(155 , 80 , 45,45);
        num7.setBounds(50 , 130 , 45,45);
        num8.setBounds(103 , 130 , 45,45);
        num9.setBounds(155 , 130 , 45,45);
        punto.setBounds(103 , 180 , 45,45);
        cajaDeTexto.setBounds(230,35,115 ,40);
        cajaDeTexto1.setBounds(230,80,115 ,40);




        panel.add(boton1);
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
        panel.add(cajaDeTexto);
        panel.add(cajaDeTexto1);


        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


}



class Marco extends JFrame {

    public Marco() {
        setTitle("Supermercado-Dame");
        setSize(600, 300);

    }


}

