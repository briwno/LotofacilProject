package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Usuario;

import view.LoginTela;

import model.Salvar;


public class ApostadorTela extends JFrame{

    private Usuario usuarioLogado;

    

    public ApostadorTela(String usuarioLogado) {

        setTitle("Lotofácil - Apostador");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        List<Usuario> usuarios = Salvar.carregar();
        for (Usuario usuario : usuarios) {
            if(usuario.getNome().equals(usuarioLogado)){
                add(new JLabel("Bem-vindo, " + usuario.getNome()));
            }
        }

        /*Visualizar os dados das suas apostas, tanto se houver uma aposta em um
        concurso em andamento, bem como o histórico de suas apostas; */
        JButton visualizarApostas = new JButton("Visualizar Apostas");
        add(visualizarApostas);

        JButton apostar = new JButton("Aposte nos concursos ativos");
        add(apostar);

        JButton dadosApostador = new JButton("Seus Dados");
        add(dadosApostador);


        apostar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RealizarApostaTela().setVisible(true);
            }
        });

        




    }

    
}
