package Supermercado.Interface.ventanas;
import Supermercado.Service.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaLogin extends JFrame{

    public static void main (String [] args) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.gray);
        JButton botonIngresar = new JButton("Ingresar");
        JButton botonRegistrar = new JButton("Registrar");
        JTextField usuarioTF = new JTextField();
        usuarioTF.requestFocusInWindow();
        JPasswordField passwordTF = new JPasswordField();
        passwordTF.setEchoChar('*');
        JLabel ingreseUsuario = new JLabel("Usuario");
        JLabel ingresePassword = new JLabel("Contraseña");
        JLabel usuarioOPasswordIncorrecto = new JLabel("Usuario o Contraseña incorrectos!");
        JLabel usuarioRegistrado = new JLabel("Usuario registrado!");
        JLabel usuarioExistente = new JLabel ("El usuario ya existe!");

        ingreseUsuario.setBounds(30 , 10 , 150,40);
        usuarioTF.setBounds(30 , 40 , 200,30);

        ingresePassword.setBounds(30 ,70 , 150,40);
        passwordTF.setBounds(30 , 100 , 200,30);

        usuarioOPasswordIncorrecto.setBounds(30, 170,200,30);
        usuarioOPasswordIncorrecto.setVisible(false);
        usuarioOPasswordIncorrecto.setForeground(Color.red);
        
        usuarioExistente.setBounds(30, 170,200,30);
        usuarioExistente.setVisible(false);
        usuarioExistente.setForeground(Color.red);
        
        usuarioRegistrado.setBounds(30, 170,200,30);
        usuarioRegistrado.setVisible(false);
        usuarioRegistrado.setForeground(Color.blue);

        botonIngresar.setBounds(30 , 140, 95 ,30);
        botonRegistrar.setBounds(135 , 140, 95 ,30);

        panel.add(ingreseUsuario);
        panel.add(usuarioTF);
        panel.add(ingresePassword);
        panel.add(passwordTF);
        panel.add(botonIngresar);
        panel.add(botonRegistrar);
        panel.add(usuarioOPasswordIncorrecto);
        panel.add(usuarioRegistrado);
        panel.add(usuarioExistente);


        VentanaLogin ventana = new VentanaLogin();
        ventana.setVisible(true);
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);

        botonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String usuarioIngresado = usuarioTF.getText();
                String passwordIngresado = String.valueOf(passwordTF.getPassword());
                UsuarioService service = new UsuarioService();
                String[] arguments = new String[]{usuarioIngresado};

                if (service.comprobarUsuario(usuarioIngresado, passwordIngresado)) {
                    VentanaPrincipal.main(arguments);
                    ventana.dispose();
                } else {
                	usuarioRegistrado.setVisible(false);
                	usuarioExistente.setVisible(false);
                    usuarioOPasswordIncorrecto.setVisible(true);
                    usuarioTF.setText("");
                    passwordTF.setText("");
                }

            }
        });
        
        botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String usuarioIngresado = usuarioTF.getText();
                String passwordIngresado = String.valueOf(passwordTF.getPassword());
                UsuarioService service = new UsuarioService();
                String[] arguments = new String[]{usuarioIngresado};

                if (usuarioIngresado != "" && passwordIngresado != "") {
                	usuarioOPasswordIncorrecto.setVisible(false);
                    usuarioRegistrado.setVisible(false);
                	try
                    {
                		service.guardarUsuario(usuarioIngresado, passwordIngresado);
                		usuarioExistente.setVisible(false);
                        usuarioOPasswordIncorrecto.setVisible(false);
                		usuarioRegistrado.setVisible(true);
                		}
                    catch (Exception e) {
                    	usuarioExistente.setVisible(true);
                    }
                    usuarioTF.setText("");
                    passwordTF.setText("");
                } else {
                	usuarioExistente.setVisible(false);
                	usuarioRegistrado.setVisible(false);
                    usuarioOPasswordIncorrecto.setVisible(true);
                	usuarioTF.setText("");
                    passwordTF.setText("");
                }

            }
        });
    }


    public VentanaLogin(){
        setTitle("DAME - LOGIN");
        setSize(265, 230);
        setLocation(560, 190);
    }
}
