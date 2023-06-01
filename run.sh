#!/bin/bash
# -*- ENCODING: UTF-8 -*-
# Omar David Pino O.
# omar.david.pino@gmail.com

cp -f standalone.xml /opt/wildfly-27.0.1.Final/standalone/configuration/
rm -f /opt/wildfly-27.0.1.Final/standalone/deployments/
rm -R -f /opt/wildfly-27.0.1.Final/standalone/tmp/
rm -R -f /opt/wildfly-27.0.1.Final/standalone/log/
cp -f medicamentos/target/medicamentos-0.0.1-SNAPSHOT.war /opt/wildfly-27.0.1.Final/standalone/deployments/medicamentos.war
cp -f tienda/target/tienda-0.0.1-SNAPSHOT.war /opt/wildfly-27.0.1.Final/standalone/deployments/tienda.war
sh /opt/wildfly-27.0.1.Final/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0
exit
