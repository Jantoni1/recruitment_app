FROM postgres:11.5-alpine
COPY docker/POSTGRES/init.sql /docker-entrypoint-initdb.d/
