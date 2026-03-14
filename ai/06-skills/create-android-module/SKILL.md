---
name: create-android-module
description: Cria um módulo Android aderente ao padrão do projeto, com namespace, build file e manifest mínimos.
---

# Objetivo
Evitar divergência estrutural ao adicionar módulos novos.

# Quando usar
- Criação de módulo `core:*`
- Criação de módulo `feature:*`

# Saídas esperadas
- `build.gradle.kts`
- `src/main/AndroidManifest.xml`
- pacote base do módulo

# Regras
- Usar apenas dependências necessárias
- Definir namespace coerente com o package base
- Não introduzir dependências cíclicas
