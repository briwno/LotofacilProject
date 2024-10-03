package view;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CadastrarConcursoTela extends JFrame {
    private JTextField concursoField;
    private JTextField dataField;
    private JTextField numerosField;
    private JButton cadastrarButton;
    private static List<Concurso> concursos = new ArrayList<>();

    public CadastrarConcursoTela() {
        setTitle("Cadastrar Concurso");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel concursoLabel = new JLabel("Concurso:");
        concursoField = new JTextField();
        JLabel dataLabel = new JLabel("Data e hora do Sorteio:");
        dataField = new JTextField();
        JLabel numerosLabel = new JLabel("Números sorteados:");
        numerosField = new JTextField();
        JButton gerarButton = new JButton("Gerar Números");
        gerarButton.addActionListener(e -> {
            List<Integer> numeroGerados = new ArrayList<>();
            while (numeroGerados.size() < 15) {
                int numero = (int) (Math.random() * 25) + 1;
                if (!numeroGerados.contains(numero)) {
                    numeroGerados.add(numero);
                }
            }
            StringBuilder numeros = new StringBuilder();
            for (int numero : numeroGerados) {
                numeros.append(numero).append(" ");
            }
            numerosField.setText(numeros.toString());
        });

        cadastrarButton = new JButton("Cadastrar");

        add(concursoLabel);
        add(concursoField);
        add(dataLabel);
        add(dataField);
        add(numerosLabel);
        add(numerosField);
        add(gerarButton);
        add(cadastrarButton);

        cadastrarButton.addActionListener(e -> cadastrarConcurso());

        setVisible(true);
    }

    private void cadastrarConcurso() {
        String concurso = concursoField.getText();
        String data = dataField.getText();
        String numeros = numerosField.getText();

        if (concurso.isBlank() || data.isBlank()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        concursos.add(new Concurso(concurso, data, numeros));
        JOptionPane.showMessageDialog(this, "Concurso cadastrado com sucesso", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        concursoField.setText("");
        dataField.setText("");
        numerosField.setText("");
        salvarConcursos();

        dispose();
        new AdminTela().setVisible(true);
    }

    private void salvarConcursos() {
        // Salvar concursos em arquivo
        try (FileWriter salvar = new FileWriter("src\\db\\concursos.txt")) {
            for (Concurso concurso : concursos) {
                salvar.write(concurso.getConcurso() + ";" + concurso.getData() + ";" + concurso.getNumerosSorteados()
                        + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Concurso> getConcursos() {
        List<Concurso> concursos = new ArrayList<>();
        try (FileReader leitor = new FileReader("src\\db\\concursos.txt");
                BufferedReader leitorbuff = new BufferedReader(leitor)) {
            String linha;
            while ((linha = leitorbuff.readLine()) != null) {
                String[] partes = linha.split(";");
                String concurso = partes[0];
                String data = partes[1];
                String numeros = partes[2];
                concursos.add(new Concurso(concurso, data, numeros));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return concursos;
    }
}

class Concurso {
    private String concurso;
    private String data;
    private String numerosSorteados;

    public Concurso(String concurso, String data, String numerosSorteados) {
        this.concurso = concurso;
        this.data = data;
        this.numerosSorteados = numerosSorteados;

    }

    public String getConcurso() {
        return concurso;
    }

    public String getData() {
        return data;
    }

    public String getNumerosSorteados() {
        return numerosSorteados;
    }
}
