# PRD — Bootstrap de Projeto Android Kotlin + Compose

## 1. Resumo
Criar a estrutura inicial de um aplicativo Android moderno com Kotlin e Jetpack Compose, preparado para crescimento modular e desenvolvimento guiado por especificação.

## 2. Problema
Sem uma base técnica padronizada, o projeto tende a crescer de forma inconsistente, com acoplamento excessivo, baixa testabilidade e dificuldade de manutenção.

## 3. Objetivo
Disponibilizar uma base pronta para o desenvolvimento das próximas features com arquitetura previsível, testável e escalável.

## 4. Público / atores envolvidos
- Engenheiro Android
- Time de produto
- Time de design system
- IA agente de implementação

## 5. Escopo
### Inclui
- Estrutura Gradle inicial
- Módulos base
- Compose + Material 3
- Arquitetura MVI base
- ViewModel base
- Navegação inicial
- Setup de testes unitários

### Não inclui
- Integração com backend real
- Persistência local
- Analytics
- Autenticação
- CI/CD completo

## 6. Requisitos funcionais
- RF01: o projeto deve abrir e compilar no Android Studio
- RF02: deve existir uma tela inicial renderizada com Compose
- RF03: deve existir uma estrutura MVI reutilizável
- RF04: o projeto deve ser modularizado
- RF05: deve existir baseline de testes unitários

## 7. Requisitos não funcionais
- RNF01: arquitetura clara
- RNF02: baixo acoplamento
- RNF03: alta legibilidade
- RNF04: facilidade de expansão
- RNF05: aderência ao Material Design 3

## 8. Regras de negócio
- RN01: a primeira entrega é técnica, não de produto
- RN02: a estrutura deve privilegiar evolução incremental
- RN03: módulos core devem conter somente responsabilidades compartilhadas

## 9. Fluxo principal
1. Criar o projeto base
2. Modularizar o projeto
3. Criar baseline de tema e UI
4. Criar baseline MVI
5. Criar navegação inicial
6. Criar baseline de testes

## 10. Fluxos alternativos / exceções
- Caso 1: se a modularização gerar complexidade desnecessária, reduzir o número de módulos mantendo separação conceitual.
- Caso 2: se alguma dependência introduzir atrito no bootstrap, optar pela alternativa mais simples.

## 11. Critérios de aceite
- [ ] O projeto compila
- [ ] Existem módulos base separados
- [ ] Existe uma tela inicial Compose
- [ ] Existe um tema Material 3 funcional
- [ ] Existe baseline MVI com ViewModel
- [ ] Existe baseline de testes unitários

## 12. Métricas de sucesso
- Tempo para criar a próxima feature reduzido
- Menor retrabalho estrutural nas primeiras sprints
- Clareza arquitetural para onboarding

## 13. Dependências
- Android Studio
- Kotlin
- Compose BOM
- Lifecycle ViewModel Compose
- Navigation Compose
- Material 3
- Framework de testes unitários

## 14. Riscos
- Overengineering na modularização inicial
- Criar base rígida demais antes da primeira feature real

## 15. Dúvidas abertas
- O projeto usará Hilt, Koin ou DI manual na próxima fase?
- Haverá módulo `core:data` já no bootstrap ou apenas quando surgir uso real?
