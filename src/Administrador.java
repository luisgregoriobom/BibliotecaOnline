import java.util.List;

public class Administrador extends Usuario {

    public Administrador(String nome, String cpf) {
        super(nome, cpf);
    }

    public void adicionarLivro(List<Livro> listaLivros, Livro livro) {
        listaLivros.add(livro);
    }

    public void removerLivro(List<Livro> listaLivros, Livro livro) {
        listaLivros.remove(livro);
    }
}
