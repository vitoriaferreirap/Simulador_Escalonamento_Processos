package queue;

import java.util.concurrent.LinkedBlockingQueue;

import model.ThreadSimulada;

public class FilaCompartilhada {
    // ESCOLHA DE ESTRUTURA PARA ATENDER REQUISITO DE SINCRONIZAÇÃO E EXCLUSÃO MUTUA
    // DO TRABALHO
    // LinkedBlockingQueue = permite que múltiplas threads adicionem ou removam
    // processos com segurança (thread-safe)
    private LinkedBlockingQueue<ThreadSimulada> filaProntos;

    public FilaCompartilhada() {
        this.filaProntos = new LinkedBlockingQueue<>();
    }

    // Adiciona um processo na fila de prontos
    public void adicionarProcesso(ThreadSimulada thread) {
        filaProntos.offer(thread);
    }

    // Remove e retorna o próximo processo da fila
    public ThreadSimulada removerProcesso() {
        return filaProntos.poll();
    }

    // Verifica se a fila está vazia
    public boolean estaVazia() {
        return filaProntos.isEmpty();
    }

    // Retorna o tamanho atual da fila
    public int tamanho() {
        return filaProntos.size();
    }
}