package entidades;

public abstract class _EntidadeBase {
    // _ convenção para classe abstrata
    // o que caracteriza o sistema
    // normalmente coloca-se data de criacao, data de atualizacao e um boolean para deletado
    private int id;

    public _EntidadeBase() {
    }

    public _EntidadeBase(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "_EntidadeBase{" +
                "id=" + id +
                '}';
    }
}
