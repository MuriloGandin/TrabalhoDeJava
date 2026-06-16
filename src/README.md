Integrantes: Erick, Clara Pujol, Murilo Gandin
Tema: RPG de aventura

#### A fazer: (Marcar ❌✅)
- Adicionar lógica de turnos ✅
- Menus (interatividade) ✅
- Lógica de ondas ❌
- Adicionar telas (Apresentação do jogo, Fim de jogo, Tela de vitória) ✅
- Equipamentos ❌
- Inventário ✅
- Separar MVC corretamente ✅
- Modularizar métodos e funções ❌
- Modos de obter itens ✅
- Progressão de jogador ✅
- Remover Comentários ❌

#### Requisitos a fazer: 
 - CRUD

# Informações gerais sobre o projeto

# Informações sobre as classes e suas relações

## Camada Model
> Responsável pela definição estrutural das classes e seus métodos e atributos principais

* ### Interface Combatente
    Esta interface define quais entidades participarão ativamente dos combates, permitindo que elas possam atacar e mostrar dados e estatísticas de combate.

* ### Classe Abstrata Entidade
    Define atributos e métodos essenciais para o jogador e os inimigos, como pontos de vida, dano e nome (que são atributos comuns entre Personagem e Inimigo)

* ### Classe Inimigo
    Os inimigos são os antagonistas principais do jogo, eles atacam o jogador, podendo derrota-lo, mas deixam recompensas em diamantes quando derrotados. Os inimigos existentes e em qual onda aparecem são definidos pelos bancos de dados.

* ### Classe Item
...
* ### Classe Onda
...
* ### Classe Personagem
...
* ### inimigos.txt + inimigoCRUD
...


## Camada View
> Camada responsável pelos feedbacks visuais e interações diretas com o usuário (Como prints no terminal)
* ### Classe Sistema
    O sistema é o coração do jogo, contendo o fluxo principal de métodos e funções que são executadas assim que o jogo se inicia.

* ### Classe InputHelper
* ### Classe RodadasView
* ### Classe OutputHelper

## Camada Controller

## Módulo Log


# Como executar o projeto

# Uso de IA
As IAs Claude, Gemini e ChatGPT foram utilizadas para fornecer ideias de estruturas de classes, tema e relações entre as camadas MVC, além de terem tirado dúvidas sobre a utilização de ferramentas como Git e bibliotecas como Iterator.

# Referências
Site para criação de ASCII arts a partir de texto: https://patorjk.com/software/taag/
