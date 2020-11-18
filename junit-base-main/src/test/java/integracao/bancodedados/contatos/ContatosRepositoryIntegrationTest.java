package integracao.bancodedados.contatos;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import integracao.bancodedados.model.ContatoModel;
import integracao.bancodedados.repository.ContatoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest //testa jpa
public class ContatosRepositoryIntegrationTest {
	
	private ContatoModel contato;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Before
	public void start() {
 contato = new ContatoModel("Gabriel", "011y", "9xxxxxx9");
	}
	
	@Rule
	public ExpectedException esperadaExcecao= ExpectedException.none();
	
	
	@Test
	public void salvarComTelNulo() throws Exception{
		esperadaExcecao.expect(ConstraintViolationException.class); //nao autoriza violacao
		esperadaExcecao.expectMessage("O Telefone deve ser preenchido");
		
		contato.setTelefone(null);
		contatoRepository.save(contato);
	}
	
	
}


