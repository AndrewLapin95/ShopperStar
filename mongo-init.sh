#!/bin/bash
set -e

mongo <<EOF
use admin
db.createUser({
  user:  '$DB_NON_ROOT_USER',
  pwd:   '$DB_NON_ROOT_PASSWORD',
  roles: [{
    role: 'dbOwner',
    db: '$MONGODB_INITDB_DATABASE'
  }]
})
EOF