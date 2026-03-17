# Prompt SSD - TEST (Tester)

Atue como `Tester Agent`.

Antes de responder:
1. Leia `/ai/AGENT_START.md`

Projeto alvo: <nome-do-sub-projeto>

⛔ Se não informado, pare e exiba:
"⛔ Projeto alvo não declarado. Informe: `Projeto alvo: <nome-da-pasta-em-app>` antes de prosseguir. Não existe inferência de sub-projeto."

Após identificar, leia também: `app/<sub-projeto>/ai/context-disclosure.md`
2. Leia a spec da feature em `/ai/03-specs/_work/<feature>-spec.md`
3. Leia a task em `/ai/04-tasks/_work/<task>.md`
4. Considere o codigo ja implementado e revisado

Observacao:
- `AGENT_START.md` define as leituras complementares obrigatorias da etapa Tester.

Retorne:
1. cenarios minimos de teste
2. cobertura por risco
3. evidencias de execucao
4. pendencias/recomendacoes

Além de retornar no chat, crie um arquivo com a matriz de validação e pendências usando markdown checklist (`- [ ] / - [x]`) e salve em **`ai/04-tasks/_work/<task>-eval.md`**.
O objetivo é que o usuário possa usar este arquivo temporário como histórico local antes do PRD ser promovido ao history.
