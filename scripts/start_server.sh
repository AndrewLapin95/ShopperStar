#!/bin/bash
source ~/.env

PROJECT_DIR="/var/www/shopperstar-project.com"

cd $PROJECT_DIR
kill $(ps aux | grep 'node' | ps aux | grep 'index.js' | awk '{print $2}')

docker-compose --file docker-compose.yml up -d

echo "Starting the application!"
cd "$PROJECT_DIR/server"
node index.js &