package view;

import model.Usuario;
import model.Salvar;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginTela extends JFrame {
    public LoginTela() {
        setTitle("Lotofácil - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel imagem = new JLabel();
        imagem.setIcon(new ImageIcon("src/lib/lotofacil.jpg"));
        imagem.setHorizontalAlignment(SwingConstants.CENTER);
        add(imagem);

        add(new JLabel("Faça login para continuar:"));

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
                    dispose();
                    new AdminTela().setVisible(true);
                    
                } else {
                    List<Usuario> usuarios = Salvar.carregar();
                    boolean achou = false;
                    for (Usuario usuario : usuarios) {
                        if (usuario.getUser().equals(user) && usuario.getSenha().equals(senha)) {
                            achou = true;
                            JOptionPane.showMessageDialog(null, "Login de apostador bem-sucedido!");
                            dispose();
                            new ApostadorTela().setVisible(true);
                            break;
                        }
                    }
                    if (!achou) {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
                    }
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
  