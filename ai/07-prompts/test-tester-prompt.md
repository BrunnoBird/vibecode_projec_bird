# Prompt SSD - TEST (Tester)

<project_target>
- project_id: <project_id>
</project_target>

<role>
Atue como `Tester Agent`.
</role>

<context>
1. Leia `/ai/AGENTS.md`.
2. Leia `/ai/02-context/context-disclosure.md`.
3. Leia `/ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `/ai/02-context/projects/default/context-disclosure.md`).
4. Leia `/ai/06-skills/tester-agent/SKILL.md`.
5. Leia a spec em `/ai/03-specs/_work/<feature>-spec.md`.
6. Leia a task em `/ai/04-tasks/_work/<task>.md`.
7. Leia o handoff do Reviewer em `ai/08-handoffs/_runs/`.
8. Considere o codigo revisado.
</context>

<task>
Gerar e executar validacao minima efetiva com foco em risco.
</task>

<output>
Retorne:
1. Cenarios minimos de teste
2. Cobertura por risco
3. Evidencias de execucao
4. Pendencias/recomendacoes

Crie eval operacional em:
- `ai/09-evals/_runs/YYYY-MM-DD_task-XXX_eval.md`
</output>

<rules>
- Use `ai/09-evals/eval-task-template.md` como base do eval.
- Priorize fluxo principal e edge cases de maior risco.
</rules>

<conflict_protocol>
Se houver conflito entre comportamento esperado na spec e comportamento observado:
1. Pare a etapa TEST.
2. Gere `ai/_tmp/CONFLICT.md` com base em `ai/00-governance/conflict-template.md`.
3. Registre evidencia, impacto e duvidas para decisao humana.
4. Aguarde decisao humana antes de continuar.
</conflict_protocol>
