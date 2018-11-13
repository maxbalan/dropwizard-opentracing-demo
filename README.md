# DEMO opentracing with dropwizard and docker-compose

the idea of the demo is to run jaeger-opentracing and the app inside a docker-compose

the app is using:
 - dropwizard 1.3.7
 - dropwizard-opentracing 0.2.2
 
the app has following endpoints:
 
 - `GET /hello/auto?name=someString`
 - `GET /hello/manual?name=someString`
 
 so the `auto` endpoint is using dropwizard instrumentation for opentracing while the `manual` is building a tracer and 
 publishing a span manually 
 
 
# Jaeger
Jaeger is using a cassadra for the storage 

