---
name: bootstrap-android-project
description: Cria a base de um projeto Android modular com Kotlin, Compose, Material 3, MVI, ViewModel e testes unitários.
---

# Objetivo
Transformar um template Android inicial em uma base modular, previsível e testável para futuras features.

# Quando usar
- Início de um novo projeto Android
- Reestruturação de um projeto Android ainda sem arquitetura consolidada

# Entradas esperadas
- Nome do projeto
- Estrutura modular desejada
- Stack obrigatória
- Restrições arquiteturais do bootstrap

# Saídas esperadas
- Módulos `app`, `core:*` e `feature:*`
- Build scripts coerentes
- Tema compartilhado em `core:designsystem`
- Baseline MVI em `core:common`
- Navegação inicial no `app`
- Baseline de testes em `core:testing`

# Regras
- Preferir DI manual no bootstrap
- Não criar camadas de domain/data por feature sem uso real
- Não criar design system complexo
- Garantir compilação, clareza estrutural e testabilidade
