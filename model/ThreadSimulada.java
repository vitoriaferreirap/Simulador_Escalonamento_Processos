package model;

/**
 * * A classe ThreadSimulada atua como motor de execução do Processo. Ela
 * encapsula um objeto Processo e estende a classe Thread nativa do java, que
 * permite que o escalonador gerencia seu ciclo de vida (inicio, pausa, termino)
 * dentro da JVM
 */

public class ThreadSimulada extends Thread {
    // Referência direta ao objeto Processo que esta thread representa
    // Serve como ponte, entre os dados do processo e a execução do SO
    private Processo processo;

    /**
     * Atributos de controle de escalonador: Esses valores permitem que o
     * escalonador tome decisães de priorização e organização mas filas (Ready/Wait)
     */
    private int tempoChegada;
    private int prioridade;

    public ThreadSimulada(Processo processo) {
        this.processo = processo;
        // inicializa
        this.prioridade = processo.getPrioridade();
        this.tempoChegada = processo.getTempoChegada();
    }

    // Método para executar logica de processamento - forma de consumir a CPU
    @Override
    public void run() {
        try {
            // Define o estado do processo como EXECUTANDO
            processo.setEstadoAtual(EstadoProcesso.EXECUTANDO);

            System.out.println("Processo " + processo.getId() + " começou a executar.");

            // Simula o consumo de CPU: (tempo de processamento)
            long tempoBurst = processo.getTempoExecucaoTotal() * 1000L;
            Thread.sleep(tempoBurst);

            // Ao finalizar, marca como CONCLUIDO
            processo.setEstadoAtual(EstadoProcesso.CONCLUIDO);
            System.out.println("Processo " + processo.getId() + " finalizado.");

        } catch (InterruptedException e) {
            // Caso o escalonador precise pausar ou interromper a thread
            processo.setEstadoAtual(EstadoProcesso.PRONTO);
            System.out.println("Processo " + processo.getId() + " foi interrompido.");
        }
    }

    // Getters e Setters
    public Processo getProcesso() {
        return processo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }
}