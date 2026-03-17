# 03 - Contratos por Etapa

## Prompt padrao por etapa

- BOARD -> PRB/PRD: `ai/07-prompts/board-to-prd-prompt.md`
- PLAN: `ai/07-prompts/plan-architect-prompt.md`
- NEXT STEP DISPATCH: `ai/07-prompts/next-step-dispatch-prompt.md`
- EXECUTION: `ai/07-prompts/execution-coder-prompt.md`
- REVIEW: `ai/07-prompts/review-reviewer-prompt.md`
- TEST: `ai/07-prompts/test-tester-prompt.md`

Regra comum: toda etapa deve informar `project_id`.

## Role Skill `architect-agent`

Entrada:
- PRB/PRD em `ai/01-product/_work/` + contexto + governanca + skills existentes.
- `ai/AGENTS.md` ja carregado (reler somente se nao estiver no contexto atual).
- `ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `default`).

Saida obrigatoria:
- Spec
- Task breakdown
- decisao de skill por task
- ordem de execucao
- riscos tecnicos

## Role Skill `coder-agent`

Entrada:
- Spec e task ativa em `_work` + skill associada (quando existir).
- `ai/AGENTS.md` ja carregado (reler somente se nao estiver no contexto atual).
- `ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `default`).

Saida esperada:
- codigo da task
- testes proporcionais ao risco
- riscos/follow-ups
- handoff em `_runs` baseado no template oficial

## Role Skill `reviewer-agent`

Entrada:
- diff/codigo + spec/task em `_work` + handoff do coder.
- `ai/AGENTS.md` ja carregado (reler somente se nao estiver no contexto atual).
- `ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `default`).

Saida obrigatoria:
- achados por severidade (`alta`, `media`, `baixa`)
- impacto
- correcao pratica sugerida
- handoff de review em `_runs` baseado no template oficial

## Role Skill `tester-agent`

Entrada:
- codigo revisado + spec/task em `_work` + handoff do reviewer.
- `ai/AGENTS.md` ja carregado (reler somente se nao estiver no contexto atual).
- `ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `default`).

Saida obrigatoria:
- cenarios minimos
- cobertura por risco
- evidencias de execucao
- pendencias/recomendacoes
- eval em `_runs` baseado no template oficial

## Regra de qualidade transversal

Toda etapa deve respeitar escopo e nao inventar requisito fora de PRB/PRD/Spec/Task.
Se houver conflito entre PRD, spec e task, a etapa deve pausar e gerar `ai/_tmp/CONFLICT.md`.
