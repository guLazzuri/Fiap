package AEntidades;

public class Musica extends _EntidadeBase {
    private String titulo;
    private String album;
    private int duracao;

    public Musica(String id, String titulo, String album, int duracao) {
        super(id);
        this.titulo = titulo;
        this.album = album;
        this.duracao = duracao;
    }



    public Musica(String titulo, String album, int duracao) {
        this.titulo = titulo;
        this.album = album;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "titulo='" + titulo + '\'' +
                ", album='" + album + '\'' +
                ", duracao=" + duracao +
                "} " + super.toString();
    }
}
