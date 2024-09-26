package model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Salvar {
    private static final String CAMINHO_ARQUIVO = "src/db/contas.txt";

    public static void salvar(Usuario usuario) {
        try (FileWriter escritorArquivo = new FileWriter(CAMINHO_ARQUIVO, true);
                BufferedWriter escritorBuffer = new BufferedWriter(escritorArquivo);
                PrintWriter escritorImpressao = new PrintWriter(escritorBuffer)) {
            escritorImpressao.println(usuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Usuario> carregar() {
        List<Usuario> usuarios = new ArrayList<>();
        try (FileReader leitorArquivo = new FileReader(CAMINHO_ARQUIVO);
                BufferedReader leitorBuffer = new BufferedReader(leitorArquivo)) {
            String linha;
            while ((linha = leitorBuffer.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                String usuario = partes[1];
                String senha = partes[2];
                usuarios.add(new Usuario(nome, usuario, senha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
