public class Avaliacao {
    private String usuario;
    private int nota;
    private String comentario;

    public Avaliacao() {
    }

    public Avaliacao(String usuario, int nota, String comentario) {
        this.usuario = usuario;
        if(nota < 0 || nota > 5)
            throw new IllegalArgumentException("Nota deve entre 0 e 5 estrelas");
        else
            this.nota = nota;
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setNota(int nota) {
        if(nota < 0 || nota > 5)
            throw new IllegalArgumentException("Nota deve entre 0 e 5 estrelas");
        this.nota = nota;
    }

    public String getComentarios() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "Usuario:'" + usuario + '\'' +
                ", Nota: " + nota +
                ", Comentario:'" + comentario + '\'' +
                '}';
    }
}




