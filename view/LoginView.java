package LotofacilProject.view;

/**
 * Classe que representa a tela de login do sistema.
 * 
 * @version 1.0
 */

import javax.swing.*;

public class LoginView {
        
        private JFrame frame;
        private JPanel panel;
        private JLabel label;
        private JTextField textField;
        private JButton button;
        
        public LoginView() {
            frame = new JFrame("Login");
            panel = new JPanel();
            label = new JLabel("Digite seu nome:");
            textField = new JTextField(20);
            button = new JButton("Entrar");
            
            panel.add(label);
            panel.add(textField);
            panel.add(button);
            
            frame.add(panel);
            frame.setSize(300, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        
        public static void main(String[] args) {
            new LoginView();
        }
        
        public JFrame getFrame() {
            return frame;
        }
        
        public void setFrame(JFrame frame) {
            this.frame = frame;
        }
        
        public JPanel getPanel() {
            return panel;
        }
        
        public void setPanel(JPanel panel) {
            this.panel = panel;
        }
        
        public JLabel getLabel() {
            return label;
        }
        
        public void setLabel(JLabel label) {
            this.label = label;
        }
        
        public JTextField getTextField() {
            return textField;
        }
        
        public void setTextField(JTextField textField) {
            this.textField = textField;
        }
        
        public JButton getButton() {
            return button;
        }
        
        public void setButton(JButton button) {
            this.button = button;
        }

        public void setVisible(boolean b) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
        }
    
}
