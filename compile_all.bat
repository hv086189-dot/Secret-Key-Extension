@echo off
setlocal
cd /d "%~dp0"

where javac >nul 2>nul
if errorlevel 1 (
  echo ERROR: javac was not found.
  echo Install a Java JDK and add its bin folder to PATH.
  pause
  exit /b 1
)

echo Compiling KGC...
javac -encoding UTF-8 -d "KGC" "KGC\kgc.java" "KGC\processreq.java"
if errorlevel 1 goto :error

echo Compiling six KPA servers...
javac -encoding UTF-8 -d "KPA" "KPA\kpa1.java" "KPA\kpa2.java" "KPA\kpa3.java" "KPA\kpa4.java" "KPA\kpa5.java" "KPA\kpa6.java"
if errorlevel 1 goto :error

echo Compiling peer node...
javac -encoding UTF-8 -d "peer node" "peer node\peernode.java" "peer node\receiver.java" "peer node\getkeyparts.java" "peer node\net.java"
if errorlevel 1 goto :error

echo.
echo Compilation completed successfully.
exit /b 0

:error
echo.
echo Compilation failed. Read the error shown above.
pause
exit /b 1
