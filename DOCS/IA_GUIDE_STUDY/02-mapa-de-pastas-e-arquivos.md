# 02 - Mapa de Pastas e Arquivos

## Pastas `ai/` e responsabilidades

- `ai/00-governance/`: principios, padroes e Definition of Done.
- `ai/01-product/`: PRBs/PRDs.
- `ai/02-context/`: contexto tecnico global + roteamento por projeto.
- `ai/02-context/projects/`: contextos especificos por `project_id`.
- `ai/03-specs/`: area de specs (usar `_work` para historias nao versionadas).
- `ai/04-tasks/`: area de tasks (usar `_work` para historias nao versionadas).
- `ai/06-skills/`: capacidades reutilizaveis.
- `ai/07-prompts/`: prompts operacionais por etapa.
- `ai/08-handoffs/`: templates oficiais de handoff + `_runs` efemeros.
- `ai/09-evals/`: templates oficiais de avaliacao + `_runs` efemeros.

## Diretorios de historia nao versionados

- `ai/01-product/_work/`: PRB/PRD por historia (local, nao sobe no merge)
- `ai/03-specs/_work/`: specs por historia (local, nao sobe no merge)
- `ai/04-tasks/_work/`: tasks por historia (local, nao sobe no merge)

## Templates oficiais para padronizacao

- `ai/00-governance/conflict-template.md`
- `ai/03-specs/spec-template.md`
- `ai/04-tasks/task-template.md`
- `ai/08-handoffs/handoff-coder-template.md`
- `ai/08-handoffs/handoff-reviewer-template.md`
- `ai/09-evals/eval-task-template.md`

## Tipos de arquivo `.md`

### `AGENTS.md`
Contrato global unico do fluxo SSD, ordem de leitura e politica geral de carregamento sob demanda.

### `ai/02-context/projects/<project_id>/context-disclosure.md`
Define stack/arquitetura/convensoes do projeto alvo. Precedencia sobre o contexto global.

### `prd-*.md` (ou `prb-*.md`)
Define problema, objetivo, escopo, criterios de aceite, riscos e restricoes de produto.

### `*-spec.md`
Traduz PRB/PRD para plano tecnico executavel.

### `task-*.md`
Unidade de execucao da role skill `coder-agent`.
Cada task deve ter:
- dependencias
- criterio de pronto
- status de skill (`skill existente`, `nova skill`, `sem skill`)

### `architect-agent`, `coder-agent`, `reviewer-agent`, `tester-agent` (skills)
Definem responsabilidades, entradas obrigatorias e formato de saida por etapa em `ai/06-skills/<skill>/SKILL.md`.

### `SKILL.md`
Define uma capacidade reutilizavel: objetivo, quando usar, entradas, saidas e regras.

### Prompt de dispatch
`ai/07-prompts/next-step-dispatch-prompt.md` monta a proxima etapa apos o PLAN com `spec_path` e `task_path` exatos.

### Tags XML nos prompts
Os prompts em `ai/07-prompts/` usam tags como `<project_target>`, `<context>`, `<task>`, `<output>`, `<rules>` e `<code>` para delimitar instrucoes.
