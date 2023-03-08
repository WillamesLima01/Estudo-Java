public class appCL {
    public static void main(String[] args) {
        ContaLogin cl = new ContaLogin("illaap@hotmail.com");
        cl.setNome("wilames", 10);

        System.out.println("CL: " + cl.getNome());
    }
}
