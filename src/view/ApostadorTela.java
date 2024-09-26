package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ApostadorTela  extends JFrame{
    public ApostadorTela(){
        setTitle("Lotofácil - Apostador");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        //Realizar apostas
        JButton realizarAposta = new JButton("Realizar Aposta");
        add(realizarAposta);

        /*Visualizar os dados das suas apostas, tanto se houver uma aposta em um
        concurso em andamento, bem como o histórico de suas apostas; */
        JButton visualizarApostas = new JButton("Visualizar Apostas");
        add(visualizarApostas);

        /*Visualizar o resultado dos concursos realizados a fim de saber os números
        sorteados, a quantidade de ganhadores e o valor dos prêmios pagos aos
        ganhadores; */
        JButton visualizarResultado = new JButton("Visualizar Resultado");
        add(visualizarResultado);

        

        realizarAposta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RealizarApostaTela().setVisible(true);
            }
        });

        




    }

    
}
