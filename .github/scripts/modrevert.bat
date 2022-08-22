echo "Downloading backup..."

git restore .\src\
git restore .\build.gradle
git restore .\gradle.properties

echo "Backup applied!"