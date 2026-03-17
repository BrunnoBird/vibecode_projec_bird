# 04 - Politica de Skills e Escala

## Politica de skills

Ordem obrigatoria:
1. analisar skills existentes em `ai/06-skills/`
2. reutilizar antes de criar
3. criar nova skill apenas quando houver padrao repetivel e reutilizavel
4. versionar toda skill (`version` e `updated_at` no cabecalho)

## Quando criar nova skill

Criar skill quando a solucao for:
- repetivel
- padronizavel
- reutilizavel em multiplas features
- estrutural (nao pontual)

## Quando NAO criar skill

- ajuste pontual de tela/layout
- hotfix especifico de uma task
- caso unico sem potencial de reuso

## Escala do processo SSD

### Crescimento por feature
- novo PRB/PRD em `ai/01-product/_work/`
- nova spec em `ai/03-specs/_work/`
- novas tasks em `ai/04-tasks/_work/`
- implementacao task por task com prompts oficiais

### Crescimento por capacidade
- promover padroes recorrentes para `ai/06-skills/`
- referenciar skill por task
- reduzir repeticao com prompts e templates oficiais
- separar role skills (etapa) de technical skills (capacidade)
- aplicar carregamento sob demanda para reduzir tokens
- aplicar contexto por projeto em `ai/02-context/projects/<project_id>/`

### Prevencao de overengineering
- planejar o minimo necessario
- evitar abstracoes sem segundo caso real
- priorizar clareza de dependencias e simplicidade
