# Prompt SSD - PLAN (Architect)

Atue como `Architect Agent`.

Antes de responder:
1. Leia `/ai/AGENT_START.md`
2. Identifique automaticamente o PRD relevante em `/ai/01-product/_work/` (auto-discovery)
3. Leia `/ai/00-governance/work-naming-convention.md`
4. Se a historia for tipo BUG, leia tambem `/ai/00-governance/bug-resolution-rules.md`

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
- `/ai/03-specs/_work/<slug>-spec.md`
- `/ai/04-tasks/_work/<slug>-task-*.md`
- `/ai/06-skills/<skill>/SKILL.md` (somente se necessario)

Nomes de arquivos gerados devem seguir `/ai/00-governance/work-naming-convention.md`.

Ao final (obrigatorio), adicione um bloco `ARTEFATOS_GERADOS` contendo:
- spec criada (caminho completo)
- tasks geradas (caminhos completos)
- skills reutilizadas (nome e caminho)
- novas skills criadas (nome e caminho, ou "nenhuma")

Nao gere codigo.
