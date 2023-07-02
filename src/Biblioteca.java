import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> listaLivros;
    private List<UsuarioComum> listaUsuariosComuns;
    private List<Administrador> listaAdministradores;

    // Construtor
    public Biblioteca() {
        this.listaLivros = new ArrayList<>();
        this.listaUsuariosComuns = new ArrayList<>();
        this.listaAdministradores = new ArrayList<>();
    }

    // Métodos para cadastrar usuários
    public void cadastrarUsuarioComum(UsuarioComum usuarioComum) {
        listaUsuariosComuns.add(usuarioComum);
    }

    public void cadastrarAdministrador(Administrador administrador) {
        listaAdministradores.add(administrador);
    }

    // Métodos para gerenciamento de livros
    public List<Livro> consultarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : listaLivros) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    public boolean emprestarLivro(Livro livro, UsuarioComum usuarioComum) {
        if (listaLivros.contains(livro)) {
            return usuarioComum.emprestarLivro(livro);
        }
        return false;
    }

    public boolean devolverLivro(Livro livro, UsuarioComum usuarioComum) {
        if (listaLivros.contains(livro)) {
            return usuarioComum.devolverLivro(livro);
        }
        return false;
    }

    // Métodos adicionais
    public List<Livro> consultarLivrosPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        for (Livro livro : listaLivros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.add(livro);
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> consultarLivrosPorGenero(String genero) {
        List<Livro> livrosPorGenero = new ArrayList<>();
        for (Livro livro : listaLivros) {
            if (livro.getGenero().equalsIgnoreCase(genero)) {
                livrosPorGenero.add(livro);
            }
        }
        return livrosPorGenero;
    }
}
