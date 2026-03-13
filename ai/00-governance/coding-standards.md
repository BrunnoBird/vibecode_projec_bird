# Coding Standards

## Kotlin
- Preferir `val` sempre que possível.
- Usar data classes para estados e modelos simples.
- Funções pequenas e com responsabilidade clara.
- Evitar classes utilitárias genéricas demais.
- Evitar heranças desnecessárias.

## Compose
- Composables sem regra de negócio.
- Preferir state hoisting.
- Componentes reutilizáveis devem viver em módulos core quando fizer sentido.
- Sempre considerar estados: loading, content, error e empty quando aplicável.

## MVI
- Cada tela deve ter:
  - `Contract` (Intent, UiState, Effect)
  - `ViewModel`
  - `Screen`
- Um único `UiState` por tela.
- `Effect` apenas para eventos únicos.

## Testes
- Testes unitários em ViewModel e reducers/transformações.
- Nome dos testes descritivo.
- Cobrir fluxo feliz e fluxos de erro prioritários.
