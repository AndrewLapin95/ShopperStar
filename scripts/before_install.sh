#!/bin/bash

PROJECT_DIR="/var/www/shopperstar-project.com"

rm -rf "$PROJECT_DIR/*"
kill $(ps aux | grep 'node' | ps aux | grep 'index.js' | awk '{print $2}')