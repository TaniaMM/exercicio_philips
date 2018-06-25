# Instruções para executar os testes

1. No prompt de comando acesse a pasta do projeto e execute o comando `mvn test`;
1. Os testes serão executados no navegador definido por padrão chrome;
  1. Para alterar o navegador, basta alterar o parâmetro `browser` do arquivo `data.properties`, localizado em: `src/main/java/resources`. As opções disponíveis são: `firefox`, `msie` e `chrome`;
  1. Os WebDrivers podem ser baixados através do website do [Selenium](https://docs.seleniumhq.org/download/).
1. Em todos os testes desse programa, o sistema efetua o login, executa o teste, exclui o e-mail e efetua o logout no gmail. Os testes realizados são:
  1. `TestAllEmailFieldsInformed`: Esse teste informa todos os campos de um e-mail: Destinatário, Assunto e Texto de e-mail. Verifica a 	mensagem de email enviado, abre o e-mail, verifica se o e-mail do remetente, assunto e mensagem estão de acordo com o esperado;
  1. `TestInvalidRecipient`: Esse teste envia um e-mail para um destinatário inválido, verifica a mensagem de e-mail enviado, a validação do e-mail enviado pelo "mailer-daemon@googlemail.com", o remetente e o assunto do e-mail;
  1. `TestNoMailBody`: Esse teste informa somente o destinatário e o assunto do e-mail e posteriormente verifica a mensagem de e-mail enviado, o assunto e o remetente;
  1. `TestNoMailReceiver`: Esse teste tenta enviar um e-mail sem informar um destinatário e valida, efetua a verificação da mensagem de 	validação, e em seguida apaga o rascunho do e-mail;
  1. `TestNoSubjectEmail`: Esse teste verifica o envio de e-mail quando não é informado um assunto, acessa a caixa de entrada, abre o e-mail enviado e verifica o assunto, o remetente e o texto de e-mail.
1. Os Screenshots dos testes que falharam, podem ser conferidos na pasta parametrizada no arquivo `data.properties`, localizado em `src/main/java/resources`. O parâmetro é `error.screenshots.folder`;
1. Os arquivos de log estão localizados na pasta log do projeto;
1. O Relatório de execução dos testes pode ser conferido na pasta `test-output` do projeto, o arquivo `index.html`.


 
