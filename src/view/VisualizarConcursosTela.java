package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import view.CadastrarConcursoTela;

public class VisualizarConcursosTela extends JFrame {
    public VisualizarConcursosTela() {
        setTitle("Visualizar Concursos");
        setSize(400, 300);
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

        Concurso ultimoConcurso = concursos.get(concursos.size() - 1);
        JLabel concursoLabel = new JLabel("Concurso: " + ultimoConcurso.getConcurso());
        JLabel dataLabel = new JLabel("Data e hora do Sorteio: " + ultimoConcurso.getData());

        add(concursoLabel);
        add(dataLabel);

        revalidate();
        repaint();
    }

    private void verConcursosAnteriores() {
    }

    private void gerarNumeros() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            numeros.add(i);
        }

        List<Integer> numerosSorteados = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int index = (int) (Math.random() * numeros.size());
            numerosSorteados.add(numeros.get(index));
            numeros.remove(index);
        }

        JOptionPane.showMessageDialog(this, "Números sorteados: " + numerosSorteados);
    }

}
