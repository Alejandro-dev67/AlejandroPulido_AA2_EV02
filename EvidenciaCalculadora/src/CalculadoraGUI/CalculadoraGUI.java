/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculadoraGUI;

/**
 *
 * @author gabri
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraGUI extends JFrame {

    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JLabel lblResultado;
    private JButton btnSuma, btnResta, btnMultiplicacion, btnDivision, btnBorrar;

    public CalculadoraGUI() {
        initComponents();
    }

    private void initComponents() {
        // Configuración de ventana
        setTitle("Calculadora Evidencia ");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        // Campos de texto
        txtNumero1 = new JTextField();
        txtNumero2 = new JTextField();
        txtNumero1.setBounds(50, 30, 130, 30);
        txtNumero2.setBounds(220, 30, 130, 30);
        txtNumero1.setBackground(new Color(0, 85, 0));
        txtNumero2.setBackground(new Color(0, 85, 0));
        txtNumero1.setForeground(Color.WHITE);
        txtNumero2.setForeground(Color.WHITE);
        add(txtNumero1);
        add(txtNumero2);

        // Botones
        btnSuma = new JButton("+");
        btnResta = new JButton("-");
        btnMultiplicacion = new JButton("*");
        btnDivision = new JButton("/");
        btnBorrar = new JButton("Borrar");

        JButton[] botones = {btnSuma, btnResta, btnMultiplicacion, btnDivision, btnBorrar};
        int x = 30;

        for (JButton btn : botones) {
            btn.setBackground(new Color(0, 128, 0));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBounds(x, 80, 70, 30);
            add(btn);
            x += 75;
        }

        // Resultado
        lblResultado = new JLabel("Resultado:");
        lblResultado.setForeground(new Color(0, 255, 0));
        lblResultado.setBounds(50, 130, 300, 30);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblResultado);

        // Eventos
        btnSuma.addActionListener(e -> calcular("+"));
        btnResta.addActionListener(e -> calcular("-"));
        btnMultiplicacion.addActionListener(e -> calcular("*"));
        btnDivision.addActionListener(e -> calcular("/"));
        btnBorrar.addActionListener(e -> borrar());
    }

    private void calcular(String operacion) {
        try {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            double resultado = 0;

            switch (operacion) {
                case "+": resultado = num1 + num2; break;
                case "-": resultado = num1 - num2; break;
                case "*": resultado = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        lblResultado.setText("Error: División por cero");
                        return;
                    }
                    resultado = num1 / num2;
                    break;
            }

            lblResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            lblResultado.setText("Error: Solo números válidos");
        }
    }

    private void borrar() {
        txtNumero1.setText("");
        txtNumero2.setText("");
        lblResultado.setText("Resultado:");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraGUI().setVisible(true);
        });
    }
}
