#!/bin/bash

rm -rf "/var/www/shopperstar-project.com/*"
kill $(ps aux | grep 'node' | ps aux | grep 'index.js' | awk '{print $2}') || true