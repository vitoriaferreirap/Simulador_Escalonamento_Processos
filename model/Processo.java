package model;

public class Processo {
    // Representa cada processo, que será gerênciado pelo escalonador
    private int id;
    private int tempoExecucaoTotal; // tempo total que o processo PRECISA na CPU
    private int tempoExecutado; // quanto tempo o processo GASTOU rodando
    private EstadoProcesso estadoAtual;

    public Processo(int id, int tempoExecucaoTotal, EstadoProcesso estadoAtual) {
        this.id = id;
        this.tempoExecucaoTotal = tempoExecucaoTotal;
        this.tempoExecutado = 0; // todo processo comça sem tempo gasto
        this.estadoAtual = EstadoProcesso.NOVO; // todo processo inicia no estado padrao de NOVO
    }

    // metodo para simular a execução do processo por um determinado tempo - quantum

    // getters e setters
    public int getId() {
        return id;
    }

    public int getTempoExecucaoTotal() {
        return tempoExecucaoTotal;
    }

    public int getTempoExecutado() {
        return tempoExecutado;
    }

    public EstadoProcesso getEstadoAtual() {
        return estadoAtual;
    }

    // univo set
    public void setEstadoAtual(EstadoProcesso estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    // metodo de exibição de resultados

}
