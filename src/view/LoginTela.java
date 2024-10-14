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
        setSize(700, 400); // Tamanho maior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setLayout(new BorderLayout(10, 10)); // Espaçamento entre os componentes

        // Painel de imagem à direita
        ImageIcon originalIcon = new ImageIcon("src/lib/aaaa.png");
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Redimensiona para 200x200
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.EAST);

        // Painel de login central com GridBagLayout para organizar os componentes lado a lado
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Faça login para continuar:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(titleLabel, gbc);

        // Campo Usuário
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        loginPanel.add(new JLabel("Usuário:"), gbc);

        JTextField usernameField = new JTextField(15);
        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);

        // Campo Senha
        gbc.gridy = 2;
        gbc.gridx = 0;
        loginPanel.add(new JLabel("Senha:"), gbc);

        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        // Opções "Lembrar-me" e "Esqueceu a senha?" na mesma linha
        JCheckBox rememberMeCheckbox = new JCheckBox("Lembrar-me");
        gbc.gridy = 3;
        gbc.gridx = 0;
        loginPanel.add(rememberMeCheckbox, gbc);

        JButton forgotPasswordButton = new JButton("Esqueceu a senha?");
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setForeground(Color.RED);
        gbc.gridx = 1;
        loginPanel.add(forgotPasswordButton, gbc);

        // Painel para os botões de login e cadastro na mesma linha
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Cadastrar");
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        loginPanel.add(buttonPanel, gbc);

        // Botões adicionais
        gbc.gridy = 5;
        JButton entrarAdminButton = new JButton("Entrar como administrador");
        loginPanel.add(entrarAdminButton, gbc);

        JButton entraApostador = new JButton("Entrar como apostador");
        gbc.gridy = 6;
        loginPanel.add(entraApostador, gbc);

        add(loginPanel, BorderLayout.CENTER);

        // Ações dos botões
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

        forgotPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Recuperação de senha em desenvolvimento.");
            }
        });
    }
}
