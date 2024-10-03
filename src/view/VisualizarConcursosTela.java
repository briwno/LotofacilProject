package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VisualizarConcursosTela extends JFrame {

    

    public VisualizarConcursosTela() {
        setTitle("Visualizar Concursos");
        setSize(900, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        int ativo = 0;

        JButton verConcursosAtivos = new JButton("Ver Concursos Ativos(%d)".formatted(ativo));
        add(verConcursosAtivos);

        JButton verConcursosAnteriores = new JButton("Ver Concursos Anteriores");
        add(verConcursosAnteriores);

        verConcursosAtivos.addActionListener(e -> verConcursosAtivos());

        verConcursosAnteriores.addActionListener(e -> verConcursosAnteriores());

    }

    private void verConcursosAtivos()  {
        List<Concurso> concursos = CadastrarConcursoTela.getConcursos();
        if (concursos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum concurso cadastrado", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Concurso concurso = concursos.get(concursos.size()- 1 );
        JLabel concursoLabel = new JLabel("Concurso: " + concurso.getConcurso());
        JLabel dataLabel = new JLabel("Data e hora do Sorteio: " + concurso.getData());
        JLabel numerosLabel = new JLabel("Números sorteados: " + concurso.getNumerosSorteados());

        JButton encerrarButton = new JButton("Encerrar Concurso");

        JFrame detalhesConcursoFrame = new JFrame("Detalhes do Concurso Ativo");
        detalhesConcursoFrame.setSize(800, 200);
        detalhesConcursoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detalhesConcursoFrame.setLayout(new GridLayout(2, 2));
        detalhesConcursoFrame.add(concursoLabel);
        detalhesConcursoFrame.add(dataLabel);
        detalhesConcursoFrame.add(numerosLabel);
        detalhesConcursoFrame.add(encerrarButton);
        detalhesConcursoFrame.setVisible(true);


  


    
    }




    private void verConcursosAnteriores() {

    }


    

}
