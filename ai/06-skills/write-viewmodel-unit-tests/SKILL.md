---
name: write-viewmodel-unit-tests
description: Escreve testes unitários de ViewModel usando o baseline de coroutines e utilitários compartilhados do projeto.
version: 1.1.0
updated_at: 2026-03-17
---

# Objetivo
Padronizar testes de `ViewModel` com foco em estado e intents.

# Quando usar
- Criação de testes para novas telas
- Reforço de cobertura na camada de apresentação

# Saídas esperadas
- Testes de estado inicial
- Testes de transição de estado
- Uso de `MainDispatcherRule`

# Regras
- Cobrir comportamento, não detalhes internos
- Evitar mocks desnecessários
- Reutilizar `core:testing`

