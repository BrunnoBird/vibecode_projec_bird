# Prompt SSD - REVIEW (Reviewer)

<project_target>
- project_id: <project_id>
</project_target>

<role>
Atue como `Reviewer Agent`.
</role>

<context>
1. Leia `/ai/AGENTS.md`.
2. Leia `/ai/02-context/context-disclosure.md`.
3. Leia `/ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `/ai/02-context/projects/default/context-disclosure.md`).
4. Leia `/ai/06-skills/reviewer-agent/SKILL.md`.
5. Leia a spec em `/ai/03-specs/_work/<feature>-spec.md`.
6. Leia a task em `/ai/04-tasks/_work/<task>.md`.
7. Leia o handoff do Coder em `ai/08-handoffs/_runs/`.
8. Analise o diff/codigo implementado.
</context>

<task>
Executar code review tecnico por severidade.
</task>

<output>
Retorne achados por severidade (`alta`, `media`, `baixa`) contendo:
- problema
- impacto
- correcao pratica sugerida

Se nao houver problemas, declarar `sem achados` e riscos residuais.

Crie handoff de review em:
- `ai/08-handoffs/_runs/YYYY-MM-DD_task-XXX_reviewer-handoff.md`
</output>

<rules>
- Use `ai/08-handoffs/handoff-reviewer-template.md` como base do handoff.
- Foque em risco tecnico real e acao pratica.
</rules>

<conflict_protocol>
Se houver conflito entre expectativa da spec e implementacao da task:
1. Pare a etapa REVIEW.
2. Gere `ai/_tmp/CONFLICT.md` com base em `ai/00-governance/conflict-template.md`.
3. Registre evidencia do conflito e bloqueio.
4. Aguarde decisao humana antes de continuar.
</conflict_protocol>
