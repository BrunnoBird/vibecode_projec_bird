# Bug Resolution Rules

Regras obrigatorias para todos os agents ao trabalhar em historias do tipo BUG.

## Regras

1. **Hipotese de causa raiz** — obrigatorio formular pelo menos uma hipotese de causa-raiz antes de propor qualquer correcao.
2. **Correcao minima** — propor a correcao mais simples possivel que resolva o bug. Nao expandir escopo, nao refatorar codigo adjacente, nao adicionar funcionalidades.
3. **Validacao de regressao** — definir pelo menos um cenario de validacao que garanta que a correcao nao introduz novos problemas em fluxos existentes.

## Quando aplicar

- Sempre que o PRB/PRD for identificado como tipo BUG.
- Agents devem ler e aplicar automaticamente estas regras nesse cenario, sem necessidade de repeticao no prompt.
- Este arquivo deve ser referenciado em `AGENT_START.md` como leitura condicional obrigatoria.
