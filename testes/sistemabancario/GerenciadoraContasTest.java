package sistemabancario;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GerenciadoraContasTest {

	private GerenciadoraContas gerContas;
	@Test 
	public void testTransfereValor1() {
		//*** MONTAGEM DE CENÁRIO ***
		int idConta01 = 1;
		int idConta02 = 2;
		
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
			
		List<ContaCorrente> contasDoBanco = new ArrayList<ContaCorrente>();
		contasDoBanco.add(conta02);
		contasDoBanco.add(conta01);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		//***** EXECUÇÃO DA REGRA DE NEGÓCIO (que foi selecionada para o teste)***
		boolean resultado = gerContas.transfereValor(idConta01, 50, idConta02);
		
		//***** VERIFICAÇÕES E ANÁLISE ******
		assertThat(resultado, is(true));
		assertTrue(resultado); // mais simples 
		assertThat(conta01.getSaldo(), is(150.0)); // garantir que seja double
		assertThat(conta02.getSaldo(), is(50.0));
	
	}
	
	@Test
	public void testTransfereValor2() {
		
		//*** MONTAGEM DE CENÁRIO ***
				int idConta01 = 1;
				int idConta02 = 2;
				
				ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
				ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
					
				List<ContaCorrente> contasDoBanco = new ArrayList<ContaCorrente>();
				contasDoBanco.add(conta02);
				contasDoBanco.add(conta01);
				
				gerContas = new GerenciadoraContas(contasDoBanco);
				
				//***** EXECUÇÃO DA REGRA DE NEGÓCIO (que foi selecionada para o teste)***
				boolean resultado = gerContas.transfereValor(idConta01, 200, idConta02);
				
				//***** VERIFICAÇÕES E ANÁLISE ******
				assertThat(resultado, is(true));
				assertTrue(resultado); // mais simples 
				assertThat(conta01.getSaldo(), is(-100.0)); // garantir que seja double
				assertThat(conta02.getSaldo(), is(200.0));
		
		
	}
	
	@Test
	public void testTransfereValor3() {
		
		//*** MONTAGEM DE CENÁRIO ***
		int idConta01 = 1;
		int idConta02 = 2;
		
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 300, true);
			
		List<ContaCorrente> contasDoBanco = new ArrayList<ContaCorrente>();
		contasDoBanco.add(conta02);
		contasDoBanco.add(conta01);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		//***** EXECUÇÃO DA REGRA DE NEGÓCIO (que foi selecionada para o teste)***
		boolean resultado = gerContas.transfereValor(idConta01, 200, idConta02);
		
		//***** VERIFICAÇÕES E ANÁLISE ******
		assertThat(resultado, is(true));
		assertTrue(resultado); // mais simples 
		assertThat(conta01.getSaldo(), is(-300.0)); // garantir que seja double
		assertThat(conta02.getSaldo(), is(500.0));
		
		
	}
	
	@Test
	public void testTransfereValor4() {
		
		//*** MONTAGEM DE CENÁRIO ***
		int idConta01 = 1;
		int idConta02 = 2;
		
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
			
		List<ContaCorrente> contasDoBanco = new ArrayList<ContaCorrente>();
		contasDoBanco.add(conta02);
		contasDoBanco.add(conta01);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		//***** EXECUÇÃO DA REGRA DE NEGÓCIO (que foi selecionada para o teste)***
		boolean resultado = gerContas.transfereValor(idConta01, 200, idConta02);
		
		//***** VERIFICAÇÕES E ANÁLISE ******
		assertThat(resultado, is(true));
		assertTrue(resultado); // mais simples 
		assertThat(conta01.getSaldo(), is(-300.0)); // garantir que seja double
		assertThat(conta02.getSaldo(), is(100.0));
		
		
	}
	

}


