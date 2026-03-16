# Context Disclosure — Base Global

> Este arquivo descreve a stack compartilhada por todos os sub-projetos em `app/`.
> Agents devem sempre complementar esta leitura com:
> `app/<sub-projeto-alvo>/ai/context-disclosure.md`
> Em caso de conflito, o context-disclosure do sub-projeto prevalece.
## Plataforma
- Android

## Linguagem
- Kotlin

## UI
- Jetpack Compose
- Material Design 3

## Arquitetura
- MVI

## Estado
- UIState imutável
- Intent para eventos
- Effect para eventos únicos

## Navegação
- Navigation Compose

## Estrutura
- projeto modular

## Testes
- testes unitários obrigatórios para lógica crítica