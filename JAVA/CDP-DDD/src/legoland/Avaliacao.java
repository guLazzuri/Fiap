package legoland;

public class Avaliacao {
    private String nomeusuario;
    private int avaliacao;
    private String comentario;

    public Avaliacao() {
    }

    public Avaliacao(String nomeusuario, int avaliacao, String comentario) {
        this.nomeusuario = nomeusuario;
        if(avaliacao < 0 || avaliacao > 10)
            throw new IllegalArgumentException("A nota de avaliação deve ser entre 0 a 10");
        else
            this.avaliacao = avaliacao;
        this.comentario = comentario;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        if(avaliacao < 0 || avaliacao > 10)
            throw new IllegalArgumentException("A nota de avaliação deve ser entre 0 a 10");
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comment) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentário{" +
                "Nome de usuário='" + nomeusuario + '\'' +
                ", Avaliação =" + avaliacao +
                ", Comentário='" + comentario + '\'' +
                '}';
    }
}

