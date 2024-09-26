package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminTela extends JFrame{
    public AdminTela(){
        setTitle("Lotofácil - Admin");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        //cadastrar um concurso
        JButton cadastrarConcurso = new JButton("Cadastrar Concurso");
        add(cadastrarConcurso);

        //Visualizar os dados dos concursos realizados, tanto se houver um concurso em andamento, bem como o histórico dos concursos realizados;
        JButton visualizarConcursos = new JButton("Visualizar Concursos");
        add(visualizarConcursos);

        cadastrarConcurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CadastrarConcursoTela().setVisible(true);
            }
        });

        visualizarConcursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VisualizarConcursosTela().setVisible(true);
            }
        });


    }


    
}
