#!/bin/sh
##################
# bak MySQL db   #
##################
# 1. cp origin huasheng.sql
cp huasheng.sql huasheng.sql.bak
mysqldump --socket=/opt/mysql/tmp/mysql.sock -c -uroot -proot123 --default-character-set=utf8 huasheng > huasheng.sql

