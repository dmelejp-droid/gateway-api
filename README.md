# Gateway API

API Gateway construido con **Spring Cloud Gateway**, diseñado para actuar como el único punto de entrada unificado para el ecosistema de microservicios de e-commerce.

Este servicio abstrae la complejidad de la red interna, protegiendo los puertos directos de los microservicios y enrutando dinámicamente las peticiones del cliente basándose en patrones de URL (`predicates`).

## Stack Tecnológico
- Java 17
- Spring Boot 3.x
- Spring Cloud Gateway
- Spring WebFlux (Non-blocking I/O)

## Reglas de Enrutamiento (Routing)

El Gateway escucha en el puerto `8000` y expone las siguientes rutas:

| Predicado (URL) | Microservicio Destino | Puerto Interno |
|---|---|---|
| `/api/products/**` | `inventory-service` | `8080` |
| `/api/orders/**` | `orders-service` | `8081` |

## Ventajas implementadas
- **Desacoplamiento:** Los clientes (Frontend/Mobile) no necesitan conocer la topología de red ni los puertos internos.
- **Seguridad:** Los puertos 8080 y 8081 pueden aislarse de la red pública, dejando solo el puerto 8000 expuesto.
- **Escalabilidad:** Prepara el terreno para añadir Load Balancing y Auth de forma centralizada en el futuro.
