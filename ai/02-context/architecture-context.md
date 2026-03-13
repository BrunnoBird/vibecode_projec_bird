# Architecture Context

## Arquitetura
- Modular por responsabilidade
- Camada de apresentação baseada em MVI
- Unidirectional Data Flow
- ViewModel para orquestração

## Módulos esperados
- `app`: ponto de entrada e wiring principal
- `core:common`: utilidades compartilhadas e contratos leves
- `core:ui`: componentes e helpers de UI compartilhados
- `core:designsystem`: tema, tokens e componentes básicos
- `core:navigation`: abstrações mínimas de rotas/navegação
- `core:testing`: utilitários de teste
- `feature:home`: primeira feature shell

## Convenções obrigatórias
- Cada feature deve ter package `presentation`
- Cada tela deve expor `Screen` e `ViewModel`
- Contratos devem ficar centralizados em arquivo `Contract`
- `UiState` único por tela
- `Effect` para navegação, toast/snackbar e eventos únicos

## Restrições
- Não adicionar frameworks desnecessários no bootstrap
- Não adicionar camadas de domínio/dados sem necessidade real
- Não criar abstrações genéricas antes do primeiro uso concreto
- Não criar design system complexo no bootstrap
