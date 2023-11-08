docker run -d \
--name fintech-mysql5 \
-e MYSQL_ROOT_PASSWORD="fintech" \
-e MYSQL_USER="fintech" \
-e MYSQL_PASSWORD="fintech" \
-e MYSQL_DATABASE="fintech" \
--network redis-net5 \
-p 3306:3306 \
mysql:latest