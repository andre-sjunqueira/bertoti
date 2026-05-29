import java.util.List;

// Classe de Teste: Serve para garantir que o nosso código principal funciona sem precisar de um usuário clicando em telas.
public class Teste {

    // Método main: Ponto de entrada. É por aqui que o Java começa a rodar o programa.
    public static void main(String[] args) {
        System.out.println("Iniciando testes automáticos da Concessionária...\n");

        // 1. Preparação (Setup)
        // Criamos o objeto que vai gerenciar nossos dados.
        Concessionaria concessionaria = new Concessionaria();

        // Instanciamos novos carros usando a palavra 'new' e o construtor da classe Carro.
        concessionaria.cadastrarCarro(new Carro("Civic", "Honda", 2022));
        concessionaria.cadastrarCarro(new Carro("Corolla", "Toyota", 2023));

        // 2. Teste de Cadastro
        // Pegamos o tamanho da lista (size) para ver se os 2 carros realmente entraram.
        if (concessionaria.getCarros().size() == 2) {
            System.out.println("[PASSOU] O cadastro de carros funcionou. (Total = 2)");
        } else {
            System.out.println("[FALHOU] Era esperado ter 2 carros, mas encontrou " + concessionaria.getCarros().size());
        }

        // 3. Teste de Busca
        // Vamos testar o método que filtra os carros.
        List<Carro> encontrados = concessionaria.buscarPorModelo("Corolla");

        // Verifica se a busca trouxe exatamente o 1 carro que esperávamos.
        if (encontrados.size() == 1) {
            System.out.println("[PASSOU] A busca pelo modelo 'Corolla' retornou exatamente 1 carro.");

            // Verifica se as informações internas (como a marca) daquele carro estão corretas.
            if ("Toyota".equals(encontrados.get(0).getMarca())) {
                System.out.println("[PASSOU] A marca do carro encontrado está correta.");
            } else {
                System.out.println("[FALHOU] A marca retornada (" + encontrados.get(0).getMarca() + ") estava incorreta.");
            }
        } else {
            System.out.println("[FALHOU] Era esperado encontrar 1 carro, mas encontrou " + encontrados.size());
        }

        System.out.println("\nFim dos testes.");
    }
}
