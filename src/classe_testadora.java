public class classe_testadora {
    //psvm - Método main necessário para executar o programa java
    public static void main(String[] args) {
        //sout - atalho para imprimir na tela
        /*
    comentário de bloco é feito desta maneira
 */

// comentar linha

// para apagar arquivo - botao direito em cima do arquivo, refactor, safe delete

//exercício cadastro de paciente

        String nome = "willames";
        int idade = 42;
        double altura = 1.69;
        double peso = 72.2;
        boolean fumante = false;

        //Respostas

        boolean praticaAtividade = true;
        int atividadeSemana = 4;
        boolean dorsentida = true;
        int intensidadeDor = 8;

        if (praticaAtividade = true) {
            System.out.println("O paciente pratica atividade física!");

            if (atividadeSemana > 3) {
                System.out.println("Boa quantidade de endorfina!");
            } else {
                System.out.println("Precisa melhorar!");
            }
        }
        if (dorsentida == true){
            System.out.println("O paciente sente dor!");
            if (intensidadeDor > 5){
                System.out.println("Sente uma dor muito forte!");
            } else {
                System.out.println("Vamos tratar com medicamento!");
            }
        }
    }
}

