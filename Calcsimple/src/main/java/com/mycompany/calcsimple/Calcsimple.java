package com.mycompany.calcsimple;
import java.awt.Font;
import javax.swing.*;
public class Calcsimple extends JFrame{
    private JLabel label1, label2;
    public Calcsimple(){
        setLayout(null);
        label1=new JLabel("Sistema de calculadora",SwingConstants.CENTER);
        label1.setFont(new Font("Sans",Font.BOLD,35));
        label1.setBounds(3,30,950,30);
        add(label1);
        label2=new JLabel("Ingrese los dos numeros a calcular",SwingConstants.CENTER);
        label2.setFont(new Font("Sans",Font.PLAIN,20));
        label2.setBounds(20,100,400,60);
        add(label2);
        
    }
    public static void main(String[] args) {
        Calcsimple form= new Calcsimple();
        form.setBounds(171, 134, 1024, 800);
        form.setVisible(true);
    }
}
