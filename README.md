# VB-Swap Mod

A Fabric mod that allows you to swap your mainhand and offhand items using the `.vb-swap` command, even while in GUIs!

## Features
- Type `.vb-swap` in chat to instantly swap your held item with your offhand
- Works in ANY GUI (chests, inventories, crafting tables, etc.)
- Client-side mod - works on vanilla servers
- Lightweight and simple

## Installation

### Prerequisites
1. Install [Fabric Loader](https://fabricmc.net/use/)
2. Install [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)

### Building the Mod
1. Navigate to the mod directory
2. Run: `./gradlew build` (Linux/Mac) or `gradlew.bat build` (Windows)
3. Find the compiled JAR in `build/libs/`
4. Copy the JAR to your `.minecraft/mods/` folder

### Quick Install (if JAR is provided)
1. Make sure you have Fabric Loader and Fabric API installed
2. Download the `vbswap-1.0.0.jar` file
3. Place it in your `.minecraft/mods/` folder
4. Launch Minecraft with Fabric

## Usage
1. Open any GUI or just be in your normal inventory
2. Select the item you want to swap in your hotbar
3. Type `.vb-swap` in the chat
4. Press Enter
5. Your mainhand and offhand items are swapped!

## Compatibility
- Minecraft: 1.21.11 (can be adjusted in gradle.properties)
- Fabric Loader: 0.18.1+
- Java: 21+

## License
MIT License - Feel free to modify and distribute!
