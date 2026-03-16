# Work Naming Convention

Padrao de nomenclatura para artefatos em pastas `_work/`.

## Regras de nomenclatura e pastas

| Tipo | Pasta | Padrao | Observações |
|------|-------|--------|------------|
| PRD (rascunho) | `ai/01-product/_work/` | `<tipo>-<slug>-prd.md` | Efêmero, não versionado |
| PRD (aprovado) | `ai/01-product/history/` | `<tipo>-<slug>-prd.md` | O PRD final é movido p/ cá |
| Spec | `ai/03-specs/_work/` | `<slug>-spec.md` | Efêmero, não versionado |
| Task | `ai/04-tasks/_work/` | `<slug>-task-<NN>.md` | Efêmero, não versionado |

`Tipo` no PRD deve ser `bug` ou `feature`.

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

---

## Ciclo de vida: Promoção de PRD (Work → History)

1. A IA cria o PRD em `ai/01-product/_work/<tipo>-<slug>-prd.md`.
2. O fluxo (PLAN, EXECUTION, etc) ocorre baseando-se no `_work`.
3. Após validado/concluído com o Tester/Humano, o PRD é **copiado/movido** para `ai/01-product/history/<tipo>-<slug>-prd.md`.
4. Os arquivos de Spec e Task são deletados de `_work/` para limpar o discovery da próxima task.
