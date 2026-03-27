package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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
public class GerenciadoraClientesTest2 {
	
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
	public void testPesquisaCliente() {
		/*======== Montagem do cenário ========*/
//		//criando alguns clientes
//		Cliente cliente01 = new Cliente(1, "Clayton", 49, "claytn@clayton.com", 1, true);
//		Cliente cliente02 = new Cliente(2, "Maria", 18, "maria@maria.com", 2, true);
//
//		//inserindo os clientes criados na lista de clientes do banco
//		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
//		clientesDoBanco.add(cliente01);
//		clientesDoBanco.add(cliente02);
//
//		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);

		/*======== Teste propriamente dito (Execução) ========*/
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);

		/*======== Verificação e Análise (Asserts) ========*/
		//verificação do teste
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getNome(), is("Clayton"));

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
	public void testRemoveCliente() {
		/*======== Montagem do cenário ========*/
//		//criando alguns clientes
//		Cliente cliente01 = new Cliente(1, "Clayton", 49, "claytn@clayton.com", 1, true);
//		Cliente cliente02 = new Cliente(2, "Maria", 18, "maria@maria.com", 2, true);
//
//		//inserindo os clientes criados na lista de clientes do banco
//		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
//		clientesDoBanco.add(cliente01);
//		clientesDoBanco.add(cliente02);
//
//		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);

		/*======== Teste propriamente dito (Execução) ========*/
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);

		/*======== Verificação e Análise (Asserts) ========*/
		//verificação do teste
		assertThat(clienteRemovido, is(true));
		assertTrue(clienteRemovido); //mesma coisa da linha anterior, mais elegante
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));

	}

}
