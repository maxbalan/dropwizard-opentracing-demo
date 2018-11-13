#!/bin/sh

cd /home/hello/dropwizard-opentracing-demo-0.1/bin/
bash dropwizard-opentracing-demo server app.yaml
echo "[hit enter key to exit] or run 'docker stop <container>'"

read
pause

# stop service and clean up here
echo "exited $0"
