package Entidades;

public abstract class _EntidadeBase {
    private String id;
    private boolean excluido;
    private boolean publicando;

    public _EntidadeBase(String id, boolean excluido, boolean publicando) {
        this.id = id;
        this.excluido = excluido;
        this.publicando = publicando;
    }

    public _EntidadeBase(String id) {
        this.id = id;
    }

    public _EntidadeBase() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public boolean isPublicando() {
        return publicando;
    }

    public void setPublicando(boolean publicando) {
        this.publicando = publicando;
    }

    @Override
    public String toString() {
        return "_EntidadeBase{" +
                "id='" + id + '\'' +
                ", excluido=" + excluido +
                ", publicando=" + publicando +
                '}';
    }
}
