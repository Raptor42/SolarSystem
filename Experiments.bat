javac *.java 
java SolarSystem -d -ts 7200 -tf 2592000 -i Data/planets.dat -fn Results/planets_2h_1M_e_1.dat
java SolarSystem -d -ts 7200 -tf 2592000 -c -i Data/planets.dat -fn Results/planets_2h_1M_c_1.dat
java SolarSystem -d -ts 3600 -tf 2592000 -i Data/planets.dat -fn Results/planets_1h_1M_e_1.dat
java SolarSystem -d -ts 3600 -tf 2592000 -c -i Data/planets.dat -fn Results/planets_1h_1M_c_1.dat
java SolarSystem -d -ts 1800 -tf 2592000 -i Data/planets.dat -fn Results/planets_30m_1M_e_1.dat
java SolarSystem -d -ts 1800 -tf 2592000 -c -i Data/planets.dat -fn Results/planets_30m_1M_c_1.dat

java SolarSystem -d -ts 7200 -tf 2592000 -i Data/fullSystem.dat -fn Results/fullSystem_2h_1M_e_1.dat
java SolarSystem -d -ts 7200 -tf 2592000 -c -i Data/fullSystem.dat -fn Results/fullSystem_2h_1M_c_1.dat
java SolarSystem -d -ts 3600 -tf 2592000 -i Data/fullSystem.dat -fn Results/fullSystem_1h_1M_e_1.dat
java SolarSystem -d -ts 3600 -tf 2592000 -c -i Data/fullSystem.dat -fn Results/fullSystem_1h_1M_c_1.dat
java SolarSystem -d -ts 1800 -tf 2592000 -i Data/fullSystem.dat -fn Results/fullSystem_30m_1M_e_1.dat
java SolarSystem -d -ts 1800 -tf 2592000 -c -i Data/fullSystem.dat -fn Results/fullSystem_30m_1M_c_1.dat
pause 