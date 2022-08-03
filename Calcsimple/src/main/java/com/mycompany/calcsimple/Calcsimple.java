package com.mycompany.calcsimple;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
public class Calcsimple extends JFrame implements  ActionListener{
    private JLabel titulo, instruccion, instruccion2, primerNumero, segNumero;
    private JTextField primNum, segNum;
    private JRadioButton suma,resta,multi,div;
    private ButtonGroup bg;
    private JButton salir;
    int sum,rest,mult;
    float divi;
    public Calcsimple(){
        funcItemListener escucha=new funcItemListener();
        setLayout(null);
        titulo=new JLabel("Sistema de calculadora",SwingConstants.CENTER);
        titulo.setFont(new Font("Sans",Font.BOLD,35));
        titulo.setBounds(3,30,950,30);
        add(titulo);
        instruccion=new JLabel("Ingrese los dos numeros a calcular:",SwingConstants.CENTER);
        instruccion.setFont(new Font("Sans",Font.PLAIN,20));
        instruccion.setBounds(20,100,400,60);
        add(instruccion);
        instruccion2=new JLabel("Seleccione la operacion:",SwingConstants.CENTER);
        instruccion2.setFont(new Font("Sans",Font.PLAIN,20));
        instruccion2.setBounds(550,100,250,60);
        add(instruccion2);
        primerNumero=new JLabel("Primer numero:",SwingConstants.LEFT);
        primerNumero.setFont(new Font("Sans",Font.PLAIN,20));
        primerNumero.setBounds(75,160,200,60);
        add(primerNumero);
        primNum=new JTextField();
        primNum.setFont(new Font("Sans",Font.PLAIN,12));
        primNum.setBounds(240,175,150,30);
        add(primNum);
        segNumero=new JLabel("Segundo numero:",SwingConstants.LEFT);
        segNumero.setFont(new Font("Sans",Font.PLAIN,20));
        segNumero.setBounds(75,250,200,60);
        add(segNumero);
        segNum=new JTextField();
        segNum.setFont(new Font("Sans",Font.PLAIN,12));
        segNum.setBounds(240,265,150,30);
        add(segNum);
        bg=new ButtonGroup();
        suma=new JRadioButton("Sumar");
        suma.setBounds(550, 175, 200, 30);
        suma.setFont(new Font("Sans",Font.PLAIN,20));
        suma.setActionCommand("Sumar");
        suma.addItemListener(escucha);
        add(suma);
        bg.add(suma);
        resta=new JRadioButton("Restar");
        resta.setBounds(550, 200, 200, 30);
        resta.setFont(new Font("Sans",Font.PLAIN,20));
        resta.setActionCommand("Restar");
        resta.addItemListener(escucha);
        add(resta);
        bg.add(resta);
        multi=new JRadioButton("Multiplicar");
        multi.setBounds(550, 225, 200, 30);
        multi.setFont(new Font("Sans",Font.PLAIN,20));
        multi.setActionCommand("Multiplicar");
        multi.addItemListener(escucha);
        add(multi);
        bg.add(multi);
        div=new JRadioButton("Dividir");
        div.setBounds(550, 250, 200, 30);
        div.setFont(new Font("Sans",Font.PLAIN,20));
        div.setActionCommand("Dividir");
        div.addItemListener(escucha);
        add(div);
        bg.add(div);
        salir = new JButton("Salir");
        salir.setBounds(550, 300, 100, 30);
        add(salir);
        salir.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== salir){
            int seleccion= JOptionPane.showConfirmDialog(null, "Desea continuar calculando ", "Salir", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.OK_OPTION== seleccion){
                JOptionPane.showMessageDialog(null, "Continuando...");
            } else {
                System.exit(0);
            }
        }
    }
    public class Funciones{
        public void sum1(int num1, int num2) {
            int sum1 = num1 + num2;
            sum =sum1;
        }
        public void rest1(int num1, int num2) {
            int rest1 = num1 - num2;
            rest=rest1;
        }
        public void mult1(int num1, int num2) {
            int mult1 = num1 * num2;
            mult=mult1;
        }
        public void divi1(float num1, float num2) {
            float divi1 = num1 / num2;
            divi=divi1;
        }
    }
    public class funcItemListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            Funciones func=new Funciones();
            boolean seleccionado = (e.getStateChange()== ItemEvent.SELECTED);
            AbstractButton button = (AbstractButton) e.getItemSelectable();
            String command = button.getActionCommand();
            if (seleccionado){
                int tipoMensaje = -1;
                String mensaje="";
                if (command.equals("Sumar")) {
                        String n1=primNum.getText();
                        String n2=segNum.getText();
                        int x=Integer.parseInt(n1);
                        int y=Integer.parseInt(n2);
                        func.sum1(x, y);
                        tipoMensaje = JOptionPane.INFORMATION_MESSAGE;
                        mensaje = "El resultado es: "+sum;
                    }
                if (command.equals("Restar")) {
                        String n1=primNum.getText();
                        String n2=segNum.getText();
                        int x=Integer.parseInt(n1);
                        int y=Integer.parseInt(n2);
                        func.rest1(x, y);
                        tipoMensaje = JOptionPane.INFORMATION_MESSAGE;
                        mensaje = "El resultado es: "+rest;
                    }
                if (command.equals("Multiplicar")) {
                        String n1=primNum.getText();
                        String n2=segNum.getText();
                        int x=Integer.parseInt(n1);
                        int y=Integer.parseInt(n2);
                        func.mult1(x, y);
                        tipoMensaje = JOptionPane.INFORMATION_MESSAGE;
                        mensaje = "El resultado es: "+mult;
                    }
                if (command.equals("Dividir")) {
                        String n1=primNum.getText();
                        String n2=segNum.getText();
                        float x=Float.parseFloat(n1);
                        float y=Float.parseFloat(n2);
                        func.divi1(x, y);
                        tipoMensaje = JOptionPane.INFORMATION_MESSAGE;
                        mensaje = "El resultado es: "+divi;
                    }
                JOptionPane.showMessageDialog(null, mensaje,"Resultado",tipoMensaje);
            }
        }
    }
  
    public static void main(String[] args) {
        Calcsimple form= new Calcsimple();
        form.setBounds(400, 250, 1024, 450);
        form.setVisible(true);
    }

    
}
