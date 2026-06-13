# microservices-springcloud-erudio
Microservices com Feign Spring Cloud Netflix Eureka API Gateway Circuit Breaker Resilience4j Config Server LoadBalancer

### Repositório do curso: Microsserviços 2026 c. Spring Cloud Boot Kubernetes e Docker
```
https://www.udemy.com/course/microservices-do-0-a-gcp-com-spring-boot-kubernetes-e-docker/learn/lecture/25443416#overview
```

### Criando banco de dados Postgres no Docker
#### Criar uma network para conectar dois ou mais containeres (deve ser feito antes de criar o container):
```
docker network create spring-network
```
#### Criando container para o banco de dados postgres:
```
docker run --name springdb -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=spring --network spring-network -d postgres:latest
```
#### Criando container para a ide PgAdmin4:
```
docker run --name pgadmin4 -p 15432:80 -e PGADMIN_DEFAULT_EMAIL=admin@admin.com -e PGADMIN_DEFAULT_PASSWORD=admin --network spring-network -d dpage/pgadmin4
```
## Configurando pgAdmin para se conectar ao Docker
No navegador acesse: http://localhost:15432/browser/

Clique com botão direito no servidor existente e selecione **Register -> Server**, para abrir uma janela e acesse as abas para configurar.
#### General
**Nome:** 
```
localhost
```
#### Connection
| Campo                | Valor                  |
| -------------------- | ---------------------- |
| Host                 | `host.docker.internal` |
| Port                 | `5432`                 |
| Maintenance database | `postgres`             |
| Username             | `postgres`             |
| Password             | `postgres`             |
