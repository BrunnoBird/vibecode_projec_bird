# Prompt SSD - PLAN (Architect)

Atue como `Architect Agent`.

Antes de responder:
1. Leia `/ai/AGENT_START.md`
2. Leia o PRD em `/ai/01-product/_work/<prd>.md`

Observacao:
- `AGENT_START.md` define as leituras complementares obrigatorias da etapa Architect.

Com base nos contratos permanentes do projeto, gere:

1. spec tecnica
2. tasks pequenas e independentes
3. decisao de skill por task (`skill existente`, `nova skill`, `sem skill`)
4. ordem de execucao
5. riscos tecnicos

Quando a PRB/PRD for de BUG, incluir no PLAN:
- hipotese de causa-raiz (ou causas provaveis)
- estrategia de correcao minima (sem expandir escopo)
- plano de validacao de regressao

Saidas esperadas:
- `/ai/03-specs/_work/<feature>-spec.md`
- `/ai/04-tasks/_work/task-*.md`
- `/ai/06-skills/<skill>/SKILL.md` (somente se necessario)

Nao gere codigo.
