# Android Kotlin Compose SSD + Codex Starter

Este starter kit inicia um projeto Android com:

- Kotlin
- Jetpack Compose
- Material Design 3
- Arquitetura MVI
- ViewModel
- Testes unitarios
- Modularizacao
- Fluxo SSD (Specification-Driven Development)
- Agentes e skills com Codex

## Objetivo

Manter um fluxo SSD padronizado com base em contratos de agentes, prompts reutilizaveis e skills.

## Fluxo SSD adotado

`Board -> PRB/PRD -> PLAN -> Spec -> Tasks -> Coder -> Reviewer -> Tester -> Aceite`

## Documentacao IA

Guia principal em partes:
- `DOCS/IA_GUIDE_STUDY/README.md`

## Ordem sugerida de uso

1. Leia `ai/AGENT_START.md`
2. Leia `ai/00-governance/*`
3. Leia `ai/02-context/*`
4. Gere PRB/PRD local em `ai/01-product/_work/` (nao versionado)
5. Gere spec local em `ai/03-specs/_work/` (nao versionado)
6. Gere tasks locais em `ai/04-tasks/_work/` (nao versionado)
7. Execute prompts oficiais em `ai/07-prompts/`
8. Registre handoffs/evals em `_runs`

## Repositorio versiona somente padroes

- contratos de agentes
- governanca e contexto
- skills
- prompts reutilizaveis
- templates oficiais de handoff/eval

Arquivos de historia ativa ficam em `_work` e nao devem ser mergeados.
