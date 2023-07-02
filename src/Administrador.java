import java.util.List;

public class Administrador extends Usuario {

    // Construtor
    public Administrador(String nome, String cpf) {
        super(nome, cpf);
    }

    // Método para adicionar livro
    public void adicionarLivro(List<Livro> listaLivros, Livro livro) {
        listaLivros.add(livro);
    }

    // Método para remover livro
    public void removerLivro(List<Livro> listaLivros, Livro livro) {
        listaLivros.remove(livro);
    }
}
