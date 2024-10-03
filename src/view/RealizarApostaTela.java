package view;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.util.List;

// Removed unused import

public class RealizarApostaTela extends JFrame {

    public RealizarApostaTela() {

        List<Concurso> concursos = CadastrarConcursoTela.getConcursos();

        setTitle("Lotofácil - Apostador");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel concursoLabel = new JLabel("Concurso: ");
        JComboBox<String> concurso = new JComboBox<>();
        for (Concurso c : concursos) {
            concurso.addItem(String.valueOf(c.getConcurso()));
        }
        JButton apostar = new JButton("Apostar");
        add(apostar);
        add(concursoLabel);
        add(concurso);

        apostar.addActionListener(e -> apostar(concurso));

    }

    public void apostar(JComboBox<String> concurso) {
        String concursoString = (String) concurso.getSelectedItem();
        JFrame escolherNumerosTela = new JFrame("Escolher Números para o Concurso: " + concursoString);
        escolherNumerosTela.setSize(500, 300);
        escolherNumerosTela.setLayout(new GridLayout(6, 5));

        JCheckBox[] numeros = new JCheckBox[25];
        for (int i = 0; i < 25; i++) {
            numeros[i] = new JCheckBox(String.valueOf(i + 1));
            escolherNumerosTela.add(numeros[i]);
        }

        JButton confirmar = new JButton("Confirmar");
        escolherNumerosTela.add(confirmar);

        confirmar.addActionListener(event -> {
            StringBuilder numerosEscolhidos = new StringBuilder("Números escolhidos: ");
            for (JCheckBox numero : numeros) {
                if (numero.isSelected()) {
                    numerosEscolhidos.append(numero.getText()).append(" ");
                }
            }
            JOptionPane.showMessageDialog(escolherNumerosTela, numerosEscolhidos.toString());
            escolherNumerosTela.dispose();
            JOptionPane.showMessageDialog(escolherNumerosTela, "Aposta realizada com sucesso!");
            salvarAposta(concursoString, numerosEscolhidos.toString());
        });

        escolherNumerosTela.setVisible(true);
    }

    public void salvarAposta(String concurso, String numeros) {
        try(FileWriter apostar = new FileWriter("src\\db\\apostas.txt", true)) {
            apostar.write(concurso + " - " + numeros + "\n");
        } catch (Exception e) {
            e.printStackTrace();
    }
}

}
