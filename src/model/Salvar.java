package model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Salvar {
    private static final String FILE_PATH = "src/db/contas.txt";

    public static void salvar(Usuario usuario) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println(usuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Usuario> carregar() {
        List<Usuario> usuarios = new ArrayList<>();
        try (FileReader fileReader = new FileReader(FILE_PATH);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String user = parts[0];
                String senha = parts[1];
                usuarios.add(new Usuario(user, senha));
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return usuarios;
    }
}
