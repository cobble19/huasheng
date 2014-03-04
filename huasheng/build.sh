#!/bin/sh
. /etc/profile
CATALINA_HOME=`echo ${CATALINA_HOME}`
echo "Stop tomcat..."
sh ${CATALINA_HOME}/bin/shutdown.sh
# bak upload dir
echo "Bak [upload] directory..."
/bin/cp -R target/huasheng/upload/* temp/upload/

echo "Start git pull..."
git pull
echo "Start mvn..."
mvn clean install -Dmaven.test.skip=true
# Restore upload dir
echo "Restore [upload] directory..."
mkdir -p target/huasheng/upload
/bin/cp -R temp/upload/* target/huasheng/upload/
echo "Start tomcat..."
sh ${CATALINA_HOME}/bin/startup.sh
echo "Build finished..."

