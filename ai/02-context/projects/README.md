# Contextos por Projeto

Cada projeto/modulo pode ter contexto proprio em:
- `ai/02-context/projects/<project_id>/context-disclosure.md`

## Regra de uso
1. Prompt informa `project_id`.
2. Carrega `ai/02-context/context-disclosure.md`.
3. Carrega `ai/02-context/projects/<project_id>/context-disclosure.md`.
4. Se nao existir, usar `ai/02-context/projects/default/context-disclosure.md`.

## Precedencia
- projeto > global > default.

## Projetos cadastrados
- `default`
- `bird-sounds`
