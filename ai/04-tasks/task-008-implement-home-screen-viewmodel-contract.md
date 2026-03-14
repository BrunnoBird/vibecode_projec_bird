# Task 008 - Implement Home Screen ViewModel Contract

## Objetivo
Implementar `HomeContract`, `HomeViewModel` e `HomeScreen`.

## Contexto
- A Home é a primeira tela técnica do projeto
- Deve demonstrar o padrão MVI e a renderização Compose

## Entradas
- `core:common`
- `core:ui`
- `core:data`

## Saídas esperadas
- `HomeContract.kt`
- `HomeViewModel.kt`
- `HomeScreen.kt`

## Dependências
- `task-003-create-feature-home-module.md`
- `task-004-extract-compose-theme-to-core-designsystem.md`
- `task-005-implement-mvi-baseline-in-core-common.md`
- `task-007-add-core-data-minimal-infra.md`

## Restrições
- Sem regra de negócio real
- Somente estado e interação simples

## Critérios de conclusão
- [ ] Home usa a baseline MVI
- [ ] A tela renderiza estado inicial e reage a um intent simples

## Escopo para o agente
Implementar apenas a shell técnica da Home.
