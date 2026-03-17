# Context Disclosure - bird-sounds

## Identificacao
- project_id: `bird-sounds`
- Escopo: projeto/modulo `app` para fluxo Bird Sounds

## Plataforma e linguagem
- Android
- Kotlin

## UI
- XML (Views)
- Material Components (quando aplicavel)

## Arquitetura
- MVVM
- `ViewModel` + `LiveData`/`StateFlow` conforme codigo existente

## Contrato de camada de apresentacao
- `Fragment/Activity` para UI XML
- `ViewModel` para estado e orquestracao
- Evitar regra de negocio na camada de UI

## Navegacao
- Navigation Component (XML/NavGraph) quando aplicavel

## Testes
- Testes unitarios para ViewModel e logica critica
- Evitar acoplamento desnecessario em testes de UI

## Regras especificas
- Nao introduzir Compose neste projeto, salvo aprovacao explicita.
- Manter consistencia com padroes MVVM existentes.
