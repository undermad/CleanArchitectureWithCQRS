#!/bin/bash
set -e

host="$1"
shift
cmd="$@"

until echo 'SELECT 1' | mysql -h"$host" -P3306 -uroot -prootpassword clean; do
  echo "MySQL is unavailable - sleeping"
  sleep 1
done

echo "MySQL is up - executing command"
exec $cmd