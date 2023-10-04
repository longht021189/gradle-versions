plugins {
  `version-catalog`
  `maven-publish`
}

catalog {
  versionCatalog {
    from(files("libs.versions.toml"))
  }
}

publishing {
  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/OWNER/REPOSITORY")
      credentials {
        username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
        password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
      }
    }
  }
  publications {
    create<MavenPublication>("maven") {
      groupId = "org.gradle.sample"
      artifactId = "library"
      version = "0.0.1"

      from(components["versionCatalog"])
    }
  }
}
