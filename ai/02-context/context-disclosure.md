# Context Disclosure (Global Minimo)

## Objetivo
Definir apenas restricoes transversais do workspace, sem forcar stack/arquitetura de um projeto especifico.

## Regras globais de contexto
- O prompt deve declarar `project_id` (ou modulo alvo).
- O contexto efetivo e resolvido por:
  1. `ai/02-context/context-disclosure.md` (este arquivo)
  2. `ai/02-context/projects/<project_id>/context-disclosure.md`
  3. fallback `ai/02-context/projects/default/context-disclosure.md`

## Precedencia
- `contexto do projeto` > `contexto global` > `default`.

## Qualidade transversal
- Escopo controlado por PRB/PRD, spec e task.
- Testabilidade obrigatoria para logica critica.
- Em conflitos de artefato: gerar `ai/_tmp/CONFLICT.md` e pausar etapa.
