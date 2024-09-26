package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CadastrarConcursoTela extends JFrame{
    private JTextField concursoField;
    private JTextField dataField;
    private JButton cadastrarButton;
    private static List<Concurso> concursos = new ArrayList<>();

    public CadastrarConcursoTela() {
        setTitle("Cadastrar Concurso");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel concursoLabel = new JLabel("Concurso:");
        concursoField = new JTextField();
        JLabel dataLabel = new JLabel("Data e hora do Sorteio:");
        dataField = new JTextField();
        cadastrarButton = new JButton("Cadastrar");

        add(concursoLabel);
        add(concursoField);
        add(dataLabel);
        add(dataField);
        add(new JLabel()); // empty cell
        add(cadastrarButton);


        cadastrarButton.addActionListener(e -> cadastrarConcurso());

        setVisible(true);
    }

    private void cadastrarConcurso() {
        String concurso = concursoField.getText();
        String data = dataField.getText();

        if (concurso.isBlank() || data.isBlank()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        concursos.add(new Concurso(concurso, data));
        JOptionPane.showMessageDialog(this, "Concurso cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        concursoField.setText("");
        dataField.setText("");

        dispose();
        new AdminTela().setVisible(true);
    }

    public static List<Concurso> getConcursos() {
        return concursos;
    }
}

class Concurso {
    private String concurso;
    private String data;

    public Concurso(String concurso, String data) {
        this.concurso = concurso;
        this.data = data;
    }

    public String getConcurso() {
        return concurso;
    }

    public String getData() {
        return data;
    }
    


}
