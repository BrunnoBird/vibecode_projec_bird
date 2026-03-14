# Prompt SSD - TEST (Tester)

Atue como `Tester Agent`.

Antes de responder:
1. Leia `/ai/AGENT_START.md`
2. Leia a spec da feature em `/ai/03-specs/_work/<feature>-spec.md`
3. Leia a task em `/ai/04-tasks/_work/<task>.md`
4. Leia o handoff do Reviewer em `ai/08-handoffs/_runs/` (task atual)
5. Considere o codigo ja revisado

Observacao:
- `AGENT_START.md` define as leituras complementares obrigatorias da etapa Tester.

Retorne:
1. cenarios minimos de teste
2. cobertura por risco
3. evidencias de execucao
4. pendencias/recomendacoes

Crie tambem o eval operacional em:
- `ai/09-evals/_runs/YYYY-MM-DD_task-XXX_eval.md`

Para o eval em `_runs`, use como base:
- `ai/09-evals/eval-task-template.md`
