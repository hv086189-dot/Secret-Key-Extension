@echo off
cd /d "%~dp0"
javac -encoding UTF-8 kgc.java processreq.java
if errorlevel 1 (
  echo Compilation failed.
  pause
  exit /b 1
)
java kgc
pause
