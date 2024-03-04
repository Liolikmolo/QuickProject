### Запуск для фронтендеров и тестировщиков
Для запуска проекта необходимо выполнить следующую команду:

```bash
docker compose up --build
```

### Если понадобится запустить локально отдельно БД можно запустить скрипт

Это может понадобиться для бэкендеров когла работаю из среды разработки.
```bash
scripts/run-db.bat
```

### Далее более продвинутые опции запуска

#### Разворачиваем Postgres:
- загружаем [контейнер с последним postgres](https://hub.docker.com/_/postgres): `docker pull postgres`
- если на локальной машине уже запущен сервис postgres, надо его остановить: для Windows я запустил `C:\Windows\System32\cmd.exe as Admin` и остановил командой `net stop postgresql-x64-10`
- запускаем контейнер с postgres: `docker run -p 5432:5432 -d --name dev_db -e POSTGRES_USER=pet -e POSTGRES_PASSWORD=password -e POSTGRES_DB=pet postgres`   

[Основные команды Docker](https://tproger.ru/translations/top-10-docker-commands):
```
docker ps -a : посмотреть все контейнеры
docker stop pet_db : остановить наш контейнер
docker start pet_db : запустить его
docker rm pet_db : удалить
docker help : справка по командам
```

Под Windows можно также управлять запуском docker из DockerDesktop.

#### Сборка и запуск проекта сервера на Spring Boot в Docker

- сборка запускается из папки backend командой :'docker build -t qp_spring .'
- запуск: 'docker run -p 8080:8080 qp_spring'

