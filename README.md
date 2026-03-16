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
- Suporte a Multi-Projeto (estrutura separada por responsabilidade)

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
4. Defina o sub-projeto com `Projeto alvo:` nos prompts
5. Gere PRB/PRD local em `ai/01-product/_work/` (rascunho, nao versionado)
6. Gere spec e tasks locais em `ai/03-specs/_work/` e `ai/04-tasks/_work/`
7. Execute prompts oficiais em `ai/07-prompts/`
8. Se aprovado, promova PRD para `ai/01-product/history/` (versionado)

## Repositorio versiona somente padroes

- contratos de agentes
- governanca e contexto (global e por sub-projeto)
- skills
- prompts reutilizaveis
- documentacao viva (PRDs aprovados em `ai/01-product/history/`)

Arquivos de historia ativa (specs, tasks, PRD em rascunho) ficam em `_work` e nao devem ser mergeados.
