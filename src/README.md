Integrantes: Erick, Clara Pujol, Murilo Gandin
Tema: RPG de aventura

### *prioridade: sistema básico do jogo*
- como é o combate?
- > O combate será baseado em turnos. O jogador será apresentado com um menu de opções descrevendo suas possíveis ações.
- como o jogador interage com o jogo?
- > O jogador poderá participar de batalhas (escolhendo como agir a cada turno), e deverá escolher como agir a cada turno. Além de administrar um inventário pessoal, usando, equipando e descartando itens que podem afetar os resultados das batalhas.
- o que o jogador pode fazer?

#### A fazer: (Marcar ❌✅)
- Adicionar lógica de turnos ✅
- Menus (interatividade) ❌
- Lógica de ondas ❌
- Adicionar telas (Apresentação do jogo, Fim de jogo, Tela de vitória) ❌
- Tipos de ataque / equipamentos ❌
- Inventário ❌
- Separar MVC corretamente ❌
- Modularizar métodos e funções ❌
- Modos de obter itens ❌
- Lógica de níveis ❌
- Progressão de jogador ❌
- Remover Comentários ❌

#### Requisitos a fazer: 
 - CRUD
 - Log
 - Serialização - salvar progresso de um único jogador, criar um txt novo para salvar isso.

# Informações gerais sobre o projeto

# Informações sobre as classes e suas relações

## Camada Model
> Responsável pela definição estrutural das classes e seus métodos e atributos principais

* ### Interface Combatente
...
* ### Classe Abstrata Entidade
...
* ### Classe Inimigo
...
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
