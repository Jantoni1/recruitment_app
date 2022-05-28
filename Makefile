#!make
include .env
MAKE_VERBOSE=1

up:
	@mvn package
	@docker-compose -f docker-compose.deps.yml up -d
	@docker-compose -f docker-compose.apps.yml up -d

stop:
	@docker-compose -f docker-compose.deps.yml stop
	@docker-compose -f docker-compose.apps.yml stop

recreate:
	@mvn package
	@docker-compose -f docker-compose.deps.yml up --build -d
	@docker-compose -f docker-compose.apps.yml up --build -d

apps-up:
	@mvn package
	@docker-compose -f docker-compose.apps.yml up -d

apps-stop:
	@mvn package
	@docker-compose -f docker-compose.apps.yml stop

apps-recreate:
	@mvn package
	@docker-compose -f docker-compose.apps.yml up --build -d

deps-up:
	@docker-compose -f docker-compose.deps.yml up -d

deps-stop:
	@docker-compose -f docker-compose.deps.yml stop

deps-recreate:
	@docker-compose -f docker-compose.deps.yml up --build -d

version:
	mvn versions:set -DnewVersion=${'$'}(version) -DprocessAllModules -DgenerateBackupPoms=false

clean:
	@mvn clean
	@find . -type d -name target -prune -exec rm -r {} +

