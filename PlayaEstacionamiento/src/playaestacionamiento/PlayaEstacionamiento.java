package playaestacionamiento;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class PlayaEstacionamiento {

    public static void main(String[] args) {
        // TODO code application logic here
        Login a = new Login("", "");
    }

    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;

    public PlayaEstacionamiento(String user, String pass) {
        //Objetos
        frame = new JFrame("Playa Estacionamiento (Av.Colon 3030)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.orange);

        JCheckBox checkbox = new JCheckBox("Poner texto abajo");
        checkbox.setBounds(20, 275, 170, 30);
        checkbox.setBackground(Color.orange);
        checkbox.setSelected(true);
        checkbox.setMnemonic('P');

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(20, 30, 360, 245);
        scroll.setBorder(BorderFactory.createLineBorder(Color.blue));

        textField = new JTextField();
        textField.setBounds(20, 310, 360, 30);
        textField.setVisible(false);

        JButton letras = new JButton("Ingrese Datos");
        letras.setBounds(20, 310, 360, 30);
        letras.setBackground(Color.white);
        letras.setBorder(BorderFactory.createLineBorder(Color.cyan));
        letras.setHorizontalAlignment(JTextField.LEFT);
        letras.setMnemonic('I');

        JButton borrar = new JButton("Borrar");
        borrar.setBounds(210, 350, 80, 30);
        borrar.setBackground(Color.red);
        borrar.setMnemonic('b');

        JButton enviar = new JButton("Ingresar");
        enviar.setBounds(300, 350, 80, 30);
        enviar.setBackground(Color.green);
        enviar.setMnemonic('e');

        JButton salir = new JButton("Salir");
        salir.setBounds(20, 350, 150, 30);
        salir.setMnemonic('S');

        JLabel perfil = new JLabel("Bienvenido " + user + "!");
        perfil.setBounds(20, 5, 380, 20);

        
        //Acciones
        salir.addActionListener((ActionEvent e) -> {
            frame.dispose();
            Login a = new Login(user, pass);
        });

        enviar.addActionListener((ActionEvent e) -> {
            if (checkbox.isSelected()) {
                pasarTextoAbajo();
            } else {
                pasarTextoArriba();
            }

        });

        borrar.addActionListener((ActionEvent e) -> {
            if ("".equals(textField.getText())) {
                int rta = JOptionPane.showConfirmDialog(null, "Desea borrar todo el texto de area?", "Borrar texto", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (rta == JOptionPane.YES_OPTION) {
                    textArea.setText("");
                }

            } else {
                textField.setText("");
            }
            textField.requestFocus();

        });

        letras.addActionListener((ActionEvent e) -> {
            letras.setVisible(false);
            textField.setVisible(true);
            textField.requestFocus();
        });

        textField.addActionListener((ActionEvent e) -> {
            if (checkbox.isSelected()) {
                pasarTextoAbajo();
            } else {
                pasarTextoArriba();
            }
        });

        checkbox.addActionListener((ActionEvent e) -> {
            textField.requestFocus();
        });

        frame.add(perfil);
        frame.add(salir);
        frame.add(checkbox);
        frame.add(scroll);
        frame.add(letras);
        frame.add(borrar);
        frame.add(enviar);
        frame.add(textField);
        frame.setVisible(true);
    }

    public void pasarTextoAbajo() {
        textArea.setText(textArea.getText() + textField.getText() + "\n");
        textField.setText("");
        textField.requestFocus();
    }

    public void pasarTextoArriba() {
        textArea.setText(textField.getText() + "\n" + textArea.getText());
        textField.setText("");
        textField.requestFocus();
    }
}