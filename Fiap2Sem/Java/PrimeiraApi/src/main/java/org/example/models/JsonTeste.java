package org.example.models;

public class JsonTeste {
    private int id;
    private String description;

    public JsonTeste() {
    }

    public JsonTeste(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JsonTeste{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
