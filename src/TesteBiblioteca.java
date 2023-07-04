import java.util.List;
import java.util.Scanner;

public class TesteBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        System.out.println("=== Cadastro de Livros ===");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Livro " + i);

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Autor: ");
            String autor = scanner.nextLine();

            System.out.print("Gênero: ");
            String genero = scanner.nextLine();

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            Livro livro = new Livro(titulo, autor, genero, isbn);
            biblioteca.cadastrarLivro(livro);
        }

        System.out.println("=== Cadastro de Usuários ===");
        System.out.print("Quantidade de usuários comuns: ");
        int qtdUsuariosComuns = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do Scanner

        for (int i = 1; i <= qtdUsuariosComuns; i++) {
            System.out.println("Usuário Comum " + i);

            System.out.print("Nome: ");
            String nomeUsuario = scanner.nextLine();

            System.out.print("CPF: ");
            String cpfUsuario = scanner.nextLine();

            UsuarioComum usuario = new UsuarioComum(nomeUsuario, cpfUsuario);
            biblioteca.cadastrarUsuarioComum(usuario);
        }

        System.out.println("Usuário Administrador");

        System.out.print("Nome: ");
        String nomeAdmin = scanner.nextLine();

        System.out.print("CPF: ");
        String cpfAdmin = scanner.nextLine();

        Administrador admin = new Administrador(nomeAdmin, cpfAdmin);
        biblioteca.cadastrarAdministrador(admin);

        System.out.println("=== Empréstimo de Livros ===");
        System.out.print("Título do livro a ser emprestado: ");
        String tituloEmprestimo = scanner.nextLine();

        Livro livroEmprestimo = biblioteca.buscarLivroPorTitulo(tituloEmprestimo);

        if (livroEmprestimo != null) {
            System.out.print("Nome do usuário: ");
            String nomeUsuarioEmprestimo = scanner.nextLine();

            Usuario usuarioEmprestimo = biblioteca.buscarUsuarioPorNome(nomeUsuarioEmprestimo);

            if (usuarioEmprestimo != null) {
                boolean emprestimoSucesso = biblioteca.emprestarLivro(livroEmprestimo, (UsuarioComum) usuarioEmprestimo);
                if (emprestimoSucesso) {
                    System.out.println("Livro " + livroEmprestimo.getTitulo() + " emprestado para " + usuarioEmprestimo.getNome());
                } else {
                    System.out.println("Não foi possível realizar o empréstimo do livro " + livroEmprestimo.getTitulo());
                }
            } else {
                System.out.println("Usuário não encontrado!");
            }
        } else {
            System.out.println("Livro não encontrado!");
        }

        System.out.println("=== Devolução de Livros ===");
        System.out.print("Título do livro a ser devolvido: ");
        String tituloDevolucao = scanner.nextLine();

        Livro livroDevolucao = biblioteca.buscarLivroPorTitulo(tituloDevolucao);

        if (livroDevolucao != null) {
            System.out.print("Nome do usuário: ");
            String nomeUsuarioDevolucao = scanner.nextLine();

            Usuario usuarioDevolucao = biblioteca.buscarUsuarioPorNome(nomeUsuarioDevolucao);

            if (usuarioDevolucao != null) {
                boolean devolucaoSucesso = biblioteca.devolverLivro(livroDevolucao, (UsuarioComum) usuarioDevolucao);
                if (devolucaoSucesso) {
                    System.out.println("Livro " + livroDevolucao.getTitulo() + " devolvido por " + usuarioDevolucao.getNome());
                } else {
                    System.out.println("Não foi possível realizar a devolução do livro " + livroDevolucao.getTitulo());
                }
            } else {
                System.out.println("Usuário não encontrado!");
            }
        } else {
            System.out.println("Livro não encontrado!");
        }

        System.out.println("=== Consultar Livros por Autor ===");
        System.out.print("Autor: ");
        String autorConsulta = scanner.nextLine();

        List<Livro> livrosPorAutor = biblioteca.consultarLivrosPorAutor(autorConsulta);

        System.out.println("Livros por autor (" + autorConsulta + "):");
        for (Livro livro : livrosPorAutor) {
            System.out.println("- " + livro.getTitulo());
        }

        System.out.println("=== Consultar Livros por Gênero ===");
        System.out.print("Gênero: ");
        String generoConsulta = scanner.nextLine();

        List<Livro> livrosPorGenero = biblioteca.consultarLivrosPorGenero(generoConsulta);

        System.out.println("Livros por gênero (" + generoConsulta + "):");
        for (Livro livro : livrosPorGenero) {
            System.out.println("- " + livro.getTitulo());
        }
    }
}