package Supermercado.Interface.ventanas;
import Supermercado.Service.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
        JLabel usuarioOPasswordIncorrecto = new JLabel("usuario o password incorrectos!");

        ingreseUsuario.setBounds(150 , 70 , 150,40);
        usuarioTF.setBounds(150 , 100 , 200,30);
        usuarioTF.setToolTipText("ingrese usuario...");

        ingresePassword.setBounds(150 , 140 , 150,40);
        passwordTF.setBounds(150 , 170 , 200,30);
        passwordTF.setToolTipText("ingrese Password");

        usuarioOPasswordIncorrecto.setBounds(158, 270,200,30);
        usuarioOPasswordIncorrecto.setVisible(false);

        botonIngresar.setBounds(200 , 220, 100 ,40);

        panel.add(ingreseUsuario);
        panel.add(usuarioTF);
        panel.add(ingresePassword);
        panel.add(passwordTF);
        panel.add(botonIngresar);
        panel.add(usuarioOPasswordIncorrecto);


        VentanaLogin ventana = new VentanaLogin();
        ventana.setVisible(true);
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);

        botonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String usuarioIngresado = usuarioTF.getText();
                String passwordIngresado = passwordTF.getText();
                UsuarioService service = new UsuarioService();
                String[] arguments = new String[]{usuarioIngresado};

                if (service.comprobarUsuario(usuarioIngresado, passwordIngresado)) {

                    VentanaPrincipal.main(arguments);
                    ventana.setVisible(false);
                    ventana.dispose();
                } else {
                    usuarioOPasswordIncorrecto.setVisible(true);
                    usuarioTF.setText("");
                    passwordTF.setText("");
                }

            }
        });
    }


    public VentanaLogin(){
        setTitle("Supermercado-Dame LOGIN");
        setSize(550, 370);
    }
}
