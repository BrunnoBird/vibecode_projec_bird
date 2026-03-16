# Work Naming Convention

Padrao de nomenclatura para artefatos em pastas `_work/`.

## Regras de nomenclatura

| Tipo | Pasta | Padrao |
|------|-------|--------|
| PRD de bug | `ai/01-product/_work/` | `bug-<slug>-prd.md` |
| PRD de feature | `ai/01-product/_work/` | `feature-<slug>-prd.md` |
| Spec | `ai/03-specs/_work/` | `<slug>-spec.md` |
| Task | `ai/04-tasks/_work/` | `<slug>-task-<NN>.md` |

## Regras de slug

- Lowercase.
- Palavras separadas por hifen.
- Sem acentos ou caracteres especiais.
- Derivado do titulo ou contexto da historia.
- Maximo 5 palavras.

Exemplos:
- `bug-profile-crash-prd.md`
- `feature-padronizacao-automacao-agents-ssd-prd.md`
- `padronizacao-automacao-agents-ssd-spec.md`
- `padronizacao-automacao-agents-ssd-task-01.md`

## Auto-discovery de arquivos

Quando um prompt referenciar `_work/` sem caminho explicito, o agent deve seguir estas regras:

1. Se **1 arquivo** na pasta → usar automaticamente.
2. Se **multiplos arquivos** → selecionar pelo slug mais proximo ao contexto do prompt.
3. Se **0 arquivos** → informar ao usuario que nenhum artefato foi encontrado na pasta.
