# 03 - Contratos por Etapa

## Prompt padrao por etapa

- BOARD -> PRB/PRD: `ai/07-prompts/board-to-prd-prompt.md`
- PLAN: `ai/07-prompts/plan-architect-prompt.md`
- NEXT STEP DISPATCH: `ai/07-prompts/next-step-dispatch-prompt.md`
- EXECUTION: `ai/07-prompts/execution-coder-prompt.md`
- REVIEW: `ai/07-prompts/review-reviewer-prompt.md`
- TEST: `ai/07-prompts/test-tester-prompt.md`

## Architect Agent

Entrada:
- PRB/PRD em `ai/01-product/_work/`
- `Projeto alvo:` declarado
- Contextos em `ai/02-context/` e `app/<sub-proj>/ai/`
- Governanca e skills existentes.

Saida obrigatoria:
- Spec
- Task breakdown
- decisao de skill por task
- ordem de execucao
- riscos tecnicos

## Coder Agent

Entrada:
- `Projeto alvo:` declarado
- Contextos globais e locais
- Spec e task ativa em `_work` + skill associada (quando existir).

Saida esperada:
- codigo da task
- testes proporcionais ao risco
- riscos/follow-ups (direto na conversa)

## Reviewer Agent

Entrada:
- `Projeto alvo:` declarado
- Contextos globais e locais
- diff/codigo + spec/task em `_work`

Saida obrigatoria:
- achados por severidade (`alta`, `media`, `baixa`)
- impacto
- correcao pratica sugerida (direto na conversa)

## Tester Agent

Entrada:
- `Projeto alvo:` declarado
- Contextos globais e locais
- codigo revisado + spec/task em `_work`

Saida obrigatoria:
- cenarios minimos
- cobertura por risco
- evidencias de execucao
- pendencias/recomendacoes (direto na conversa)

## Regra de qualidade transversal

Toda etapa deve respeitar escopo e nao inventar requisito fora de PRB/PRD/Spec/Task.
