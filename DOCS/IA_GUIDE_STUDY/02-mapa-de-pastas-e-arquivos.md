# 02 - Mapa de Pastas e Arquivos

## Pastas `ai/` e responsabilidades

- `ai/00-governance/`: principios, padroes e Definition of Done.
- `ai/01-product/`: PRBs/PRDs. `history/` para aprovados, `_work/` para rascunho.
- `ai/02-context/`: contexto tecnico persistente (base global).
- `app/<sub-projeto>/ai/`: contexto técnico específico do sub-projeto.
- `ai/03-specs/`: area de specs (usar `_work` para historias nao versionadas).
- `ai/04-tasks/`: area de tasks (usar `_work` para historias nao versionadas).
- `ai/05-agents/`: contratos dos agentes.
- `ai/06-skills/`: capacidades reutilizaveis.
- `ai/07-prompts/`: prompts operacionais por etapa.
## Diretorios de historia nao versionados

- `ai/01-product/_work/`: PRB/PRD por historia (local, nao sobe no merge)
- `ai/03-specs/_work/`: specs por historia (local, nao sobe no merge)
- `ai/04-tasks/_work/`: tasks por historia (local, nao sobe no merge)


## Tipos de arquivo `.md`

### `AGENT_START.md`
Contrato global do fluxo SSD, ordem de leitura e politica geral de prompts/skills.

### `prd-*.md` (ou `prb-*.md`)
Define problema, objetivo, escopo, criterios de aceite, riscos e restricoes de produto.

### `*-spec.md`
Traduz PRB/PRD para plano tecnico executavel.

### `task-*.md`
Unidade de execucao do Coder Agent.
Cada task deve ter:
- dependencias
- criterio de pronto
- status de skill (`skill existente`, `nova skill`, `sem skill`)

### `architect-agent.md`, `coder-agent.md`, `reviewer-agent.md`, `tester-agent.md`
Definem responsabilidades, entradas obrigatorias e formato de saida por etapa.

### `SKILL.md`
Define uma capacidade reutilizavel: objetivo, quando usar, entradas, saidas e regras.

### Prompt de dispatch
`ai/07-prompts/next-step-dispatch-prompt.md` monta a proxima etapa apos o PLAN com `spec_path` e `task_path` exatos.
