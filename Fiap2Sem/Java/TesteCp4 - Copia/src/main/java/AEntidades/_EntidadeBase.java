package AEntidades;


public abstract class _EntidadeBase {
    private String id;

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



    @Override
    public String toString() {
        return "_EntidadeBase{" +
                "id='" + id + '\'' +
                '}';
    }
}
