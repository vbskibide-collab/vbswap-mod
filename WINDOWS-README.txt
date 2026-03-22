================================================================
VB-SWAP MOD - WINDOWS BUILD INSTRUCTIONS
================================================================

EASIEST METHOD - Use the setup script:
--------------------------------------
1. Make sure Java 21 is installed
   Download from: https://adoptium.net/

2. Double-click: setup-and-build.bat

3. Wait for it to finish

4. Find your mod at: build\libs\vbswap-1.0.0.jar

5. Copy that JAR to your .minecraft\mods\ folder


MANUAL METHOD - If the script doesn't work:
-------------------------------------------
1. Open Command Prompt in this folder

2. Type: gradlew.bat build

3. If it says gradlew is not recognized, you need to 
   download the Gradle wrapper first:
   
   Go to: https://gradle.org/install/
   Or manually download gradle-wrapper.jar to:
   gradle\wrapper\gradle-wrapper.jar


TROUBLESHOOTING:
----------------
- "Java not found" = Install Java 21 from https://adoptium.net/
- "gradlew not recognized" = Run setup-and-build.bat first
- Build fails = Make sure you have internet connection


After building, install the mod:
---------------------------------
1. Install Fabric Loader for Minecraft 1.21.11
2. Install Fabric API mod
3. Copy build\libs\vbswap-1.0.0.jar to .minecraft\mods\
4. Launch Minecraft
5. Type .vb-swap in chat to swap items!

================================================================
