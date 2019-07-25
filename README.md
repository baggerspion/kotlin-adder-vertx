# kotlin-adder-vertx
Another simple Kotlin-based microservice which will add two numbers together.

- To build: `./gradle build`
- To run: `./gradle run`

## Docker
- First build, as above
- Build your Docker image: `docker build -t therealpadams/adder-vertx .`
- Run: `docker run -d -p 8080:8080 therealpadams/adder-vertx`

## To Test
- `curl -H "Content-Type: application/json" -X POST -d '{"operand1": 21, "operand2": 12}' localhost:8080/add`
