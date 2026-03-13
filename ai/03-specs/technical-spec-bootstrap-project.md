# Technical Spec — Bootstrap do Projeto Android

## 1. Objetivo técnico
Criar a fundação técnica do projeto Android com Kotlin, Compose, Material 3, MVI, ViewModel e modularização mínima suficiente para suportar o desenvolvimento das próximas features.

## 2. Referência ao PRD
- `ai/01-product/prd-bootstrap-project.md`

## 3. Situação atual
O projeto ainda não possui base estrutural definida.

## 4. Solução proposta
Criar um app Android com módulos core e uma feature inicial, incluindo:
- build configuration padrão
- tema Material 3
- shell de navegação
- baseline MVI
- baseline de testes

## 5. Arquitetura da solução
### Camadas afetadas
- UI
- Application de apresentação
- Infra de build

### Módulos afetados
- app
- core:common
- core:ui
- core:designsystem
- core:navigation
- core:testing
- feature:home

## 6. Contratos
### Inputs
- intents de UI da feature inicial

### Outputs
- renderização da tela inicial
- state previsível
- efeitos únicos quando necessários

### Erros
- o bootstrap deve minimizar fluxos complexos de erro; foco em compilação, estrutura e previsibilidade

## 7. Modelos de dados
### Entidades internas esperadas
- `HomeContract.Intent`
- `HomeContract.UiState`
- `HomeContract.Effect`
- `BaseViewModel` ou estrutura equivalente leve para MVI

## 8. Fluxo técnico
1. Configurar settings.gradle.kts e build.gradle.kts raiz
2. Criar módulos e dependências mínimas
3. Configurar Compose e Material 3
4. Criar tema base em `core:designsystem`
5. Criar baseline MVI reutilizável
6. Criar `feature:home`
7. Integrar `feature:home` no `app`
8. Adicionar baseline de testes unitários

## 9. Decisões técnicas
- Decisão: modularização mínima inicial
- Justificativa: reduzir acoplamento sem overengineering
- Trade-off: mais arquivos desde o início, porém maior clareza estrutural

- Decisão: MVI somente na camada de apresentação
- Justificativa: previsibilidade de estado e testabilidade
- Trade-off: mais boilerplate inicial

- Decisão: Material 3 padrão no bootstrap
- Justificativa: velocidade e consistência visual inicial
- Trade-off: design system custom pode vir depois

## 10. Impactos
- Impacto em API: nenhum
- Impacto em banco: nenhum
- Impacto em UI: criação do shell inicial
- Impacto em telemetria: nenhum nesta fase
- Impacto em testes: baseline inicial de ViewModel e reducers

## 11. Estratégia de rollout
- Sem feature flag
- Aplicação local/interna inicialmente
- Validar por build + execução + testes

## 12. Estratégia de testes
- Unitários para ViewModel base/feature home
- Testar mudança de estado inicial
- Testar processamento de intent simples
- Validar reducers/helpers se existirem

## 13. Critérios técnicos de aceite
- [ ] Projeto compila
- [ ] Todos os módulos referenciados corretamente
- [ ] Navegação inicial funcionando
- [ ] Baseline MVI reutilizável criada
- [ ] Testes unitários básicos passam
