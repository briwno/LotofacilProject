package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import view.CadastrarConcursoTela;

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

        Concurso concurso = concursos.get(concursos.size() - 1);
        JLabel concursoLabel = new JLabel("Concurso: " + concurso.getConcurso());
        JLabel dataLabel = new JLabel("Data: " + concurso.getData());
        JLabel numerosLabel = new JLabel("Números sorteados: " + getNumerosSorteados());
        JButton gerarNumerosButton = new JButton("Gerar Números");



        JFrame detalhesConcursoFrame = new JFrame("Detalhes do Concurso Ativo");
        detalhesConcursoFrame.setSize(800, 200);
        detalhesConcursoFrame.setLayout(new GridLayout(2, 1));
        detalhesConcursoFrame.add(concursoLabel);
        detalhesConcursoFrame.add(dataLabel);
        detalhesConcursoFrame.add(gerarNumerosButton);
        detalhesConcursoFrame.add(numerosLabel);
        detalhesConcursoFrame.setVisible(true);


        gerarNumerosButton.addActionListener(e -> {
            String novosNumeros = getNumerosSorteados();
            numerosLabel.setText("Números sorteados: " + novosNumeros);
        });
        

        

        
    }

    private String getNumerosSorteados() {
        
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

        return numerosSorteados.toString();
    }


    private void verConcursosAnteriores() {
    }


    

}
