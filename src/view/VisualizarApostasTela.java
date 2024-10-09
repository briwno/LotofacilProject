package view;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class VisualizarApostasTela extends JFrame{
    String apostador = JOptionPane.showInputDialog("Digite seu nome: ");
    public VisualizarApostasTela() {
        setTitle("Visualizar Apostas" + apostador);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 2));

        JLabel apostas = new JLabel("Apostas de: " + apostador);
        add(apostas);
        try (FileReader leitor = new FileReader("src/db/apostas.txt");
            BufferedReader leitorbuff = new BufferedReader(leitor)) {
            String linha;
            while ((linha = leitorbuff.readLine()) != null) {
               if (linha.startsWith(apostador)) {
                  add(new JLabel(linha));
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JButton verificarButton = new JButton("Verificar se Acertou");
        verificarButton.addActionListener(e -> {
            try (FileReader leitorConcursos = new FileReader("src/db/concursos.txt");
                BufferedReader leitorbuffConcursos = new BufferedReader(leitorConcursos)) {
                String linhaConcurso;
                while ((linhaConcurso = leitorbuffConcursos.readLine()) != null) {
                   String[] partesConcurso = linhaConcurso.split(";");
                   String numerosConcurso = partesConcurso[2];
                   System.out.println(numerosConcurso);
                   try (FileReader leitorApostas = new FileReader("src/db/apostas.txt");
                        BufferedReader leitorbuffApostas = new BufferedReader(leitorApostas)) {
                       String linhaAposta;
                       while ((linhaAposta = leitorbuffApostas.readLine()) != null) {
                           if (linhaAposta.startsWith(apostador)) {
                               String[] partesAposta = linhaAposta.split(",");
                               String numerosAposta = partesAposta[2].trim();
                               System.out.println(numerosAposta);
                               if (numerosConcurso.equals(numerosAposta)) {
                                   JOptionPane.showMessageDialog(this, "Parabéns " + apostador + ", você acertou os números!");
                                   return;
                               }
                           }
                       }
                   }
                }
                JOptionPane.showMessageDialog(this, "Que pena " + apostador + ", você não acertou os números. Tente novamente!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(verificarButton);


    }

}
