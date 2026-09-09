@echo off
cd /d "%~dp0"

start "KPA1 - Port 3000" "%~dp0KPA\kpa1.bat"
start "KPA2 - Port 3100" "%~dp0KPA\kpa2.bat"
start "KPA3 - Port 3200" "%~dp0KPA\kpa3.bat"
start "KPA4 - Port 3300" "%~dp0KPA\kpa4.bat"
start "KPA5 - Port 3400" "%~dp0KPA\kpa5.bat"
start "KPA6 - Port 3500" "%~dp0KPA\kpa6.bat"

timeout /t 2 /nobreak >nul
start "KGC - Port 2000" "%~dp0KGC\kgc.bat"

echo KPA1-KPA6 and KGC have been started.
