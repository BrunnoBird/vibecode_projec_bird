# 06 - Operacao Viva da Documentacao

## Checklist operacional rapido

1. Confirmar leitura de `AGENT_START` + prompt oficial da etapa.
2. Confirmar PRB/PRD, spec e task corretos em `_work` para o escopo.
3. Confirmar status de skill por task.
4. Executar etapa atual sem expandir escopo.
5. Registrar handoff/eval em `_runs` usando template oficial.
6. Registrar evidencias de review/test antes do aceite final.

## Playbook sem ambiguidade

- Entrada da etapa: sempre pelo prompt oficial em `ai/07-prompts/`.
- Saida da etapa: sempre registrar handoff/eval efemero em `_runs` quando aplicavel.
- Fonte de verdade de padrao: `AGENT_START`, `ai/05-agents/`, `ai/06-skills/`, `ai/07-prompts/`.
- Artefatos de historia em execucao: `ai/01-product/_work/`, `ai/03-specs/_work/`, `ai/04-tasks/_work/`.
- Artefatos efemeros (`_tmp`, `_scratch`, `_runs`) nao substituem documentos oficiais.
- Templates oficiais de handoff/eval devem ser reutilizados para padrao de time.

## Cadencia de revisao da documentacao

- Revisao minima: a cada feature concluida.
- Revisao completa: mensal (ou por release importante).

## Quando atualizar docs

Atualizar documentacao sempre que houver:
- mudanca de fluxo SSD
- mudanca de contrato de agentes
- mudanca de templates de `_runs`
- nova convencao de task/spec
- nova politica de skills
- nova pratica de review/test

## Dono da atualizacao

- Dono principal: Tech Lead (ou owner tecnico da feature)
- Executor: quem abre a PR da mudanca (humano ou IA assistida)
- Revisor: pelo menos 1 pessoa que nao foi autora da alteracao

## Mini changelog por arquivo

Use este bloco no final de cada doc alterado:

```md
## Changelog
- YYYY-MM-DD - <resumo da mudanca> - impacto: <baixo|medio|alto>
```

## Regra de manutencao continua

Documentacao boa e documentacao viva:
- curta, objetiva e atualizada
- alinhada com o fluxo real praticado
- sem duplicacao desnecessaria entre arquivos
- revisada junto com mudancas em prompts e contratos de agentes
