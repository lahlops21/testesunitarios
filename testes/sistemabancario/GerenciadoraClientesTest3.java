package sistemabancario;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//comentário de linha

/*
 * comentário de bloco
 */

/**
 * comentário com javadocs
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes realizadas pela classe {@link GerenciadoraClientes}
 * através de testes unitários com JUnit
 * @author Clayton Chagas
 * @date 27/02/2026
 * @local FATEC, Rio de Janeiro, Brasil, Planeta Terra
 */
public class GerenciadoraClientesTest3 {
// A filosofia do junit é montar cenário no mesma classe - testa e depois desmonta. 

	// INDEPENDENCIA DOS TESTES
	// COBERTURA DOS TESTES - Pelo menos um teste para cada método dos métodos das regras de negócio. O bom é ter vários para cada regra de negocio. 
	private GerenciadoraClientes gerClientes;
	
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	@Before
	public void setUp() {
		//***** Montagem do cenário global *****//
		//criando alguns clientes
		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 49, "claytn@clayton.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 18, "maria@maria.com", 2, true);

		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}
	
	@After
	public void tearDown() {
		//***** desmontagem do cenário global *****//
		gerClientes.limpa();
		
	}

	/**
	 * Teste básico da pesquisa de um cliente a partir de seu ID
	 * Testamos a certificação com o retorno do ID e do nome (asserts)
	 * 
	 * @author Clayton Chagas
	 * @date 27/02/2026
	 * @local FATEC, RJ, BR
	 */
	@Test
	public void testPesquisaCliente1() {
		/*======== Montagem do cenário ========*/
		//Feita pelo método setUp()
		
		/*======== Teste propriamente dito (Execução) ========*/
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);

		/*======== Verificação e Análise (Asserts) ========*/
		//verificação do teste
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getNome(), is("Clayton"));

	}
	
	@Test
	public void testPesquisaCliente2() {
		/*======== Montagem do cenário ========*/
		//Feita pelo método setUp()
		
		/*======== Teste propriamente dito (Execução) ========*/
		Cliente cliente = gerClientes.pesquisaCliente(idCliente02);

		/*======== Verificação e Análise (Asserts) ========*/
		//verificação do teste
		assertThat(cliente.getId(), is(2));
		assertThat(cliente.getNome(), is("Maria"));

	}
	
	@Test
	public void testPesquisaClienteInexistente() {
		/*======== Montagem do cenário ========*/
		//Feita pelo método setUp()
		
		/*======== Teste propriamente dito (Execução) ========*/
		Cliente cliente = gerClientes.pesquisaCliente(10);

		/*======== Verificação e Análise (Asserts) ========*/
		//verificação do teste
		assertNull(cliente);

	}

	/**
	 * Teste básico da remoção de um cliente a partir de seu ID
	 * Testamos a certificação com o boolean de retorno, o tamanho da lista
	 * e a pesquisa do cliente removido(asserts)
	 * 
	 * @author Clayton Chagas
	 * @date 27/02/2026
	 * @local FATEC, RJ, BR
	 */
	@Test
	public void testRemoveCliente2() {
		/*======== Montagem do cenário ========*/
		//Feita pelo método setUp()

		/*======== Teste propriamente dito (Execução) ========*/
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);

		/*======== Verificação e Análise (Asserts) ========*/
		//verificação do teste
		assertThat(clienteRemovido, is(true));
		assertTrue(clienteRemovido); //mesma coisa da linha anterior, mais elegante
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));

	}
	
	@Test
	public void testRemoveCliente1() {
		/*======== Montagem do cenário ========*/
		//Feita pelo método setUp()

		/*======== Teste propriamente dito (Execução) ========*/
		boolean clienteRemovido = gerClientes.removeCliente(idCliente01);

		/*======== Verificação e Análise (Asserts) ========*/
		//verificação do teste
		assertThat(clienteRemovido, is(true));
		assertTrue(clienteRemovido); //mesma coisa da linha anterior, mais elegante
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente01));

	}
	
	@Test
	public void testRemoveClienteInexistente() {
		/*======== Montagem do cenário ========*/
		//Feita pelo método setUp()

		/*======== Teste propriamente dito (Execução) ========*/
		boolean clienteRemovido = gerClientes.removeCliente(10);

		/*======== Verificação e Análise (Asserts) ========*/
		//verificação do teste
		assertThat(clienteRemovido, is(false));
		assertFalse(clienteRemovido); //mesma coisa da linha anterior, mais elegante
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));

	}
	
	// Validação quando o cliente está no interavlo central da idade permitida
	
	@Test
	public void testClienteIdadePermitida1() throws IdadeNaoPermitidaException {
		
		// Cenário Customizado para teste
		Cliente cliente = new Cliente(3, "Lais", 25, "lais@email", 3, true);
		
		// Execução
		
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		// Verificação 
		
		assertTrue(idadeValida);
		
	}
	
	// Validação quando o cliente está no intervalo de idade permitida ma borda inferior
		
	@Test
		public void testClienteIdadePermitida2() throws IdadeNaoPermitidaException {
		
		// Cenário Customizado para teste
		Cliente cliente = new Cliente(4, "Cadu", 18, "cadu@email", 4, true);
		
		// Execução
		
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		// Verificação 
		
		assertTrue(idadeValida);
		
	}

	// Validação quando o cliente está no intervalo de idade permitida ma borda inferior
	
		@Test
			public void testClienteIdadePermitida3() throws IdadeNaoPermitidaException {
			
			// Cenário Customizado para teste
			Cliente cliente = new Cliente(5, "Ralph", 65, "ralph@email", 5, true);
			
			// Execução
			
			boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
			
			// Verificação 
			
			assertTrue(idadeValida);
			
		}
		
		// Validação quando o cliente está no intervalo de idade NÃO permitida na borda inferior
		
			@Test
				public void testClienteIdadePermitida4() throws IdadeNaoPermitidaException {
				
				// Cenário Customizado para teste
				Cliente cliente = new Cliente(6, "Ícaro", 17, "icaro@email", 6, true);
				
				// Execução
				try {
					gerClientes.validaIdade(cliente.getId());
					fail();
					System.out.println("t1");
					
				} catch (Exception e) {
					System.out.println("t2");
					assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
				}
				boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
				
				
			}
			
			// Validação quando o cliente está no intervalo de idade NÃO permitida na borda superior
			
			@Test
				public void testClienteIdadePermitida5() throws IdadeNaoPermitidaException {
				
				// Cenário Customizado para teste
				Cliente cliente = new Cliente(7, "Ralph", 66, "ralph@email", 7, true);
				
				// Execução
				try {
					gerClientes.validaIdade(cliente.getId());
					fail();
					System.out.println("t1");
					
				} catch (Exception e) {
					System.out.println("t2");
					assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
				}
				boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());	
				
			}



	
	
}









