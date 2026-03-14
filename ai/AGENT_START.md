# AGENT START

Este documento define o contrato global de funcionamento dos agentes de IA neste projeto.

## Fluxo SSD Canonico

Fluxo obrigatorio para features:

AGENT_START -> Architect Agent -> Spec -> Tasks -> Coder Agent -> Code -> Reviewer Agent -> Tester Agent

## Politica de Prompts reutilizaveis (padrao de time)

Para padronizacao entre times, usar prompts oficiais em `ai/07-prompts/`:

- BOARD -> PRB/PRD (pre-PLAN): `ai/07-prompts/board-to-prd-prompt.md`
- PLAN: `ai/07-prompts/plan-architect-prompt.md`
- NEXT STEP DISPATCH (pos-PLAN): `ai/07-prompts/next-step-dispatch-prompt.md`
- EXECUTION: `ai/07-prompts/execution-coder-prompt.md`
- REVIEW: `ai/07-prompts/review-reviewer-prompt.md`
- TEST: `ai/07-prompts/test-tester-prompt.md`

Regras:
- Prompts sao gatilhos operacionais reutilizaveis.
- `AGENT_START.md` e `ai/05-agents/*.md` continuam como fonte de verdade.
- Prompts devem evitar repetir listas longas ja definidas no contrato global.
- Prompt ad-hoc deve ser salvo em `ai/07-prompts/_scratch/`.

## Politica de artefatos de historia (nao versionados)

Para evitar merge de arquivos especificos de historia, usar por padrao:
- `ai/01-product/_work/` para PRB/PRD da historia
- `ai/03-specs/_work/` para spec da historia
- `ai/04-tasks/_work/` para tasks da historia

Esses diretorios sao ignorados no git e servem apenas para execucao local do fluxo.

## Governanca Humano x IA

- Humano define visao de produto, arquitetura alvo, escopo e prioridades.
- IA executa planejamento tecnico, implementacao, revisao e testes dentro do escopo aprovado.
- Humano valida plano, diffs, riscos e aceite final.

## Ordem obrigatoria de leitura por etapa

### Etapa Architect (PLAN)
Entrada operacional padrao: `ai/07-prompts/plan-architect-prompt.md`

1. `/ai/00-governance/`
2. `/ai/02-context/context-disclosure.md`
3. `/ai/05-agents/architect-agent.md`
4. `/ai/01-product/_work/` (PRB/PRD da feature em execucao)
5. `/ai/06-skills/`

### Etapa Coder (EXECUTION)
Entrada operacional padrao: `ai/07-prompts/execution-coder-prompt.md`

1. `/ai/00-governance/`
2. `/ai/02-context/context-disclosure.md`
3. `/ai/05-agents/coder-agent.md`
4. `/ai/03-specs/_work/` (spec da feature em execucao)
5. `/ai/04-tasks/_work/` (task ativa em execucao)
6. `/ai/06-skills/`

### Etapa Reviewer (REVIEW)
Entrada operacional padrao: `ai/07-prompts/review-reviewer-prompt.md`

1. `/ai/00-governance/`
2. `/ai/02-context/context-disclosure.md`
3. `/ai/05-agents/reviewer-agent.md`
4. `/ai/03-specs/_work/`
5. `/ai/04-tasks/_work/`

### Etapa Tester (TEST)
Entrada operacional padrao: `ai/07-prompts/test-tester-prompt.md`

1. `/ai/00-governance/`
2. `/ai/02-context/context-disclosure.md`
3. `/ai/05-agents/tester-agent.md`
4. `/ai/03-specs/_work/`
5. `/ai/04-tasks/_work/`

## Contratos por etapa

### Architect Agent
Entrada: PRB/PRD + contexto + governanca + skills existentes.
Saida: Spec + Task breakdown + decisoes de skill + ordem de execucao + riscos.

### Coder Agent
Entrada: Spec + Task + skill associada (quando existir).
Saida: Codigo + testes necessarios + nota de implementacao.

### Reviewer Agent
Entrada: Codigo + Spec + Task + governanca.
Saida: achados por severidade com impacto e correcao pratica.

### Tester Agent
Entrada: Codigo revisado + Spec + Task.
Saida: cenarios de teste, cobertura por risco e evidencias de execucao.

## Politica global de Skills

- Sempre verificar skills existentes em `/ai/06-skills/` antes de propor ou implementar solucao nova.
- Reutilizar skill existente sempre que cobrir parte relevante da solucao.
- Criar nova skill apenas quando o padrao for repetivel, padronizavel e reutilizavel.
- Evitar criar skill para correcoes pontuais e casos unicos.

## Artefatos de execucao (efemeros)

Diretorios para saidas temporarias por task/execucao:

- `ai/_tmp/`
- `ai/07-prompts/_scratch/`
- `ai/08-handoffs/_runs/`
- `ai/09-evals/_runs/`

Regra:
- Templates oficiais ficam versionados em `ai/07-prompts/`, `ai/08-handoffs/` e `ai/09-evals/`.
- Saidas operacionais por execucao devem ser gravadas somente em `_scratch`, `_runs` ou `_tmp`.
- Esses artefatos sao descartaveis e nao devem ser considerados fonte de verdade permanente.
- Para padronizar handoffs/evals, copiar os templates oficiais em `ai/08-handoffs/` e `ai/09-evals/` para os arquivos em `_runs`.

## Regras globais

- Nao inventar requisitos fora de PRB/PRD/Spec/Task.
- Nao expandir escopo sem aprovacao humana.
- Manter simplicidade e evitar overengineering.
- Respeitar arquitetura e convencoes persistentes do projeto.


