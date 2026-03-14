# Task 002 - Create Core Module Structure

## Objetivo
Criar a árvore `core:common`, `core:ui`, `core:designsystem`, `core:navigation`, `core:data` e `core:testing`.

## Contexto
- A estrutura atual usa um módulo `:core` genérico
- O bootstrap precisa de separação por responsabilidade

## Entradas
- Configuração Gradle final da task 001

## Saídas esperadas
- Build files dos módulos core
- Manifestos mínimos
- Pacotes base coerentes

## Dependências
- `task-001-restructure-gradle-and-settings.md`

## Restrições
- Evitar abstrações de domínio ou dados sem uso concreto
- Criar apenas o mínimo estrutural

## Critérios de conclusão
- [ ] Todos os módulos core existem e compilam
- [ ] Relações entre módulos estão coerentes

## Escopo para o agente
Criar apenas a estrutura base dos módulos core e suas dependências.
