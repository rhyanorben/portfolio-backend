# Modelagem da API REST - Serviço de Armazenamento

## Casos de Uso

1. **Gerenciar Arquivos**: Permitir que os usuários façam upload, download, listagem e exclusão de arquivos.
2. **Gerenciar Pastas**: Permitir que os usuários criem, renomeiem e excluam pastas para organizar seus arquivos.

## Recursos

- **arquivos**
- **pastas**

## Endpoints

### 1. Recursos: Arquivos

| Descrição                        | URI                                   | Método HTTP | Corpo                                              | Resposta Esperada            | Erros Esperados                     |
|----------------------------------|---------------------------------------|-------------|----------------------------------------------------|-------------------------------|--------------------------------------|
| Retornar um arquivo              | GET /arquivos/{arquivo-id}           | GET         | Vazio                                              | 200 OK                        | 404 Not Found - arquivo não encontrado. |
| Fazer upload de um arquivo       | POST /arquivos                       | POST        | { "nome": "arquivo.txt", "conteudo": "conteudo do arquivo" } | 201 Created                   | 400 Bad Request - dados inválidos.    |
| Atualizar um arquivo             | PUT /arquivos/{arquivo-id}           | PUT         | { "nome": "arquivo_atualizado.txt", "conteudo": "novo conteudo" } | 200 OK                        | 404 Not Found - arquivo não encontrado. |
| Deletar um arquivo               | DELETE /arquivos/{arquivo-id}        | DELETE       | Vazio                                              | 204 No Content                | 404 Not Found - arquivo não encontrado. |
| Listar todos os arquivos         | GET /arquivos                        | GET         | Vazio                                              | 200 OK, [ { "id": 1, "nome": "arquivo1.txt" }, ... ] | 500 Internal Server Error - erro no servidor. |

### 2. Recursos: Pastas

| Descrição                        | URI                                   | Método HTTP | Corpo                                              | Resposta Esperada            | Erros Esperados                     |
|----------------------------------|---------------------------------------|-------------|----------------------------------------------------|-------------------------------|--------------------------------------|
| Retornar uma pasta               | GET /pastas/{pasta-id}               | GET         | Vazio                                              | 200 OK                        | 404 Not Found - pasta não encontrada. |
| Criar uma nova pasta             | POST /pastas                         | POST        | { "nome": "Nova Pasta" }                          | 201 Created                   | 400 Bad Request - dados inválidos.    |
| Atualizar uma pasta              | PUT /pastas/{pasta-id}               | PUT         | { "nome": "Pasta Atualizada" }                    | 200 OK                        | 404 Not Found - pasta não encontrada. |
| Deletar uma pasta                | DELETE /pastas/{pasta-id}            | DELETE       | Vazio                                              | 204 No Content                | 404 Not Found - pasta não encontrada. |
| Listar todas as pastas          | GET /pastas                         | GET         | Vazio                                              | 200 OK, [ { "id": 1, "nome": "pasta1" }, ... ] | 500 Internal Server Error - erro no servidor. |
