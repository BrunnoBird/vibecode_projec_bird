# Project Bootstrap Spec

## 1. Análise da feature
O bootstrap entrega a fundação técnica do app Android, com foco em previsibilidade estrutural. O escopo cobre build multi-module, baseline de UI com Compose e Material 3, baseline MVI com `ViewModel`, navegação inicial e testes unitários mínimos.

A entrega não inclui backend, persistência real, analytics, autenticação nem modelagem de domínio. O objetivo é reduzir o custo da próxima feature sem antecipar abstrações que ainda não têm uso concreto.

## 2. Arquitetura proposta
- Modularização por responsabilidade
- Compose + Material 3 para UI
- MVI por tela com `Intent`, `UiState` e `Effect`
- `ViewModel` como orquestrador de estado
- DI manual via composition root no `app`
- Navegação centralizada no `app` com rotas mínimas em `core:navigation`

Fluxo base:
1. A tela dispara um `Intent`
2. O `ViewModel` reduz o intent para novo estado
3. A UI observa `StateFlow`
4. Efeitos únicos ficam disponíveis via `SharedFlow`

## 3. Estrutura de módulos
- `:app`
- `:core:common`
- `:core:ui`
- `:core:designsystem`
- `:core:navigation`
- `:core:data`
- `:core:testing`
- `:feature:home`

Relações principais:
- `:app` depende de `:core:designsystem`, `:core:navigation`, `:feature:home`
- `:feature:home` depende de `:core:common`, `:core:ui`, `:core:data`
- `:core:ui` depende de `:core:common` e `:core:designsystem`
- `:core:testing` é consumido apenas em `testImplementation`

## 4. Organização de pacotes
Base package: `com.example.vibecodeprojecbird`

Convenções:
- módulos core usam `com.example.vibecodeprojecbird.core.*`
- features usam `com.example.vibecodeprojecbird.feature.<name>`
- cada feature concentra apresentação em `presentation/`
- cada tela expõe `Contract`, `ViewModel` e `Screen`

## 5. Dependências principais
- AGP + Kotlin + Gradle Kotlin DSL
- Compose BOM
- Activity Compose
- Lifecycle Runtime e ViewModel
- Navigation Compose
- Material 3
- JUnit 4
- Coroutines Test
- utilitário compartilhado em `core:testing`

## 6. Skills reutilizáveis
- `bootstrap-android-project`
  - revisada para refletir modularização final e DI manual
- `create-compose-mvi-screen`
  - gera `Contract`, `ViewModel`, `Screen` e teste base
- `create-android-module`
  - gera módulo aderente ao padrão do projeto
- `write-viewmodel-unit-tests`
  - padroniza testes de `ViewModel` com coroutines

## 7. Especificação técnica completa
Build:
- substituir os módulos genéricos `:core` e `:features` por módulos aninhados
- consolidar dependências no version catalog
- manter configuração comum simples por módulo

UI:
- mover o tema Compose para `:core:designsystem`
- expor `ProjectTheme`
- manter tema simples e aderente ao Material 3

MVI:
- criar contratos `UiIntent`, `UiState`, `UiEffect`
- criar `MviViewModel` leve com `StateFlow` e `SharedFlow`
- evitar framework interno complexo

Navegação:
- `app` contém o `NavHost`
- `core:navigation` contém os destinos
- `feature:home` expõe a tela inicial

Dados:
- `core:data` existe desde o bootstrap
- contém apenas infraestrutura mínima compartilhada
- nenhum backend, persistência ou fake repository de produto

Testes:
- validar estado inicial da Home
- validar transição de estado ao processar intent
- prover `MainDispatcherRule` em `core:testing`

## 8. Quebra da implementação em tasks pequenas
- `task-001-restructure-gradle-and-settings.md`
- `task-002-create-core-module-structure.md`
- `task-003-create-feature-home-module.md`
- `task-004-extract-compose-theme-to-core-designsystem.md`
- `task-005-implement-mvi-baseline-in-core-common.md`
- `task-006-setup-navigation-shell-in-app.md`
- `task-007-add-core-data-minimal-infra.md`
- `task-008-implement-home-screen-viewmodel-contract.md`
- `task-009-add-unit-test-baseline.md`
- `task-010-verify-bootstrap-acceptance.md`

## 9. Ordem de execução
1. Gradle e settings
2. Estrutura dos módulos core
3. Estrutura do módulo `feature:home`
4. Tema em `core:designsystem`
5. Baseline MVI em `core:common`
6. Infra mínima em `core:data`
7. Shell de navegação no `app`
8. Home screen + `ViewModel` + `Contract`
9. Testes unitários
10. Verificação final

## 10. Riscos técnicos e decisões importantes
Riscos:
- overengineering na modularização
- boilerplate excessivo na baseline MVI
- `core:data` ficar genérico demais

Decisões:
- DI manual no bootstrap
- Material 3 quase puro
- sem camada domain dedicada nesta fase
- Home usada apenas como shell técnico
