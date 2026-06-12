import model.Processo;
import model.ThreadSimulada;
import queue.FilaCompartilhada;
import sheduler.Escalonador;

public class Main {
    public static void main(String[] args) {
        // Inicializa a fila compartilhada
        FilaCompartilhada fila = new FilaCompartilhada();

        // Cria processos para teste
        Processo p1 = new Processo(1, 10, 0, 1);
        Processo p2 = new Processo(2, 3, 0, 2);
        Processo p3 = new Processo(3, 8, 0, 1);

        // Encapsula os processos em ThreadsSimuladas e coloca na fila
        fila.adicionarProcesso(new ThreadSimulada(p1));
        fila.adicionarProcesso(new ThreadSimulada(p2));
        fila.adicionarProcesso(new ThreadSimulada(p3));

        // Instancia o escalonador com a fila e um quantum
        Escalonador escalonador = new Escalonador(fila, 2000, "ROUND_ROBIN", 2);

        System.out.println("Iniciando simulação de escalonamento...");

        // Inicia o processo de escalonamento
        escalonador.iniciarEscalonamento();

        System.out.println("Simulação finalizada.");
    }
}