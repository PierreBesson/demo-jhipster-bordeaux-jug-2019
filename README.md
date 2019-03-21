# JHipster microservice demo (Bordeaux JUG 2019/03/21)

## Local development

Start the all apps locally with:

- Start the all apps locally with:
    - `docker-compose -f store/src/main/docker/jhipster-registry.yml up -d`
    - `./mvnw` and `yarn start` for the gateway
    - `./mvnw` for the microservices
    - `docker-compose -f accountancy/src/main/docker/mongodb.yml up -d` (required for MongoDB)

- Package for prod and build the docker image: `./mvnw package -Pprod,zipkin jib:dockerBuild` (the zipkin profile is necessary to enable zipkin)

## Deployment to a single host with docker-compose

- `cd docker && docker-compose up -d`


## Deployment to a Kubernetes cluster

For convenience, I have already pushed the images to the docker hub (pbesson/store, pbesson/accountancy and pbesson/crm).

# Links

- Gateway : [http://localhost:8080/](http://localhost:8080/)
- Gateway API (load-balanced): [http://localhost:8080/#/docs](http://localhost:8080/#/docs)
- Registry: [http://localhost:8761/#/](http://localhost:8761/#/)
- Registry API (per instance access): [http://localhost:8761/#/docs]- (http://localhost:8761/#/docs)
- Registry metrics: [http://localhost:8761/#/jhi-metrics](http://localhost:8761/#/jhi-metrics)


- Kibana: [http://localhost:5601](http://localhost:5601)
- Logtrail: [http://localhost:5601/app/logtrail#/?q=-logger_name:+"metrics"](http://localhost:5601/app/logtrail#/?q=-logger_name:+"metrics")
- Zipkin UI: [http://localhost:9411/zipkin/](http://localhost:9411/zipkin/)
