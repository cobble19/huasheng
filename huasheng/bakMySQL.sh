#!/bin/sh
##################
# bak MySQL db   #
##################
mysqldump --socket=/opt/mysql/tmp/mysql.sock -c -uroot -proot123 --default-character-set=utf8 huasheng > huasheng.sql

