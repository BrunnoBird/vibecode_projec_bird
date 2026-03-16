# Guia de Cenários — Fluxo SSD Ponta a Ponta

Este guia mostra 3 cenários reais de uso do fluxo SSD com os prompts padronizados.
Cada cenário mostra **exatamente o que você digita** em cada etapa e **o que a IA entrega**.

---

## Visão geral do fluxo

```
BOARD → PRD → PLAN → EXECUTION → REVIEW → TEST
  ↑        ↑       ↑         ↑          ↑        ↑
  Você    IA      IA        IA         IA       IA
  escreve gera    gera      implementa revisa   testa
```

**Regra de ouro:** Você controla o ritmo. Cada etapa é um prompt separado. Não existe escolha forçada — você decide quando avançar.

---

## Cenário 1: Nova Feature do Zero

### Contexto
Você recebeu do board: *"Implementar tela de favoritos onde o usuário pode salvar e visualizar seus itens favoritos"*

---

### Etapa 1 — BOARD → PRD

**O que você faz:** Abre uma nova conversa e cola o prompt abaixo.

```
Atue como apoio de Product + Tech Writing.

Use como base o template:
- ai/07-prompts/board-to-prd-prompt.md

Historia do Board:
- Titulo: Implementar tela de favoritos
- Contexto: O app atualmente não permite salvar itens como favoritos.
  O usuário precisa navegar novamente até o item toda vez que quer acessá-lo.
- Problema: Não existe funcionalidade de favoritos no app.
- Resultado esperado:
  1. Botão de favoritar visível nos cards de item
  2. Tela de favoritos acessível pelo menu de navegação
  3. Persistência local dos favoritos
- Restrições:
  - Sem backend por enquanto (apenas local)
  - Seguir padrão MVI existente
- Dependências:
  - Módulo core:navigation existente
  - Design system do projeto

Saida:
- criar ai/01-product/_work/<feature>-prd.md
- manter lacunas em "Duvidas abertas"
- nao inventar requisitos fora da historia
```

**O que a IA entrega:**
- Arquivo `ai/01-product/_work/feature-tela-favoritos-prd.md` (nome gerado automaticamente)
- PRD com 10 seções obrigatórias
- Dúvidas abertas marcadas

**Você faz:** Lê a PRD. Se ok, avança para PLAN.

---

### Etapa 2 — PRD → PLAN

**O que você faz:** Abre uma nova conversa (ou continua) e cola:

```
Atue como Architect Agent em modo PLAN.

Leia:
- ai/AGENT_START.md
- ai/07-prompts/plan-architect-prompt.md
- ai/01-product/_work/<feature>-prd.md

Saida esperada:
- ai/03-specs/_work/<feature>-spec.md
- ai/04-tasks/_work/task-*.md
- decisoes de skill por task
- ordem de execucao
- riscos tecnicos
```

> **Nota:** Você não precisa saber o nome exato do arquivo. O agent usa auto-discovery e encontra o PRD sozinho em `_work/`.

**O que a IA entrega:**
- `ai/03-specs/_work/tela-favoritos-spec.md`
- `ai/04-tasks/_work/tela-favoritos-task-01.md` (ex: criar módulo feature:favorites)
- `ai/04-tasks/_work/tela-favoritos-task-02.md` (ex: implementar ViewModel + Contract)
- `ai/04-tasks/_work/tela-favoritos-task-03.md` (ex: implementar FavoritesScreen)
- `ai/04-tasks/_work/tela-favoritos-task-04.md` (ex: integrar navegação)
- Decisões de skill por task
- Bloco **ARTEFATOS_GERADOS** com todos os caminhos

**Você faz:** Revisa spec e tasks. Se ok, avança para EXECUTION.

---

### Etapa 3 — EXECUTION (Task por task)

**O que você faz:** Copia um dos comandos abaixo para implementar a primeira task:

```
Atue como Coder Agent.
Leia e siga: ai/07-prompts/execution-coder-prompt.md
Task alvo: ai/04-tasks/_work/tela-favoritos-task-01.md
Spec: ai/03-specs/_work/tela-favoritos-spec.md
```

**O que a IA entrega:**
- Código implementado (módulo, ViewModel, Screen, etc.)
- Resumo da implementação
- Arquivos alterados
- Testes adicionados
- Handoff em `ai/08-handoffs/_runs/2026-03-14_task-01_coder-handoff.md`

**Você faz:** Revisa o código. Se ok, pode fazer REVIEW ou ir direto para a próxima task.

---

### Etapa 4 — REVIEW (opcional mas recomendado)

```
Atue como Reviewer Agent.
Leia e siga: ai/07-prompts/review-reviewer-prompt.md
Task alvo: ai/04-tasks/_work/tela-favoritos-task-01.md
Spec: ai/03-specs/_work/tela-favoritos-spec.md
```

**O que a IA entrega:**
- Achados por severidade (alta/média/baixa)
- Impacto e correção prática para cada achado
- Handoff em `ai/08-handoffs/_runs/2026-03-14_task-01_reviewer-handoff.md`

---

### Etapa 5 — TEST (opcional mas recomendado)

```
Atue como Tester Agent.
Leia e siga: ai/07-prompts/test-tester-prompt.md
Task alvo: ai/04-tasks/_work/tela-favoritos-task-01.md
Spec: ai/03-specs/_work/tela-favoritos-spec.md
```

**O que a IA entrega:**
- Cenários mínimos de teste
- Cobertura por risco
- Evidências de execução
- Eval em `ai/09-evals/_runs/2026-03-14_task-01_eval.md`

---

### Etapa 6 — Próxima task

Repete as etapas 3-5 para cada task (task-02, task-03, task-04...).

**Atalho opcional:** Se quiser que a IA descubra automaticamente a próxima task:

```
Leia e siga: ai/07-prompts/next-step-dispatch-prompt.md
```

A IA retorna os caminhos exatos e os comandos prontos para copiar.

---

### Resumo do fluxo Feature

```
Prompt 1: BOARD → PRD          → ai/01-product/_work/feature-tela-favoritos-prd.md
Prompt 2: PRD → PLAN           → ai/03-specs/_work/tela-favoritos-spec.md
                                  ai/04-tasks/_work/tela-favoritos-task-01..04.md
Prompt 3: EXECUTION task-01    → código + handoff
Prompt 4: REVIEW task-01       → achados + handoff  (opcional)
Prompt 5: TEST task-01         → cenários + eval    (opcional)
Prompt 6: EXECUTION task-02    → código + handoff
...repete até última task...
```

---
---

## Cenário 2: Resolver um BUG

### Contexto
Você recebeu do board: *"App crasha ao abrir o perfil quando o nome do usuário é null"*

---

### Etapa 1 — BOARD → PRD (tipo BUG)

```
Atue como apoio de Product + Tech Writing.

Use como base o template:
- ai/07-prompts/board-to-prd-prompt.md

Historia do Board:
- Titulo: App crasha ao abrir perfil com nome null
- Tipo: BUG
- Contexto: Usuários que fizeram login via SSO sem nome preenchido
  causam crash ao navegar para a tela de perfil.
- Comportamento esperado: Tela de perfil exibe placeholder "Usuário"
  quando o nome é null.
- Comportamento atual: App crasha com NullPointerException.
- Passos de reprodução:
  1. Login via SSO sem nome preenchido
  2. Navegar para tela de perfil
  3. App crasha
- Ambiente: Android 14, versão 1.2.0
- Impacto: ~15% dos usuários SSO afetados
- Evidências: stacktrace no Crashlytics apontando ProfileViewModel.kt:42

Saida:
- criar ai/01-product/_work/<bug>-prd.md
- manter lacunas em "Duvidas abertas"
- nao inventar requisitos fora da historia
```

**O que a IA entrega:**
- Arquivo `ai/01-product/_work/bug-perfil-crash-nome-null-prd.md`
- PRD com seções extras de BUG:
  - Comportamento esperado vs atual
  - Passos de reprodução
  - Ambiente/versão
  - Impacto
  - Evidências

---

### Etapa 2 — PRD → PLAN (tipo BUG)

```
Atue como Architect Agent em modo PLAN.

Leia:
- ai/AGENT_START.md
- ai/07-prompts/plan-architect-prompt.md
- ai/01-product/_work/<bug>-prd.md

Saida esperada:
- ai/03-specs/_work/<bug>-spec.md
- ai/04-tasks/_work/task-*.md
- decisoes de skill por task
- ordem de execucao
- riscos tecnicos
```

**O que a IA entrega (diferenças do fluxo de feature):**
- A IA lê automaticamente `ai/00-governance/bug-resolution-rules.md`
- Spec inclui seções extras obrigatórias:
  - **Hipótese de causa raiz** (ex: `ProfileViewModel` não trata nome nullable)
  - **Estratégia de correção mínima** (ex: adicionar operador `?:` com fallback "Usuário")
  - **Plano de validação de regressão** (ex: testar SSO com/sem nome, login normal)
- Tasks tipicamente são menores (1-2 tasks para bugs simples)
- Bloco ARTEFATOS_GERADOS com caminhos

**Exemplo de tasks geradas:**
- `ai/04-tasks/_work/perfil-crash-nome-null-task-01.md` — corrigir nullable handling no ProfileViewModel
- `ai/04-tasks/_work/perfil-crash-nome-null-task-02.md` — adicionar testes unitários para cenário null

---

### Etapa 3 — EXECUTION

```
Atue como Coder Agent.
Leia e siga: ai/07-prompts/execution-coder-prompt.md
Task alvo: ai/04-tasks/_work/perfil-crash-nome-null-task-01.md
Spec: ai/03-specs/_work/perfil-crash-nome-null-spec.md
```

**A IA implementa a correção mínima** conforme as regras de bug:
- Apenas a correção do null handling
- Sem refactor adicional
- Sem features extras

---

### Etapa 4 — REVIEW + TEST

Igual ao cenário de feature, usando os mesmos prompts (REVIEW e TEST).

---

### Resumo do fluxo BUG

```
Prompt 1: BOARD → PRD (BUG)    → ai/01-product/_work/bug-perfil-crash-nome-null-prd.md
                                  (inclui comportamento esperado vs atual, stacktrace, etc.)
Prompt 2: PRD → PLAN (BUG)     → spec com hipótese de causa raiz + correção mínima
                                  ai/04-tasks/_work/perfil-crash-nome-null-task-01..02.md
Prompt 3: EXECUTION task-01    → correção mínima implementada
Prompt 4: REVIEW task-01       → revisão
Prompt 5: TEST task-01         → teste de regressão
Prompt 6: EXECUTION task-02    → testes unitários
```

---
---

## Cenário 3: Pedir Testes Unitários

### Variante A — Testes como parte do fluxo SSD (task dentro do PLAN)

Se o PLAN já gerou uma task de testes, basta executá-la normalmente:

```
Atue como Coder Agent.
Leia e siga: ai/07-prompts/execution-coder-prompt.md
Task alvo: ai/04-tasks/_work/tela-favoritos-task-03.md
Spec: ai/03-specs/_work/tela-favoritos-spec.md
```

A task já está definida no PLAN — ex: *"Criar testes unitários do FavoritesViewModel"*.

---

### Variante B — Pedir testes avulsos (fora do fluxo SSD formal)

Quando já existe código implementado e você quer a IA gerar testes unitários **sem passar pelo fluxo completo de BOARD→PRD→PLAN**:

```
Atue como Tester Agent.
Leia e siga: ai/07-prompts/test-tester-prompt.md
Task alvo: ai/04-tasks/_work/tela-favoritos-task-02.md
Spec: ai/03-specs/_work/tela-favoritos-spec.md
```

A IA vai:
1. Ler a spec e a task
2. Analisar o código implementado
3. Gerar cenários de teste + executar/propor testes unitários

---

### Variante C — Pedir testes unitários diretamente (sem spec/task)

Se você quer algo mais direto — sem spec nem task formal — pode usar a skill existente:

```
Gere testes unitários para o arquivo:
feature/favorites/presentation/FavoritesViewModel.kt

Use como referência a skill:
ai/06-skills/write-viewmodel-unit-tests/SKILL.md

Regras:
- Cobrir fluxo feliz e erros
- Seguir padrão de nomes descritivos
- Usar JUnit + coroutines test
```

A IA vai:
1. Ler a skill de testes de ViewModel
2. Analisar o ViewModel indicado
3. Gerar testes unitários seguindo as convenções do projeto

> **Nota:** Esta variante não gera PRD, spec, tasks, handoffs nem evals. É um atalho para quando você só precisa de testes e não quer o fluxo formal.

---

### Variante D — Pedir testes de regressão de bug

Após corrigir um bug, pedir testes específicos de regressão:

```
Atue como Tester Agent.
Leia e siga: ai/07-prompts/test-tester-prompt.md
Task alvo: ai/04-tasks/_work/perfil-crash-nome-null-task-02.md
Spec: ai/03-specs/_work/perfil-crash-nome-null-spec.md
```

A IA sabe (via spec) que é um BUG e vai:
1. Gerar cenários de regressão cobrindo o caso null
2. Testar que o fluxo normal não quebrou
3. Documentar evidências de execução

---

### Resumo das variantes de teste

| Variante | Quando usar | Precisa de spec/task? |
|----------|-------------|----------------------|
| **A** — Task do PLAN | Task de teste já existe no PLAN | Sim (gerados no PLAN) |
| **B** — Tester Agent | Código implementado, quer testes formais | Sim |
| **C** — Skill direto | Quer testes rápidos sem fluxo formal | Não |
| **D** — Regressão de bug | Após correção de bug, validar regressão | Sim (spec de bug) |

---
---

## Mapa rápido de prompts

| Etapa | Prompt file | Quando usar |
|-------|-------------|-------------|
| **BOARD → PRD** | `ai/07-prompts/board-to-prd-prompt.md` | Transformar história do board em PRD |
| **PRD → PLAN** | `ai/07-prompts/plan-architect-prompt.md` | Gerar spec + tasks a partir da PRD |
| **NEXT STEP** | `ai/07-prompts/next-step-dispatch-prompt.md` | Descobrir próxima task e caminhos |
| **EXECUTION** | `ai/07-prompts/execution-coder-prompt.md` | Implementar uma task |
| **REVIEW** | `ai/07-prompts/review-reviewer-prompt.md` | Revisar código de uma task |
| **TEST** | `ai/07-prompts/test-tester-prompt.md` | Testar/validar uma task |

---

## Dicas práticas

1. **Sempre comece com BOARD → PRD.** Mesmo que a história pareça simples, o PRD formaliza o escopo e evita que a IA invente requisitos.

2. **Você controla o ritmo.** Não existe mais escolha forçada. Após cada etapa, você decide o que fazer:
   - Avançar para a próxima etapa
   - Pedir ajustes na etapa atual
   - Pular etapas opcionais (REVIEW/TEST)

3. **Auto-discovery funciona.** Você não precisa lembrar o nome exato do arquivo. Se houver apenas 1 PRD/spec/task em `_work/`, a IA encontra sozinha.

4. **Limpe `_work/` entre features.** As pastas `_work/` são efêmeras. Após concluir uma feature, limpe os arquivos para que o auto-discovery funcione perfeitamente na próxima.

5. **Use NEXT STEP DISPATCH como atalho.** Em vez de montar os comandos manualmente, use o prompt `next-step-dispatch-prompt.md` para que a IA descubra os caminhos e monte os comandos prontos para você.

6. **Para bugs, as regras de resolução são automáticas.** Você não precisa repetir "incluir hipótese de causa raiz" — a IA lê `bug-resolution-rules.md` sozinha quando detecta que é um BUG.
