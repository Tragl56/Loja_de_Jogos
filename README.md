# Loja_de_Jogos

 API para os jogadores 

- Categorias
    - [Jogos](#listar-todas)
    - [Categoria](#detalhar-categorias)
    - [Cadastrar](#cadastrar-categoria)
    - [Apagar](#apagar-categoria)
    - [Editar](#editar-categoria)

- Movimentações
---


 ### Jogos

`GET` /categoria

retorna um array com todas as categorias.

**Exemplo de Resposta**

```js
[
  {
      "id":1,
      "nome":"Jogos",
      "icone"Game"
  }
]
```
| código | descrição |
|--------|-----------|
|200|Dados retornados com sucesso
---

### Detalhar Categorias 

`GET` /categoria/{id}

Retornar os dados da categoria com o `id` informado.

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
|404| Id da categoria não encontrado

___

### Cadastrar Categoria

`POST` /categoria

Insere uma nova categoria.

**Corpo da Requisição** 

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|Um nome curto para a categoria
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
|201|Categoria criada com sucesso
|400|Erro de validação - verifique o corpo da requisição

---

### Apagar Categoria

`DELETE` /categoria/{id}

Apaga a categoria com o `id` informado.

**Códigos de Status** 

| código | descrição |
|--------|-----------|
|204|Categoria apagada com sucesso
|404| Id da categoria não encontrado

___

### Editar Categoria

`PUT` /categoria/{id}

Atualiza os dados da categoria com o `id` informado.

**Corpo da Requisição** 

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|Um nome curto para a categoria
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
|200|Categoria atualizada com sucesso
|400| A validação falhou - verifique o corpo da requisição
|404| Id da categoria não encontrado

 
