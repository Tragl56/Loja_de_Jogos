# Loja_de_Jogos

 API para os jogadores 

- Categorias
    - [Jogos](#jogos)
    - [Categoria](#categorias)
    - [Cadastrar](#cadastrar-jogo)
    - [Apagar](#apagar-jogo)
    - [Editar](#editar-jogo)

- Movimentações
---


 ### Jogos

`GET` /JOGO

retorna um array com todas as jogos.

**Exemplo de Resposta**

```js
[
  {
      "id":1,
      "nome":"Jogos",
      "icone":"Game"
  }
]
```
| código | descrição |
|--------|-----------|
|200|Dados retornados com sucesso
---

### Categorias 

`GET` /JOGO/{id}

Retornar os dados do jogo com o `id` informado.

**Exemplo de Resposta** 

```js

    {
        "id": 1,
        "nome": "Jogo",
        "icone": "Game"
    }

```

**Códigos de Status** 

| código | descrição |
|--------|-----------|
|200|Dados retornados com sucesso
|404| Id do jogo não encontrado

___

### Cadastrar Jogo

`POST` /JOGO

Insere um novo Jogo.

**Corpo da Requisição** 

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|Um nome curto para o jogo
|icone|string|❌|O nome do ícone conforme Material Icons


```js
{
    "nome": "Jogo",
    "icone": "Game"
}
```

**Exemplo de Resposta** 

```js
{
    "id": 1,
    "nome": "jogo",
    "icone": "Game"
}
```

**Códigos de Status** 

| código | descrição |
|--------|-----------|
|201|Jogo criada com sucesso
|400|Erro de validação - verifique o corpo da requisição

---

### Apagar JOGO

`DELETE` /JOGO/{id}

Apaga o jogo com o `id` informado.

**Códigos de Status** 

| código | descrição |
|--------|-----------|
|204|Jogo apagada com sucesso
|404| Id da categoria não encontrado

___

### Editar jogo

`PUT` /JOGO/{id}

Atualiza os dados da categoria com o `id` informado.

**Corpo da Requisição** 

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|Um nome curto para o jogo
|icone|string|✅|O nome do ícone conforme Material Icons


```js
{
    "nome": "Jogo",
    "icone": "Game"
}
```

**Exemplo de Resposta** 

```js
{
    "id": 1,
    "nome": "Jogo",
    "icone": "Game"
}
```

**Códigos de Status** 

| código | descrição |
|--------|-----------|
|200|Jogo atualizada com sucesso
|400| A validação falhou - verifique o corpo da requisição
|404| Id do jogo  não encontrado
