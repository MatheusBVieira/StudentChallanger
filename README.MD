# Student Challenge

## Execução

 - Para execução do Projeto, deve ser executada apenas a classe main "StudentChallangerApplication.java".
 - O banco de dados é o H2 então não é necessario configurações.
 - Para inserção de um novo aluno o usuario deve estar autenticado. Conta padrão:
    - Email: admin@email.com
    - Senha: 123456
 - Após autenticado o token do tipo bearer deve ser enviado junto aos métodos HTTP
 - A documentação está localizado no painel padrão do swagger. Pode ser encontrada no endereço:
    - localhost:8080/swagger-ui.html
    
## Exemplos

### POST - Aluno
```javascript
{
    "nomeCompleto": "Matheus Bruggemann Vieira",
    "username": "nofti",
    "email": "matheusbvieira@hotmail.com",
    "telefone": "48991444466",
    "sexo": "MASCULINO",
    "dataNascimento": "29/11/2000"
}
```

### PUT - Aluno
```javascript
{	
    "nomeCompleto": "Matheus Bruggemann Vieira",
    "email": "matheusbvieira@gmail.com",
    "telefone": "48991444466",
    "sexo": "MASCULINO",
    "dataNascimento": "30/11/2000"
}
```

## POST - Autenticação
```javascript
{
	"email" : "admin@email.com",
	"senha": "123456"
}
```
