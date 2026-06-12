package sheduler;

import model.ThreadSimulada;

public class NucleoCPU {
    // AQUI ESTÁ O REQUISITO: O sistema possui múltiplos núcleos de CPU simulados
    // para representar a arquitetura multicore conforme a Descrição do Problema.
    private int id;
    private boolean estaLivre;

    public NucleoCPU(int id) {
        this.id = id;
        this.estaLivre = true;
    }

    // Executa uma thread simulada no núcleo
    // AQUI ESTÁ O REQUISITO: O núcleo atua como a unidade de execução
    // física (simulada) que recebe a thread delegada pelo escalonador.
    public void executar(ThreadSimulada thread) {
        this.estaLivre = false;
        System.out.println("Núcleo " + id + " executando processo " + thread.getProcesso().getId());
        thread.start();
    }

    // Verifica se o núcleo está disponível
    public boolean isEstaLivre() {
        return estaLivre;
    }

    // Define o estado do núcleo
    public void setEstaLivre(boolean estaLivre) {
        this.estaLivre = estaLivre;
    }

    // Retorna o ID do núcleo
    public int getId() {
        return id;
    }
}