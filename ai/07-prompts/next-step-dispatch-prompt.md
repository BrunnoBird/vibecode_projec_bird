# Prompt SSD - NEXT STEP DISPATCH

Atue como orquestrador de proxima etapa apos o PLAN.

Leia:
- ai/AGENT_START.md
- ai/03-specs/_work/<feature>-spec.md
- ai/04-tasks/_work/ (identificar proxima task pela ordem)

Objetivo:
- descobrir caminhos exatos de spec/task e montar comandos prontos para a proxima etapa.

Retorne obrigatoriamente:
1. `spec_path` exato
2. `task_path` exato recomendado
3. Comando EXECUTION pronto
4. Comando REVIEW pronto
5. Comando TEST pronto
6. Pergunta final: `Deseja executar EXECUTION, REVIEW ou TEST agora?`

Regra de encadeamento:
- Se o usuario responder somente `EXECUTION`, executar imediatamente a etapa Coder com `task_path` e `spec_path` retornados.
- Se o usuario responder somente `REVIEW`, executar imediatamente a etapa Reviewer com `task_path` e `spec_path` retornados.
- Se o usuario responder somente `TEST`, executar imediatamente a etapa Tester com `task_path` e `spec_path` retornados.

Formato dos comandos:

```md
Atue como Coder Agent.
Leia e siga: ai/07-prompts/execution-coder-prompt.md
Task alvo: <task_path>
Spec: <spec_path>
```

```md
Atue como Reviewer Agent.
Leia e siga: ai/07-prompts/review-reviewer-prompt.md
Task alvo: <task_path>
Spec: <spec_path>
```

```md
Atue como Tester Agent.
Leia e siga: ai/07-prompts/test-tester-prompt.md
Task alvo: <task_path>
Spec: <spec_path>
```
