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
- Sempre declarar o `Projeto alvo:` no prompt.

## Prompt recomendado para gerar PRB/PRD a partir do Board

Use o template oficial:
- `ai/07-prompts/board-to-prd-prompt.md`

### Exemplo pronto (copiar e preencher)

```md
Atue como apoio de Product + Tech Writing.

Use como base o template:
- ai/07-prompts/board-to-prd-prompt.md

Projeto alvo: <nome-da-pasta-em-app>

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

Projeto alvo: <nome-da-pasta-em-app>

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
Projeto alvo: <nome-da-pasta-em-app>
Task alvo: ai/04-tasks/_work/<task>.md
Spec: ai/03-specs/_work/<feature>-spec.md
```

### REVIEW (Reviewer)
```md
Atue como Reviewer Agent.
Leia e siga: ai/07-prompts/review-reviewer-prompt.md
Projeto alvo: <nome-da-pasta-em-app>
Task alvo: ai/04-tasks/_work/<task>.md
Spec: ai/03-specs/_work/<feature>-spec.md
```

### TEST (Tester)
```md
Atue como Tester Agent.
Leia e siga: ai/07-prompts/test-tester-prompt.md
Projeto alvo: <nome-da-pasta-em-app>
Task alvo: ai/04-tasks/_work/<task>.md
Spec: ai/03-specs/_work/<feature>-spec.md
```

## Aplicabilidade operacional (quando usar cada pasta)

1. `ai/07-prompts/`: iniciar a etapa (Board->PRB/PRD, PLAN, EXECUTION, REVIEW, TEST).
2. `ai/03-specs/_work/` e `ai/04-tasks/_work/`: rascunhos locais da feature em execucao.
3. `ai/01-product/history/`: PRDs aprovados ficam versionados aqui.

---

## Cenario exemplificativo: historia de BUG

Historia no board (exemplo):
- Titulo: `BUG - App fecha ao abrir Profile apos logout`
- Contexto: usuarios reportam crash apos logout/login rapido
- Problema: ao tocar em `Profile`, app fecha
- Resultado esperado: `Profile` deve abrir sem crash
- Restricoes: corrigir sem alterar fluxo de autenticacao
- Dependencias conhecidas: modulo `feature:profile` + navegacao no `app`

### Prompt para gerar PRB/PRD de BUG

```md
Atue como apoio de Product + Tech Writing.

Use como base:
- ai/07-prompts/board-to-prd-prompt.md

Projeto alvo: bird-watcher

Historia do Board (BUG):
- Titulo: BUG - App fecha ao abrir Profile apos logout
- Contexto: crash apos logout/login rapido
- Problema: tela Profile fecha o app
- Resultado esperado: Profile abre normalmente
- Restricoes: nao alterar fluxo de autenticacao
- Dependencias conhecidas: feature:profile, app navigation
- Evidencias: stacktrace do Crashlytics + video curto de reproducao

Saida:
- criar ai/01-product/_work/bug-profile-crash-prd.md
- incluir comportamento esperado vs atual
- incluir passos de reproducao e ambiente impactado
- nao inventar requisitos fora da historia
```

### Prompt para iniciar PLAN da PRB/PRD de BUG

```md
Atue como Architect Agent em modo PLAN.

Leia:
- ai/AGENT_START.md
- ai/07-prompts/plan-architect-prompt.md
- ai/01-product/_work/bug-profile-crash-prd.md

Projeto alvo: bird-watcher

Gere:
- ai/03-specs/_work/bug-profile-crash-spec.md
- ai/04-tasks/_work/task-*.md

Regra para BUG:
- incluir hipotese de causa-raiz
- propor correcao minima (sem expandir escopo)
- definir validacao de regressao
```

### Sequencia dos Agents para BUG (sem ambiguidade)

1. Gerar PRB/PRD com `ai/07-prompts/board-to-prd-prompt.md`.
2. Rodar PLAN com `ai/07-prompts/plan-architect-prompt.md`.
3. Rodar EXECUTION com `ai/07-prompts/execution-coder-prompt.md`.
4. Rodar REVIEW com `ai/07-prompts/review-reviewer-prompt.md`.
5. Rodar TEST com `ai/07-prompts/test-tester-prompt.md`.
6. Humano decide aceite com base na avaliação final direto no chat do agente e promove PRD para `history`.

---

## Encadeamento automatico apos PLAN (sem montar prompt manual)

### Opcao recomendada

- O proprio `plan-architect-prompt.md` exige bloco final `NEXT_STEP`.
- Nesse bloco, a IA deve retornar:
  - `spec_path` exato gerado
  - `task_path` exato da proxima task
  - comandos prontos para `EXECUTION`, `REVIEW` e `TEST`
  - pergunta final: `Deseja executar EXECUTION, REVIEW ou TEST agora?`
- Se voce responder apenas `EXECUTION` (ou `REVIEW` / `TEST`), a IA deve iniciar imediatamente a etapa escolhida usando os caminhos do `NEXT_STEP`.

### Opcao alternativa (quando o PLAN ja rodou)

Use o prompt:
- `ai/07-prompts/next-step-dispatch-prompt.md`

Exemplo:

```md
Atue como orquestrador da proxima etapa.
Leia e siga: ai/07-prompts/next-step-dispatch-prompt.md
Feature: <feature>
```

Saida esperada:
- `spec_path` exato
- `task_path` exato
- prompt pronto de Coder
- prompt pronto de Reviewer
- prompt pronto de Tester
- pergunta final de decisao da proxima etapa
