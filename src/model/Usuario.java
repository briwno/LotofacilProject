package model;

public class Usuario {
    private String user;
    private String senha;

    public Usuario(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }

    public String toString() {
        return user + "," + senha;
    }
    
}
