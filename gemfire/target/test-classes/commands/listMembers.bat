@echo off
setlocal

REM Set Variable 
@set LOCATOR_PORT=41111

REM List Members
@  gfsh -e "connect --locator=localhost[%LOCATOR_PORT%]" ^
-e "list members"