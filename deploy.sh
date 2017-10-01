#!/bin/sh

rm -r /etc/wildfly-11.0.0.CR1/standalone/deployments/*

cp target/watchCustom.war /etc/wildfly-11.0.0.CR1/standalone/deployments


chown -R www-data:www-data /etc/wildfly-11.0.0.CR1/standalone/deployments/*
chmod -R 777  /etc/wildfly-11.0.0.CR1/standalone/deployments/*

exit 0
