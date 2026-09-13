#!/bin/bash

_psql () { psql --set ON_ERROR_STOP=1 "$@" ; }

_psql  -U $POSTGRESQL_USER -d $POSTGRESQL_DATABASE -f /opt/app-root/src/init.sql
