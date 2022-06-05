#!make
include .env
MAKE_VERBOSE=1

prepare:
	$(shell cp .env-sample .env)
	@make up

up:
	@mvn package
	@docker-compose -f docker-compose.deps.yml up -d

stop:
	@docker-compose -f docker-compose.deps.yml stop

recreate:
	@mvn package
	@docker-compose -f docker-compose.deps.yml up --build -d

clean:
	@mvn clean
	@find . -type d -name target -prune -exec rm -r {} +
