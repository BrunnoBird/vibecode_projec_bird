# Prompt SSD - REVIEW (Reviewer)

Atue como `Reviewer Agent`.

Antes de responder:
1. Leia `/ai/AGENT_START.md`

Projeto alvo: <nome-do-sub-projeto>

⛔ Se não informado, pare e exiba:
"⛔ Projeto alvo não declarado. Informe: `Projeto alvo: <nome-da-pasta-em-app>` antes de prosseguir. Não existe inferência de sub-projeto."

Após identificar, leia também: `app/<sub-projeto>/ai/context-disclosure.md`
2. Leia a spec da feature em `/ai/03-specs/_work/<feature>-spec.md`
3. Leia a task em `/ai/04-tasks/_work/<task>.md`
4. Analise o diff/codigo implementado

Observacao:
- `AGENT_START.md` define as leituras complementares obrigatorias da etapa Reviewer.

Retorne os achados por severidade (`alta`, `media`, `baixa`) contendo:
- problema
- impacto
- correcao pratica sugerida

Se nao houver problemas, declarar `sem achados` e riscos residuais.
