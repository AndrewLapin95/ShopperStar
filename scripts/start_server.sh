#!/bin/bash
source ~/.env

PROJECT_DIR="/var/www/shopperstar-project.com"

echo "Starting the application!"
cd $PROJECT_DIR
node index.js