package testes;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FuncionarioTest {

	@Test
	void testFuncionarioConstructor() {
		String nome = "Luiggy";
		String email = "luiggy@email.com";
		Integer salario = 10000;
		String cargo = "GERENTE";
		
		Funcionario funcionario = new Funcionario(nome, email, salario, cargo);
		
		assertEquals("ERRO: getNome()", nome, funcionario.getNome()); 
		assertEquals("ERRO: getEmail()", email, funcionario.getEmail()); 
		assertEquals("ERRO: getSalario()", salario, funcionario.getSalario()); 
		assertEquals("ERRO: getCargo()", cargo, funcionario.getCargo()); 
	}	

	@Test
	void testFuncionarioEmptyConstructor() {
		Funcionario funcionario = new Funcionario();
		assertNull(funcionario.getNome()); 
		assertNull(funcionario.getEmail()); 
		assertNull(funcionario.getSalario());
		assertNull(funcionario.getCargo()); 
	}
	
	@Test
	void testFuncionarioSetMethods() {
		String nome1 = "Luiggy";
		String email1 = "luiggy@email.com";
		Integer salario1 = 10000;
		String cargo1 = "CEO";
		
		Funcionario funcionario = new Funcionario(nome1, email1, salario1, cargo1);
		
		assertEquals("ERRO: getNome()", nome1, funcionario.getNome()); 
		assertEquals("ERRO: getEmail()", email1, funcionario.getEmail()); 
		assertEquals("ERRO: getSalario()", salario1, funcionario.getSalario()); 
		assertEquals("ERRO: getCargo()", cargo1, funcionario.getCargo()); 
		
		String nome2 = "Irineu";
		String email2 = "irineu@email.com";
		Integer salario2 = 5000;
		String cargo2 = "DBA";
		
		funcionario.setNome(nome2);
		funcionario.setEmail(email2);
		funcionario.setSalario(salario2);
		funcionario.setCargo(cargo2);
		
		assertEquals("ERRO: setNome()", nome2, funcionario.getNome()); 
		assertEquals("ERRO: setEmail()", email2, funcionario.getEmail()); 
		assertEquals("ERRO: setSalario()", salario2, funcionario.getSalario()); 
		assertEquals("ERRO: setCargo()", cargo2, funcionario.getCargo()); 
		
	}

	@Test
	void testFuncionarioEmptyNameConstructorException() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario ("", "funcionario@email.com", 1000, "DBA");
	           },
	           "ERRO: Criação de funcionário com nome vazio"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Nome do funcionário vazio!"));
	}
	
	@Test
	void testFuncionarioEmptySetNameException() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", 1000, "DBA");
	        	   funcionario.setNome("");
	           },
	           "ERRO: Alteração de funcionário com nome vazio"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Nome do funcionário vazio!"));
	}
	
	@Test
	void testFuncionarioEmptyEmailConstructorException() {
		// Testando com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "", 1000, "DBA");
	           },
	           "ERRO: Criação de funcionário com email vazio"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Email do funcionário vazio!"));
	}
	
	@Test
	void testFuncionarioEmptySetEmailException() {
		// Testando com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 1000, "DBA");
	        	   funcionario.setEmail("");
	           },
	           "ERRO: Alteração de funcionário com email vazio"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Email do funcionário vazio!"));
	}
	
	@Test
	void testFuncionarioInvalidSalaryConstructorException() {
		// Testando com o valor igual a zero
		IllegalArgumentException thrown1 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 0, "DBA");
	           },
	           "ERRO: Criação de funcionário com salario igual a zero"
	    );
		assertTrue(thrown1.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
		
		// Testando com o valor negativo
		IllegalArgumentException thrown2 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", -1, "DBA");
	           },
	           "ERRO: Criação de funcionário com salario menor ou igual a zero"
	    );
		assertTrue(thrown2.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}
	
	@Test
	void testFuncionarioInvalidSetSalaryException() {
		// Testando com o valor igual a zero
		IllegalArgumentException thrown1 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 1000, "DBA");
	        	   funcionario.setSalario(0);
	           },
	           "ERRO: Alteração de funcionário com salario igual a zero"
	    );
		assertTrue(thrown1.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
		
		// Testando com o valor negativo
		IllegalArgumentException thrown2 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 1000, "DBA");
	        	   funcionario.setSalario(-1);
	           },
	           "ERRO: Alteração de funcionário com salario menor ou igual a zero"
	    );
		assertTrue(thrown2.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}
	
	@Test
	void testFuncionarioInvalidCargoConstructorException() {
		// Testando com string vazia
		IllegalArgumentException thrown1 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 1000, "");
	           },
	           "ERRO: Criação de funcionário com cargo vazio"
	    );
		assertTrue(thrown1.getMessage().contentEquals("Cargo do funcionário vazio!"));
		
		// Testando com cargo que não foi especificado
		IllegalArgumentException thrown2 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 1000, "FAZ_TUDO");
	           },
	           "ERRO: Criação de funcionário com cargo inexistente"
	    );
		assertTrue(thrown2.getMessage().contentEquals("Cargo do funcionário não existe!"));
		
		// Testando com cargo que não foi especificado
		IllegalArgumentException thrown3 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 1000, "ESTAGIO");
	           },
	           "ERRO: Criação de funcionário com cargo inexistente"
	    );
		assertTrue(thrown3.getMessage().contentEquals("Cargo do funcionário não existe!"));
	}
	
	@Test
	void testFuncionarioInvalidSetCargoException() {
		// Testando com string vazia
		IllegalArgumentException thrown1 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 10000, "GERENTE");
	        	   funcionario.setCargo("");
	           },
	           "ERRO: Alteração de funcionário com cargo vazio"
	    );
		assertTrue(thrown1.getMessage().contentEquals("Cargo do funcionário vazio!"));
		
		// Testando com cargo que não foi especificado
		IllegalArgumentException thrown2 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 10000, "GERENTE");
	        	   funcionario.setCargo("DEV");
	           },
	           "ERRO: Alteração de funcionário com cargo inexistente"
	    );
		assertTrue(thrown2.getMessage().contentEquals("Cargo do funcionário não existe!"));
		
		// Testando com cargo que não foi especificado
		IllegalArgumentException thrown3 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 10000, "GERENTE");
	        	   funcionario.setCargo("ESTAGIO");
	           },
	           "ERRO: Alteração de funcionário com cargo inexistente"
	    );
	    assertTrue(thrown3.getMessage().contentEquals("Cargo do funcionário não existe!"));
	}
	
	@Test
	void testFuncionarioGetNetSalaryDESENVOLVEDOR() {
		// Valor bem maior
		Funcionario funcionario1 = new Funcionario("luiggy", "luiggy@email.com", 10000, "DESENVOLVEDOR");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 8000, funcionario1.getSalarioLiquido());
		// Valor bem menor
		Funcionario funcionario2 = new Funcionario("luiggy", "luiggy@email.com", 1000, "DESENVOLVEDOR");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 900, funcionario2.getSalarioLiquido());
		// Valor proximo do limite superior
		Funcionario funcionario3 = new Funcionario("luiggy", "luiggy@email.com", 2999.99, "DESENVOLVEDOR");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 2699.991, funcionario3.getSalarioLiquido());
		// Valor proximo do limite inferior
		Funcionario funcionario4 = new Funcionario("luiggy", "luiggy@email.com", 3000.01, "DESENVOLVEDOR");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 2400.008, funcionario4.getSalarioLiquido());
		// Valor igual ao limite
		Funcionario funcionario5 = new Funcionario("luiggy", "luiggy@email.com", 2100, "DESENVOLVEDOR");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 2400, funcionario5.getSalarioLiquido());
	}
	
	@Test
	void testFuncionarioGetNetSalaryDBA() {
		// Valor bem maior
		Funcionario funcionario1 = new Funcionario("luiggy", "luiggy@email.com", 10000, "DBA");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 7500, funcionario1.getSalarioLiquido());
		// Valor bem menor
		Funcionario funcionario2 = new Funcionario("luiggy", "luiggy@email.com", 1000, "DBA");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 850, funcionario2.getSalarioLiquido());
		// Valor proximo do limite superior
		Funcionario funcionario3 = new Funcionario("luiggy", "luiggy@email.com", 1999.99, "DBA");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1700.0085, funcionario3.getSalarioLiquido());
		// Valor proximo do limite inferior
		Funcionario funcionario4 = new Funcionario("luiggy", "luiggy@email.com", 2000.01, "DBA");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1500.0075, funcionario4.getSalarioLiquido());
		// Valor igual ao limite
		Funcionario funcionario5 = new Funcionario("luiggy", "luiggy@email.com", 2000, "DBA");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1500, funcionario5.getSalarioLiquido());		
	}

	@Test
	void testFuncionarioGetNetSalaryTESTADOR() {
		// Valor bem maior
		Funcionario funcionario1 = new Funcionario("luiggy", "luiggy@email.com", 10000, "TESTADOR");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 7500, funcionario1.getSalarioLiquido());
		// Valor bem menor
		Funcionario funcionario2 = new Funcionario("luiggy", "luiggy@email.com", 1000, "TESTADOR");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 850, funcionario2.getSalarioLiquido());
		// Valor proximo do limite superior
		Funcionario funcionario3 = new Funcionario("luiggy", "luiggy@email.com", 1999.99, "TESTADOR");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1700.0085, funcionario3.getSalarioLiquido());
		// Valor proximo do limite inferior
		Funcionario funcionario4 = new Funcionario("luiggy", "luiggy@email.com", 2000.01, "TESTADOR");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1500.0075, funcionario4.getSalarioLiquido());
		// Valor igual ao limite
		Funcionario funcionario5 = new Funcionario("luiggy", "luiggy@email.com", 2000, "TESTADOR");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1500, funcionario5.getSalarioLiquido());		
	}

	@Test
	void testFuncionarioGetNetSalaryGERENTE() {
		// Valor bem maior
		Funcionario funcionario1 = new Funcionario("luiggy", "luiggy@email.com", 10000, "GERENTE");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 7500, funcionario1.getSalarioLiquido());
		// Valor bem menor
		Funcionario funcionario2 = new Funcionario("luiggy", "luiggy@email.com", 1000, "GERENTE");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 800, funcionario2.getSalarioLiquido());
		// Valor proximo do limite superior
		Funcionario funcionario3 = new Funcionario("luiggy", "luiggy@email.com", 4999.99, "GERENTE");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 3999,992, funcionario3.getSalarioLiquido());
		// Valor proximo do limite inferior
		Funcionario funcionario4 = new Funcionario("luiggy", "luiggy@email.com", 5000.01, "GERENTE");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 3500,007, funcionario4.getSalarioLiquido());
		// Valor igual ao limite
		Funcionario funcionario5 = new Funcionario("luiggy", "luiggy@email.com", 5000, "GERENTE");
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 3500, funcionario5.getSalarioLiquido());		
	}
	
}
