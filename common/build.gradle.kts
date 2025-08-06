architectury {
    val enabledPlatforms: String by rootProject
    common(enabledPlatforms.split(","))
}

dependencies {
    // We need these for mixins to work in the common module
    modCompileOnly("net.fabricmc:fabric-loader:0.16.7")
    
    modCompileOnly(group = "tech.thatgravyboat", name = "commonats", version = "2.0")
}
