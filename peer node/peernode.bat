@echo off
cd /d "%~dp0"
javac -encoding UTF-8 peernode.java receiver.java getkeyparts.java net.java
if errorlevel 1 (
  echo Compilation failed.
  pause
  exit /b 1
)
java peernode
pause
