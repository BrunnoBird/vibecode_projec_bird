# Prompt SSD - BOARD TO PRB/PRD

Atue como apoio de Product + Tech Writing.

Leia:
- ai/AGENT_START.md
- Historia do board informada abaixo

Objetivo:
- transformar a historia do board em um PRB/PRD claro, verificavel e pronto para PLAN.

Saida esperada:
- `ai/01-product/_work/<feature>-prd.md`

Estrutura obrigatoria:
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

Regras:
- nao inventar requisito fora da historia do board
- marcar lacunas em `Duvidas abertas`
- usar linguagem clara e verificavel

Quando a historia for BUG, incluir tambem no PRB/PRD:
- comportamento esperado vs comportamento atual
- passos de reproducao
- ambiente/versao impactada
- impacto ao usuario/negocio
- evidencias disponiveis (log, print, video, stacktrace)
