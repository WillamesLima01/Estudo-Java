public class appCc {
    public static void main(String[] args) {
        ContaCorrente Cc = new ContaCorrente("willames P de Lima", "*******");

        Cc.depositar(1000);
        Cc.sacar(2200.30);
        Cc.depositar(1579.10);

        System.out.println("Nome: " + Cc.getNome());
        System.out.println("Senha: " + Cc.getSenha());
        System.out.println("Saldo: " + Cc.verificarSaldo());
    }
}
