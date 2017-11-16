@echo on

setlocal

REM Set Variable 
@set LOCATOR_PORT=41111

@ gfsh -e "connect --locator=localhost[%LOCATOR_PORT%]" ^
 -e "deploy --jars='E:\workspace\eclipse\java\gemfire\target\gemfire-demo.jar'"