# Simulador de Escalonamento de Processos

Este projeto consiste no desenvolvimento de um simulador de escalonamento de processos utilizando conceitos de programação paralela e concorrência. O objetivo principal é modelar o comportamento de um Sistema Operacional ao gerenciar como múltiplos processos competem pelo uso da CPU.

## Objetivos do Projeto

O simulador consolida de forma prática os seguintes conceitos de Sistemas Operacionais:
* **Concorrência e Sincronização:** Gerenciamento de múltiplas linhas de execução simultâneas.
* **Exclusão Mútua:** Proteção de estruturas de dados compartilhadas para evitar condições de corrida.
* **Escalonamento de CPU:** Distribuição inteligente de processos entre os núcleos simulados.
* **Desempenho Multicore:** Compreensão do comportamento do software em arquiteturas de múltiplos núcleos.

## Tecnologias Utilizadas

* **Linguagem:** Java 17

## Aprendizado Esperado

Ao final do trabalho, deve ser possível compreender:
* Concorrência e sincronização;
* Exclusão mútua e condições de corrida;
* Escalonamento de CPU e comunicação entre threads;
* Desempenho em arquiteturas multicore.

## Descrição do Trabalho

* **Representação:** Cada processo será representado por uma thread.
* **Ambiente:** O sistema possuirá múltiplos núcleos de CPU simulados e um escalonador para distribuir os processos entre eles.
* **Atributos do Processo:**
    * Tempo de chegada;
    * Tempo de execução;
    * Prioridade;
    * Estado (READY, RUNNING, WAITING, FINISHED).

### Objetivos Técnicos

1. **Criação de Threads:** Utilização da classe `Thread` do Java.
2. **Filas Compartilhadas:** Implementação de estruturas protegidas com mecanismos de sincronização (`mutex`, semáforos ou variáveis de condição) para:
    * Fila de prontos;
    * Fila de espera;
    * Lista de processos finalizados.
3. **Algoritmos de Escalonamento:** Implementação de pelo menos dois dos algoritmos abaixo:
    * FIFO (First-In, First-Out);
    * Round Robin;
    * Prioridade;
    * SJF (Shortest Job First).

## Nota de Reflexão e Evolução Pessoal

> Até este momento da minha jornada acadêmica e profissional como desenvolvedora júnior, meu contato com software era majoritariamente focado na camada mais alta da aplicação: construindo CRUDs, estruturando APIs e manipulando requisições HTTP. O desenvolvimento deste simulador marcou uma virada de chave fundamental na minha percepção sobre engenharia de software.
> 
> Construir esta aplicação me forçou a enxergar a ponte real que conecta as linhas de código ao hardware. Perceber que cada rota síncrona que eu criava no Spring Boot aciona mecanismos profundos do Sistema Operacional, como Threads e gerenciamento de CPU, expandiu minha visão. Mais do que entender algoritmos teóricos, este projeto me ensinou a respeitar o ecossistema físico onde o software vive, transformando a forma como planejo a eficiência e o custo de processamento das minhas aplicações daqui para frente.

## Referências
https://www.youtube.com/watch?v=JbDHLaf1c5Y
https://archive.org/details/SistemasOperacionaisModernosTanenbaum4Edio/page/n139/mode/2up