# PRD — AI Multi-Project Context Flow

**Arquivo:** `feature-ai-multi-project-context-flow-prd.md`
**Tipo:** Feature
**Data:** 2026-03-16
**Status:** Pronto para PLAN ✅

---

## 1. Resumo

O fluxo atual de AI do projeto não consegue operar corretamente quando a pasta `app/` contém múltiplos sub-projetos independentes entre si. A AI não tem mecanismo para identificar qual sub-projeto deve ser o alvo da sua atuação, e não existem agents, arquitetos ou skills configurados para lidar com contextos e padrões específicos de cada sub-projeto. Esta feature reestrutura o flow de AI para suportar essa arquitetura multi-projeto de forma clara, navegável e documentada.

---

## 2. Problema

### Situação atual
- A pasta `app/` do repositório contém múltiplos sub-projetos que existem de forma independente — não há ligação entre eles.
- A AI não possui mecanismo de descoberta ou seleção do sub-projeto alvo antes de atuar.
- Não há separação de contexto, agents, arquiteto ou skills específicos por sub-projeto.
- O resultado é que a AI pode atuar no sub-projeto errado, gerar código incompatível ou simplesmente falhar ao tentar entender o escopo.

### Impacto
- Execuções incorretas e perda de confiança no fluxo de AI.
- Retrabalho manual para corrigir atuações feitas no contexto errado.
- Impossibilidade de escalar o uso de AI em projetos com estrutura multi-módulo ou multi-app.

---

## 3. Objetivo

Reestruturar o flow de AI para que:

1. A AI saiba **qual sub-projeto deve ser o alvo** antes de qualquer atuação.
2. Existam **agents e arquitetos capazes de lidar com contextos específicos** de cada sub-projeto.
3. O flow seja **fácil de seguir** por qualquer membro do time.
4. As **documentações sejam atualizadas** para refletir a nova estrutura, removendo partes que não se aplicam mais.

---

## 4. Escopo

### Inclui
- Definição de um mecanismo de seleção/declaração de sub-projeto alvo no início de qualquer prompt ou sessão de AI.
- Criação ou adaptação de agents (architect, coder, reviewer, tester) com suporte a contexto específico de sub-projeto.
- Criação ou adaptação de skills específicas por sub-projeto, quando aplicável.
- Atualização dos prompts oficiais em `ai/07-prompts/` para suportar o novo flow multi-projeto.
- Atualização do `AGENT_START.md` para incluir a política de seleção de sub-projeto.
- Atualização da documentação afetada em `ai/00-governance/`, `ai/02-context/` e `ai/05-agents/`.
- Remoção ou marcação como obsoleto de qualquer artefato que contradiga a nova estrutura.

### Não inclui
- Alteração na estrutura de código dos sub-projetos em `app/`.
- Criação de CI/CD ou pipelines automatizados.
- Integração com ferramentas externas de gestão de projeto (Jira, Linear, etc.).
- Qualquer automação de deploy.

---

## 5. Requisitos Funcionais

| ID | Requisito |
|----|-----------|
| RF-01 | O flow de AI deve exigir a declaração explícita do sub-projeto alvo antes de qualquer etapa (PLAN, EXECUTION, REVIEW, TEST). |
| RF-02 | O `AGENT_START.md` deve descrever a política de seleção de sub-projeto e como ela se integra ao fluxo canônico. |
| RF-03 | Cada sub-projeto deve ter ou herdar um contexto de disclosure (`context-disclosure`) que descreva seu stack, padrões e convenções. |
| RF-04 | Os agents (architect, coder, reviewer, tester) devem carregar o contexto do sub-projeto selecionado antes de atuar. |
| RF-05 | Skills existentes em `ai/06-skills/` devem ser verificadas quanto à compatibilidade com sub-projetos específicos; caso uma skill seja exclusiva de um sub-projeto, isso deve ser indicado em sua documentação. |
| RF-06 | Os prompts oficiais em `ai/07-prompts/` devem incluir um passo de identificação/confirmação do sub-projeto alvo. |
| RF-07 | A documentação afetada deve ser atualizada para refletir o novo flow. Seções que não se aplicam mais devem ser removidas ou marcadas como obsoletas. |
| RF-08 | O novo flow deve ser fácil de seguir: cada etapa deve ter uma entrada clara, uma saída clara e indicar qual sub-projeto é o escopo. |

---

## 6. Requisitos Não Funcionais

| ID | Requisito |
|----|-----------|
| RNF-01 | O mecanismo de seleção de sub-projeto não deve adicionar fricção desnecessária ao flow — deve ser declarado uma única vez por sessão/prompt. |
| RNF-02 | A estrutura de pastas e artefatos deve continuar seguindo a convenção definida em `ai/00-governance/work-naming-convention.md`. |
| RNF-03 | A documentação deve ser escrita em linguagem clara e verificável, sem ambiguidade sobre qual sub-projeto está em escopo. |
| RNF-04 | O flow reestruturado deve ser retrocompatível: projetos com apenas um sub-projeto em `app/` não devem precisar de mudanças adicionais para continuar funcionando. |

---

## 7. Critérios de Aceite

| ID | Critério |
|----|----------|
| CA-01 | Dado que a pasta `app/` contém dois ou mais sub-projetos, quando um prompt de AI é iniciado, então o sub-projeto alvo deve ser identificado antes de qualquer ação de planejamento ou codificação. |
| CA-02 | Dado o sub-projeto selecionado, quando o Architect Agent executa o PLAN, então ele deve usar somente o contexto, skills e convenções daquele sub-projeto. |
| CA-03 | Dado o sub-projeto selecionado, quando o Coder Agent executa, então o código gerado deve ser compatível com o stack e padrões específicos daquele sub-projeto. |
| CA-04 | O `AGENT_START.md` atualizado deve conter a política de seleção de sub-projeto e ser consistente com os prompts em `ai/07-prompts/`. |
| CA-05 | Toda documentação que descrevia o flow antigo (sem separação de sub-projetos) deve estar atualizada ou removida após a entrega. |
| CA-06 | Um membro do time que nunca usou o flow deve conseguir seguir as instruções e atuar no sub-projeto correto sem ambiguidade. |

---

## 8. Riscos

| ID | Risco | Probabilidade | Impacto | Mitigação |
|----|-------|--------------|---------|-----------|
| R-01 | Sub-projetos podem ter stacks muito diferentes, exigindo agents/skills altamente especializados e aumentando o escopo. | Média | Alto | Iniciar com um mecanismo simples de seleção e context-disclosure; criar skills específicas apenas quando estritamente necessário. |
| R-02 | Atualização incompleta da documentação pode deixar artefatos conflitantes no repositório. | Média | Médio | Criar um checklist de documentos afetados antes da execução e revisar ao final. |
| R-03 | O mecanismo de seleção de sub-projeto pode ser ignorado por usuários acostumados ao flow antigo. | Baixa | Alto | Tornar a seleção um passo obrigatório e explícito nos prompts. |

---

## 9. Dependências

Sem dependências atuais (declaradas na história do board).

---

## 10. Decisões Registradas

| ID | Dúvida | Decisão |
|----|--------|---------|
| DA-01 | Mecanismo de seleção do sub-projeto alvo | **Campo declarativo no início do prompt** (ex: `Projeto alvo: bird-watcher`). Sem arquivo de config externo nem variável de ambiente. Builds e configs são compartilhados dentro de `app/`, portanto a declaração no prompt é suficiente e sem fricção. |
| DA-02 | Sub-projetos existentes com identificadores únicos | **Não existem sub-projetos hoje.** Criadas 3 pastas didáticas dentro de `app/` apenas para fins estruturais e de exemplificação do flow: `bird-watcher/`, `bird-sounds/`, `bird-map/`. Nenhum código dentro delas no momento. |
| DA-03 | Estratégia de `context-disclosure`: global + por sub-projeto ou apenas por sub-projeto | **Decidido: Global + por sub-projeto.** Como todos os sub-projetos compartilham a mesma stack base (Android + Kotlin + Compose + MVI + Gradle), o `ai/02-context/context-disclosure.md` global cobre a base. Cada sub-projeto em `app/<sub-proj>/ai/context-disclosure.md` descreve apenas o que **difere**: nome, domínio de negócio, features e dependências únicas. Regra de precedência: específico sobrescreve global em caso de conflito. |

## 11. Dúvidas Abertas

| ID | Dúvida | Impacto |
|----|--------|---------|
| DA-04 | Skills em `ai/06-skills/` que são genéricas devem ser mantidas como estão ou precisam de anotação indicando compatibilidade com sub-projetos? | Impacta RF-05 e governança de skills. |
| DA-05 | Quais documentos de `ai/00-governance/`, `ai/02-context/` e `ai/05-agents/` estão diretamente afetados e precisam ser listados no plano de execução? | Necessário para garantir completude do CA-05. |
| DA-06 | O flow deve suportar apenas `app/<sub-projeto>/` ou também estruturas mais profundas como `app/<categoria>/<sub-projeto>/`? | Define o escopo real da solução técnica. |
