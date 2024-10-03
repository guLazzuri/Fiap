package Entidade;

public class EntidadeBase {
    private int id;

    public EntidadeBase(int id) {
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
        return "Base_Entities{" +
                "id=" + id +
                '}';
    }
}
