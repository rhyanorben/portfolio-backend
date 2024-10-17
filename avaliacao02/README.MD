# Projeto em Java Spring Boot 17.0

## Início da Aplicação

Para iniciar a aplicação, siga o passo abaixo:

- Selecione o arquivo `Avaliacao02Application.java` e execute-o no interpretador.

## Estrutura de Páginas

A aplicação roda na porta `8080`, e a URL raiz é:

- **[http://localhost:8080](http://localhost:8080)**

### Endpoints Disponíveis

#### `/sobre` (GET)
- Retorna o nome completo do estudante e o nome do projeto.

#### `/partidas`
- **`/{id}` (GET):** Retorna somente a partida selecionada ao informar o ID da partida.
- **`/andamento` (GET):** Retorna todas as partidas de futebol que estão em andamento no momento.
    - Parâmetros opcionais (podem ser usados separadamente ou em conjunto):
        - `idLiga={id}`: Retorna as partidas em andamento de uma liga específica.
        - `idTime={id}`: Retorna as partidas em andamento de um time específico.
- **`/favoritas` (GET):** Retorna apenas as partidas que foram setadas como favoritas.

#### `/ligas` (GET)
- Parâmetro obrigatório:
    - `nome={nomeLiga}`: Informa o nome da liga que está buscando e traz os dados de todas as ligas que possuem este nome. É utilizado para permitir a busca de partidas em andamento de uma liga específica pelo ID.

#### `/times` (GET)
- Parâmetro obrigatório:
    - `nome={nomeTime}`: Informa o nome do time que está buscando e traz os dados de todos os times que possuem este nome. É utilizado para permitir a busca de partidas em andamento de um time específico pelo ID.

#### `/partidas/{id}/favorita` (POST)
- Adiciona uma partida como favorita, iterando-a sobre uma lista que contém apenas as partidas marcadas como favoritas.
