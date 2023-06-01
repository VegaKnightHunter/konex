#!/bin/bash
# -*- ENCODING: UTF-8 -*-
# Omar David Pino O.
# omar.david.pino@gmail.com

mvn -f medicamentos clean install -DskipTests=true &&
mvn -f tienda clean install -DskipTests=true
exit
