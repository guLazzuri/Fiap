package Entidade;

public class Feedback extends EntidadeBase {
    private int idUsuario;
    private int idAgendamento;
    private int nota;
    private String comentarios;

    public Feedback(int id, int idUsuario, int idAgendamento, int nota, String comentarios) {
        super(id);
        this.idUsuario = idUsuario;
        this.idAgendamento = idAgendamento;
        this.nota = nota;
        this.comentarios = comentarios;
    }

    // Getters and Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
