@echo off
cd /d "%~dp0"
javac -encoding UTF-8 kpa2.java
if errorlevel 1 (
  echo Compilation failed.
  pause
  exit /b 1
)
java kpa2
pause
