#Echo PWD
echo 'Current Directory is '$PWD
#Save Current Working Directory
baser_dir=$(PWD)
echo 'Saved base Dir as '$baser_dir
#Build Project
./gradlew build
mkdir -p build/dependency
cd build/dependency
echo 'Current Directory is '$PWD
jar -xf ../libs/*.jar
cd $baser_dir
echo 'Current Directory is '$PWD
docker build -t kshitijbahul/pokemon-service:0.0.0.1 .
