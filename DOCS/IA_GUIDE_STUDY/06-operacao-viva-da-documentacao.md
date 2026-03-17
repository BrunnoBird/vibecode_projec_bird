# 06 - Operacao Viva da Documentacao

## Checklist operacional rapido

1. Confirmar leitura de `AGENT_START` + prompt oficial da etapa.
2. Confirmar PRB/PRD, spec e task corretos em `_work` para o escopo.
3. Confirmar status de skill por task.
4. Executar etapa atual sem expandir escopo.
5. Garantir que o `Projeto alvo:` está declarado no prompt.
6. Promover PRD aprovado para `history/` ao final do fluxo.

## Playbook sem ambiguidade

- Entrada da etapa: sempre pelo prompt oficial em `ai/07-prompts/`.
- Pos-PLAN: usar bloco `NEXT_STEP` ou `ai/07-prompts/next-step-dispatch-prompt.md` para decidir a etapa seguinte.
- Saida da etapa: documentada no próprio log da conversa, mas o **Reviewer** e **Tester** geram temporariamente uma checklist local (`*-review.md` e `*-eval.md`) em `_work/` para ajudar no acompanhamento antes do PR.
- Fonte de verdade de padrao: `AGENT_START`, `ai/05-agents/`, `ai/06-skills/`, `ai/07-prompts/`.
- Artefatos de historia em execucao: `ai/01-product/_work/`, `ai/03-specs/_work/`, `ai/04-tasks/_work/`.
- Artefatos aprovados: `ai/01-product/history/`.
- Artefatos efemeros (`_tmp`, `_scratch`) nao substituem documentos oficiais.

## Cadencia de revisao da documentacao

- Revisao minima: a cada feature concluida.
- Revisao completa: mensal (ou por release importante).

## Quando atualizar docs

Atualizar documentacao sempre que houver:
- mudanca de fluxo SSD
- mudanca de contrato de agentes
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
