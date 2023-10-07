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
      url = uri("https://maven.pkg.github.com/longht021189/gradle-versions")
      credentials {
        username = System.getenv("GITHUB_ACTOR")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
  publications {
    create<MavenPublication>("maven") {
      groupId = "com.github.longht021189"
      artifactId = "gradle-versions"
      version = "0.0.2"

      from(components["versionCatalog"])
    }
  }
}
