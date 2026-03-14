# 03 - Contratos por Etapa

## Prompt padrao por etapa

- BOARD -> PRB/PRD: `ai/07-prompts/board-to-prd-prompt.md`
- PLAN: `ai/07-prompts/plan-architect-prompt.md`
- EXECUTION: `ai/07-prompts/execution-coder-prompt.md`
- REVIEW: `ai/07-prompts/review-reviewer-prompt.md`
- TEST: `ai/07-prompts/test-tester-prompt.md`

## Architect Agent

Entrada:
- PRB/PRD em `ai/01-product/_work/` + contexto + governanca + skills existentes.

Saida obrigatoria:
- Spec
- Task breakdown
- decisao de skill por task
- ordem de execucao
- riscos tecnicos

## Coder Agent

Entrada:
- Spec e task ativa em `_work` + skill associada (quando existir).

Saida esperada:
- codigo da task
- testes proporcionais ao risco
- riscos/follow-ups
- handoff em `_runs` baseado no template oficial

## Reviewer Agent

Entrada:
- diff/codigo + spec/task em `_work` + handoff do coder.

Saida obrigatoria:
- achados por severidade (`alta`, `media`, `baixa`)
- impacto
- correcao pratica sugerida
- handoff de review em `_runs` baseado no template oficial

## Tester Agent

Entrada:
- codigo revisado + spec/task em `_work` + handoff do reviewer.

Saida obrigatoria:
- cenarios minimos
- cobertura por risco
- evidencias de execucao
- pendencias/recomendacoes
- eval em `_runs` baseado no template oficial

## Regra de qualidade transversal

Toda etapa deve respeitar escopo e nao inventar requisito fora de PRB/PRD/Spec/Task.
