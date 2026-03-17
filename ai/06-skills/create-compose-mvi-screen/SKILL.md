---
name: create-compose-mvi-screen
description: Cria uma tela Compose com Contract, ViewModel, Screen e teste unitário base seguindo o padrão MVI do projeto.
version: 1.1.0
updated_at: 2026-03-17
---

# Objetivo
Padronizar a criação de novas telas com o menor conjunto de arquivos necessário.

# Quando usar
- Nova screen em uma feature existente
- Primeira tela de uma nova feature

# Saídas esperadas
- `<Feature>Contract.kt`
- `<Feature>ViewModel.kt`
- `<Feature>Screen.kt`
- `<Feature>ViewModelTest.kt`

# Regras
- Um `UiState` por tela
- `Intent`, `UiState` e `Effect` no contrato
- `ViewModel` deve estender a baseline MVI do projeto
- O teste deve cobrir estado inicial e ao menos um intent

