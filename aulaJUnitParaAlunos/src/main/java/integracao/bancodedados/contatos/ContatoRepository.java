package integracao.bancodedados.contatos;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContatoRepository extends JpaRepository<Contato, Long> {


		//procurar
	Contato findFirstByNome(String nome);

		//procurar por nome,igno
	List<Contato> findAllByNomeIgnoreCaseContaining(String nome);
	
	//por ordem alfabetica
	@Query (value= "SELECT c FROM Contato c")
	List<Contato>findAllBybuscaTodosContatosComOrdenacao(Sort sort);
	
	//por ordem alfabetica
	@Query (value= "SELECT D FROM Contato D")
	List<Contato>findAllBybuscaTodosContatosComOrdenacao2(Sort sort);
	
	
	@Query (value= "SELECT c FROM Contato c ORDER BY nome ")
	Stream<Contato> buscaTodosContatos();
}
