#! /bin/bash
URL=$1
DB_USER=$2
PASSWORD=$3

if [[ -z $URL ]]
then
        echo "URL nao setada"
        exit 1
fi

if [[ -z $USER ]]
then
        echo "USER nao setada"
        exit 1
fi

if [[ -z $PASSWORD ]]
then
        echo "PASSWORD nao setada"
        exit 1
fi

echo $URL
echo $DB_USER
echo $PASSWORD

docker run --rm \
    -v $(pwd)/migrations:/flyway/sql \
    -v $(pwd)/conf:/flyway/conf \
    flyway/flyway \
    -url=$URL \
    -user=$DB_USER \
    -password=$PASSWORD \
    migrate