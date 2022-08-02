package com.mycompany.calcsimple;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Calcsimple extends JFrame implements ItemListener{
    private JLabel titulo, instruccion, instruccion2, primerNumero, segNumero;
    private JTextField primNum, segNum;
    private JRadioButton suma,resta,multi,div;
    private ButtonGroup bg;
    int sum,rest,mult,divi;

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
        //suma.addChangeListener(this);
        resta=new JRadioButton("Restar");
        resta.setBounds(550, 200, 200, 30);
        resta.setFont(new Font("Sans",Font.PLAIN,20));
        //resta.addChangeListener(this);
        add(resta);
        bg.add(resta);
        multi=new JRadioButton("Multiplicar");
        multi.setBounds(550, 225, 200, 30);
        multi.setFont(new Font("Sans",Font.PLAIN,20));
        //multi.addChangeListener(this);
        add(multi);
        bg.add(multi);
        div=new JRadioButton("Dividir");
        div.setBounds(550, 250, 200, 30);
        div.setFont(new Font("Sans",Font.PLAIN,20));
        //div.addChangeListener(this);
        add(div);
        bg.add(div);
     
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        public void divi1(int num1, int num2) {
            int divi1 = num1 / num2;
            divi=divi1;
        }
    }
    
    
    class funcItemListener implements ItemListener{

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
                JOptionPane.showMessageDialog(null, mensaje,"Resultado",tipoMensaje);
            }
        }
    }
    /*public void stateChanged(ChangeEvent e) {
        
        
        if (suma.isSelected()) {
            String n1=primNum.getText();
            String n2=segNum.getText();
            int x=Integer.parseInt(n1);
            int y=Integer.parseInt(n2);
            func.sum1(x, y);
            System.out.println("Resultado imprimido");
            bg.clearSelection();
            JOptionPane.showMessageDialog(null, "El resultado es: "+sum);
        }
        if (resta.isSelected()) {
            String n1=primNum.getText();
            String n2=segNum.getText();
            int x=Integer.parseInt(n1);
            int y=Integer.parseInt(n2);
            func.rest1(x, y);
            tipoMensaje= JOptionPane.INFORMATION_MESSAGE;
            /*bg.clearSelection();
            JOptionPane.showMessageDialog(null, "El resultado es: "+rest);
            
        }
        if (multi.isSelected()) {
            String n1=primNum.getText();
            String n2=segNum.getText();
            int x=Integer.parseInt(n1);
            int y=Integer.parseInt(n2);
            func.mult1(x, y);
            JOptionPane.showMessageDialog(null, "El resultado es: "+mult);
            bg.clearSelection();
        }
        if (div.isSelected()) {
            String n1=primNum.getText();
            String n2=segNum.getText();
            int x=Integer.parseInt(n1);
            int y=Integer.parseInt(n2);
            func.divi1(x, y);
            JOptionPane.showMessageDialog(null, "El resultado es: "+divi);
            bg.clearSelection();
        }
    }*/
    public static void main(String[] args) {
        Calcsimple form= new Calcsimple();
        form.setBounds(171, 134, 1024, 800);
        form.setVisible(true);
    }

    
}
