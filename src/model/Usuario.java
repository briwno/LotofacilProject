package model;

public class Usuario {
    private String nome;
    private String user;
    private String senha;

    public Usuario(String nome, String user, String senha) {
        this.nome = nome;
        this.user = user;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }

    public String toString() {
        return nome + "," + user + "," + senha;
    }
    
}
