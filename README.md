# Spigot ChatColor API

Spigot Color API is a simple and efficient tool that allows you to send colored messages, create gradients, and convert text to small letters in Minecraft.

## 💎 Features 

- **Gradient Creation – Converts text into a colorful gradient.**
- **Text Miniaturization – Transforms letters into their smaller equivalents.**
- **Text Coloring – Converts color codes into Minecraft-compatible formatting.**

## 🗃️ Installation 

To add the API to your project, include the following dependency in your pom.xml:

```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
  ```
```xml
<dependencies>
    <dependency>
	<groupId>com.github.NightFurry98</groupId>
        <artifactId>spigot-ChatHelper-api</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
  ```

## 🚧 How to Use?

 * Creating a Gradient
```java
String gradientText = SpigotColorAPI.createGradient("Welcome to Minecraft!", "#FF0000", "#00FF00", "#0000FF");
 ```
* Converting Text to Small Letters
```java
String smallText = SpigotColorAPI.toSmallText("Example Text");
 ```
* Coloring Text
```java
String coloredText = SpigotColorAPI.fixColor("&aThis is green text!");
 ```
