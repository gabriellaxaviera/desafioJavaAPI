#Desafio Concrete Solutions - Java 

##API RESTful de criação de usuários e login

#### Todos os endpoints abaixo estão disponiveis em: 
https://desafio-java-api-gabriella.herokuapp.com/


- Endpoint /cadastro:

Método POST

Deve receber o seguinte body:

    {
        "name": "João da Silva",
        "email": "joao@silva.org",
        "password": "hunter2",
        "phones": [
            {
                "number": "987654321",
                "ddd": "21"
            }
        ]
    }
    
Observando que, um ou mais números de telefone devem estar no mesmo formato que o do exemplo acima.
  
Retornos:
> 201 Created: retorna as informações passadas, acrescido de id, token, last_login, last_modified e created 

> 403 Forbidden: informa que o usuário já está cadastrado, no seguinte padrão:
 
    {"mensagem": "Usuário já cadastrado"}


- Endpoint /login
  
 Método POST
 
 Deve receber o seguinte body:
 
        {
            "email": "joao@silva.org",
            "password": "hunter2"
        }
        
 Retornos:
 > 202 Acepted: retorna as mesmas informações do endpoint de criação 
 
 > 401 Unauthorized: Caso a senha passada esteja incorreta, informa ao usuário no seguinte padrão:
  
     {"mensagem": "Usuário e/ou senha inválidos"}
     
  > 404 Not Found: Caso o e-mail passado não exista, informa ao usuário no seguinte padrão:
   
      {"mensagem": "Usuário e/ou senha inválidos"}
      
- Enpoint /userprofile/{id}
 
Método GET

> Recebe no header da requisição o Token do usuário, informado no cadastro
Recebe no path da requisição o id do usuário, também informado no cadastro

Retornos:

> 202 Acepted: retorna as mesmas informações do endpoint de criação 
 
> 401 Unauthorized: Caso o token passado não exista, informa ao usuário no seguinte padrão:
  
     {"mensagem": "Não autorizado"}
     
> 401 Unauthorized: Caso o token exista mas não seja correspondente ao usuário com id passado no path, informa ao usuário no seguinte padrão:
   
      {"mensagem": "Não autorizado"}
 
 > 401 Unauthorized: Caso o token exista e seja correspondente ao usuário mas o último login tenha sido a mais de 30 minutos, informa ao usuário no seguinte padrão:
    
       {"mensagem": "Sessão Inválida"}
       
- Outros retornos:

> 415 UNSUPPORTED_MEDIA_TYPE: Caso no body não seja passado um JSON


> 400 BAD_REQUEST: Caso o id e token não estejam no padrão UUID