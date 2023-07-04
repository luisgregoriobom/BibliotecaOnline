import java.util.ArrayList;
import java.util.List;

public class UsuarioComum extends Usuario{
    private List<Livro> livrosEmprestados;

    public UsuarioComum(String nome, String cpf) {
        super(nome, cpf);
        this.livrosEmprestados = new ArrayList<>();
    }

    public boolean emprestarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            livrosEmprestados.add(livro);
            return true;
        }
        return false;
    }

    public boolean devolverLivro(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            livro.setDisponivel(true);
            livrosEmprestados.remove(livro);
            return true;
        }
        return false;
    }
}
