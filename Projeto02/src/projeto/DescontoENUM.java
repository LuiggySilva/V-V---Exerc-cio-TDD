package projeto;

public enum DescontoENUM {
	DESENVOLVEDOR_MAIOR_DESCONTO(0.2),
	DESENVOLVEDOR_MENOR_DESCONTO(0.1),
	DESENVOLVEDOR_LIMITE_SALARIO_DESCONTO(3000),
	
	TESTADOR_MAIOR_DESCONTO(0.25),
	TESTADOR_MENOR_DESCONTO(0.15),
	TESTADOR_LIMITE_SALARIO_DESCONTO(2000),
	
	GERENTE_MAIOR_DESCONTO(0.3),
	GERENTE_MENOR_DESCONTO(0.2),
	GERENTE_LIMITE_SALARIO_DESCONTO(5000),
	
	DBA_MAIOR_DESCONTO(0.25),
	DBA_MENOR_DESCONTO(0.15),
	DBA_LIMITE_SALARIO_DESCONTO(2000);

    private final double desconto;

    private DescontoENUM(double desconto) {
        this.desconto = desconto;
    }

    public double getValor() {
        return this.desconto;
    }
}