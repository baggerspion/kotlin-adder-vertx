FROM vertx/vertx3-alpine

ENV VERTICLE_NAME org.baggerspion.adder.MainVerticle
ENV VERTICLE_FILE build/libs/adder-1.0.0-SNAPSHOT.jar
ENV VERTICLE_HOME /usr/verticles

EXPOSE 8080

COPY $VERTICLE_FILE $VERTICLE_HOME/

WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec vertx run $VERTICLE_NAME -cp $VERTICLE_HOME/*"]
