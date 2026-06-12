package model;

// apenas estrutura que guarda dados
public class Processo {
    // Representa cada processo, que será gerênciado pelo escalonador
    private int id;
    private int tempoExecucaoTotal; // tempo total que o processo PRECISA na CPU
    private int tempoExecutado; // quanto tempo o processo GASTOU rodando
    private EstadoProcesso estadoAtual;
    private int tempoChegada;
    private int prioridade;

    public Processo(int id, int tempoExecucaoTotal, int tempoChegada, int prioridade) {
        this.id = id;
        this.tempoExecucaoTotal = tempoExecucaoTotal;
        this.tempoChegada = tempoChegada;
        this.prioridade = prioridade;
        this.tempoExecutado = 0; // todo processo comça sem tempo gasto
        this.estadoAtual = EstadoProcesso.NOVO; // todo processo inicia no estado padrao de NOVO
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public int getTempoExecucaoTotal() {
        return tempoExecucaoTotal;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getTempoExecutado() {
        return tempoExecutado;
    }

    // Adicionado para o escalonador poder incrementar o tempo executado
    public void setTempoExecutado(int tempoExecutado) {
        this.tempoExecutado = tempoExecutado;
    }

    public EstadoProcesso getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(EstadoProcesso estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    // metodo de exibição de resultados
    @Override
    public String toString() {
        return "Processo [ID=" + id + ", Estado=" + estadoAtual + "]";
    }
}