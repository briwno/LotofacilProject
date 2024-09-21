package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    public LoginScreen() {
        setTitle("Lotofácil - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Usuário:"));
        JTextField usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Senha:"));
        JPasswordField passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Login");
        add(loginButton);

        JButton registerButton = new JButton("Cadastrar");
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Aqui você deve verificar o login no banco de dados
                if (username.equals("admin") && password.equals("admin")) {
                    // Abrir tela de administrador
                    JOptionPane.showMessageDialog(null, "Login de administrador bem-sucedido!");
                } else {
                    // Abrir tela de usuário
                    JOptionPane.showMessageDialog(null, "Login de usuário bem-sucedido!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // Abrir tela de cadastro
                JOptionPane.showMessageDialog(null, "Abrir tela de cadastro!");
            }
        });
    }
}