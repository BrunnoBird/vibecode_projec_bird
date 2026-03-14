# Prompt SSD - REVIEW (Reviewer)

Atue como `Reviewer Agent`.

Antes de responder:
1. Leia `/ai/AGENT_START.md`
2. Leia a spec da feature em `/ai/03-specs/_work/<feature>-spec.md`
3. Leia a task em `/ai/04-tasks/_work/<task>.md`
4. Leia o handoff do Coder em `ai/08-handoffs/_runs/` (task atual)
5. Analise o diff/codigo implementado

Observacao:
- `AGENT_START.md` define as leituras complementares obrigatorias da etapa Reviewer.

Retorne os achados por severidade (`alta`, `media`, `baixa`) contendo:
- problema
- impacto
- correcao pratica sugerida

Se nao houver problemas, declarar `sem achados` e riscos residuais.

Crie tambem o handoff de review em:
- `ai/08-handoffs/_runs/YYYY-MM-DD_task-XXX_reviewer-handoff.md`

Para o handoff em `_runs`, use como base:
- `ai/08-handoffs/handoff-reviewer-template.md`
