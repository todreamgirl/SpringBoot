package integracao.rest.agenda;





import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import integracao.rest.contatos.Contato;
import integracao.rest.contatos.ContatoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Salvar{

	@Autowired
	private TestRestTemplate testRestTemplate;
	@Autowired
	private ContatoRepository contatoRepository;
	private Contato contato;	
	private String nome = "Aluno";
	private String ddd = "11";
	private String telefone = "99999999";
	
	@Test
	public void SalvarContatoVerSeINSERIRFUNCIONA() {
		Contato contato = new Contato(nome, ddd, telefone);
		HttpEntity<Contato> httpEntity = new HttpEntity<>(contato);
		ResponseEntity<Contato> resposta = 
				testRestTemplate.exchange("/contatos/inserir",HttpMethod.POST,httpEntity, Contato.class);
		Assert.assertEquals(HttpStatus.CREATED,resposta.getStatusCode());

		//depois que a resposta entra no body, a aplicacao compara se as variaveis inseridas conferem com o parametro do body
		Contato resultado = resposta.getBody();
		Assert.assertNotNull(resultado.getId());
		Assert.assertEquals(contato.getNome(), resultado.getNome());
		Assert.assertEquals(contato.getDdd(), resultado.getDdd());
		Assert.assertEquals(contato.getTelefone(), resultado.getTelefone());
		contatoRepository.deleteAll();
	}




}