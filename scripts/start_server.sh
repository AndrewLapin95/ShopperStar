#!/bin/bash
source ~/.env

PROJECT_DIR="/var/www/shopperstar-project.com"
cd $PROJECT_DIR

docker-compose --file docker-compose.yml down
docker-compose --file docker-compose.yml up -d

sleep 90

echo "Starting the application!"
cd "$PROJECT_DIR/server"
node index.js > /etc/shopperstar-project/stdout.txt 2> /etc/shopperstar-project/stderr.txt &

exit 0
