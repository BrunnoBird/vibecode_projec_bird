# Task 005 - Implement Mvi Baseline In Core Common

## Objetivo
Criar a baseline MVI reutilizável em `core:common`.

## Contexto
- O projeto precisa padronizar `Intent`, `UiState`, `Effect` e `ViewModel`

## Entradas
- Estrutura do módulo `core:common`

## Saídas esperadas
- Contratos base
- `MviViewModel` leve
- Helpers mínimos para coroutines/dispatchers

## Dependências
- `task-002-create-core-module-structure.md`

## Restrições
- Não criar framework interno pesado
- Manter legibilidade e testabilidade

## Critérios de conclusão
- [ ] A baseline MVI compila e é reutilizável
- [ ] `feature:home` consegue consumir a estrutura

## Escopo para o agente
Implementar apenas a infraestrutura mínima necessária para MVI.
