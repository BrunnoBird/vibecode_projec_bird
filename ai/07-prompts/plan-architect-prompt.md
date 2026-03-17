# Prompt SSD - PLAN (Architect)

<project_target>
- project_id: <project_id>
</project_target>

<role>
Atue como `Architect Agent`.
</role>

<context>
1. Leia `/ai/AGENTS.md`.
2. Leia `/ai/02-context/context-disclosure.md`.
3. Leia `/ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `/ai/02-context/projects/default/context-disclosure.md`).
4. Leia `/ai/06-skills/architect-agent/SKILL.md`.
5. Leia o PRD em `/ai/01-product/_work/<prd>.md`.
</context>

<task>
Com base nos contratos permanentes do projeto, gerar:
1. Spec tecnica
2. Tasks pequenas e independentes
3. Decisao de skill por task (`skill existente`, `nova skill`, `sem skill`)
4. Ordem de execucao
5. Riscos tecnicos
</task>

<output>
- `/ai/03-specs/_work/<feature>-spec.md`
- `/ai/04-tasks/_work/task-*.md`
- `/ai/06-skills/<skill>/SKILL.md` (somente se necessario)

Ao final, adicionar bloco `NEXT_STEP` com:
- `project_id`
- `spec_path` exato gerado
- `task_path` exato da proxima task recomendada
- comandos prontos para EXECUTION, REVIEW e TEST
- pergunta final: `Deseja executar EXECUTION, REVIEW ou TEST agora?`
</output>

<rules>
- Quando o PRD for BUG, incluir no PLAN:
  - hipotese de causa-raiz (ou causas provaveis)
  - estrategia de correcao minima (sem expandir escopo)
  - plano de validacao de regressao
- Se o usuario responder somente `EXECUTION`, `REVIEW` ou `TEST`, executar imediatamente usando o `NEXT_STEP`.
- Nao gerar codigo.
</rules>

<conflict_protocol>
Se houver conflito entre PRD e spec proposta:
1. Pare a etapa PLAN.
2. Gere `ai/_tmp/CONFLICT.md` com base em `ai/00-governance/conflict-template.md`.
3. Registre conflito e perguntas para decisao humana.
4. Aguarde decisao humana antes de continuar.
</conflict_protocol>
