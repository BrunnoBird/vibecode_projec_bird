# Android Kotlin Compose SDD + Codex Starter

Este starter kit foi criado para iniciar um projeto Android com:

- Kotlin
- Jetpack Compose
- Material Design 3
- Arquitetura MVI
- ViewModel
- Testes unitários
- Arquitetura modular
- Fluxo SDD (Specification-Driven Development)
- Uso de agentes e skills com Codex

## Objetivo inicial

A primeira entrega deste projeto é **montar toda a estrutura base do projeto** para permitir evolução segura das próximas features.

## Fluxo sugerido

1. Leia `ai/00-governance/*`
2. Leia `ai/02-context/*`
3. Leia o PRD em `ai/01-product/prd-bootstrap-project.md`
4. Leia a spec em `ai/03-specs/technical-spec-bootstrap-project.md`
5. Execute as tasks em `ai/04-tasks/`
6. Use os prompts prontos em `ai/07-prompts/`

## Ordem recomendada para o Codex

1. `task-001-bootstrap-gradle-setup.md`
2. `task-002-create-modules.md`
3. `task-003-core-designsystem-and-theme.md`
4. `task-004-core-architecture-mvi.md`
5. `task-005-app-navigation-and-home-shell.md`
6. `task-006-unit-test-baseline.md`

## Módulos alvo da estrutura inicial

- `app`
- `core:designsystem`
- `core:common`
- `core:ui`
- `core:testing`
- `core:navigation`
- `feature:home`

## Resultado esperado após o bootstrap

- Projeto compilando
- Navegação inicial funcionando
- Tema Material 3 configurado
- Estrutura MVI base pronta para reuso
- Primeira feature (`feature:home`) conectada
- Testes unitários base configurados
- Convenções do projeto documentadas
