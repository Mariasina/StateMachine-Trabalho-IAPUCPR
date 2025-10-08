# Máquina de Estados — Jonas & Manny

Trabalho I — Inteligência Artificial e Ilusão de Inteligência em Jogos  
Prof.ª: Marina de Lara  
Disciplina: Inteligência Artificial e Ilusão de Inteligência em Jogos  
Equipe: Caio Roque, Felipe Charello e Maria Carolina 
Data de entrega: 08/10/2025  

---

## Objetivo
Este projeto implementa uma máquina de estados com dois agentes inteligentes — Jonas e Manny — que alternam entre diferentes comportamentos de forma autônoma.
O trabalho segue o padrão State, utilizando os métodos `enter()`, `execute()` e `exit()` para controlar os ciclos de vida dos agentes e suas transições determinísticas baseadas em variáveis internas.

---

## Agentes

### Agente A — Jonas
Seus comportamentos são representados por dois estados principais:

- Playing (Jogando): Jonas se diverte jogando videogame, acumulando sujeira a cada ciclo.  
- Showering (Tomando banho): Quando atinge um nível crítico de sujeira, Jonas vai tomar banho até ficar limpo, voltando em seguida a jogar.

Transições principais:
- `Playing → Showering` quando `dirty >= 30`
- `Showering → Playing` quando `dirty <= 0`

---

### Agente B — Manny
Ele possui três estados que se alternam de acordo com seu progresso e cansaço:

- Painting (Pintando): Produz quadros e aumenta seu contador de pinturas.  
- Resting (Descansando): Recupera energia após pintar ou limpar.  
- Cleaning (Limpando): Quando o estúdio está bagunçado, Manny realiza a limpeza e depois descansa.

Transições principais:
- `Painting → Resting` quando `paintCount == 2`
- `Painting → Cleaning` quando `paintCount == 3`
- `Resting → Painting` quando `restTime <= 0`
- `Cleaning → Resting` quando `cleanTime <= 0`

---

## Estrutura do Projeto
```
📦 maquina-de-estados
├── 📁 src/
│   └── AbstractState.java
│   ├── Agente.java
│   ├── Cleaning.java
│   ├── Jonas.java
│   ├── Main.java
│   ├── Manny.java
│   ├── Painting.java
│   ├── Playing.java
│   ├── Resting.java
│   ├── Showering.java
│   ├── State.java
│   ├── StateMachine.java
├── 📁 docs/
│   └── Trabalho_Maquina_de_Estados.pdf
└── README.md

```
---

## Como Compilar e Executar

1. Clonar o repositório:
   ```bash
   git clone https://github.com/seu-usuario/maquina-de-estados.git
   cd maquina-de-estados/src

2. Compilar os arquivos Java:
    javac *.java

3. Executar o programa:

---

## Exemplo de Saída (Logs)

Jonas: Hora de jogar!
Jonas | Sujeira: 0

Manny - Hora de pintar!
Manny - Manny: Pintando...
Manny - Manny | Quadros: 0

Jonas: Jogando...
Jonas | Sujeira: 5

Jonas: Jogando...
Jonas | Sujeira: 10

Jonas: Hora de tomar banho!
Jonas | Sujeira: 30
Jonas: Tomando banho...
Jonas | Sujeira: 25
Jonas: Já estou limpo!
Jonas: Hora de jogar!

Manny - Tudo limpo!
Manny - Indo descansar...

---

## Lógica de Transição 
| Agente    | Estado    | Ação de Entrada         | Execução              | Transição                                  |
| --------- | --------- | ----------------------- | --------------------- | ------------------------------------------ |
| **Jonas** | Playing   | "Hora de jogar!"        | Sujeira aumenta +5    | Sujeira ≥30 → Showering                    |
| **Jonas** | Showering | "Hora de tomar banho!"  | Sujeira diminui -5    | Sujeira ≤0 → Playing                       |
| **Manny** | Painting  | "Hora de pintar!"       | Contador de quadros ↑ | 2 quadros → Resting / 3 quadros → Cleaning |
| **Manny** | Cleaning  | "Começando a limpar..." | Tempo de limpeza ↓    | Limpeza completa → Resting                 |
| **Manny** | Resting   | "Indo descansar..."     | Tempo de descanso ↓   | Tempo zerado → Painting                    |


