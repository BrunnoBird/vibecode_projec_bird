# PRD: Criar tela do diário de observações vazia

**Projeto alvo:** `bird-watcher`
**Status:** Pronto para PLAN ✅

---

## 1. Contexto e Problema
O sub-projeto `bird-watcher` precisa ter um diário onde as observações do usuário ficarão salvas. Atualmente o projeto está vazio e carece de uma tela "Home" (Diário). Precisamos estabelecer essa tela principal, começando pelo estado visual em que a lista de observações encontra-se vazia.

## 2. Objetivo
Criar uma tela inicial em Jetpack Compose que sirva como a home do sub-projeto `bird-watcher`, incluindo o título apropriado e uma mensagem clara de "estado vazio" informando ao usuário que ainda não há aves registradas.

## 3. Escopo Implementável
- [x] Criar componente Toplevel de UI (ex: `DiarioScreen` ou `HomeScreen`) usando Jetpack Compose.
- [x] Implementar AppBar/Header com o título "Meu Diário".
- [x] Implementar Container principal com a mensagem "Nenhuma ave registrada ainda" alinhada perfeitamente ao centro da tela.
- [x] Posicionar a tela como Ponto de Entrada / Tela Inicial no sub-projeto `bird-watcher` (se aplicável ao módulo atual).

## 4. Fora de Escopo
- Lógica de persistência em banco de dados local (Room) ou remoto.
- Fluxo de adição de nova observação (botão FAB ou formulário).
- Mock de lista estruturada.
- Navegação para outras telas do app.

## 5. Critérios de Aceite
- [ ] O app `bird-watcher` abre exibindo a nova tela de diário com sucesso.
- [ ] O título "Meu Diário" está visível no AppBar no topo.
- [ ] A mensagem central "Nenhuma ave registrada ainda" está centralizada (vertical e horizontalmente).
- [ ] O código segue os padrões globais de UI definidos em `ai/02-context/context-disclosure.md` (Jetpack Compose).

## 6. Restrições e Decisões de Arquitetura
- **Persistência restrita**: Estritamente UI estática, sem integração com banco de dados nessa fase.
- **Componentização**: Seguir boas práticas de Compose (state hoisting se necessário futuramente, functions focadas em UI).

## 7. Dependências
- Nenhuma dependência cruzada externa, apenas as libs nativas do Jetpack Compose que já compõem o contexto Global do projeto e do Bird Watcher.

## 8. Dúvidas Abertas
- Existe um Typography ou Color guideline específico para o `bird-watcher` que deve ser aplicado nesta view vazia? (Por ora, o escopo permite usar estilos Material 3 padrão).
