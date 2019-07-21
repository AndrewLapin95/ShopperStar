#!/bin/bash
source ~/.env

PROJECT_DIR="/var/www/shopperstar-project.com"

docker-compose --file docker-compose.yml up

echo "Starting the application!"
cd "$PROJECT_DIR/server"
node index.js