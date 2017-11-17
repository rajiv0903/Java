@echo off

setlocal

REM Delete the Directory
rmdir E:\workspace\gemfire\service\locators\* /s /q
rmdir E:\workspace\gemfire\service\servers\ /s /q

REM Set Variables 
@set LOCATOR_PORT=41111
@set SERVER_PORT_INDEX=4112
@set LOCATOR_HOME=E:\workspace\gemfire\service\locators
@set SERVER_HOME=E:\workspace\gemfire\service\servers
@set CACHE_XML_DIR=E:\workspace\eclipse\java\gemfire\src\test\resources\commands\events\client
@set SERVER_CACHE_XML=client-events

REM Start Locators and Servers 
@ gfsh -e "start locator --name=locator1 --port=%LOCATOR_PORT% --initial-heap=50m --max-heap=50m --dir=%LOCATOR_HOME%\locator1 --mcast-port=0" ^
-e "start server --name=server1 --locators=localhost[%LOCATOR_PORT%] --server-port=%SERVER_PORT_INDEX%1 --dir='%SERVER_HOME%\server1' --initial-heap=512m --max-heap=512m --cache-xml-file='%CACHE_XML_DIR%\%SERVER_CACHE_XML%.xml' --J=-XX:+UseConcMarkSweepGC --J=-XX:CMSInitiatingOccupancyFraction=60" 

