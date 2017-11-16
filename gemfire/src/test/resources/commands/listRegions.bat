@echo off
setlocal

REM Set Variable Port 
@set LOCATOR_PORT=41111

REM List of Regions
@  gfsh -e "connect --locator=localhost[%LOCATOR_PORT%]" ^
-e "list regions"