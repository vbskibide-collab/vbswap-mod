@echo off
echo ============================================
echo VB-Swap Mod - Windows Setup
echo ============================================
echo.

REM Check for Java
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH!
    echo Please install Java 21 from: https://adoptium.net/
    pause
    exit /b 1
)

echo Java found! Checking version...
java -version

echo.
echo Downloading Gradle wrapper...
echo.

REM Create gradle wrapper directory if it doesn't exist
if not exist "gradle\wrapper" mkdir gradle\wrapper

REM Download gradle-wrapper.jar using PowerShell
powershell -Command "Invoke-WebRequest -Uri 'https://raw.githubusercontent.com/gradle/gradle/v8.5.0/gradle/wrapper/gradle-wrapper.jar' -OutFile 'gradle\wrapper\gradle-wrapper.jar'"

if %errorlevel% neq 0 (
    echo.
    echo ERROR: Failed to download Gradle wrapper.
    echo Please check your internet connection.
    pause
    exit /b 1
)

echo.
echo ============================================
echo Setup complete! Now building the mod...
echo ============================================
echo.

REM Run the build
gradlew.bat build

if %errorlevel% equ 0 (
    echo.
    echo ============================================
    echo BUILD SUCCESSFUL!
    echo ============================================
    echo.
    echo Your mod is located at:
    echo build\libs\vbswap-1.0.0.jar
    echo.
    echo Copy this file to your .minecraft\mods\ folder
    echo.
) else (
    echo.
    echo BUILD FAILED! Check the errors above.
    echo.
)

pause
