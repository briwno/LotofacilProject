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
        setLayout(new GridLayout(5, 3));

        add(new JLabel("Faça login para continuar:"));
        add(new JLabel());

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

        JButton entrarAdminButton = new JButton("Entrar como administrador");
        add(entrarAdminButton);

        JButton entraApostador = new JButton("Entrar como apostador");
        add(entraApostador);

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String user = new String(usernameField.getText());
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

                            String usuarioLogado = usuario.getNome();

                            JOptionPane.showMessageDialog(null, "Login de apostador bem-sucedido!");
                            dispose();
                            new ApostadorTela(usuarioLogado).setVisible(true);
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

        entrarAdminButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminTela().setVisible(true);
            }
        });

        entraApostador.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                new ApostadorTela("Apostador").setVisible(true);
            }
        });
    }

}
