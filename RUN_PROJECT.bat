@echo off
cd /d "%~dp0"

call compile_all.bat
if errorlevel 1 exit /b 1

call start_servers.bat
timeout /t 3 /nobreak >nul

call start_peer.bat
call start_peer.bat

echo.
echo Two peer windows were started.
echo Suggested ports: sender 1234 and receiver 5678.
echo Follow README_RUN.txt for the remaining steps.
pause
