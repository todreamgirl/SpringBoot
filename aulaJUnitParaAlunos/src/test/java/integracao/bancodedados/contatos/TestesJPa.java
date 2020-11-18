package integracao.bancodedados.contatos;

import java.util.List;
import java.util.stream.Stream;


import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestesJPa {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Test
	public void findAllByNomeIgnoreCaseRetornaTresContato() 
	{
		List<Contato> contatos = contatoRepository.findAllByNomeIgnoreCaseContaining("chefe");
		Assert.assertEquals(3, contatos.size());
	}
	
	@Test
	public void buscaTodosContatosComOrdenacaoRetornaListaOrdenadaDeFormaDescendente() 
	{
		List<Contato> contatos = contatoRepository.findAllBybuscaTodosContatosComOrdenacao(Sort.by(Direction.DESC, "nome"));
		
		Assert.assertTrue(contatos.get(0).getNome().equals("Novo Chefe"));
	}
	
	@Test
	public void buscaTodosContatosComOrdenacaoRetornaListaOrdenadaDeFormaAscendente() 
	{
		List<Contato> contatos = contatoRepository.findAllBybuscaTodosContatosComOrdenacao2(Sort.by(Direction.ASC, "nome"));
		
		Assert.assertTrue(contatos.get(0).getNome().equals("Amigo"));
	}
	
	@Test
	@Transactional
	public void buscarTodosContatosRetornaStreamOrdenada() 
	{
		try(Stream<Contato> contatos= contatoRepository.buscaTodosContatos())
		{
			Assert.assertTrue(contatos.findFirst().get().getNome().equals("Amigo"));
		}
	}





	

}

	
	

	





	





