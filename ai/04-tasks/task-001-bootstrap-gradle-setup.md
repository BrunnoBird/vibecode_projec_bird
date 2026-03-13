# Task 001 — Configurar bootstrap Gradle do projeto

## Objetivo
Criar a configuração inicial do projeto Android usando Gradle Kotlin DSL com suporte a múltiplos módulos.

## Contexto
- PRD: `ai/01-product/prd-bootstrap-project.md`
- Spec: `ai/03-specs/technical-spec-bootstrap-project.md`

## Entradas
- Projeto Android vazio ou inexistente

## Saídas esperadas
- `settings.gradle.kts`
- `build.gradle.kts` raiz
- catálogo de versões se adotado
- configuração base compartilhada para módulos Android/Kotlin

## Restrições
- Não adicionar bibliotecas desnecessárias
- Preparar terreno para Compose, ViewModel e testes

## Critérios de conclusão
- [ ] Projeto sincroniza no Gradle
- [ ] Módulos podem ser adicionados sem retrabalho estrutural

## Instrução para o agente
Implemente somente o bootstrap de build. Não criar a feature ainda.
