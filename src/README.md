<h1 align="center">⚔️ NullPointer Quest — RPG em Java</h1>

**Integrantes:** Erick, Clara Pujol, Murilo Gandin  
**Tema:** RPG de aventura


#### A fazer:
- Remover Comentários 

### O que cada um irá falar
- InimigoController: Erick
- ItemController: Murilo
- Log: Erick
- OndaController: Clara
- PersonagemController: Murilo
- RodadasController: Murilo
- SaveController: Clara
---
- Combatente: Clara
- Entidade: Clara
- Inimigo: Erick 
- Item: Murilo
- Loja: Murilo
- Onda: Erick
- Personagem: Erick
---
- InputHelper/OutputHelper: Murilo
- LojaView: Murilo
- OndaView: Clara
- PersonagemView: Erick
- RodadasView: Clara
- SaveView: Clara
- Sistema: Clara, Erick e Murilo

# Informações gerais sobre o projeto


## 🗂️ Informações sobre as Classes

### Camada Model
> Responsável pela definição estrutural das classes e seus atributos e métodos principais.

**Interface Combatente**
Define quais entidades participam ativamente dos combates, permitindo que possam atacar, recuperar vida e exibir dados de combate.

**Classe Abstrata Entidade**
- Define atributos e métodos essenciais compartilhados entre `Personagem` e `Inimigo`, como pontos de vida, dano e nome.

**Classe Inimigo**
- Os inimigos são os antagonistas principais do jogo. Atacam o jogador e podem derrotá-lo, mas deixam recompensas em diamantes quando derrotados. Os inimigos existentes e em qual onda aparecem são definidos pelo banco de dados `inimigos.txt`.

**Classe Item**
- Representa os itens do jogo, podendo ser consumíveis (cura, força) ou equipáveis (arma, armadura). Cada item tem id, nome, tipo, valor de efeito e preço.

**Classe Onda**
- Agrupa uma lista de inimigos que aparecem juntos em um mesmo momento do jogo.

**Classe Personagem**
- O herói controlado pelo jogador. Possui inventário, diamantes, equipamento, armadura e dano extra temporário. Herda de `Entidade` e tem lógica própria de receber dano (considerando armadura) e atacar (considerando equipamento).

**`inimigos.txt` + `InimigoController`**
Banco de dados em texto que armazena os inimigos disponíveis no formato `nome,hp,dano,ataquesParaEspecial,moedasMin,moedasMax,tipoAtaqueEspecial`. O `InimigoController` faz a leitura, conversão e operações de CRUD.

---

### Camada View
> Responsável pelos feedbacks visuais e interações diretas com o usuário.

**Classe Sistema**
O coração do jogo. Contém o fluxo principal de métodos executados ao iniciar, incluindo montagem das ondas, menu inicial, criação do personagem e orquestração geral.

**Classe InputHelper**
Utilitário para leitura de entradas do terminal. Valida tipos de dados e repete a leitura em caso de entrada inválida.

**Classe OutputHelper**
Responsável por toda a saída formatada no terminal: impressão gradual, colorida, com suporte às cores vermelho, verde, amarelo, azul e ciano.

**Classe RodadasView**
Exibe o menu de rodada, feedback de inimigos derrotados e ganho de diamantes.

**Classe LojaView**
Menu completo de loja com compra e venda de itens usando diamantes.

**Classe PersonagemView**
Exibe o inventário do jogador e permite usar ou equipar itens.

**Classe SaveView**
Gerencia o menu de save e load, e o fluxo de salvar entre ondas.

---

### Camada Controller
> Responsável pela lógica de negócio e intermediação entre Model e View.

**InimigoController** — CRUD de inimigos, execução do turno dos inimigos e sorteio de moedas.  
**ItemController** — Carrega os itens do arquivo `Itens.txt`.  
**PersonagemController** — Processa as ações do jogador (atacar, defender, usar item) e lógica de compra.  
**RodadasController** — Controla o fluxo de rodadas, remoção de inimigos derrotados e encerramento do combate.  
**SaveController** — Serialização: salva e carrega o `Personagem` em `save.dat`.

---

### Módulo Log
Registra todos os eventos relevantes do jogo (ataques, saves, encerramentos) em `data/log.txt` com data e hora no formato `dd/MM/yyyy HH:mm:ss`.

---

## 🚀 Como Executar

```bash
# Compilar (na pasta raiz do projeto)
mkdir out
javac -d out -sourcepath src src/Main.java

# Executar
java -cp out Main
```

> A pasta `data/` deve existir antes de rodar. Crie-a manualmente se necessário.

---

## 🤖 Uso de IA
As IAs Claude, Gemini e ChatGPT foram utilizadas para fornecer ideias de estruturas de classes, tema e relações entre as camadas MVC, além de terem tirado dúvidas sobre a utilização de ferramentas como Git e bibliotecas como `Iterator`.

---

## 📚 Referências
- Criação de ASCII arts a partir de texto: https://patorjk.com/software/taag/
