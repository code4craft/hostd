#!/bin/sh
HOSTD_HOME=/usr/local/hostd/
WAR4E_URL=http://code4craft.qiniudn.com/war4e.jar
WAR_URL=http://code4craft.qiniudn.com/hostd-server-0.1.0.war
curl http://code4craft.github.io/blackhole/install.sh | sh
mkdir -p ${HOSTD_HOME}
curl ${WAR4E_URL} > war4e.jar
curl ${WAR_URL} > hostd-server-0.1.0.war
curl http://code4craft.github.io/hostd/zonesfile.db > zonesfile.db
