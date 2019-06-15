package Supermercado.Interface.ventanas.paneles;

import Supermercado.model.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductListPanel extends JPanel {
    JPanel panel = new JPanel();
    DefaultListModel<Producto> productos = new  DefaultListModel();
    JList productosHastaElMomento;
    JScrollPane scroller;


    public ProductListPanel(){
        productosHastaElMomento = new JList(productos);
        productosHastaElMomento.setVisibleRowCount(10);
        scroller = new JScrollPane(productosHastaElMomento,

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        productosHastaElMomento.setFixedCellHeight(25);
        productosHastaElMomento.setFixedCellWidth(150);
        //productosHastaElMomento.setFixedCellHeight(500);
        this.panel.setVisible(true);
        this.panel.add(scroller);
    }

    public void añadirProducto(Producto p){
        this.productos.addElement(p);
    }

    public JPanel getPanel() {
        return panel;
    }

    }
