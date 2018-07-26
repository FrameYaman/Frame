#language: pt

Funcionalidade: Visitar o site com sucesso
	Como um novo cliente
	Eu quero visitar o site
	Para eu descobrir mais sobre a Yaman
	
	Contexto:
	Dado que estou no site "Yaman"
	
@exemplo_01
Esquema do Cenário: Deve navegar no site com sucesso
	Quando apresentar a página inicial
	Então o menu "<menu>" será visualizado com sucesso
	
@exemplo_02
Esquema do Cenário: Deve validar contato com sucesso
	E clico no menu "<menu>"
	Quando carregar a página "<pagina>"
	E preencher o cadastro de contato
	Então deverá enviar contato com sucesso
		
Exemplos:
| menu    | pagina   |
| Home    | Contato  |
| Contato | Soluções |
