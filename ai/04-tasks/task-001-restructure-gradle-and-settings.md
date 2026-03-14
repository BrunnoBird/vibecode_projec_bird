# Task 001 - Restructure Gradle And Settings

## Objetivo
Reestruturar a configuração Gradle para suportar os módulos `core:*` e `feature:home`.

## Contexto
- PRD: `ai/01-product/prd-bootstrap-project.md`
- Spec: `ai/03-specs/project-bootstrap-spec.md`

## Entradas
- Projeto Android Studio padrão existente
- Version catalog atual

## Saídas esperadas
- `settings.gradle.kts` com os novos módulos
- `build.gradle.kts` raiz atualizado
- `gradle/libs.versions.toml` consolidado

## Dependências
- Nenhuma

## Restrições
- Não adicionar frameworks fora do escopo do bootstrap
- Manter a configuração simples

## Critérios de conclusão
- [ ] Gradle sync reconhece todos os módulos alvo
- [ ] Dependências principais estão no version catalog

## Escopo para o agente
Implemente apenas a base de build e declaração de módulos. Não criar lógica de UI nesta task.
