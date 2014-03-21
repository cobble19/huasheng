#!/bin/sh
. /etc/profile
HS_BASE=/opt/app/huasheng/huasheng
CATALINA_HOME=`echo ${CATALINA_HOME}`
echo "Stop tomcat..."
sh ${CATALINA_HOME}/bin/shutdown.sh
# bak upload dir
echo "Bak [upload] directory..."
/bin/cp -R ${HS_BASE}/target/huasheng/upload/* ${HS_BASE}/temp/upload/

echo "cd ${HS_BASE} ..."
cd ${HS_BASE}
echo "Start git pull..."
git pull 
echo "Start mvn..."
mvn clean install -Dmaven.test.skip=true
# Restore upload dir
echo "Restore [upload] directory..."
mkdir -p ${HS_BASE}/target/huasheng/upload
/bin/cp -R ${HS_BASE}/temp/upload/* ${HS_BASE}/target/huasheng/upload/
echo "Start tomcat..."
sh ${CATALINA_HOME}/bin/startup.sh
echo "Build finished..."

