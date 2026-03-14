# Task 006 - Setup Navigation Shell In App

## Objetivo
Criar o shell de navegação inicial no módulo `app`.

## Contexto
- A navegação ficará centralizada no `app`
- `core:navigation` manterá apenas contratos mínimos

## Entradas
- `core:navigation`
- `feature:home`

## Saídas esperadas
- `NavHost`
- destino inicial Home
- composition root simples

## Dependências
- `task-003-create-feature-home-module.md`
- `task-004-extract-compose-theme-to-core-designsystem.md`

## Restrições
- Sem rotas adicionais além da Home
- Sem framework de DI

## Critérios de conclusão
- [ ] O app abre na Home
- [ ] O `app` faz o wiring manual do `ViewModel`

## Escopo para o agente
Implementar somente o shell de navegação e o wiring do app.
