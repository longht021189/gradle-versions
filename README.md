# Version Catalogs
Sharing Version Catalogs

## Import Version Catalogs
```
dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/longht021189/gradle-versions")
            credentials {
                username = System.getenv("GITHUB_USERNAME")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    versionCatalogs {
        create("libs") {
            from("com.github.longht021189:gradle-versions:0.0.1")
        }
    }
}
```

## Documents
https://docs.gradle.org/current/userguide/platforms.html