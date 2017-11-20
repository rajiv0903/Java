@echo off
setlocal

REM Set Variable 
@set LOCATOR_PORT=41111

@ gfsh -e "connect --locator=localhost[%LOCATOR_PORT%]" ^
-e "shutdown --include-locators=true"

REM Delete the Directory
rmdir E:\workspace\gemfire\service\locators\ /s /q
rmdir E:\workspace\gemfire\service\servers\ /s /q
