#language: pt

Funcionalidade: Visitar o site com sucesso
	Como um novo cliente
	Eu quero visitar o site
	Para eu descobrir mais sobre a Yaman
	
	Contexto:
	Dado que estou no site "Yaman"
	
@exemplo_01
Esquema do Cenario: Deve navegar no site com sucesso
	Quando apresentar a pagina inicial
	Entao o menu "<menu>" seria visualizado com sucesso
	
@exemplo_02
Esquema do Cenario: deve validar contato com sucesso
	E clico no menu "<menu>"
	Quando carregar a pagina "<pagina>"
	E preencher o cadastro de contato
	Entao deveria enviar contato com sucesso
		
Exemplos:
| menu    | pagina   |
| Home    | Contato  |
| Contato | Solucoes |
