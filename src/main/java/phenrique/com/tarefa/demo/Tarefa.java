package phenrique.com.tarefa.demo;

import java.time.LocalDate;

public class Tarefa {

    // Enum para Status
    public enum Status {
        PENDENTE,
        EM_ANDAMENTO,
        CONCLUIDA,
        CANCELADA
    }

    // Atributos
    private long id;
    private String nome;
    private Status status;
    private String categoria;
    private LocalDate data;
    private String descricao;

    // Construtor vazio
    public Tarefa() {
    }

    // Construtor completo
    public Tarefa(long id, String nome, Status status, String categoria,
                  LocalDate data, String descricao) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.categoria = categoria;
        this.data = data;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // toString para exibir no terminal
    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                ", categoria='" + categoria + '\'' +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                '}';
    }

}