package Entidades;

public class Usuario extends _EntidadesBases{
    private String nome;
    private String emai;

    public Usuario() {
    }

    public Usuario(int id, String nome, String emai) {
        super(id);
        this.nome = nome;
        this.emai = emai;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", emai='" + emai + '\'' +
                "} " + super.toString();
    }
}
