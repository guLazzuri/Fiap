package entidades;

public  class Usuario  extends _EntidadeBase{

    private String nome;
    private String email;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email) {
        super(id);
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                "} " + super.toString();
    }
}
