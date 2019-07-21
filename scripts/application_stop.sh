#!/bin/bash

kill $(ps aux | grep 'node' | ps aux | grep 'index.js' | awk '{print $2}') || true
rm -rf /var/www/shopperstar-project.com/*