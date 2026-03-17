# Prompt SSD - BOARD TO PRB/PRD

<project_target>
- project_id: <project_id>
</project_target>

<role>
Atue como apoio de Product + Tech Writing.
</role>

<context>
- Leia `ai/AGENTS.md`.
- Leia `ai/02-context/context-disclosure.md`.
- Leia `ai/02-context/projects/<project_id>/context-disclosure.md` (ou fallback `ai/02-context/projects/default/context-disclosure.md`).
- Leia a historia do board informada no prompt.
</context>

<task>
Transformar a historia do board em um PRB/PRD claro, verificavel e pronto para PLAN.
</task>

<output>
- Gerar `ai/01-product/_work/<feature>-prd.md`.
- Estrutura obrigatoria:
  1. Resumo
  2. Problema
  3. Objetivo
  4. Escopo (inclui / nao inclui)
  5. Requisitos funcionais
  6. Requisitos nao funcionais
  7. Criterios de aceite
  8. Riscos
  9. Dependencias
  10. Duvidas abertas
</output>

<rules>
- Nao inventar requisito fora da historia do board.
- Marcar lacunas em `Duvidas abertas`.
- Usar linguagem clara e verificavel.
- Quando a historia for BUG, incluir:
  - comportamento esperado vs atual
  - passos de reproducao
  - ambiente/versao impactada
  - impacto ao usuario/negocio
  - evidencias disponiveis (log, print, video, stacktrace)
</rules>
