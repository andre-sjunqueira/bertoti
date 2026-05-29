import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Concessionaria concessionaria = new Concessionaria();
        Scanner scanner = new Scanner(System.in);

        // Cadastrar um carro
        System.out.print("Modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());

        concessionaria.cadastrarCarro(new Carro(modelo, marca, ano));
        System.out.println("Carro cadastrado!\n");

        // Buscar um carro
        System.out.print("Buscar por modelo: ");
        String busca = scanner.nextLine();

        List<Carro> encontrados = concessionaria.buscarPorModelo(busca);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum carro encontrado.");
        } else {
            for (Carro c : encontrados) {
                System.out.println("Encontrado: " + c.getModelo() + " | " + c.getMarca() + " | " + c.getAnoFabricacao());
            }
        }

        scanner.close();
    }
}
