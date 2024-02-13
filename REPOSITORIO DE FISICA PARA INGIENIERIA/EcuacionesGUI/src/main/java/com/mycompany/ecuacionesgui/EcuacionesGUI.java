/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ecuacionesgui;

/**
 *
 * @author pamee
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.commons.net.
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

public class EcuacionesGUI extends JFrame {

    private JTextField ecuacionTextField;
    private JButton identificarGradoButton;
    private JButton resolverEDOButton;

    public EcuacionesGUI() {
        // Configuración del JFrame
        setTitle("Identificación y Resolución de Ecuaciones");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Componentes de la interfaz
        ecuacionTextField = new JTextField(20);
        identificarGradoButton = new JButton("Identificar Grado");
        resolverEDOButton = new JButton("Resolver EDO");

        // Configuración del contenedor
        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese la ecuación: "));
        panel.add(ecuacionTextField);
        panel.add(identificarGradoButton);
        panel.add(resolverEDOButton);

        // Manejadores de eventos
        identificarGradoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                identificarGrado();
            }
        });

        resolverEDOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resolverEDO();
            }
        });

        // Agregar el panel al JFrame
        add(panel);
    }

    private void identificarGrado() {
        String ecuacion = ecuacionTextField.getText();
        // Implementar lógica para identificar el grado de la ecuación aquí
        // Puedes utilizar expresiones regulares o métodos de análisis sintáctico

        // Ejemplo: Mostrar un cuadro de mensaje con el grado identificado
        JOptionPane.showMessageDialog(this, "Grado identificado: X");
    }

    private void resolverEDO() {
        String ecuacion = ecuacionTextField.getText();
        // Implementar lógica para resolver la EDO aquí
        // Puedes utilizar Apache Commons Math o cualquier otra biblioteca

        // Ejemplo: Resolver una EDO simple
        FirstOrderDifferentialEquations ode = new MyODE();
        FirstOrderIntegrator integrator = new EulerIntegrator(0.1);
        double[] y = new double[] { 1.0 };
        integrator.integrate(ode, 0.0, y, 10.0, y);
        JOptionPane.showMessageDialog(this, "Resultado EDO: " + y[0]);
    }

    // Ejemplo de una EDO simple para demostración
    private static class MyODE implements FirstOrderDifferentialEquations {
        @Override
        public int getDimension() {
            return 1;
        }

        @Override
        public void computeDerivatives(double t, double[] y, double[] yDot) {
            yDot[0] = -0.1 * y[0];
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EcuacionesGUI().setVisible(true);
            }
        });
    }
}

