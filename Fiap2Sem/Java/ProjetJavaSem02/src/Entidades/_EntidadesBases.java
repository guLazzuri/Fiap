package Entidades;

public abstract class _EntidadesBases {
    private int id;

    public _EntidadesBases(int id) {
        this.id = id;
    }

    public _EntidadesBases() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "_EntidadesBases{" +
                "id=" + id +
                '}';
    }
}
