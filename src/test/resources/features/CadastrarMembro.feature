Feature: Cadastrar um novo membro do DevMT
	Como usuario do sistema de apresentacao do DEVMT
	Eu desejo cadastrar um novo membro
	Para que eu possa obter uma listagem dos participantes do evento
	
	Background: possibilidade de estar na pagina de cadastro de membros
		Given eu estou na home page dos sistema
		|Campo|                                  valor|
		|  url| http://localhost:8080/TedDsa/index.jsf|
	
	Scenario: Cadastrar novo membro
		When eu informo o nome
		And eu informo o email corretamente
		And eu informo o telefone
		And eu clico no botao de registro
		Then o registro eh realizado com sucesso
		And eu visualizo o novo membro registrado na listagem do sistema
		
	Scenario: Cadastrar membro com email jah existente
		Given jah exista algum membro resgistrado no sistema
		When eu informo o nome
		And eu informo o email jah existente
		|campo|                          valor|
		|email| fernanda.ferreira@sigma.com.br|
		And eu informo o telefone
		And eu clico no botao de registro
		Then eu recebo a mensagem de validacao
		|campo|                                    valor|
		|  msg| Falha ao registrar, este email ja existe.|		