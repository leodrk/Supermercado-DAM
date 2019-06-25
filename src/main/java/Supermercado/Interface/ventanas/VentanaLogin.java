package Supermercado.Interface.ventanas;
import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame{

    public static void main (String [] args) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.gray);
        JButton botonIngresar = new JButton("Ingresar");
        JTextField usuarioTF = new JTextField();
        usuarioTF.requestFocusInWindow();
        JTextField passwordTF = new JTextField();
        JLabel ingreseUsuario = new JLabel("Ingrese Usuario");
        JLabel ingresePassword = new JLabel("Ingrese Password");

        ingreseUsuario.setBounds(150 , 70 , 150,40);
        usuarioTF.setBounds(150 , 100 , 200,30);
        usuarioTF.setToolTipText("ingrese usuario...");
        //usuarioTF.setText("ingrese usuario...");


        ingresePassword.setBounds(150 , 140 , 150,40);
        passwordTF.setBounds(150 , 170 , 200,30);
        passwordTF.setToolTipText("ingrese Password");
        //passwordTF.setText("ingrese password...");

        botonIngresar.setBounds(200 , 220, 100 ,40);

        panel.add(ingreseUsuario);
        panel.add(usuarioTF);
        panel.add(ingresePassword);
        panel.add(passwordTF);
        panel.add(botonIngresar);

        VentanaLogin ventana = new VentanaLogin();
        ventana.setVisible(true);
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);


    }


    public VentanaLogin(){
        setTitle("Supermercado-Dame LOGIN");
        setSize(550, 370);
    }
}
