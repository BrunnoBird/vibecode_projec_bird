# Context Disclosure — bird-map

> Sub-projeto de `app/bird-map`. Leia também `ai/02-context/context-disclosure.md` (base global).

## Domínio
Focado na geolocalização, mapeamento de hotspots de aves e planejamento de rotas de observação baseado em dados geográficos de ocorrência de espécies.

## Features Específicas
- Visualização de mapa com pinos de avistamentos recentes nas proximidades
- Heatmap de probabilidade de encontro de determinada espécie
- Integração com dados de migração geolocalizados

## Dependências Únicas
- Google Maps SDK para Android (ou Mapbox API)
- Dependências de localização (FusedLocationProvider)

## Permissões (sobrescreve global)
- Exige permissões estritas de `ACCESS_FINE_LOCATION` e `ACCESS_BACKGROUND_LOCATION` (placeholder).
