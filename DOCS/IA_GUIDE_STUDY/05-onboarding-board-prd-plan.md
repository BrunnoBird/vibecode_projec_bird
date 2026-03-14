# 05 - Onboarding: Board -> PRB/PRD -> Agents Flow

## Exemplo de flow real

Card da PM no board:
`Adicionar aba Profile na bottom navigation com tela placeholder`

Fluxo completo:
1. PM/PO cria a historia no board.
2. Humano + IA usam prompt oficial para gerar PRB/PRD.
3. IA Architect gera spec + tasks + decisoes de skill.
4. IA Coder implementa task.
5. IA Reviewer revisa e registra achados.
6. IA Tester valida e recomenda aceite.
7. Humano aprova e faz merge.

## Regra de padronizacao para times

- Sempre iniciar etapa com prompt oficial de `ai/07-prompts/`.
- Sempre registrar handoff/eval operacional em `_runs`.
- Sempre usar templates oficiais para artefatos de `_runs`.

## Prompt recomendado para gerar PRB/PRD a partir do Board

Use o template oficial:
- `ai/07-prompts/board-to-prd-prompt.md`

### Exemplo pronto (copiar e preencher)

```md
Atue como apoio de Product + Tech Writing.

Use como base o template:
- ai/07-prompts/board-to-prd-prompt.md

Historia do Board:
- Titulo: <titulo>
- Contexto: <contexto>
- Problema: <problema>
- Resultado esperado: <resultado>
- Restricoes: <restricoes>
- Dependencias conhecidas: <dependencias>

Saida:
- criar ai/01-product/_work/<feature>-prd.md
- manter lacunas em "Duvidas abertas"
- nao inventar requisitos fora da historia
```

## Prompt recomendado para iniciar PLAN a partir do PRB/PRD

Use o template oficial:
- `ai/07-prompts/plan-architect-prompt.md`

### Exemplo pronto (copiar e preencher)

```md
Atue como Architect Agent em modo PLAN.

Leia:
- ai/AGENT_START.md
- ai/07-prompts/plan-architect-prompt.md
- ai/01-product/_work/<feature>-prd.md

Saida esperada:
- ai/03-specs/_work/<feature>-spec.md
- ai/04-tasks/_work/task-*.md
- decisoes de skill por task
- ordem de execucao
- riscos tecnicos
```

## Prompt recomendado para seguir o flow completo de Agents

### EXECUTION (Coder)
```md
Atue como Coder Agent.
Leia e siga: ai/07-prompts/execution-coder-prompt.md
Task alvo: ai/04-tasks/_work/<task>.md
Spec: ai/03-specs/_work/<feature>-spec.md
```

### REVIEW (Reviewer)
```md
Atue como Reviewer Agent.
Leia e siga: ai/07-prompts/review-reviewer-prompt.md
Task alvo: ai/04-tasks/_work/<task>.md
Spec: ai/03-specs/_work/<feature>-spec.md
```

### TEST (Tester)
```md
Atue como Tester Agent.
Leia e siga: ai/07-prompts/test-tester-prompt.md
Task alvo: ai/04-tasks/_work/<task>.md
Spec: ai/03-specs/_work/<feature>-spec.md
```

## Aplicabilidade operacional (quando usar cada pasta)

1. `ai/07-prompts/`: iniciar a etapa (Board->PRB/PRD, PLAN, EXECUTION, REVIEW, TEST).
2. `ai/08-handoffs/_runs/`: registrar entrega de Coder/Reviewer da task atual.
3. `ai/09-evals/_runs/`: registrar validacao final de Tester.
4. `ai/03-specs/_work/` e `ai/04-tasks/_work/`: artefatos locais da feature em execucao.
5. `ai/08-handoffs/*.md` e `ai/09-evals/*.md`: templates oficiais versionados.
