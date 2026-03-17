# 01 - Visao e Fluxo SSD

## Objetivo

Explicar como o projeto opera em SSD (Specification-Driven Development), mantendo separacao clara entre decisoes humanas e execucao por IA.

## Fluxo canonico

`Board -> PRB/PRD -> PLAN -> Spec -> Tasks -> EXECUTION -> REVIEW -> TEST -> Aceite`

## Quem faz o que

- Humano: define produto, escopo, prioridades e aprova plano/aceite.
- IA Product Writer (prompt): ajuda a transformar board em PRB/PRD.
- Role skill `architect-agent`: transforma PRB/PRD em spec, tasks e decisoes de skill.
- Role skill `coder-agent`: implementa task por task.
- Role skill `reviewer-agent`: revisa com severidade.
- Role skill `tester-agent`: valida cenarios, cobertura por risco e evidencias.

## Regra central

Nunca pular de board direto para codigo.
Sempre seguir: `Board -> PRB/PRD -> Spec -> Tasks -> Code -> Review -> Test -> Aceite`.

## Regra de padronizacao

- Cada etapa inicia por prompt oficial em `ai/07-prompts/`.
- Cada etapa registra artefato operacional em `_runs` quando aplicavel.
- PRB/PRD, spec e tasks da historia ativa devem ser criados em `_work` para nao serem mergeados.
- `ai/AGENTS.md` e contexto base da etapa: nao reler se ja estiver no contexto atual.
- Toda etapa deve declarar `project_id` para carregar contexto do projeto alvo.
- Em conflito PRD/Spec/Task: pausar etapa e gerar `ai/_tmp/CONFLICT.md`.
