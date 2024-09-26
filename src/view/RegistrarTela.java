package view;

import model.Usuario;
import model.Salvar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarTela extends JFrame {
    public RegistrarTela() {
        setTitle("Lotofácil - Cadastro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Como Deseja ser chamado?"));
        JTextField nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Usuário:"));
        JTextField usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Senha:"));
        JPasswordField passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Confirmar Senha:"));
        JPasswordField confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        JButton registrarButton = new JButton("Cadastrar");
        add(registrarButton);

        JButton backButton = new JButton("Voltar");
        add(backButton);

        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String user = usernameField.getText();
                String senha = new String(passwordField.getPassword());
                String confirmSenha = new String(confirmPasswordField.getPassword());

                if (!senha.equals(confirmSenha)) {
                    JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
                    return;
                }

                Usuario usuario = new Usuario(nome, user, senha);
                Salvar.salvar(usuario);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                dispose();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });
    }
}
