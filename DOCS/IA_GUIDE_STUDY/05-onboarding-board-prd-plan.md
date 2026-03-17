# 05 - Onboarding: Board -> PRB/PRD -> Flow SSD (Role Skills)

## Exemplo de flow real

Card da PM no board:
`Adicionar aba Profile na bottom navigation com tela placeholder`

Fluxo completo:
1. PM/PO cria a historia no board.
2. Humano + IA usam prompt oficial para gerar PRB/PRD.
3. Role skill `architect-agent` gera spec + tasks + decisoes de skill.
4. Role skill `coder-agent` implementa task.
5. Role skill `reviewer-agent` revisa e registra achados.
6. Role skill `tester-agent` valida e recomenda aceite.
7. Humano aprova e faz merge.

## Regra de padronizacao para times

- Sempre iniciar etapa com prompt oficial de `ai/07-prompts/`.
- Sempre declarar `project_id` no prompt.
- Sempre registrar handoff/eval operacional em `_runs`.
- Sempre usar templates oficiais para artefatos de `_runs`.
- Considerar `ai/AGENTS.md` como contexto base da etapa (nao reler se ja estiver no contexto atual).
- Em conflito PRD/Spec/Task, pausar etapa e gerar `ai/_tmp/CONFLICT.md`.

## Prompt recomendado para gerar PRB/PRD a partir do Board

Use o template oficial:
- `ai/07-prompts/board-to-prd-prompt.md`

### Exemplo pronto (copiar e preencher)

```xml
<project_target>
- project_id: <project_id>
</project_target>

<role>
Atue como apoio de Product + Tech Writing.
</role>

<context>
- Base ja carregada: ai/AGENTS.md (nao reler se ja estiver no contexto)
- Leia: ai/02-context/context-disclosure.md
- Leia: ai/02-context/projects/<project_id>/context-disclosure.md (ou fallback default)
- Leia: ai/07-prompts/board-to-prd-prompt.md
</context>

<task>
Gerar PRB/PRD a partir da historia do board.
Historia:
- Titulo: <titulo>
- Contexto: <contexto>
- Problema: <problema>
- Resultado esperado: <resultado>
- Restricoes: <restricoes>
- Dependencias conhecidas: <dependencias>
</task>

<output>
- criar ai/01-product/_work/<feature>-prd.md
- manter lacunas em "Duvidas abertas"
- nao inventar requisitos fora da historia
</output>
```

## Prompt recomendado para iniciar PLAN a partir do PRB/PRD

Use o template oficial:
- `ai/07-prompts/plan-architect-prompt.md`

### Exemplo pronto (copiar e preencher)

```xml
<project_target>
- project_id: <project_id>
</project_target>

<role>
Atue com role skill architect-agent em modo PLAN.
</role>

<context>
- Base ja carregada: ai/AGENTS.md (nao reler se ja estiver no contexto)
- Leia: ai/02-context/context-disclosure.md
- Leia: ai/02-context/projects/<project_id>/context-disclosure.md (ou fallback default)
- Leia: ai/06-skills/architect-agent/SKILL.md
- Leia: ai/07-prompts/plan-architect-prompt.md
- Leia: ai/01-product/_work/<feature>-prd.md
</context>

<task>
Planejar implementacao da feature.
</task>

<output>
- ai/03-specs/_work/<feature>-spec.md
- ai/04-tasks/_work/task-*.md
- decisoes de skill por task
- ordem de execucao
- riscos tecnicos
</output>

<rules>
- Em conflito PRD vs spec proposta: gerar ai/_tmp/CONFLICT.md e pausar.
</rules>
```

## Prompt recomendado para seguir o flow completo por etapa

### EXECUTION (coder-agent)
```xml
<project_target>
- project_id: <project_id>
</project_target>
<role>
Atue com role skill coder-agent.
</role>
<context>
- Base ja carregada: ai/AGENTS.md (nao reler se ja estiver no contexto)
- Leia: ai/07-prompts/execution-coder-prompt.md
</context>
<task>
Task alvo: ai/04-tasks/_work/<task>.md
Spec: ai/03-specs/_work/<feature>-spec.md
</task>
```

### REVIEW (reviewer-agent)
```xml
<project_target>
- project_id: <project_id>
</project_target>
<role>
Atue com role skill reviewer-agent.
</role>
<context>
- Base ja carregada: ai/AGENTS.md (nao reler se ja estiver no contexto)
- Leia: ai/07-prompts/review-reviewer-prompt.md
</context>
<task>
Task alvo: ai/04-tasks/_work/<task>.md
Spec: ai/03-specs/_work/<feature>-spec.md
</task>
```

### TEST (tester-agent)
```xml
<project_target>
- project_id: <project_id>
</project_target>
<role>
Atue com role skill tester-agent.
</role>
<context>
- Base ja carregada: ai/AGENTS.md (nao reler se ja estiver no contexto)
- Leia: ai/07-prompts/test-tester-prompt.md
</context>
<task>
Task alvo: ai/04-tasks/_work/<task>.md
Spec: ai/03-specs/_work/<feature>-spec.md
</task>
```

## Aplicabilidade operacional (quando usar cada pasta)

1. `ai/07-prompts/`: iniciar etapa (Board->PRB/PRD, PLAN, EXECUTION, REVIEW, TEST).
2. `ai/02-context/projects/`: resolver contexto por `project_id`.
3. `ai/08-handoffs/_runs/`: registrar entrega de coder/reviewer da task atual.
4. `ai/09-evals/_runs/`: registrar validacao final de tester.
5. `ai/03-specs/_work/` e `ai/04-tasks/_work/`: artefatos locais da feature em execucao.
6. `ai/_tmp/`: conflitos e bloqueios operacionais (ex.: `CONFLICT.md`).

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

```xml
<project_target>
- project_id: bird-sounds
</project_target>
<role>
Atue como apoio de Product + Tech Writing.
</role>
<context>
- Base ja carregada: ai/AGENTS.md
- Leia: ai/02-context/context-disclosure.md
- Leia: ai/02-context/projects/bird-sounds/context-disclosure.md
- Leia: ai/07-prompts/board-to-prd-prompt.md
</context>
<task>
Historia do Board (BUG):
- Titulo: BUG - App fecha ao abrir Profile apos logout
- Contexto: crash apos logout/login rapido
- Problema: tela Profile fecha o app
- Resultado esperado: Profile abre normalmente
- Restricoes: nao alterar fluxo de autenticacao
- Dependencias conhecidas: feature:profile, app navigation
- Evidencias: stacktrace do Crashlytics + video curto de reproducao
</task>
<output>
- criar ai/01-product/_work/bug-profile-crash-prd.md
- incluir comportamento esperado vs atual
- incluir passos de reproducao e ambiente impactado
- nao inventar requisitos fora da historia
</output>
```

### Prompt para iniciar PLAN da PRB/PRD de BUG

```xml
<project_target>
- project_id: bird-sounds
</project_target>
<role>
Atue com role skill architect-agent em modo PLAN.
</role>
<context>
- Base ja carregada: ai/AGENTS.md (nao reler se ja estiver no contexto)
- Leia: ai/02-context/context-disclosure.md
- Leia: ai/02-context/projects/bird-sounds/context-disclosure.md
- Leia: ai/06-skills/architect-agent/SKILL.md
- Leia: ai/07-prompts/plan-architect-prompt.md
- Leia: ai/01-product/_work/bug-profile-crash-prd.md
</context>
<task>
Gere:
- ai/03-specs/_work/bug-profile-crash-spec.md
- ai/04-tasks/_work/task-*.md
</task>
<rules>
- incluir hipotese de causa-raiz
- propor correcao minima (sem expandir escopo)
- definir validacao de regressao
- em conflito PRD vs spec: gerar ai/_tmp/CONFLICT.md e pausar
</rules>
```

### Sequencia das etapas para BUG (sem ambiguidade)

1. Gerar PRB/PRD com `ai/07-prompts/board-to-prd-prompt.md`.
2. Rodar PLAN com `ai/07-prompts/plan-architect-prompt.md`.
3. Rodar EXECUTION com `ai/07-prompts/execution-coder-prompt.md`.
4. Rodar REVIEW com `ai/07-prompts/review-reviewer-prompt.md`.
5. Rodar TEST com `ai/07-prompts/test-tester-prompt.md`.
6. Humano decide aceite com base no eval em `_runs`.

---

## Encadeamento automatico apos PLAN (sem montar prompt manual)

### Opcao recomendada

- O proprio `plan-architect-prompt.md` exige bloco final `NEXT_STEP`.
- Nesse bloco, a IA deve retornar:
  - `project_id`
  - `spec_path` exato gerado
  - `task_path` exato da proxima task
  - comandos prontos para `EXECUTION`, `REVIEW` e `TEST`
  - pergunta final: `Deseja executar EXECUTION, REVIEW ou TEST agora?`
- Se voce responder apenas `EXECUTION` (ou `REVIEW` / `TEST`), a IA deve iniciar imediatamente a etapa escolhida usando os caminhos do `NEXT_STEP`.

### Opcao alternativa (quando o PLAN ja rodou)

Use o prompt:
- `ai/07-prompts/next-step-dispatch-prompt.md`

Exemplo:

```xml
<project_target>
- project_id: <project_id>
</project_target>
<role>
Atue como orquestrador da proxima etapa.
</role>
<context>
- Leia e siga: ai/07-prompts/next-step-dispatch-prompt.md
</context>
<task>
Feature: <feature>
</task>
```

Saida esperada:
- `project_id`
- `spec_path` exato
- `task_path` exato
- prompt pronto de coder
- prompt pronto de reviewer
- prompt pronto de tester
- pergunta final de decisao da proxima etapa
