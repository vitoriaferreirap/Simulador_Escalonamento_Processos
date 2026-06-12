package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

import model.ThreadSimulada;

public class FilaCompartilhada {
    // ESCOLHA DE ESTRUTURA PARA ATENDER REQUISITO DE SINCRONIZAÇÃO E EXCLUSÃO MUTUA
    // DO TRABALHO
    // LinkedBlockingQueue = permite que múltiplas threads adicionem ou removam
    // processos com segurança (thread-safe)
    private LinkedBlockingQueue<ThreadSimulada> filaProntos;

    // AQUI ESTÁ O REQUISITO: Fila de Espera
    private LinkedBlockingQueue<ThreadSimulada> filaEspera;

    // AQUI ESTÁ O REQUISITO: Lista de processos finalizados
    private List<ThreadSimulada> listaFinalizados;

    // AQUI ESTÁ O REQUISITO: Semáforo para exclusão mútua
    private Semaphore mutex = new Semaphore(1);

    public FilaCompartilhada() {
        this.filaProntos = new LinkedBlockingQueue<>();
        this.filaEspera = new LinkedBlockingQueue<>();
        this.listaFinalizados = new ArrayList<>();
    }

    // Adiciona um processo na fila de prontos
    public void adicionarProcesso(ThreadSimulada thread) {
        filaProntos.offer(thread);
    }

    // Remove e retorna o próximo processo da fila
    public ThreadSimulada removerProcesso() {
        return filaProntos.poll();
    }

    // AQUI ESTÁ O REQUISITO: Métodos para Fila de Espera
    public void adicionarEmEspera(ThreadSimulada thread) {
        filaEspera.offer(thread);
    }

    public ThreadSimulada removerDaEspera() {
        return filaEspera.poll();
    }

    // AQUI ESTÁ O REQUISITO: Método para Lista de Finalizados com Mutex
    public void adicionarFinalizado(ThreadSimulada thread) {
        try {
            mutex.acquire(); // Bloqueia acesso (Exclusão Mútua)
            listaFinalizados.add(thread);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            mutex.release(); // Libera acesso
        }
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