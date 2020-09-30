# Desafio Java - API

Cadastro
Esse endpoint deverá receber um usuário com os campos "nome", "email", "senha", mais uma lista de objetos "telefone", seguindo o formato abaixo:
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


Login
Este endpoint irá receber um objeto com e-mail e senha.

Perfil do Usuário
Caso o token não exista, retornar erro com status apropriado com a mensagem "Não autorizado".
Caso o token exista, buscar o usuário pelo id passado no path e comparar se o token no modelo é igual ao token passado no header.
Caso não seja o mesmo token, retornar erro com status apropriado e mensagem "Não autorizado"
Caso seja o mesmo token, verificar se o último login foi a MENOS que 30 minutos atrás. Caso não seja a MENOS que 30 minutos atrás, retornar erro com status apropriado com mensagem "Sessão inválida".
Caso tudo esteja ok, retornar o usuário no mesmo formato do retorno do Login.
