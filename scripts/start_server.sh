#!/bin/bash
source ~/.env

PROJECT_DIR="/var/www/shopperstar-project.com"
cd $PROJECT_DIR

docker-compose --file docker-compose.yml down
docker-compose --file docker-compose.yml up -d

echo "Starting the application!"
cd "$PROJECT_DIR/server"
nohup node index.js > /dev/null &

exit 0