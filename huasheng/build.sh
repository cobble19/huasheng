#!/bin/sh
. /etc/profile
HS_BASE=/opt/app/huasheng/huasheng
CATALINA_HOME=`echo ${CATALINA_HOME}`
echo "[GE] Stop tomcat..."
sh ${CATALINA_HOME}/bin/shutdown.sh
# bak upload dir
echo "[GE] Bak [upload] directory..."
/bin/cp -R ${HS_BASE}/target/huasheng/upload/* ${HS_BASE}/temp/upload/

echo "[GE] cd ${HS_BASE} ..."
cd ${HS_BASE}
echo "[GE] Start git pull..."
git pull 
echo "[GE] Start mvn..."
mvn clean install -Dmaven.test.skip=true
# Restore upload dir
echo "[GE] Restore [upload] directory..."
mkdir -p ${HS_BASE}/target/huasheng/upload
/bin/cp -R ${HS_BASE}/temp/upload/* ${HS_BASE}/target/huasheng/upload/
echo "[GE] Start tomcat..."
sh ${CATALINA_HOME}/bin/startup.sh
echo "[GE] Build finished..."

