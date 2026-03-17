# Prompt SSD - NEXT STEP DISPATCH

<project_target>
- project_id: <project_id>
</project_target>

<role>
Atue como orquestrador de proxima etapa apos o PLAN.
</role>

<context>
- Leia `ai/AGENTS.md`.
- Leia `ai/02-context/context-disclosure.md`.
- Leia `ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `ai/02-context/projects/default/context-disclosure.md`).
- Leia `ai/03-specs/_work/<feature>-spec.md`.
- Leia `ai/04-tasks/_work/` e identifique a proxima task pela ordem.
</context>

<task>
Descobrir caminhos exatos de spec/task e montar comandos prontos para a proxima etapa.
</task>

<output>
Retorne obrigatoriamente:
1. `project_id`
2. `spec_path` exato
3. `task_path` exato recomendado
4. Comando EXECUTION pronto
5. Comando REVIEW pronto
6. Comando TEST pronto
7. Pergunta final: `Deseja executar EXECUTION, REVIEW ou TEST agora?`
</output>

<rules>
- Se o usuario responder somente `EXECUTION`, executar imediatamente a etapa Coder.
- Se o usuario responder somente `REVIEW`, executar imediatamente a etapa Reviewer.
- Se o usuario responder somente `TEST`, executar imediatamente a etapa Tester.
</rules>

<code language="md">
Atue como Coder Agent.
Leia e siga: ai/07-prompts/execution-coder-prompt.md
Project: <project_id>
Task alvo: <task_path>
Spec: <spec_path>
</code>

<code language="md">
Atue como Reviewer Agent.
Leia e siga: ai/07-prompts/review-reviewer-prompt.md
Project: <project_id>
Task alvo: <task_path>
Spec: <spec_path>
</code>

<code language="md">
Atue como Tester Agent.
Leia e siga: ai/07-prompts/test-tester-prompt.md
Project: <project_id>
Task alvo: <task_path>
Spec: <spec_path>
</code>
