package banheiro;

public class Principal {

    public static void main(String[] args) {

        Banheiro banheiro = new Banheiro();

        //Passando a tarefa e o nome do Thread
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
      //outros threads
        Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
        Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");
        
      //outros threads omitidos
        Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");

        limpeza.setDaemon(true);
        //inicialização dos outros threads omitida
        limpeza.start();

        convidado1.start();
        convidado2.start();
        convidado3.start();
        convidado4.start();
    }
}