# Task 004 - Extract Compose Theme To Core Designsystem

## Objetivo
Mover o tema Compose do `app` para `core:designsystem`.

## Contexto
- O template atual mantém o tema dentro do módulo `app`
- O bootstrap precisa tornar o tema compartilhável

## Entradas
- Tema atual do app

## Saídas esperadas
- `ProjectTheme` em `core:designsystem`
- Tokens mínimos de cor e tipografia

## Dependências
- `task-002-create-core-module-structure.md`

## Restrições
- Não criar um design system complexo
- Reusar o Material 3 como base

## Critérios de conclusão
- [ ] O app consome o tema a partir de `core:designsystem`
- [ ] A Home renderiza com o tema compartilhado

## Escopo para o agente
Mover apenas os elementos necessários para um tema compartilhado funcional.
