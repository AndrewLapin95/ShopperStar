#!/bin/bash
source ~/.env

kill $(ps aux | grep 'node' | ps aux | grep 'index.js' | awk '{print $2}') || true

PROJECT_DIR="/var/www/shopperstar-project.com"
cd $PROJECT_DIR

docker-compose --file docker-compose.yml down
docker-compose --file docker-compose.yml up -d

echo "Starting the application!"
cd "$PROJECT_DIR/server"
nohup node index.js &

exit 0
