@echo off
setlocal

REM Set Variable 
@set LOCATOR_PORT=41111
@set REGION=Customer

@gfsh -e "connect --locator=localhost[%LOCATOR_PORT%]" ^
 -e "query --query='select * from /%REGION%'"
 
pause

