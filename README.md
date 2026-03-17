# Android SSD + Codex Starter (Multi-Projeto)

Este starter kit suporta um workspace Android com multiplos projetos/modulos, por exemplo:

- Kotlin
- UI Compose ou XML (por contexto de projeto)
- Arquitetura MVI ou MVVM (por contexto de projeto)
- ViewModel
- Testes unitarios
- Modularizacao
- Fluxo SSD (Specification-Driven Development)
- Orquestracao por AGENTS + Skills com Codex

## Objetivo

Manter um fluxo SSD padronizado com base em contrato global, prompts com tags XML e skills sob demanda/versionadas.

## Fluxo SSD adotado

`Board -> PRB/PRD -> PLAN -> Spec -> Tasks -> Coder -> Reviewer -> Tester -> Aceite`

## Documentacao IA

Guia principal em partes:
- `DOCS/IA_GUIDE_STUDY/README.md`

## Ordem sugerida de uso

1. Leia `ai/AGENTS.md`
2. Defina `project_id` da etapa
3. Leia `ai/00-governance/*`
4. Leia `ai/02-context/context-disclosure.md` + `ai/02-context/projects/<project_id>/context-disclosure.md`
5. Gere PRB/PRD local em `ai/01-product/_work/` (nao versionado)
6. Gere spec local em `ai/03-specs/_work/` (nao versionado)
7. Gere tasks locais em `ai/04-tasks/_work/` (nao versionado)
8. Execute prompts oficiais em `ai/07-prompts/`
9. Registre handoffs/evals em `_runs`

## Repositorio versiona somente padroes

- contrato global (`ai/AGENTS.md`)
- skills de papel e skills tecnicas
- governanca e contexto
- contextos por projeto (`ai/02-context/projects/*`)
- prompts reutilizaveis
- templates de spec/task/conflito
- templates oficiais de handoff/eval

Arquivos de historia ativa ficam em `_work` e nao devem ser mergeados.
