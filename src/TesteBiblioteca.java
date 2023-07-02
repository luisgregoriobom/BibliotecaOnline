import java.util.List;

public class TesteBiblioteca {
    public static void main(String[] args) {
        // Exemplo de uso do sistema
        Biblioteca biblioteca = new Biblioteca();

        // Criação de livros
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", "Romance", "978-85-253-1757-5");
        Livro livro2 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantojuvenil", "978-85-253-1715-5");
        Livro livro3 = new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", "Romance", "978-85-253-1294-5");
        Livro livro4 = new Livro("1984", "George Orwell", "Ficção Científica", "978-85-8046-000-0");
        Livro livro5 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "978-85-359-0277-8");

        // Criação de usuários
        UsuarioComum usuario1 = new UsuarioComum("João", "123456789");
        UsuarioComum usuario2 = new UsuarioComum("Maria", "987654321");
        Administrador admin1 = new Administrador("Admin", "999999999");

        // Cadastro de livros na biblioteca
        admin1.adicionarLivro(biblioteca.consultarLivrosDisponiveis(), livro1);
        admin1.adicionarLivro(biblioteca.consultarLivrosDisponiveis(), livro2);
        admin1.adicionarLivro(biblioteca.consultarLivrosDisponiveis(), livro3);
        admin1.adicionarLivro(biblioteca.consultarLivrosDisponiveis(), livro4);
        admin1.adicionarLivro(biblioteca.consultarLivrosDisponiveis(), livro5);

        // Cadastro de usuários na biblioteca
        biblioteca.cadastrarUsuarioComum(usuario1);
        biblioteca.cadastrarUsuarioComum(usuario2);
        biblioteca.cadastrarAdministrador(admin1);

        // Empréstimo de livros
        boolean emprestimoSucesso = biblioteca.emprestarLivro(livro1, usuario1);
        if (emprestimoSucesso) {
            System.out.println("Livro " + livro1.getTitulo() + " emprestado para " + usuario1.getNome());
        } else {
            System.out.println("Não foi possível realizar o empréstimo do livro " + livro1.getTitulo());
        }

        emprestimoSucesso = biblioteca.emprestarLivro(livro2, usuario1);
        if (emprestimoSucesso) {
            System.out.println("Livro " + livro2.getTitulo() + " emprestado para " + usuario1.getNome());
        } else {
            System.out.println("Não foi possível realizar o empréstimo do livro " + livro2.getTitulo());
        }

        emprestimoSucesso = biblioteca.emprestarLivro(livro3, usuario2);
        if (emprestimoSucesso) {
            System.out.println("Livro " + livro3.getTitulo() + " emprestado para " + usuario2.getNome());
        } else {
            System.out.println("Não foi possível realizar o empréstimo do livro " + livro3.getTitulo());
        }

        // Devolução de livros
        boolean devolucaoSucesso = biblioteca.devolverLivro(livro1, usuario1);
        if (devolucaoSucesso) {
            System.out.println("Livro " + livro1.getTitulo() + " devolvido por " + usuario1.getNome());
        } else {
            System.out.println("Não foi possível realizar a devolução do livro " + livro1.getTitulo());
        }

        devolucaoSucesso = biblioteca.devolverLivro(livro2, usuario1);
        if (devolucaoSucesso) {
            System.out.println("Livro " + livro2.getTitulo() + " devolvido por " + usuario1.getNome());
        } else {
            System.out.println("Não foi possível realizar a devolução do livro " + livro2.getTitulo());
        }

        // Consultar livros por autor
        List<Livro> livrosPorAutor = biblioteca.consultarLivrosPorAutor("Machado de Assis");
        System.out.println("Livros por autor (Machado de Assis): ");
        for (Livro livro : livrosPorAutor) {
            System.out.println("- " + livro.getTitulo());
        }

        // Consultar livros por gênero
        List<Livro> livrosPorGenero = biblioteca.consultarLivrosPorGenero("Romance");
        System.out.println("Livros por gênero (Romance): ");
        for (Livro livro : livrosPorGenero) {
            System.out.println("- " + livro.getTitulo());
        }
    }
}
