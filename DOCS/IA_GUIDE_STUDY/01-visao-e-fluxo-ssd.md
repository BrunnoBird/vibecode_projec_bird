# 01 - Visao e Fluxo SSD

## Objetivo

Explicar como o projeto opera em SSD (Specification-Driven Development), mantendo separacao clara entre decisoes humanas e execucao por IA.

## Fluxo canonico

`Board -> PRB/PRD -> PLAN -> Spec -> Tasks -> EXECUTION -> REVIEW -> TEST -> Aceite`

## Quem faz o que

- Humano: define produto, escopo, prioridades e aprova plano/aceite.
- IA Product Writer (prompt): ajuda a transformar board em PRB/PRD.
- IA Architect: transforma PRB/PRD em spec, tasks e decisoes de skill.
- IA Coder: implementa task por task.
- IA Reviewer: revisa com severidade.
- IA Tester: valida cenarios, cobertura por risco e evidencias.

## Regra central

Nunca pular de board direto para codigo.
Sempre seguir: `Board -> PRB/PRD -> Spec -> Tasks -> Code -> Review -> Test -> Aceite`.

## Regra de padronizacao

- Cada etapa inicia por prompt oficial em `ai/07-prompts/`.
- Cada etapa registra artefato operacional em `_runs` quando aplicavel.
- PRB/PRD, spec e tasks da historia ativa devem ser criados em `_work` para nao serem mergeados.
