# AGENTS

Contrato global unico e roteador de contexto para o fluxo SSD deste workspace.

## Contexto resumido do workspace
- Workspace Android Kotlin com multiplos projetos/modulos.
- Diferentes projetos podem usar arquiteturas e stacks distintas (ex.: MVI/Compose ou MVVM/XML).
- Este arquivo define regras globais; arquitetura final vem do contexto do projeto alvo.

## Fluxo SSD canonico
`Board -> PRB/PRD -> PLAN -> Spec -> Tasks -> EXECUTION -> REVIEW -> TEST -> Aceite`

```mermaid
flowchart LR
    A["Board"] --> B["PRB/PRD"]
    B --> C["PLAN (architect-agent)"]
    C --> D["Spec + Tasks"]
    D --> E["EXECUTION (coder-agent)"]
    E --> F["REVIEW (reviewer-agent)"]
    F --> G["TEST (tester-agent)"]
    G --> H["Aceite Humano"]
```

## Fonte unica e sem repeticao
- Este arquivo e o contrato global unico do fluxo SSD.
- Carregar somente o contexto necessario para a etapa atual.

## Roteamento de contexto por projeto

### Entrada obrigatoria no prompt
- Toda etapa deve declarar `project_id` (ou modulo alvo) explicitamente.

### Resolucao de contexto
1. Carregar `ai/02-context/context-disclosure.md` (global minimo).
2. Tentar carregar `ai/02-context/projects/<project_id>/context-disclosure.md`.
3. Se nao existir, carregar fallback `ai/02-context/projects/default/context-disclosure.md`.

### Regra de precedencia
- `contexto do projeto` > `contexto global` > `defaults`.
- Em caso de conflito entre contextos, vence o contexto do projeto alvo.

## Skills disponiveis

### Skills de papel (uma por etapa)
- `architect-agent`: `ai/06-skills/architect-agent/SKILL.md`
- `coder-agent`: `ai/06-skills/coder-agent/SKILL.md`
- `reviewer-agent`: `ai/06-skills/reviewer-agent/SKILL.md`
- `tester-agent`: `ai/06-skills/tester-agent/SKILL.md`

### Skills tecnicas (sob demanda por task)
- `bootstrap-android-project`: `ai/06-skills/bootstrap-android-project/SKILL.md`
- `create-android-module`: `ai/06-skills/create-android-module/SKILL.md`
- `create-compose-mvi-screen`: `ai/06-skills/create-compose-mvi-screen/SKILL.md`
- `write-unit-tests`: `ai/06-skills/write-unit-tests/SKILL.md`
- `write-viewmodel-unit-tests`: `ai/06-skills/write-viewmodel-unit-tests/SKILL.md`

## Carregamento sob demanda (ordem minima)
1. Sempre carregar:
   - `ai/AGENTS.md`
   - `ai/00-governance/*`
   - `ai/02-context/context-disclosure.md`
   - `ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `default`)
2. Carregar por etapa:
   - PLAN: `ai/06-skills/architect-agent/SKILL.md` + `ai/01-product/_work/<prd>.md`
   - EXECUTION: `ai/06-skills/coder-agent/SKILL.md` + `ai/03-specs/_work/<spec>.md` + `ai/04-tasks/_work/<task>.md`
   - REVIEW: `ai/06-skills/reviewer-agent/SKILL.md` + spec/task + diff
   - TEST: `ai/06-skills/tester-agent/SKILL.md` + spec/task + codigo revisado
3. Skills tecnicas de `ai/06-skills/*` so entram quando forem citadas na task/spec.
4. Nova skill so deve ser criada quando o padrao for repetivel, padronizavel e reutilizavel.

## Definition of Done por etapa
- PLAN: spec em `_work` validada contra `ai/03-specs/spec-template.md` + tasks em `_work` validadas contra `ai/04-tasks/task-template.md` + decisao de skill por task.
- EXECUTION: task implementada no escopo + testes relevantes executados + handoff do coder em `_runs` sem placeholders abertos.
- REVIEW: review concluido por severidade + handoff do reviewer em `_runs` com status geral e riscos residuais.
- TEST: matriz de cenarios + evidencias de execucao + eval em `_runs` com recomendacao de aceite.

## Protocolo de erro e duvida (conflito de artefatos)
Se houver conflito entre PRB/PRD e spec (ou entre spec e task), o agente deve:
1. Parar a execucao da etapa.
2. Criar `ai/_tmp/CONFLICT.md` com base em `ai/00-governance/conflict-template.md`.
3. Registrar o conflito, impacto, proposta minima e perguntas objetivas para decisao humana.
4. Aguardar resolucao humana antes de continuar.

## Politica de versao das skills
- Todo `SKILL.md` deve ter `version` e `updated_at` no cabecalho.
- Alteracao de comportamento obrigatoria: incrementar `version`.
- Alteracao editorial sem impacto de comportamento: atualizar apenas `updated_at`.

## Prompts oficiais reutilizaveis
- BOARD -> PRB/PRD: `ai/07-prompts/board-to-prd-prompt.md`
- PLAN: `ai/07-prompts/plan-architect-prompt.md`
- NEXT STEP: `ai/07-prompts/next-step-dispatch-prompt.md`
- EXECUTION: `ai/07-prompts/execution-coder-prompt.md`
- REVIEW: `ai/07-prompts/review-reviewer-prompt.md`
- TEST: `ai/07-prompts/test-tester-prompt.md`
- Padrao de escrita nos prompts: usar tags XML (`<project_target>`, `<context>`, `<task>`, `<output>`, `<rules>`, `<code>`).

## Politica de artefatos operacionais
- Historias locais (nao versionadas): `ai/01-product/_work/`, `ai/03-specs/_work/`, `ai/04-tasks/_work/`
- Saidas efemeras: `ai/_tmp/`, `ai/07-prompts/_scratch/`, `ai/08-handoffs/_runs/`, `ai/09-evals/_runs/`
- Templates oficiais ficam versionados em `ai/08-handoffs/` e `ai/09-evals/`.

## Regras globais
- Nao inventar requisitos fora de PRB/PRD, spec e task.
- Nao expandir escopo sem aprovacao humana.
- Seguir arquitetura e convencoes definidas no contexto do projeto alvo.
- Priorizar simplicidade e evitar overengineering.
