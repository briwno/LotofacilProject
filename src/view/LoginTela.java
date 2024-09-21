package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginTela extends JFrame {
    public LoginTela() {
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
                String user = usernameField.getText();
                String senha = new String(passwordField.getPassword());
                
                if (user.equals("admin") && senha.equals("admin")) {
                    
                    JOptionPane.showMessageDialog(null, "Login de administrador bem-sucedido!");
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Login de usuário bem-sucedido!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                new RegistrarTela().setVisible(true);
            }
        });
    }
}