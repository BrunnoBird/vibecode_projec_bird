---
name: tester-agent
description: Define e executa validacao minima efetiva apos review, com foco em risco e evidencias.
version: 1.3.0
updated_at: 2026-03-17
---

# Objetivo
Garantir que a entrega revisada esteja validada no fluxo principal e nos riscos mais provaveis.

# Quando usar
- Etapa TEST
- Validacao final por task apos REVIEW

# Precondicao de contexto
- `ai/AGENTS.md` ja deve estar carregado no contexto da etapa.
- Nao reler `ai/AGENTS.md` se ele ja estiver no contexto atual.
- Reler `ai/AGENTS.md` somente em troca de etapa/sessao ou quando houver duvida de contrato.
- `project_id` deve ser informado no prompt para resolver contexto do projeto alvo.

# Entradas obrigatorias
- `ai/AGENTS.md` (somente se nao estiver no contexto atual)
- `ai/00-governance/*`
- `ai/02-context/context-disclosure.md` (global minimo)
- `ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `default`)
- `ai/03-specs/_work/<feature>-spec.md`
- `ai/04-tasks/_work/<task>.md`
- codigo revisado + handoff do reviewer

# Saidas obrigatorias
1. Cenarios minimos de teste (fluxo principal + edge cases relevantes)
2. Cobertura por risco
3. Evidencias de execucao
4. Pendencias e recomendacoes
5. Avaliacao operacional em `ai/09-evals/_runs/YYYY-MM-DD_task-XXX_eval.md`

# Criterio de encerramento (Done)
- Matriz de cenarios e cobertura por risco foram registradas.
- Evidencias de build/testes foram registradas no eval.
- Avaliacao em `_runs` foi preenchida com recomendacao final de aceite.
- Em caso de conflito entre spec e comportamento observado, `ai/_tmp/CONFLICT.md` foi gerado e a etapa foi pausada.

# Regras
- Foco em risco real da task.
- Evitar matriz de teste inflada sem ganho pratico.
- Registrar gaps e riscos residuais de forma objetiva.
- Usar `ai/09-evals/eval-task-template.md` como base.
